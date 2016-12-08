package com.game.robert.TeknikFordjupning;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

	private String name;
	private int hp;
	private int damage;
	private Image image;
	private ImageView imageView;

	Player() {
		super();
	}

	Player(String _name, int _HP, int _damage, Image _image) {
		this.name = _name;
		this.hp = _HP;
		this.damage = _damage;
		this.image = _image;
		this.imageView = new ImageView(_image);
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
