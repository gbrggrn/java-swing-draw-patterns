package view;

import java.awt.Graphics;
import java.io.Serializable;

import model.DrawingShape;

// TODO: Auto-generated Javadoc
/**
 * The Interface DrawingUtilInterface. If you do not like the DrawingAPI provided here, 
 * use this interface to implement a new one. The DrawingShape members are depending on a DrawingUtilInterface.
 * If you want to add shapes ad them here. Implement in DrawingUtil and add Shapes in Model.This inreface was 
 * previously called DrawingAPIInterface.
 */
public interface DrawingUtilInterface extends Serializable{

	/**
	 * Draw circle. A DrawingUtil needs to be able to draw Circles
	 *
	 * @param d the Shape to be drawn, should come from your Model
	 */
	public void drawCircle(DrawingShape d, Graphics g);
	
	/**
	 * Draw rect.A A DrawingUtil needs to be able to draw Rectangles
	 *
	 *
	 * @param d the Shape to be drawn, should come from your Model
	 */
	public void drawRect(DrawingShape d, Graphics g);
	
	/**
	 * Draw line.A DrawingUtil needs to be able to draw Lines
	 *
	 *
	 * @param d the Shape to be drawn, should come from your Model
	 */
	public void drawLine(DrawingShape d, Graphics g);

}
