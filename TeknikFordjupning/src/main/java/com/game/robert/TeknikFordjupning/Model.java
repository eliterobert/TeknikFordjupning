package com.game.robert.TeknikFordjupning;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Model {

	List<Player> players;
	List<Enemy> enemies;

	private static Model instance = null;

	private Model() {
		super();
		players = new ArrayList<>();
		enemies = new ArrayList<>();
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	void createPlayer(Rectangle playerRectangle, String name, int HP, int damage, String picPath, double startPosX,
			double startPosY, double _speed) {
		// "/game_player.png"
		Image image = new Image(getClass().getResource(picPath).toString());
		Player player = new Player(playerRectangle, name, HP, damage, image, startPosX, startPosY, _speed);
		players.add(player);
	}

	void createEnemy(Rectangle enemyRectangle, String enemyName, int HP, int damage, String picPath, double startPosX,
			double startPosY) {
		// "/enemy.png"
		Image image = new Image(getClass().getResource(picPath).toString());
		Enemy enemy = new Enemy(enemyRectangle, enemyName, HP, damage, image, startPosX, startPosY);
		enemies.add(enemy);
	}

	// COLLISION om går in i väggen med UPP, inte gå att gå mer med upp förrens
	// translateX har gått - / +

	// OM COLLISION HÄNDER NÄR UPPÅT, FÖRBJUD UPPÅT TILLS KLICKAT PÅ ANNAN KNAPP
	public void checkCollisionsWithWall(Shape rect1, Shape rect2, KeyCode key) {
		if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
			Shape intersect = Shape.intersect(rect1, rect2);
			if (intersect.getBoundsInLocal().getWidth() != -1) {
				if (key == KeyCode.UP) {
					rect1.setTranslateY(rect1.getTranslateY());
					players.get(0).rectangleVelocityY.set(0);
				}
				if (key == KeyCode.DOWN) {
					rect1.setTranslateY(rect1.getTranslateY());
					players.get(0).rectangleVelocityY.set(0);
				}
				if (key == KeyCode.LEFT) {
					rect1.setTranslateX(rect1.getTranslateX());
					players.get(0).rectangleVelocityX.set(0);
				}
				if (key == KeyCode.RIGHT) {
					rect1.setTranslateX(rect1.getTranslateX());
					players.get(0).rectangleVelocityX.set(0);
				}
			}
		}
	}

	public void checkCollisionsWithEnemy(Shape rect1, Shape rect2) {
		if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
			Shape intersect = Shape.intersect(rect1, rect2);
			if (intersect.getBoundsInLocal().getWidth() != -1) {
				players.get(0).getPlayerRectangle().setVisible(false);
			}
		}
	}
}
