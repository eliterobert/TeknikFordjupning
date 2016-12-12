package com.game.robert.TeknikFordjupning;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Player {

	private String name;
	private int hp;
	private int damage;
	private Image image;
	private ImageView imageView;
	private Pane layer;

	Player() {
		super();
	}

	double currX;
	double currY;

	private double velX = 0;
	private double velY = 0;
	double speed;

	Player(Pane _layer, String _name, int _HP, int _damage, Image _image, double startPosX, double startPosY,
			double _speed) {
		this.name = _name;
		this.hp = _HP;
		this.damage = _damage;
		this.image = _image;
		this.imageView = new ImageView(_image);
		this.layer = _layer;
		this.currX = startPosX;
		this.currY = startPosY;
		this.imageView.relocate(currX, currY);
		this.imageView.setFitHeight(40);
		this.imageView.setFitWidth(40);
		this.speed = _speed;
		addToLayer();
	}

	public void tick() {
		currX += velX;
		currY += velY;
	}

	public void move(KeyEvent e) {
		switch (e.getCode()) {
		case D:
			currX += speed;
			break;
		case A:
			currX -= speed;
			break;
		case W:
			currY -= speed;
			break;
		case S:
			currY += speed;
			break;
		default:
			break;
		}
	}

	public void updateUI() {
		imageView.relocate(currX, currY);
	}

	public void addToLayer() {
		this.layer.getChildren().add(this.imageView);
	}

	public Pane getLayer() {
		return layer;
	}

	public void setLayer(Pane layer) {
		this.layer = layer;
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

}
