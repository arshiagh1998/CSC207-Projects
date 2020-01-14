package ca.utoronto.utm.paint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * Circle objects created from this class which are self-drawing, storing
 * their own radius, color, thickess, centre, and fill.
 * @author liameaton
 *
 */
public class Circle extends Shape {
	
	/**
	 * 
	 */
	private Point centre;
	private int radius;
	
	/**
	 * Creates new Circle given a centre point, radius, color, isFill, and linethickness of border.
	 * @param centre Centre point of circle
	 * @param radius Radius of circle
	 * @param color Color of circle drawn
	 * @param fill True iff. circle drawn is to be filled in
	 * @param linethick Thickness of border surrounding circle
	 */
	public Circle(Point centre, int radius, boolean fill, double linethick) {
		super(fill, linethick);
		this.centre = centre;
		this.radius = radius;
		
	}
	/**
	 * Returns cente point of Circle
	 * @return Centre point of Circle
	 */
	public Point getCentre() {
		return this.centre;
	}
	/**
	 * Sets centre of Cirlce to given centre
	 * @param centre
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	/**
	 * Returns radius of circle
	 * @return Radius of circle
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * Sets Radius of circle to given radius
	 * @param radius Radius of circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	/**
	 * Draws current Circle based on parameters stored in Circle
	 */
	public void execute(GraphicsContext g) {
		if (this.getFill()) {
			g.fillOval(this.centre.x - this.radius, this.centre.y - this.radius, this.radius*2, this.radius*2);
		}
		else {
			g.strokeOval(this.centre.x - this.radius, this.centre.y - this.radius, this.radius*2, this.radius*2);
		}
		
	}
	

}
