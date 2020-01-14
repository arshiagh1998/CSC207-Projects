package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RectangleStrategy implements ShapeStrategy{
	
	private Rectangle rectangle;
	private PaintModel model;
	private ColorSerializable color;
	private boolean fill;
	private double linethick;
	
	
	public RectangleStrategy(PaintModel model, ColorSerializable color, boolean fill, double linethick) {
		
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
		
		
		Point corner = new Point((int) e.getX(), (int) e.getY());
		this.rectangle = new Rectangle(corner,this.fill, this.linethick);
		this.model.addRecetangle(this.rectangle);

	}
	private void mouseDragged(MouseEvent e) {
		Point p2 = new Point((int)e.getX(), (int)e.getY());
		this.model.changeRectangleP2(this.rectangle, p2);
			
	
	}
	private void mouseReleased(MouseEvent e) {
		this.rectangle = null;

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
