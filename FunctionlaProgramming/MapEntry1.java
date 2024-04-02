package Module9HW;



public class MapEntry1 <K, V> {
    String key;
    int value;
    MapEntry1 next;

    // Constructor to initialize the entry
    MapEntry1(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
  //Custom implementation of a linked list
    static class LinkedList {
        Node head;

        //Constructor to initialize the linked list
        LinkedList() {
            head = null;
        }

        //Method to add a new node to the linked list
        void add(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        //Inner class representing a node in the linked list
        private static class Node {
            String data;
            Node next;

            //Constructor to initialize the node
            Node(String data) {
                this.data = data;
                this.next = null;
            }
        }
    }
}
