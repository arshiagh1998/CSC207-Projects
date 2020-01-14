package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CircleStrategy implements ShapeStrategy{
	
	private Circle circle;
	private PaintModel model;
	private ColorSerializable color;
	private boolean fill;
	private double linethick;
	
	
	public CircleStrategy(PaintModel model, ColorSerializable color, boolean fill, double linethick) {
		
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
			this.circle = new Circle(centre, radius, this.fill, this.linethick);
			this.model.addCircle(this.circle);
			

	}
	private void mouseDragged(MouseEvent e) {
			
			int curRadius = (int) Math.sqrt((Math.pow(this.circle.getCentre().getX() - e.getX(), 2.0) + Math.pow(this.circle.getCentre().getY() - e.getY(),2.0)));
			this.model.changeCircleRadius(this.circle, curRadius);
			
	
	}
	private void mouseReleased(MouseEvent e) {
				
				this.circle = null;

	}
	public void setColor(ColorSerializable color){
		this.color = color;
		
	}
	public void setFill(boolean fill){
		this.fill = fill;
	}

	public void setLineThick(double linethick) {
		this.linethick = linethick;
		
	}

}
