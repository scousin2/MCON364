package Module2;

	// DepthFirstSearch class for DFS traversal
	class DepthFirstSearch<T extends Comparable<T>> {
		// Method for DFS traversal in preorder
	    public static <T extends Comparable<T>> void dfsPreOrder(BinarySearchTree<T> bst) {
	        dfsPreOrderRec(bst.root);
	    }
	 // Method for DFS traversal in INorder
	    public static <T extends Comparable<T>> void dfsInOrder(BinarySearchTree<T> bst) {
	        dfsInOrderRec(bst.root);
	    }
	 // Method for DFS traversal in POSTorder
	    public static <T extends Comparable<T>> void dfsPostOrder(BinarySearchTree<T> bst) {
	        dfsPostOrderRec(bst.root);
	    }
	 // Method for DFS traversal in preorder recursive
	    private static <T extends Comparable<T>> void dfsPreOrderRec(BSTNode<T> node) {
	        if (node != null) {
	            System.out.print(node.getInfo() + " ");
	            dfsPreOrderRec(node.getLeft());
	            dfsPreOrderRec(node.getRight());
	        }
	    }
	 // Method for DFS traversal in INorder recursive
	    private static <T extends Comparable<T>> void dfsInOrderRec(BSTNode<T> node) {
	        if (node != null) {
	            dfsInOrderRec(node.getLeft());
	            System.out.print(node.getInfo() + " ");
	            dfsInOrderRec(node.getRight());
	        }
	    }
	 // Method for DFS traversal in postorder recursive
	    private static <T extends Comparable<T>> void dfsPostOrderRec(BSTNode<T> node) {
	        if (node != null) {
	            dfsPostOrderRec(node.getLeft());
	            dfsPostOrderRec(node.getRight());
	            System.out.print(node.getInfo() + " ");
	        }
	    }
	}	
	
	