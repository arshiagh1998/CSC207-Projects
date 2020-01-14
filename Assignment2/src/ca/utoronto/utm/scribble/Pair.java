package ca.utoronto.utm.scribble;

import javafx.scene.paint.Color;

public class Pair extends Atributes{
	int x, y;

	Pair(int x, int y,Color color, double linethick) {
		super(color, linethick);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
