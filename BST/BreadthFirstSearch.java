package Module2;

import java.util.*;


// BreadthFirstSearch class for BFS traversal
class BreadthFirstSearch<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void bfs(BinarySearchTree<T> bst) {
        if (bst.isEmpty()) {
            return;
        }
     // Create a queue for BFS traversal
        Queue<BSTNode<T>> queue = new LinkedList<>();
        queue.offer(bst.root);

        while (!queue.isEmpty()) {
            BSTNode<T> current = queue.poll(); // Remove and get the first node from the queue
            System.out.print(current.getInfo() + " ");
         // Add the left child to the queue if not null
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
         // Add the right child to the queue if not null
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }
}
