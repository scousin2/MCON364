package Module9hw;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
			Scene scene = new Scene(root,400,455);
			scene.getStylesheets().add(getClass().getResource("Module9hw.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

