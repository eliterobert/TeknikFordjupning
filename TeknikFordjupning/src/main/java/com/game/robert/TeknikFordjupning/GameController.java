package com.game.robert.TeknikFordjupning;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.omg.Messaging.SyncScopeHelper;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController implements Initializable {

	@FXML
	AnchorPane anchorPane;
	@FXML
	Rectangle playerRectangle, enemy1Rectangle;
	@FXML
	SVGPath map;
	KeyCode keyCode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Model.getInstance().createPlayer(playerRectangle, "Player", 100, 10, "/game_player.png", 20, 20, 200);
		Model.getInstance().createEnemy(enemy1Rectangle, "Enemy", 50, 5, "/enemy.png", 300, 300);

		// createEnemy();

		final LongProperty lastUpdateTime = new SimpleLongProperty();

		final AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long timestamp) {
				if (lastUpdateTime.get() > 0) {
					final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0;
					final double deltaX = elapsedSeconds * Model.getInstance().players.get(0).rectangleVelocityX.get();
					final double oldX = Model.getInstance().players.get(0).getPlayerRectangle().getTranslateX();
					final double newX = Math.max(Model.getInstance().players.get(0).getMinX(),
							Math.min(Model.getInstance().players.get(0).getMaxX(), oldX + deltaX));

					final double deltaY = elapsedSeconds * Model.getInstance().players.get(0).rectangleVelocityY.get();
					final double oldY = Model.getInstance().players.get(0).getPlayerRectangle().getTranslateY();
					final double newY = Math.max(Model.getInstance().players.get(0).getMinY(),
							Math.min(Model.getInstance().players.get(0).getMaxY(), oldY + deltaY));
					Model.getInstance().players.get(0).getPlayerRectangle().setTranslateX(newX);
					Model.getInstance().players.get(0).getPlayerRectangle().setTranslateY(newY);

					MazeGame._scene.setOnKeyPressed(event -> {
						if (event.getCode() == KeyCode.RIGHT) {
							Model.getInstance().players.get(0).rectangleVelocityX
									.set(Model.getInstance().players.get(0).speed);
							keyCode = event.getCode();
							Model.getInstance().players.get(0).getPlayerRectangle().setTranslateX(
									Model.getInstance().players.get(0).getPlayerRectangle().getTranslateX());
						} else if (event.getCode() == KeyCode.LEFT) {
							System.out.println(event.getCode());
							keyCode = event.getCode();
							Model.getInstance().players.get(0).rectangleVelocityX
									.set(-Model.getInstance().players.get(0).speed);
							Model.getInstance().players.get(0).getPlayerRectangle().setTranslateX(
									Model.getInstance().players.get(0).getPlayerRectangle().getTranslateX());
						} else if (event.getCode() == KeyCode.UP) {
							keyCode = event.getCode();
							Model.getInstance().players.get(0).rectangleVelocityY
									.set(-Model.getInstance().players.get(0).speed);
							Model.getInstance().players.get(0).getPlayerRectangle().setTranslateY(
									Model.getInstance().players.get(0).getPlayerRectangle().getTranslateY());
						} else if (event.getCode() == KeyCode.DOWN) {
							keyCode = event.getCode();
							Model.getInstance().players.get(0).rectangleVelocityY
									.set(Model.getInstance().players.get(0).speed);
							Model.getInstance().players.get(0).getPlayerRectangle().setTranslateY(
									Model.getInstance().players.get(0).getPlayerRectangle().getTranslateY());
						}
					});

					MazeGame._scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT)
								Model.getInstance().players.get(0).rectangleVelocityX.set(0);
							else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN)
								Model.getInstance().players.get(0).rectangleVelocityY.set(0);
						}
					});
					Model.getInstance().checkCollisionsWithWall(playerRectangle, map, keyCode);
					Model.getInstance().checkCollisionsWithWall(enemy1Rectangle, map, keyCode);
					Model.getInstance().checkCollisionsWithEnemy(playerRectangle, enemy1Rectangle);

				}
				lastUpdateTime.set(timestamp);
			}
		};
		gameLoop.start();

		startEnemyMotions();

	}

	private void startEnemyMotions() {
		TranslateTransition tt = new TranslateTransition(Duration.millis(5000), enemy1Rectangle);
		tt.setByX(350);
		tt.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
		tt.setAutoReverse(true);
		tt.play();
	}

}
