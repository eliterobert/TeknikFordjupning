package com.game.robert.TeknikFordjupning;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class MazeGame extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL location = getClass().getClassLoader().getResource("View.fxml");
		FXMLLoader loader = new FXMLLoader(location);
		Parent root;
		try {
			// test
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setMinHeight(800);
			primaryStage.setMinWidth(800);
			primaryStage.setMaxHeight(800);
			primaryStage.setMaxWidth(800);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			root.requestFocus();
			primaryStage.setOnCloseRequest(e -> {
				System.exit(0);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
