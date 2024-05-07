package Animation;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class StackView {

    private StackPane root; // Root pane to hold the stack and buttons
    private VBox buttonBox; // VBox to hold the push and pop buttons

    // Constructor to initialize the StackView with a stackGroup
    public StackView(Group stackGroup) {
        root = new StackPane(); // Initialize the root pane
        buttonBox = new VBox(10); // Initialize the VBox for buttons with spacing of 10

        // Create push and pop buttons
        Button pushButton = new Button("Push"); // Button to push item onto stack
        pushButton.setOnAction(event -> StackController.pushItem()); // Attach push event handler to the push button

        Button popButton = new Button("Pop"); // Button to pop item from stack
        popButton.setOnAction(event -> StackController.popItem()); // Attach pop event handler to the pop button

        // Add push and pop buttons to the buttonBox VBox
        buttonBox.getChildren().addAll(pushButton, popButton);

        // Add the stackGroup and buttonBox to the root StackPane
        root.getChildren().addAll(stackGroup, buttonBox);
    }

    // Getter method to retrieve the root StackPane
    public StackPane getRoot() {
        return root;
    }
}
