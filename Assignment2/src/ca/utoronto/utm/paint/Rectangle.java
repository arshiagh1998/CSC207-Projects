package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

	private Point p1;
	private Point p2;

	public Rectangle(Point p1, boolean fill, double linethick) {
		super(fill, linethick);
		this.p1 = p1;
		this.p2 = p1;

	}

	public Rectangle(Point p1, Point p2, boolean fill, double linethick) {
		super(fill, linethick);
		this.p1 = p1;
		this.p2 = p2;

	}

	public Point getCorner() {
		return new Point(this.getX(), this.getY());
	}

	private int getX() {
		if (p1.x < p2.x) {
			return p1.x;
		}
		return p2.x;
	}

	private int getY() {
		if (p1.y < p2.y) {
			return p1.y;
		}
		return p2.y;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public int getWidth() {
		return Math.abs(p1.x - p2.x);
	}

	public int getHeight() {
		return Math.abs(p1.y - p2.y);
	}

	@Override
	public void execute(GraphicsContext g) {

		if (this.getFill()) {
			g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		} else {
			g.strokeRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}

	}
}