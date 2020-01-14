package ca.utoronto.utm.paint;

import java.io.Serializable;

import javafx.scene.paint.Color;

/**
 * Shape objects are created using this class. Shape stores information about a
 * Shape's color, border thickness, Fill/Not Fill drawing parameters. Allows for
 * Shapes to be self-drawn when implemented with execute method in sub-classes.
 * 
 * @author liameaton
 *
 */
public abstract class Shape implements DrawingCommand, Serializable {
	private boolean isFill = false;
	protected double linethick;

	/**
	 * Creates a new Shape with Color c, border thickness linethick, and fill (True
	 * iff. desired Shape is filled in when drawn)
	 * 
	 * @param c
	 *            Color of shape
	 * @param fill
	 *            True iff. shape is filled when drawn
	 * @param linethick
	 *            Thickness of border of shape
	 */
	public Shape (boolean fill, double linethick) {
		this.isFill = fill;
		this.linethick = linethick;
	}


	public void setLine(double linethick) {
		this.linethick = linethick;
	}

	public double getLine() {
		return this.linethick;
	}

	public boolean getFill() {
		return this.isFill;
	}

	public void setFill(boolean f) {
		this.isFill = f;
	}

}
