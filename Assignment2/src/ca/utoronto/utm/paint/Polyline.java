package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Polyline extends Shape {
	
	private ArrayList<Point> points;
	private Point p1 = new Point(0,0);
	private Point p2 = new Point(0,0);
	
	public Polyline(ArrayList<Point> points, Color color, boolean fill, double linethick) {
		super(fill, linethick);
		this.points = points;
		
	}


	public void addPoint(Point p)
	{
		this.points.add(p);
	}
	
	public Point getPoint(int i){
		return points.get(i);
	}
	
	public ArrayList<Point> getPoints(){
		return points;
	}
	
	
	public void setPoints(ArrayList<Point> p){
		this.points = p;
	}
	
	
	
	public void execute(GraphicsContext g) {
		
	
		g.setLineWidth(this.linethick);
		for (int i = 0; i < points.size() - 1; i++) {
		if (this.points != null){
			p1 = this.getPoint(i);
			p2 = this.getPoint(i+1);
			g.strokeLine(p1.x, p1.y, p2.x, p2.y);
			//g.strokePolyline(new double []{p1.x, p2.x}, new double [] {p1.y, p2.y}, 2);//(p1.x, p1.y, p2.x, p2.y);
			
            g.setLineWidth(this.linethick);
		}
	}
		
	

  }
}
