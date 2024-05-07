package Animation;

import java.util.Stack;
import javafx.scene.shape.Rectangle;

public class StackModel {

    // Maximum capacity of the stack
    private static final int STACK_CAPACITY = 20;

    // Stack to manage rectangles
    private Stack<Rectangle> stack;

    // Constructor to initialize the stack
    public StackModel() {
        stack = new Stack<>();
    }

    // Method to push item onto stack
    public void push(Rectangle rectangle) {
        // Check if the stack is not full
        if (stack.size() < STACK_CAPACITY) {
            stack.push(rectangle); // Push the rectangle onto the stack
        }
    }

    // Method to pop item from stack
    public Rectangle pop() {
        // Check if the stack is not empty
        if (!stack.isEmpty()) {
            return stack.pop(); // Pop and return the rectangle from the stack
        }
        return null; // Return null if the stack is empty
    }
}
