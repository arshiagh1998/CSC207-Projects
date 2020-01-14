package ca.utoronto.utm.paint;


import javafx.scene.input.MouseEvent;

public interface ShapeStrategy {
	public abstract void execute(MouseEvent e);
}
