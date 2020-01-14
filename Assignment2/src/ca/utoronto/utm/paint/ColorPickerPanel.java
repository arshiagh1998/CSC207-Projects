package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
/**
 * Selection panel used to select Color to be used for given shape, and display current Color
 * @author liameaton
 *
 */
public class ColorPickerPanel extends GridPane implements EventHandler<ActionEvent> {
	private ArrayList<Color> colors = new ArrayList<Color>();
	private View view;
	private ToggleGroup colorGroup = new ToggleGroup();
	private Button curColor = new Button();
	/**
	 * Creates new ColorPickerPanel given ArrayList of Color
	 * @param view View to be displayed in
	 * @param colors List of Colors to be displayed
	 */
	public ColorPickerPanel(View view, ArrayList<Color> colors) {
		this.view = view;
		this.add(curColor, 0, 0);
		this.curColor.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		curColor.setScaleX(10.0);
		//view.getPaintPanel().setColor(Color.BLACK);
		this.colors = colors;
		int i = 0;
		for (Color c: colors) {
			ToggleButton colorButton = new ToggleButton();
			colorButton.setToggleGroup(colorGroup);
			colorButton.setBackground(new Background(new BackgroundFill(c, null, null)));
			colorButton.setId(c.toString());
			this.add(colorButton, i, 1);
			colorButton.setOnAction(this);
			i += 1;
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Color color = Color.web(((ToggleButton) event.getSource()).getId());
		this.view.getPaintPanel().getPaintModel().setColor(new ColorSerializable(color));
		this.curColor.setBackground(new Background(new BackgroundFill(color, null, null)));
	}
}
