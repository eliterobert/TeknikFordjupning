package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.util.WaitForAsyncUtils;

import static org.testfx.matcher.base.NodeMatchers.*;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import static org.testfx.api.FxAssert.*;

/**
 * Unit test for MazeGame
 */

public class MazeGameTest extends ApplicationTest {
	private final double DELTA = 1e-15;
	final String LABEL_ON_STARTPAGE = "#startPageLabel";
	final String START_BUTTON = "#startButton";
	Stage stageP;

	@Before
	public void setUp() throws Exception {
		ApplicationTest.launch(MazeGame.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
		this.stageP = stage;
	}

	@Test
	public void stageShouldNotBeNull() {
		assertNotNull(stageP);
	}

	@Test
	public void startSceneShouldNotBeRezisizeabe() {
		assertFalse(stageP.isResizable());
	}

	@Test
	public void stageShoudBe800Times800() {
		assertEquals(800.00, stageP.getHeight(), DELTA);
		assertEquals(800.00, stageP.getWidth(), DELTA);
	}

	@Test
	public void checkIfGameLabelIsVisibleAndWithCorrectName() {
		assertTrue(find(LABEL_ON_STARTPAGE).isVisible());
		verifyThat(LABEL_ON_STARTPAGE, hasText("Maze Game"));
	}

	@Test
	public void verifyThatButtonIsSetOnSceen() {
		verifyThat(START_BUTTON, hasText("Start"));
	}

	@Test(expected = FxRobotException.class)
	public void clickOnElementThatDoesntExsist() {
		clickOn("#falseElement");
	}

	@Test
	public void testThatStageIsShowing() {
		clickOn("#startButton");
	}

	@Test
	public void tearDown() {

	}

	@After
	public void afterEachTest() throws Exception {
		FxToolkit.hideStage();
		release(new KeyCode[] {});
		release(new MouseButton[] {});

	}

	@SuppressWarnings("unchecked")
	public <T extends Node> T find(final String query) {
		return (T) lookup(query).queryAll().iterator().next();
	}

}
