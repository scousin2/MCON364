package Animation;

import java.util.Stack;
import javafx.scene.shape.Rectangle;

public class StackModel {

    private static final int STACK_CAPACITY = 20;
    private Stack<Rectangle> stack;

    public StackModel() {
        stack = new Stack<>();
    }

    public void push(Rectangle rectangle) {
        if (stack.size() < STACK_CAPACITY) {
            stack.push(rectangle);
        }
    }

    public Rectangle pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }
}
