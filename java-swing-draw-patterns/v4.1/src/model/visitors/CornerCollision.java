package model.visitors;

import java.awt.Point;

import model.composite.DrawingContainer;
import model.enums.Corner;
import model.shapes.Circle;
import model.shapes.Line;
import model.shapes.Rect;

/**
 * This class is responsible for checking corner collisions for different shapes.
 */
public class CornerCollision implements IShapeVisitor<Corner> {
	private Point mouse;
	private int cornerSize;
	
	public CornerCollision(Point mouseIn) {
		mouse = mouseIn;
		cornerSize = 10;
	}

	/**
	 * Checks corner collisions for rectangles.
	 */
	@Override
	public Corner visit(Rect rect) {
		int shapeX = rect.getX1();
	    int shapeY = rect.getY1();
	    int shapeW = rect.getWidth();
	    int shapeH = rect.getHeight();
	    
		if (isInCorner(mouse, shapeX, shapeY)) 
            return Corner.TOP_LEFT;
            
        if (isInCorner(mouse, shapeX + shapeW, shapeY)) 
            return Corner.TOP_RIGHT;
            
        if (isInCorner(mouse, shapeX, shapeY + shapeH)) 
            return Corner.BOTTOM_LEFT;
            
        if (isInCorner(mouse, shapeX + shapeW, shapeY + shapeH)) 
            return Corner.BOTTOM_RIGHT;
        else
        	return Corner.NONE;
	}

	/**
	 * Checks corner collisions for lines.
	 */
	@Override
	public Corner visit(Line line) {
		int shapeX = line.getX1();
	    int shapeY = line.getY1();
	    int shapeW = line.getWidth();
	    int shapeH = line.getHeight();
	    
	    if (isInCorner(mouse, shapeX, shapeY)) 
        	return Corner.TOP_LEFT;
        
        if (isInCorner(mouse, shapeX + shapeW, shapeY + shapeH)) 
        	return Corner.BOTTOM_RIGHT;
        else
        	return Corner.NONE;
	}

	/**
	 * Checks corner collisions for circles.
	 */
	@Override
	public Corner visit(Circle circle) {
		int shapeX = circle.getX1();
	    int shapeY = circle.getY1();
	    int shapeW = circle.getWidth();
	    int shapeH = circle.getHeight();
	    
		if (isInCorner(mouse, shapeX, shapeY)) 
            return Corner.TOP_LEFT;
            
        if (isInCorner(mouse, shapeX + shapeW, shapeY)) 
            return Corner.TOP_RIGHT;
            
        if (isInCorner(mouse, shapeX, shapeY + shapeH)) 
            return Corner.BOTTOM_LEFT;
            
        if (isInCorner(mouse, shapeX + shapeW, shapeY + shapeH)) 
            return Corner.BOTTOM_RIGHT;
        else
        	return Corner.NONE;
	}

	@Override
	public Corner visit(DrawingContainer drawingContainer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Collision logic to check if current mouse position is inside a corner of a shape.
	 * @param mouse Bundle of the current mouse x, y position
	 * @param targetX 
	 * @param targetY
	 * @return
	 */
	private boolean isInCorner(Point mouse, int targetX, int targetY) {
	    int half = cornerSize / 2;
	    return (mouse.x >= targetX - half && mouse.x <= targetX + half) &&
	           (mouse.y >= targetY - half && mouse.y <= targetY + half);
	}	
}
