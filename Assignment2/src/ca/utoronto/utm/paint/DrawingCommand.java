package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
/**
 * Interface used by Shapes to enable self-drawing object (Command Design Pattern)
 * @author liameaton
 *
 */
public interface DrawingCommand {
	public abstract void execute(GraphicsContext g);
}
