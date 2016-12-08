package com.game.robert.TeknikFordjupning;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	Player(Pane _layer, String _name, int _HP, int _damage, Image _image) {
		this.name = _name;
		this.hp = _HP;
		this.damage = _damage;
		this.image = _image;
		this.imageView = new ImageView(_image);
		this.layer = _layer;
		this.imageView.relocate(200, 200);
		addToLayer();
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
