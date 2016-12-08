package com.game.robert.TeknikFordjupning;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameController implements Initializable {

	@FXML
	AnchorPane anchorPane;

	List<Player> players = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		createPlayer();

		AnimationTimer gameLoop = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

			}
		};

		gameLoop.start();

	}

	private void createPlayer() {
		Image image = new Image(getClass().getResource("/game_player.png").toString());
		Player player = new Player(anchorPane, "Robert", 100, 10, image);
		players.add(player);
	}

}
