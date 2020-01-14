package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SquiggleStrategy implements ShapeStrategy{
	
	private Squiggle squiggle;
	private PaintModel model;
	private ColorSerializable color;
	private boolean fill;
	private double linethick;
	
	
	public SquiggleStrategy(PaintModel model, ColorSerializable color, boolean fill, double linethick) {
		
		this.model = model;
		this.color = color;
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
		
		
		this.squiggle = new Squiggle(new ArrayList<Point>(), this.fill, this.linethick);
		this.model.addSquiggle(this.squiggle);

	}
	private void mouseDragged(MouseEvent e) {
		
		this.model.changePoint(this.squiggle, new Point((int) e.getX(), (int) e.getY()));
	
	}
	private void mouseReleased(MouseEvent e) {
		this.squiggle = null;

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
