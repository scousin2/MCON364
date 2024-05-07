package Animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StackController {

    private static final int RECTANGLE_WIDTH = 80;
    private static final int RECTANGLE_HEIGHT = 20;
    private static final Duration ANIMATION_DURATION = Duration.seconds(1);

    private static Group stackGroup;
    private static StackModel model;

   

	

	public static void pushItem() {
        Rectangle newRectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT, Color.PURPLE);
        newRectangle.setStroke(Color.BLACK);
        newRectangle.setStrokeWidth(2);
        stackGroup.getChildren().add(newRectangle);
        model.push(newRectangle);

        double newRectangleOffset = -stackGroup.getChildren().size() * RECTANGLE_HEIGHT;
        TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION, newRectangle);
        tt.setByY(newRectangleOffset);
        tt.play();
    }

    public static void popItem() {
        if (!stackGroup.getChildren().isEmpty()) {
            Rectangle removedRectangle = model.pop();
            if (removedRectangle != null) {
                TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION, removedRectangle);
                tt.setByY(-RECTANGLE_HEIGHT);
                tt.setOnFinished(event -> stackGroup.getChildren().remove(removedRectangle));
                tt.play();
            }
        }
    }

    public static void setStackGroup(Group stackGroup) {
        StackController.stackGroup = stackGroup;
    }

    public static void setModel(StackModel model) {
        StackController.model = model;
    }
}
