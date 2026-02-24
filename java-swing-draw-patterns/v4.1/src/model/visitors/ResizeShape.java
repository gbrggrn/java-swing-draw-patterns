package model.visitors;

import java.awt.Point;

import model.composite.DrawingContainer;
import model.composite.DrawingShape;
import model.enums.Corner;
import model.shapes.Circle;
import model.shapes.Line;
import model.shapes.Rect;

/**
 * This class is responsible for resizing shapes.
 */
public class ResizeShape implements IShapeVisitor<Void> {
	private Corner corner;
	private Point point;
	
	public ResizeShape(Corner cornerIn, Point pointIn) {
		corner = cornerIn;
		point = pointIn;
	}

	@Override
	public Void visit(Rect rect) {
		resizeShape(rect);
		return null;
	}

	@Override
	public Void visit(Line line) {
		resizeShape(line);
		return null;
	}

	@Override
	public Void visit(Circle circle) {
		resizeShape(circle);
		return null;
	}

	@Override
	public Void visit(DrawingContainer drawingContainer) {
		
		return null;
	}
	
	/**
	 * This method calculates new height and width depending on which corner is fixed.
	 * @param shape The shape being visited.
	 */
	private void resizeShape(DrawingShape shape) {
		//TOP_LEFT fixed
		if (corner == Corner.BOTTOM_RIGHT) {
			shape.setWidth(point.x - shape.getX1());
			shape.setHeight(point.y - shape.getY1());
		}
		
		//BOTTOM_RIGHT fixed
		if (corner == Corner.TOP_LEFT) {
			int fixedRight = shape.getX1() + shape.getWidth();
			int fixedBottom = shape.getY1() + shape.getHeight();
			
			shape.setX1(point.x);
			shape.setY1(point.y);
			
			shape.setWidth(fixedRight - point.x);
			shape.setHeight(fixedBottom - point.y);
		}
		
		//TOP_RIGHT fixed
		if (corner == Corner.BOTTOM_LEFT) {
			int fixedRight = shape.getX1() + shape.getWidth();
			
			shape.setX1(point.x);
			shape.setWidth(fixedRight - point.x);
			shape.setHeight(point.y - shape.getY1());
		}
		
		//BOTTOM_LEFT fixed
		if (corner == Corner.TOP_RIGHT) {
			int fixedLeft = shape.getX1();
			int fixedBottom = shape.getY1() + shape.getHeight();
			
			shape.setY1(point.y);
			shape.setWidth(point.x - fixedLeft);
			shape.setHeight(fixedBottom - point.y);
		}
		
		normalizeWidthAndHeight(shape);
	}
	
	/**
	 * This method normalizes width and height so as to only work with positive values (no inverted shapes).
	 * @param shape The shape being visited.
	 */
	private void normalizeWidthAndHeight(DrawingShape shape) {
		if (shape.getWidth() < 0) {
			shape.setX1(shape.getX1() + shape.getWidth());
			shape.setWidth(Math.abs(shape.getWidth()));
		}
		if (shape.getHeight() < 0) {
			shape.setY1(shape.getY1() + shape.getHeight());
			shape.setHeight(Math.abs(shape.getHeight()));
		}
	}
}