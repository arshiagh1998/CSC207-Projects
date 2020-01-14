package ca.utoronto.utm.paint;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * Class used to allow color to be serialized for saving and opening.
 * @author liameaton
 *
 */
public class ColorSerializable implements Serializable, DrawingCommand {
	private String color;
	/**
	 * Creates new ColorSerializable
	 * @param c Color
	 */
	public ColorSerializable(Color c) {
		this.color = c.toString();
	}
	/**
	 * Returns JavaFX Color of ColorSerializable
	 * @return Color of this object
	 */
	public Color getColor() {
		return Color.web(this.color);
	}
	
	public void execute(GraphicsContext g) {
		g.setFill(this.getColor());
		g.setStroke(this.getColor());
	}

}
