package com.game.robert.TeknikFordjupning;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller implements Initializable {

	@FXML
	Button startButton;
	@FXML
	Label startPageLabel;
	@FXML
	AnchorPane anchorPane;

	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getClassLoader().getResource("GameScene.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(home_page_scene);
		app_stage.setTitle("Game Scene");
		app_stage.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}
