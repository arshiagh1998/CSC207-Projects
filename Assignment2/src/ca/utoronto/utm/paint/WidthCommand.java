package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

public class WidthCommand implements DrawingCommand {

	
	public void execute(GraphicsContext g) {
		g.setLineWidth(g.getLineWidth());
	}

}
