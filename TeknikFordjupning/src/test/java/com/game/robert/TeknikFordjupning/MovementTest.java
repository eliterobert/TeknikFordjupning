package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class MovementTest extends ApplicationTest {

	@Before
	public void setUp() throws Exception {
		ApplicationTest.launch(MazeGame.class);
	}

	@Test
	public void testMovementOnPlayerVelocityRIGHT() throws InterruptedException {
		clickOn("#startButton");
		System.out.println(Model.getInstance().players.get(0).rectangleVelocityX);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX);
		press(KeyCode.RIGHT);
		assertEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
		release(new KeyCode[] {});
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
	}

	@Test
	public void testMovementOnPlayerVelocityLEFT() throws InterruptedException {
		clickOn("#startButton");
		System.out.println(Model.getInstance().players.get(0).rectangleVelocityX);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX);
		press(KeyCode.LEFT);
		assertEquals(-Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
		release(new KeyCode[] {});
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityX.doubleValue(), 100);
	}

	@Test
	public void testMovementOnPlayerVelocityUP() throws InterruptedException {
		clickOn("#startButton");
		System.out.println(Model.getInstance().players.get(0).rectangleVelocityY);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY);
		press(KeyCode.UP);
		assertEquals(-Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
		release(new KeyCode[] {});
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
	}

	@Test
	public void testMovementOnPlayerVelocityDOWN() throws InterruptedException {
		clickOn("#startButton");
		System.out.println(Model.getInstance().players.get(0).rectangleVelocityY);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY);
		press(KeyCode.DOWN);
		assertEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
		release(new KeyCode[] {});
		assertNotEquals(Model.getInstance().players.get(0).speed,
				Model.getInstance().players.get(0).rectangleVelocityY.doubleValue(), 100);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
	}

	@After
	public void afterEachTest() throws Exception {
		FxToolkit.hideStage();
		release(new KeyCode[] {});
		release(new MouseButton[] {});

	}

}
