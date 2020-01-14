package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * Square objects created from this class which are self-drawing, storing
 * their own radius, color, thickess, centre, and fill.
 * @author liameaton
 *
 */
public class Square extends Shape {
	
	/**
	 * 
	 */
	private Point centre;
	private int radius;
	
	/**
	 * Creates new Square given a centre point, radius, color, isFill, and linethickness of border.
	 * @param centre Centre point of Square
	 * @param radius Radius of Square
	 * @param color Color of Square drawn
	 * @param fill True iff. Square drawn is to be filled in
	 * @param linethick Thickness of border surrounding Square
	 */
	public Square(Point centre, int radius,boolean fill, double linethick) {
		super(fill, linethick);
		this.centre = centre;
		this.radius = radius;
		
	}
	/**
	 * Returns cente point of Square
	 * @return Centre point of Square
	 */
	public Point getCentre() {
		return this.centre;
	}
	/**
	 * Sets centre of Square to given centre
	 * @param centre
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	/**
	 * Returns radius of Square
	 * @return Radius of Square
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * Sets Radius of Square to given radius
	 * @param radius Radius of Square
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	/**
	 * Draws current Square based on parameters stored in Square
	 */
	public void execute(GraphicsContext g) {
		
		g.setLineWidth(this.linethick);
		if (this.getFill()) {
			g.fillRect(this.centre.x - this.radius, this.centre.y - this.radius, this.radius*2, this.radius*2);
		}
		else {
			g.strokeRect(this.centre.x - this.radius, this.centre.y - this.radius, this.radius*2, this.radius*2);
		}
		
	}
	

}
