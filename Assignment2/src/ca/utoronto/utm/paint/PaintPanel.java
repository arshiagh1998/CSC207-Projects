package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private int i = 0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private String mode; // modifies how we interpret input (could be better?)
	private CircleStrategy circlestr; 
	private RectangleStrategy rectanglestr;
	private SquareStrategy squarestr;
	private SquiggleStrategy squigglestr;
	private ColorSerializable color;
	private Squiggle squiggle;



	private Canvas canvas;
//	private Polyline polyline = new Polyline(new ArrayList<Point>(), this.color, this.fill, this.linethick);
	private double linethick = 1;
	private boolean fill = false;

	public PaintPanel(PaintModel model, View view) {
		model.setColor(new ColorSerializable(Color.BLACK));
		this.circlestr = new CircleStrategy(model, this.color, fill, linethick);
		this.rectanglestr = new RectangleStrategy(model, this.color, fill, linethick);
		this.squarestr = new SquareStrategy(model, fill, linethick);
		this.squigglestr = new SquiggleStrategy(model, this.color, fill, linethick);
		
		this.canvas = new Canvas(640, 480);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		this.mode = ""; // bad code here?

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	public PaintModel getPaintModel() {
		return this.model;
	}

	


	public void clearCanvas(GraphicsContext g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setLineWidth(1);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		clearCanvas(g);
		// Draw Shapes
		this.model.executeAll(g);

	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public void handle(MouseEvent event) {

		
		if (this.mode == "Squiggle") {

			this.squigglestr.execute(event);  
			
		} else if (this.mode == "Circle") {
			this.circlestr.execute(event);
			
		} else if (this.mode == "Rectangle") {

			this.rectanglestr.execute(event);
			
		} else if (this.mode == "Square") {
			
			this.squarestr.execute(event);
			

		}
//		else if (this.mode =="Polyline") {
//			this.model.changePoint1(this.polyline, new Point((int) e.getX(), (int) e.getY()));
//			this.polyline = new Polyline(new ArrayList<Point>(), this.color, this.fill, this.linethick);
//			this.model.addPolyline(this.polyline);
//		}
	}
	

	public void setLineThick(double linethick) {
		this.linethick = linethick;

		this.circlestr.setLineThick(linethick);
		this.rectanglestr.setLineThick(linethick);
		this.squarestr.setLineThick(linethick);
		this.squigglestr.setLineThick(linethick);
		
	}
	
	public void setFill(boolean fill){
		this.fill = fill;
		this.circlestr.setFill(fill);
		this.rectanglestr.setFill(fill);
		this.squarestr.setFill(fill);
		this.squigglestr.setFill(fill);
	}


	

}
