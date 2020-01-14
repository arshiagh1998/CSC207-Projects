package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class Squiggle extends Shape {
	
	private ArrayList<Point> points;
	private Point p1 = new Point(0,0);
	private Point p2 = new Point(0,0);
	
	public Squiggle(ArrayList<Point> points, boolean fill, double linethick) {
		super(fill, linethick);
		this.points = points;
		
	}


	/**
	 * Adds a point to the points arrayList 
	 * @author ArshiaGharai(gharaiar)
	 */
	public void addPoint(Point p)
	{
		this.points.add(p);
	}
	
	/**
	 * returns the point at index i in the points arrayList 
	 * @author ArshiaGharai(gharaiar)
	 */
	public Point getPoint(int i){
		return points.get(i);
	}
	
	/**
	 * returns the points arrayList 
	 * @author ArshiaGharai(gharaiar)
	 */
	public ArrayList<Point> getPoints(){
		return points;
	}
	
	/**
	 * returns the point at index i in the points arrayList 
	 * @author ArshiaGharai(gharaiar)
	 */
	public void setPoints(ArrayList<Point> p){
		this.points = p;
	}
	
	
	/**
	 * this function draws a squiggle whenever called with appropriate inputs.
	 * @author ArshiaGharai
	 */
	public void execute(GraphicsContext g) {
		
		
		g.setLineWidth(this.linethick);
		for (int i = 0; i < points.size() - 1; i++) {
		if (this.points != null){
			
			p1 = this.getPoint(i);
			p2 = this.getPoint(i+1);
			
			g.beginPath();			
	        g.moveTo(p1.getX(), p1.getY());
	        g.lineTo(p2.getX(), p2.getY());	        
			g.closePath();			
			g.stroke();
            g.setLineWidth(this.linethick);
		}
	}
		
	

  }
}
