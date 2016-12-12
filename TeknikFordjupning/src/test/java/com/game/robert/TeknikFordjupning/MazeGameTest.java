package com.game.robert.TeknikFordjupning;

import static org.junit.Assert.*;

import java.io.IOException;
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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
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
	Controller cont;

	@Before
	public void setUp() throws Exception {
		ApplicationTest.launch(MazeGame.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
		this.stageP = stage;
		this.cont = new Controller();
	}

	@Test
	public void testStageShouldNotBeNull() {
		assertNotNull(stageP);
	}

	@Test
	public void testSceneShouldNotBeRezisizeabe() {
		assertFalse(stageP.isResizable());
	}

	@Test
	public void testThatStageWidthAndHeightIs800Times800() {
		assertEquals(800.00, stageP.getHeight(), DELTA);
		assertEquals(800.00, stageP.getWidth(), DELTA);
	}

	@Test
	public void testIfGameLabelIsVisibleAndWithCorrectName() {
		assertTrue(find(LABEL_ON_STARTPAGE).isVisible());
		verifyThat(LABEL_ON_STARTPAGE, hasText("Maze Game"));
	}

	@Test
	public void testThatButtonIsSetOnSceen() {
		verifyThat(START_BUTTON, hasText("Start"));
	}

	@Test(expected = FxRobotException.class)
	public void testClickOnElementThatDoesntExsist() {
		clickOn("#falseElement");
	}

	@Test
	public void testButtonEvent_StageShouldNotBePrimaryStage_ShouldBeGameScene()
			throws IOException, InterruptedException {
		clickOn("#startButton");
		WaitForAsyncUtils.waitForFxEvents();
		assertNotEquals("PrimaryStageApplication", stageP.getTitle());
		assertEquals("Game Scene", stageP.getTitle());

	}

	@Test
	public void testIfPlayerIsAddedOnGameSceneWhenPressedStartButton() {
		clickOn("#startButton");
		WaitForAsyncUtils.waitForFxEvents();
		// TODO KOLLA OM SPELAREN HAMNAR PÅ SPELSIDAN
		AnchorPane anchor = find("#anchorPane");
		Player player = new Player();
		player.setImage(new Image(getClass().getResource("/game_player.png").toString()));
		ObservableList<Node> obsList = FXCollections.observableArrayList();
		obsList.addAll(anchor.getChildren());
		for (Node node : obsList) {
			if (node instanceof ImageView) {
				assertEquals(player.getImage().getHeight(), ((ImageView) node).getImage().getHeight(), DELTA);
				assertEquals(player.getImage().getWidth(), ((ImageView) node).getImage().getWidth(), DELTA);
			}
		}
	}

	// @Test
	// public void tearDown() {
	//
	// }

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
