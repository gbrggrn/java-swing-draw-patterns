package model.visitors;

import java.awt.Point;

import model.composite.DrawingContainer;
import model.shapes.Circle;
import model.shapes.Line;
import model.shapes.Rect;

/**
 * This class is responsible for checking shape collisions.
 */
public class ShapeCollision implements IShapeVisitor<Boolean> {
	private Point mouse;
	
	public ShapeCollision(Point mouseIn) {
		mouse = mouseIn;
	}

	/**
	 *Collision logic to check if the current mouse position is inside a shape.<br>
	 *Same as for line.
	 */
	@Override
	public Boolean visit(Rect rect) {
		int shapeX = rect.getX1();
	    int shapeY = rect.getY1();
	    int shapeW = rect.getWidth();
	    int shapeH = rect.getHeight();
	    
    	//If shape is inside width and height -> true
        return (mouse.x >= shapeX && mouse.x <= shapeX + shapeW) &&
               (mouse.y >= shapeY && mouse.y <= shapeY + shapeH);
	}

	/**
	 *Collision logic to check if the current mouse position is inside a shape.<br>
	 *Same as for rectangle.
	 */
	@Override
	public Boolean visit(Line line) {
		int shapeX = line.getX1();
	    int shapeY = line.getY1();
	    int shapeW = line.getWidth();
	    int shapeH = line.getHeight();
	    
    	//If shape is inside width and height -> true
        return (mouse.x >= shapeX && mouse.x <= shapeX + shapeW) &&
               (mouse.y >= shapeY && mouse.y <= shapeY + shapeH);
	}

	/**
	 *Checks if mouse position is closer to the center of the circle than the circles radius.
	 */
	@Override
	public Boolean visit(Circle circle) {
		int shapeX = circle.getX1();
	    int shapeY = circle.getY1();
	    int shapeW = circle.getWidth();
	    
		//Calculate radius
        int radius = shapeW / 2;
        //Calculate center x position
        int centerX = shapeX + radius;
        //Calculate center y position
        int centerY = shapeY + radius;
        
        //Calculate change in x position (delta) between mouse-, and original shape x position
        int dx = mouse.x - centerX;
        //Calculate change in y position (delta) between mouse-, and original shape y position
        int dy = mouse.y - centerY;
        
        //If the mouse pos is further from the center than the radius -> return false (no collision)
        //If the mouse pos is closer to the center than the radius -> return true (collision)
        return (dx * dx + dy * dy) <= (radius * radius);
	}

	@Override
	public Boolean visit(DrawingContainer drawingContainer) {
		return false;
	}
}
