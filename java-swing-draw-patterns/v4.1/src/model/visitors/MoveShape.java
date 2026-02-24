package model.visitors;

import java.awt.Point;

import model.composite.DrawingContainer;
import model.composite.DrawingShape;
import model.shapes.Circle;
import model.shapes.Line;
import model.shapes.Rect;

/**
 * This class is responsible for logic for moving shapes.
 */
public class MoveShape implements IShapeVisitor<Void> {
	private Point point;
	int lastMouseX;
	int lastMouseY;
	
	public MoveShape(Point pointIn, int lastMouseXIn, int lastMouseYIn) {
		point = pointIn;
		lastMouseX = lastMouseXIn;
		lastMouseY = lastMouseYIn;
	}

	@Override
	public Void visit(Rect rect) {
		moveShape(rect);
		return null;
	}

	@Override
	public Void visit(Line line) {
		moveShape(line);
		return null;
	}

	@Override
	public Void visit(Circle circle) {
		moveShape(circle);
		return null;
	}

	@Override
	public Void visit(DrawingContainer drawingContainer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Calculates the difference in x and y position of the shape between current and last known.
	 * @param shape The shape that is being visited.
	 */
	private void moveShape(DrawingShape shape) {
		int deltaX = point.x - lastMouseX;
		int deltaY = point.y - lastMouseY;
		
		shape.setX1(shape.getX1() + deltaX);
		shape.setY1(shape.getY1() + deltaY);
	}
}