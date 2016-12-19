package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

@RunWith(JfxTestRunner.class)
public class PlayerClassTests {

	private final String PLAYER_NAME = "JOHNDOE";
	private final int PLAYER_HP = 100;
	private final int PLAYER_DAMAGE = 10;
	Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.setName(PLAYER_NAME);
		player.setHp(PLAYER_HP);
		player.setDamage(PLAYER_DAMAGE);
	}

	@Test
	public void testPlayerConstructor() {

		assertEquals(PLAYER_NAME, player.getName());
		assertEquals(PLAYER_HP, player.getHP());
		assertEquals(PLAYER_DAMAGE, player.getDamae());
	}

	@Test
	public void testPlayerImagePath() {
		Player player = new Player();
		String path = getClass().getResource("/game_player.png").toString();
		Image image = new Image(path);
		player.setImage(image);
		assertEquals(image, player.getImage());
	}

}
