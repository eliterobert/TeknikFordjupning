package com.game.robert.TeknikFordjupning;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Player {

	private String name;
	private int hp;
	private int damage;
	private Image image;
	private Rectangle playerRectangle;
	final double minY = -1200;
	final double maxY = 1200;
	final double minX = -1200;
	final double maxX = 1200;

	double currX;
	double currY;
	double speed;

	final DoubleProperty rectangleVelocityX = new SimpleDoubleProperty();
	final DoubleProperty rectangleVelocityY = new SimpleDoubleProperty();
	final LongProperty lastUpdateTime = new SimpleLongProperty();

	Player(Rectangle _playerRectangle, String _name, int _HP, int _damage, Image _image, double startPosX,
			double startPosY, double _speed) {
		this.name = _name;
		this.hp = _HP;
		this.damage = _damage;
		this.image = _image;
		this.playerRectangle = _playerRectangle;
		this.currX = startPosX;
		this.currY = startPosY;
		this.speed = _speed;
		image = new Image(getClass().getResource("/game_player.png").toString());
		ImagePattern imagePattern2 = new ImagePattern(this.image);
		playerRectangle.setFill(imagePattern2);
	}

	public Rectangle getPlayerRectangle() {
		return playerRectangle;
	}

	public void setPlayerRectangle(Rectangle playerRectangle) {
		this.playerRectangle = playerRectangle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getHP() {
		return hp;
	}

	public void setHp(int _HP) {
		this.hp = _HP;
	}

	public int getDamae() {
		return damage;
	}

	public void setDamage(int _damage) {
		this.damage = _damage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getMinY() {
		return minY;
	}

	public double getMaxY() {
		return maxY;
	}

	public double getMinX() {
		return minX;
	}

	public double getMaxX() {
		return maxX;
	}

	Player() {
		super();
	}

}