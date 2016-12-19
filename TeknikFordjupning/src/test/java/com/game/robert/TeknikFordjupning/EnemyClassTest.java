package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javafx.scene.image.Image;

@RunWith(JfxTestRunner.class)
public class EnemyClassTest {

	private final String ENEMY_NAME = "ENEMY";
	private final int ENEMY_HP = 100;
	private final int ENEMY_DAMAGE = 10;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEnemyConstructor() {
		Enemy enemy = new Enemy();
		enemy.setName(ENEMY_NAME);
		enemy.setHp(ENEMY_HP);
		enemy.setDamage(ENEMY_DAMAGE);
		assertEquals(ENEMY_NAME, enemy.getName());
		assertEquals(ENEMY_HP, enemy.getHp());
		assertEquals(ENEMY_DAMAGE, enemy.getDamage());
	}

	@Test
	public void testPlayerImagePath() {
		Enemy enemy = new Enemy();
		String path = getClass().getResource("/enemy.png").toString();
		Image image = new Image(path);
		enemy.setImage(image);
		assertEquals(image, enemy.getImage());
	}
	
	@Test(expected = NullPointerException.class)
	public void testEnemyImagePathIncorrect(){
		Enemy enemy = new Enemy();
		String path = getClass().getResource("/123.png").toString();
		Image image = new Image(path);
		enemy.setImage(image);
		assertEquals(image, enemy.getImage());
		
	}

}
