package Module2;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Iterator<Integer> iterr;
        Scanner keyboard = new Scanner(System.in);
       //add a few numbers to the BST
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        // Display the BST
        System.out.println("Binary Search Tree after insertion:");
        System.out.println();
     // Perform BFS traversal
        System.out.print("Using Breadth First Search traversal: ");
        BreadthFirstSearch.bfs(bst);
        System.out.println();
        //using the contains method to see if 40 is in the BST
        System.out.println("Testing if the number 40 is in the BST");
        int numberToCheck = CheckingContains(bst);
        //now 40 is deleted, display that to the user
        bst.remove(40);
        numberToCheck = CheckingContains(bst);
        System.out.println();
        //display the max
        System.out.println("Max number in BST: " + bst.max());
        //display the min
        System.out.println("Min number in BST: " + bst.min());
        //display the size of the BST
        System.out.println("Size of BST: " + bst.size());
        //display if BST is empty or not
        System.out.println("Is BST empty ?" + bst.isEmpty());
        //now use the DFS algorithms
        //using characters. this shows the BST can accept characters as well as the intergers.
        System.out.println();
        System.out.println("Now we will test out letters using Depth first search algorithms:");
        BinarySearchTree<Character> example = new BinarySearchTree<>();
        Iterator<Character> iter;
        //add the characters
    	    example.add('P');
    	    example.add('F');
    	    example.add('S');
    	    example.add('B');
    	    example.add('H');
    	    example.add('R');
    	    example.add('Y');
    	    example.add('G');
    	    example.add('T');
    	    example.add('Z');
    	    example.add('W');
    	 // Inorder traversal
    	    System.out.print("Inorder: ");
    	    iter = example.getIterator(BSTInterface.Traversal.Inorder);
    	    while (iter.hasNext())
    	        System.out.print(iter.next() + " ");

    	    // Preorder traversal
    	    System.out.print("\nPreorder: ");
    	    iter = example.getIterator(BSTInterface.Traversal.Preorder);
    	    while (iter.hasNext())
    	        System.out.print(iter.next() + " ");

    	    // Postorder traversal
    	    System.out.print("\nPostorder: ");
    	    iter = example.getIterator(BSTInterface.Traversal.Postorder);
    	    while (iter.hasNext())
    	        System.out.print(iter.next() + " ");

    	    

    	    // Inorder traversal again showing adding 3 A's
    	    System.out.print("\nInorder after adding A's: ");
    	    iter = example.getIterator(BSTInterface.Traversal.Inorder);
    	    example.add('A');
    	    example.add('A');
    	    example.add('A');
    	    iter = example.getIterator(BSTInterface.Traversal.Inorder); // Reinitialize iter
    	    while (iter.hasNext())
    	        System.out.print(iter.next() + " ");
    	    System.out.println();
    	    //show the removing works as well- remove the "w"
    	    System.out.println("Now we will remove the letter 'W' and display using Inorder:");
    	    example.remove('W');
    	    iter = example.getIterator(BSTInterface.Traversal.Inorder); // Reinitialize iter
    	    while (iter.hasNext())
    	    while (iter.hasNext())
    	        System.out.print(iter.next() + " ");
    	    System.out.println();
    	    System.out.println();
    	    
    	    
    	    
        // User can test it out themselves.
    	System.out.println("User can test using INTEGERS ONLY!");
        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer to insert: ");
                    int value = keyboard.nextInt();
                    bst.add(value);
                    System.out.print("BST after insertion using inorder: ");
                   // bst.display(); 
                    iterr = bst.getIterator(BSTInterface.Traversal.Inorder);
            	    while (iterr.hasNext())
            	        System.out.print(iterr.next() + " ");
            	    System.out.println();
                    break;
                case 2:
                	//allow for user validation if user enters a number to delete that is not in the BST
                	boolean validInput = false;
                    int delValue = 0;
                    while (!validInput) {
                        System.out.print("Enter integer to delete: ");
                        delValue = keyboard.nextInt();
                        if (bst.contains(delValue)) {
                            validInput = true;
                        } else {
                            System.out.println("The number " + delValue + " is not in the BST. Please enter a valid number.");
                        }
                    }
                    bst.remove(delValue);
                    System.out.print("BST after deletion using inorder: ");
                    iterr = bst.getIterator(BSTInterface.Traversal.Inorder);
                    while (iterr.hasNext())
                        System.out.print(iterr.next() + " ");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter integer to search: ");
                    int searchValue = keyboard.nextInt();
                    System.out.println("Contains " + searchValue + ": " + bst.contains(searchValue));
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Making use of the contains method. Showing the user.
    private static int CheckingContains(BinarySearchTree<Integer> bst) {
        int numberToCheck = 40;

        if (bst.contains(numberToCheck)) {
           // System.out.println("Before deletion:");
            System.out.println("The number " + numberToCheck + " is contained in the BST!");
            BreadthFirstSearch.bfs(bst);
            System.out.println();
        } else {
            System.out.println("Now we will remove 40:");
            System.out.println("The number " + numberToCheck + " is not contained in the BST.");
            BreadthFirstSearch.bfs(bst);
            System.out.println();
        }
        return numberToCheck;
    }  
   
}

