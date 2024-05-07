package Animation;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class StackView {

    private StackPane root;
    private VBox buttonBox;

    public StackView(Group stackGroup) {
        root = new StackPane();
        buttonBox = new VBox(10);

        // Create push and pop buttons
        Button pushButton = new Button("Push");
        pushButton.setOnAction(event -> StackController.pushItem());

        Button popButton = new Button("Pop");
        popButton.setOnAction(event -> StackController.popItem());

        buttonBox.getChildren().addAll(pushButton, popButton);
        root.getChildren().addAll(stackGroup, buttonBox);
    }

    public StackPane getRoot() {
        return root;
    }
}
