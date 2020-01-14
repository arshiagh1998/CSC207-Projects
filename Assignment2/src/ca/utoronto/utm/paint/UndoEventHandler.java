package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoEventHandler implements EventHandler<ActionEvent> {
	private PaintModel paintmodel;
	
	public UndoEventHandler(PaintModel paintmodel) {
		this.paintmodel = paintmodel;
	}

	@Override
	public void handle(ActionEvent event) {
		this.paintmodel.undo();
		
	}

}
