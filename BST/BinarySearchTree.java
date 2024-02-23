package Module2;

import java.util.*;

//Binary Search Tree class implementing BST Interface
public class BinarySearchTree<T> implements BSTInterface<T> {
 protected BSTNode<T> root; 
 protected Comparator<T> comp; 
 protected boolean found; 

 public BinarySearchTree() {
     root = null;
     comp = new Comparator<T>() {
         public int compare(T element1, T element2) {
             return ((Comparable)element1).compareTo(element2);
         }
     }; 
 }

 public BinarySearchTree(Comparator<T> comp) {
     root = null;
     this.comp = comp;
 }

 @Override
 public Iterator<T> getIterator(BSTInterface.Traversal orderType) {
	    final Queue<BSTNode<T>> infoQueue = new LinkedList<>();

	    if (orderType == BSTInterface.Traversal.Preorder)
	        preOrder(root, infoQueue);
	    else if (orderType == BSTInterface.Traversal.Inorder)
	        inOrder(root, infoQueue);
	    else
	        postOrder(root, infoQueue);

	    return new Iterator<T>() {
	        public boolean hasNext() {
	            return !infoQueue.isEmpty();
	        }

	        public T next() {
	          
	            return infoQueue.poll().getInfo();
	        }
	    };
	}
 private void preOrder(BSTNode<T> node, Queue<BSTNode<T>> q) {
	    if (node != null) {
	        q.add(node); // Add root
	        preOrder(node.getLeft(), q); // Traverse left subtree
	        preOrder(node.getRight(), q); // Traverse right subtree
	    }
	}

	private void inOrder(BSTNode<T> node, Queue<BSTNode<T>> q) {
	    if (node != null) {
	        inOrder(node.getLeft(), q); // Traverse left subtree
	        q.add(node); // Add root
	        inOrder(node.getRight(), q); // Traverse right subtree
	    }
	}

	private void postOrder(BSTNode<T> node, Queue<BSTNode<T>> q) {
	    if (node != null) {
	        postOrder(node.getLeft(), q); // Traverse left subtree
	        postOrder(node.getRight(), q); // Traverse right subtree
	        q.add(node); // Add root
	    }
	}



 @Override
 public T min() {
	    // If this BST is empty, returns null;
	    // otherwise returns the smallest element of the tree.
	    if (isEmpty()) {
	        return null;
	    } else {
	        BSTNode<T> node = root;
	        while (node.getLeft() != null) {
	            node = node.getLeft();
	        }
	        return node.getInfo();
	    }
	}

 
 @Override
 public T max() {
	    // If this BST is empty, returns null;
	    // otherwise returns the largest element of the tree.
	    if (isEmpty()) {
	        return null;
	    } else {
	        BSTNode<T> node = root;
	        while (node.getRight() != null) {
	            node = node.getRight();
	        }
	        return node.getInfo();
	    }
	}


 @Override
 public int size() {
	    // Returns the number of elements in this BST.
	    int count = 0;
	    if (root != null) {
	    	Stack<BSTNode<T>> nodeStack = new Stack<>();

	        
	        BSTNode<T> currNode;
	        nodeStack.push(root);
	        while (!nodeStack.isEmpty()) {
	            currNode = nodeStack.peek();
	            nodeStack.pop();
	            count++;
	            if (currNode.getLeft() != null) {
	                nodeStack.push(currNode.getLeft());
	            }
	            if (currNode.getRight() != null) {
	                nodeStack.push(currNode.getRight());
	            }
	        }
	    }
	    return count;
	}


 @Override
 public boolean isEmpty() {
	    // Returns true if BST is empty. otherwise returns false.
	    return (root == null);
	}


 @Override
 public boolean contains(T target) {
	    // Returns true if this BST contains a node 
	    return recContains(target, root);
	}

	private boolean recContains(T target, BSTNode<T> node) {
	    // Returns true if the subtree rooted at node contains info 
		if (node == null) {
	        return false; // target is not found
	    } else if (comp.compare(target, node.getInfo()) < 0) {
	        return recContains(target, node.getLeft()); // Search left subtree
	    } else if (comp.compare(target, node.getInfo()) > 0) {
	        return recContains(target, node.getRight()); // Search right subtree
	    } else {
	        return true; // target is found
	    }
	}


 @Override
 public boolean add(T element) {
	    // Adds element to this BST. The tree retains its BST property.
	    root = recAdd(element, root);
	    return true;
	}

	private BSTNode<T> recAdd(T element, BSTNode<T> node) {
	    // Adds element to tree rooted at node; tree retains its BST property.
	    if (node == null) {
	        // Addition place found
	        node = new BSTNode<T>(element);
	    } else if (comp.compare(element, node.getInfo()) <= 0) {
	        node.setLeft(recAdd(element, node.getLeft())); // Add in left subtree
	    } else {
	        node.setRight(recAdd(element, node.getRight())); // Add in right subtree
	    }
	    return node;
	}


 @Override
 public boolean remove(T target) {
	    // Removes a node with
	    root = recRemove(target, root);
	    return found;
	}

	private BSTNode<T> recRemove(T target, BSTNode<T> node) {
	    // if no such node exists, returns false.
	    if (node == null) {
	        found = false;
	    } else if (comp.compare(target, node.getInfo()) < 0) {
	        node.setLeft(recRemove(target, node.getLeft()));
	    } else if (comp.compare(target, node.getInfo()) > 0) {
	        node.setRight(recRemove(target, node.getRight()));
	    } else {
	        node = removeNode(node);
	        found = true;
	    }
	    return node;
	}

	private BSTNode<T> removeNode(BSTNode<T> node) {
	    // Removes the information at node from the tree.
	    T data;
	    if (node.getLeft() == null) {
	        return node.getRight();
	    } else if (node.getRight() == null) {
	        return node.getLeft();
	    } else {
	        data = getPredecessor(node.getLeft());
	        node.setInfo(data);
	        node.setLeft(recRemove(data, node.getLeft()));
	        return node;
	    }
	}

	private T getPredecessor(BSTNode<T> subtree) {
	    // Returns the information held in the rightmost node of subtree
	    BSTNode<T> temp = subtree;

	    while (temp.getRight() != null) {
	        temp = temp.getRight();
	    }
	    return temp.getInfo();
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

}

