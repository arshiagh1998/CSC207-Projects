package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RedoEventHandler implements EventHandler<ActionEvent> {
	private PaintModel paintmodel;
	
	public RedoEventHandler(PaintModel paintmodel) {
		this.paintmodel = paintmodel;
	}

	@Override
	public void handle(ActionEvent event) {
		paintmodel.redo();
		
	}

}
