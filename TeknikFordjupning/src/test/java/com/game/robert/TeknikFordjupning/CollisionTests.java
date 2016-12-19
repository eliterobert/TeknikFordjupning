package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

@RunWith(JfxTestRunner.class)
public class CollisionTests extends ApplicationTest {

	@Before
	public void setUp() throws Exception {

		ApplicationTest.launch(MazeGame.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
	}

	@Test
	public void rectanglesAreNotTheSameTest() {
		clickOn("#startButton");
		assertNotEquals(Model.getInstance().players.get(0).getPlayerRectangle(),
				Model.getInstance().enemies.get(0).getEnemyRectangle());
	}

	@Test
	public void playerCollideWithEnemyShouldDissapearTest() throws InterruptedException {
		clickOn("#startButton");
		press(KeyCode.RIGHT);
		release(new KeyCode[] {});
		press(KeyCode.RIGHT);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.UP);
		release(new KeyCode[] {});
		press(KeyCode.RIGHT);
		Thread.sleep(2000);
		assertEquals(false, Model.getInstance().players.get(0).getPlayerRectangle().isVisible());
	}

	@After
	public void afterEachTest() throws Exception {
		FxToolkit.hideStage();
		release(new KeyCode[] {});
		release(new MouseButton[] {});

	}

}
