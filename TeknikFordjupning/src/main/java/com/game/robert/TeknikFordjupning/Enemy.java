package com.game.robert.TeknikFordjupning;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Enemy {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Pane getLayer() {
		return layer;
	}

	public void setLayer(Pane layer) {
		this.layer = layer;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	private String name;
	private int hp;
	private int damage;
	private Image image;
	private Pane layer;
	private double posX;
	private double posY;
	private Rectangle enemyRectangle;

	public Enemy() {
		// TODO Auto-generated constructor stub
	}

	public Enemy(Rectangle _enemyRectangle, String name, int hp, int damage, Image _image, double posX,
			double posY) {
		super();
		this.enemyRectangle = _enemyRectangle;
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.image = _image;
		this.posX = posX;
		this.posY = posY;
		image = new Image(getClass().getResource("/enemy.png").toString());
		ImagePattern imagePattern2 = new ImagePattern(this.image);
		enemyRectangle.setFill(imagePattern2);

	}

	public Rectangle getEnemyRectangle() {
		return enemyRectangle;
	}

	public void setEnemyRectangle(Rectangle enemyRectangle) {
		this.enemyRectangle = enemyRectangle;
	}


}
