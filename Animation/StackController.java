package Animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StackController {

    // Constants for rectangle dimensions and animation duration
    private static final int RECTANGLE_WIDTH = 80;
    private static final int RECTANGLE_HEIGHT = 20;
    private static final Duration ANIMATION_DURATION = Duration.seconds(1);

    // Reference to the stack group and model
    private static Group stackGroup;
    private static StackModel model;

    // Method to push item onto the stack
    public static void pushItem() {
        Rectangle newRectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT, Color.PURPLE);
        newRectangle.setStroke(Color.BLACK);
        newRectangle.setStrokeWidth(2);
        stackGroup.getChildren().add(newRectangle); // Add rectangle to the stack group
        model.push(newRectangle); // Push rectangle to the model stack

        double newRectangleOffset = -stackGroup.getChildren().size() * RECTANGLE_HEIGHT; // Calculate vertical offset

        // Animate the new rectangle from the top
        TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION, newRectangle);
        tt.setByY(newRectangleOffset);
        tt.play(); // Play animation
    }

    // Method to pop item from the stack
    public static void popItem() {
        if (!stackGroup.getChildren().isEmpty()) { // Check if stack is not empty
            Rectangle removedRectangle = model.pop(); // Remove rectangle from model stack
            if (removedRectangle != null) { // If rectangle was successfully removed
                // Animate the removal of the rectangle
                TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION, removedRectangle);
                tt.setByY(-RECTANGLE_HEIGHT);
                tt.setOnFinished(event -> stackGroup.getChildren().remove(removedRectangle)); // Remove rectangle from stack group after animation
                tt.play(); // Play animation
            }
        }
    }

    // Setter method to set the stack group
    public static void setStackGroup(Group stackGroup) {
        StackController.stackGroup = stackGroup;
    }

    // Setter method to set the model
    public static void setModel(StackModel model) {
        StackController.model = model;
    }
}
