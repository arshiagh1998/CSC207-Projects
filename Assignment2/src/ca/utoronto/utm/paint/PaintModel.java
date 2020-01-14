package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintModel extends Observable {

	private ArrayList<DrawingCommand> commands = new ArrayList<DrawingCommand>(); //Commands used to draw canvas
	private ArrayList<DrawingCommand> undoCommands = new ArrayList<DrawingCommand>(); //Shapes taken off screen using undo
	private ColorSerializable color =new ColorSerializable(Color.BLACK);
	/**
	 * Adds given circle to list of drawing commands
	 * 
	 * @param circle
	 *            Circle to be drawn
	 */
	public void addCircle(Circle circle) {
		undoCommands.clear();
		commands.add(circle);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setColor(ColorSerializable c){
		this.color = c;
		this.commands.add(c);
	}

	/**
	 * Adds given rectangle to list of drawing commands
	 * 
	 * @param rectangle
	 *            Rectangle to be drawn
	 */
	public void addRecetangle(Rectangle rectangle) {
		undoCommands.clear();
		commands.add(rectangle);
		this.setChanged();
		this.notifyObservers();
	}

	public void addSquiggle(Squiggle squiggle) {
		undoCommands.clear();
		commands.add(squiggle);
		this.setChanged();
		this.notifyObservers();
	}
	public void addPolyline(Polyline polyline) {
		undoCommands.clear();
		commands.add(polyline);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Adds given square to list of drawing commands
	 * 
	 * @param square
	 *            Square to be drawn
	 */
	public void addSquare(Square s) {
		undoCommands.clear();
		commands.add(s);
		this.setChanged();
		this.notifyObservers();
		System.out.println(commands.size());
	}

	/**
	 * Draws all Shapes stored in commands
	 * 
	 * @param g
	 */
	public void executeAll(GraphicsContext g) {
		System.out.println("COMMAND");
		for (DrawingCommand command : commands) {
			System.out.println(command);
			command.execute(g);
		}
	}
	/**
	 * Deletes previous created Shapes on canvas.
	 */
	public void undo() {
		if (commands.size() > 0) {
			System.out.println(commands.size() - 1);
			undoCommands.add(commands.get(commands.size() - 1));
			this.commands.remove(commands.size() - 1);
			this.setChanged();
			this.notifyObservers();
		}
	}
	/**
	 * Re-paints the previously undone Shapes. 
	 */
	public void redo() {
		if (undoCommands.size() > 0) {
			commands.add(undoCommands.get(undoCommands.size() - 1));
			undoCommands.remove(undoCommands.size() - 1);
			this.setChanged();
			this.notifyObservers();
		}
	}
	/**
	 * Sets commands to given list of commands (helpful when opening file)
	 * @param commands Commands used to draw screen
	 */
	public void setCommands(ArrayList<DrawingCommand> commands) {
		this.commands = commands;
		this.setChanged();
		this.notifyObservers();
	}
	public void changePoint(Squiggle s, Point p) {
		s.addPoint(p);
		this.setChanged();
		this.notifyObservers();
	}
	public void changePoint1(Polyline l, Point p) {
		l.addPoint(p);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Changes the given circle's radius to given radius
	 * 
	 * @param c
	 *            Circle to be changed
	 * @param radius
	 *            Radius to be changed to
	 */
	public void changeCircleRadius(Circle c, int radius) {
		c.setRadius(radius);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Changes the given square's radius to given radius
	 * 
	 * @param s
	 *            Square to be changed
	 * @param radius
	 *            Radius to be changed to
	 */
	public void changeSquareRadius(Square s, int radius) {
		s.setRadius(radius);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Changes the given Rectangle's second point to given point P2
	 * 
	 * @param r
	 *            Rectangle to be changed
	 * @param p2
	 *            Point to be changed to
	 */
	public void changeRectangleP2(Rectangle r, Point p2) {
		r.setP2(p2);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Returns ArrayList of drawing commands
	 * 
	 * @return commands
	 */
	public ArrayList<DrawingCommand> getCommands() {
		return commands;
	}
	

}
