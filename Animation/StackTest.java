package Animation;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;
import java.awt.Rectangle;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {

    private Stack<Rectangle> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPush() {
        Rectangle rectangle = new Rectangle(50, 50);
        stack.push(rectangle);
        assertEquals(1, stack.size());
        assertEquals(rectangle, stack.peek());
    }

    @Test
    public void testPop() {
        Rectangle rectangle = new Rectangle(50, 50);
        stack.push(rectangle);
        assertEquals(rectangle, stack.pop());
        assertEquals(0, stack.size());
    }

}
