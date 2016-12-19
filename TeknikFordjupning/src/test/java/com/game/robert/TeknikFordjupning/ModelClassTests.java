package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

@RunWith(JfxTestRunner.class)
public class ModelClassTests extends ApplicationTest {

	Stage stageP;

	@Before
	public void setUp() throws Exception {
		ApplicationTest.launch(MazeGame.class);
	}

	@Test
	public void testCreatePlayer() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				clickOn("#startButton");
				Model.getInstance().createPlayer(new Rectangle(), "Test", 1, 1, "/game_player.png", 50, 50, 5);
				for (Player player : Model.getInstance().players) {
					if (player.getName().equals("Test")) {
						assertEquals("Test", player.getName());
					}

				}
			}

		});
	}

	@Test
	public void testCreateEnemy() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Model.getInstance().createEnemy(new Rectangle(), "Enemy1", 100, 1, "/enemy.png", 5, 5);
				for (Enemy enemy : Model.getInstance().enemies) {
					if (enemy.getName().equals("Enemy1")) {
						assertEquals("Enemy1", enemy.getName());
					}

				}
			}

		});
	}

	@Test
	public void testArraySizeWhenNoCreatedPlayers() {
		assertEquals(Model.getInstance().players.isEmpty(), true);
	}

	@Test
	public void testArraySizeWhenNoCreatedEnemies() {
		assertEquals(Model.getInstance().enemies.isEmpty(), true);
	}

	@Test
	public void testArraySizeWhenCreateOnePlayer() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Model.getInstance().createPlayer(new Rectangle(), "Test", 1, 1, "/game_player.png", 50, 50, 5);
				assertEquals(1, Model.getInstance().players.size());
			}

		});

	}

	@Test
	public void testArraySizeWhenCreateOneEnemy() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Model.getInstance().createEnemy(new Rectangle(), "Enemy1", 100, 1, "/enemy.png", 5, 5);
				// Model.getInstance().createEnemy(find("#anchorPane"),
				// "Enemy1", 100, 1, "/enemy.png", 5, 5);
				assertEquals(1, Model.getInstance().enemies.size());
			}

		});

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
		this.stageP = stage;
	}

	@After
	public void afterEachTest() throws Exception {
		FxToolkit.cleanupStages();
		Model.getInstance().players.clear();
		Model.getInstance().enemies.clear();
	}

	@AfterClass
	public static void noJavaFxThreadShouldBeRunningTest() {
		assertFalse(Thread.currentThread().equals("JavaFX Application Thread"));
	}

}
