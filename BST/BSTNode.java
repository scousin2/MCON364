package Module2;

//Node class for the Binary Search Tree
class BSTNode<T> {
 private T info;
 private BSTNode<T> left;
 private BSTNode<T> right;
 
 public BSTNode(T info) {
     this.info = info;
     left = null;
     right = null;
 }
 
 // Getters and Setters
 public void setInfo(T info) {
     this.info = info;
 }
 
 public T getInfo() {
     return info;
 }
 
 public void setLeft(BSTNode<T> link) {
     left = link;
 }
 
 public void setRight(BSTNode<T> link) {
     right = link;
 }
 
 public BSTNode<T> getLeft() {
     return left;
 }
 
 public BSTNode<T> getRight() {
     return right;
 }
}
