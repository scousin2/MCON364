package Module2;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class BSTTesting {
	//this class tests out all the necessary functions proving its functionality.

	 @Test
	    public void testInsert() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        bst.add(60);
	        bst.add(80);
	        assertTrue(bst.contains(50));
	        assertTrue(bst.contains(30));
	        assertTrue(bst.contains(70));
	        assertTrue(bst.contains(20));
	        assertTrue(bst.contains(40));
	        assertTrue(bst.contains(60));
	        assertTrue(bst.contains(80));
	    }

	 @Test
	    public void testDelete() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        bst.add(60);
	        bst.add(80);
	        assertTrue(bst.contains(30));
	        bst.remove(30);
	        assertFalse(bst.contains(30));
	    }

	 @Test
	    public void testMin() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        assertEquals(Integer.valueOf(20), bst.min());
	    }

	    @Test
	    public void testMax() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        assertEquals(Integer.valueOf(70), bst.max());
	    }

	    
	    
	    @Test
	    public void testBFS() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        bst.add(60);
	        bst.add(80);
	        
	        equals("50 30 70 20 40 60 80 ");
	    }

	    
	    @Test
	    public void testDFS() {
	        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.add(50);
	        bst.add(30);
	        bst.add(70);
	        bst.add(20);
	        bst.add(40);
	        bst.add(60);
	        bst.add(80);

	        //  Depth First Search traversals
	        StringBuilder expectedPreOrder = new StringBuilder();
	        expectedPreOrder.append("50 30 20 40 70 60 80 ");

	        StringBuilder expectedInOrder = new StringBuilder();
	        expectedInOrder.append("20 30 40 50 60 70 80 ");

	        StringBuilder expectedPostOrder = new StringBuilder();
	        expectedPostOrder.append("20 40 30 60 80 70 50 ");

	        equals(expectedPreOrder.toString());
	        equals(expectedInOrder.toString());
	        equals(expectedPostOrder.toString());
	    }
	}


	

