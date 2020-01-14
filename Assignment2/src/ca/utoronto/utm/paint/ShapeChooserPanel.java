package ca.utoronto.utm.paint;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	private String command;
	private View view; // So we can talk to our parent or other components of
						// the view
	private ToggleGroup shapes = new ToggleGroup();
	private ToggleGroup features = new ToggleGroup();
	private ToggleGroup fills = new ToggleGroup();
	private Map<String, String> COMMANDS = new HashMap<String, String>();
	private CircleStrategy circlestr;

	public ShapeChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "\u20DD", "\u25AD", "\u20DE", "\u2307", "\u251B" };
		COMMANDS.put("\u20DD", "Circle");
		COMMANDS.put("\u25AD", "Rectangle");
		COMMANDS.put("\u20DE", "Square");
		COMMANDS.put("\u2307", "Squiggle");
		COMMANDS.put("\u251B", "Polyline");
		
		int row = 0;
		for (String l : buttonLabels) {
			ToggleButton button = new ToggleButton(l);
			button.setToggleGroup(shapes);
			shapes.selectToggle(button);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
		}

		
		String[] fill = {"fill", "Not fill"};
		for (String l : fill) {
			ToggleButton button = new ToggleButton(l);
			button.setToggleGroup(fills);
			fills.selectToggle(button);
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);

		}
			ToggleButton button = new ToggleButton("Line Thickness");
			button.setMinWidth(100);
			this.add(button, 0, row);
			row++;
			button.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		String temp = ((ToggleButton) event.getSource()).getText();
		this.command = COMMANDS.get(temp);
		System.out.println(COMMANDS.get(temp));
		if (temp == "fill") {
			this.view.getPaintPanel().setFill(true);
		}
		else if (temp == "Line Thickness") {
			this.view.getPaintPanel().setLineThick(Double.parseDouble(JOptionPane.showInputDialog("Please enter a line thickness")));
		}
		else if (temp == "Not fill") {
			this.view.getPaintPanel().setFill(false);
			
		}
		else {
			this.view.getPaintPanel().setMode(command);
		}

	}
	
}
