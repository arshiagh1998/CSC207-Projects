package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SquareStrategy implements ShapeStrategy{
	
	private Square square;
	private PaintModel model;
	private Color color;
	private boolean fill;
	private double linethick;
	
	
	public SquareStrategy(PaintModel model, boolean fill, double linethick) {
		
		this.model = model;
		this.fill = fill;
		this.linethick = linethick;
		
		
	}
	
	@Override
	public void execute(MouseEvent e) {
		
		if(e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			mousePressed(e);
			
		}else if(e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			mouseDragged(e);
			
		}else if(e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			
			mouseReleased(e);
		}
			
	}
	private void mousePressed(MouseEvent e) {
		
		
		Point centre = new Point((int) e.getX(), (int) e.getY());
		int radius = 0;
		this.square = new Square(centre, radius, this.fill, this.linethick);
		this.model.addSquare(square);

	}
	private void mouseDragged(MouseEvent e) {
		int curRadius = (int) Math.sqrt((Math.pow(this.square.getCentre().getX() - e.getX(), 2.0) + Math.pow(this.square.getCentre().getY() - e.getY(),2.0)));
		this.model.changeSquareRadius(this.square, curRadius);
			
	
	}
	private void mouseReleased(MouseEvent e) {
		this.square = null;

	}
	public void setColor(Color color){
		this.color = color;
		
	}
	public void setFill(boolean fill){
		this.fill = fill;
	}

	public void setLineThick(double linethick) {
		this.linethick = linethick;
		
	}

}
