package ca.utoronto.utm.scribble;

import javafx.scene.paint.Color;

public abstract class Atributes {
	private Color color;
	private double linethick;
	
	public Atributes(Color c, double linethick) {
		this.color = c;
		this.linethick = linethick;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void setLine(double linethick) {
		this.linethick = linethick;
	}
	public double getLine() {
		return this.linethick;
	}
	public Color getColor() {
		return this.color;
	}
	
}
