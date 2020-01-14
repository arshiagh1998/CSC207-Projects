package ca.utoronto.utm.paint;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class View implements EventHandler<ActionEvent> {

	private PaintModel model;
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorPickerPanel colorPickerPanel;
	private EventHandler<ActionEvent> undoEventHandler;
	private EventHandler<ActionEvent> redoEventHandler;
	private ArrayList<Color> colors = new ArrayList<Color>();
	private final String[] colorList = {"red", "green", "blue", "black", "white", "purple"};

	public View(PaintModel model, Stage stage) {
		this.model = model;
		initUI(stage);
	}

	private void initUI(Stage stage) {

		this.paintPanel = new PaintPanel(this.model, this);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		for (String color: colorList) {
			colors.add(Color.web(color));
		}
		this.colorPickerPanel = new ColorPickerPanel(this, colors);

		BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		root.setLeft(this.shapeChooserPanel);
		root.setBottom(this.colorPickerPanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.show();

	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;
		undoEventHandler = new UndoEventHandler(this.model);
		redoEventHandler = new RedoEventHandler(this.model);

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setOnAction(this);
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setOnAction(undoEventHandler);
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setOnAction(redoEventHandler);
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		return menuBar;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(((MenuItem) event.getSource()).getText());
		try {
			if (((MenuItem) event.getSource()).getText().equals("Open")) { //Open file
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Image");
				model.setCommands(FileWriting.openImage(fileChooser.showOpenDialog(null).getAbsolutePath()));
			}
			if (((MenuItem) event.getSource()).getText().equals("Save")) { //Save file
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Image");
				FileWriting.saveImage(model.getCommands(), fileChooser.showSaveDialog(null).getAbsolutePath());
			}
			if (((MenuItem) event.getSource()).getText().equals("Exit")) {
				Platform.exit(); //Closes program
			}
		} catch (NullPointerException e) {
			// User clicked Cancel on Save/Open dialog
		}
	}
}
