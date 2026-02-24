package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import view.DrawingUtilInterface;

// TODO: Auto-generated Javadoc
/**
 * The Interface DrawingComposite. This should always be used to represent the Composite, to enable easy change of implementation.
 */
public interface DrawingComposite extends Serializable {
   
   /**
    * Adds a new member to the Composite (for the Container types).
    *
    * @param d new instance (leaf or container) of the Composite
    */
   public void add(DrawingComposite d);
   
   /**
    * Removes the selected member from the composite (observe by removing a Container you also remove all its leafs.
    *
    * @param d the instance to be removed from the Composite
    */
   public void remove(DrawingComposite d);
   
   /**
    * Draw the method to call when you need the Composite member(s) (re)drawn.
    *
    * @param g the Graphics object holding screen estate.
    */
   public void draw(Graphics g); 
   
   /**
    * Gets the top right corners x-value (to the rightest you have 1).
    *
    * @param di the new drawing api
    * @return the x1
    */
   
   public void setDrawingAPI(DrawingUtilInterface di);

   /**
    * Gets the x1.
    *
    * @return the x1
    */
   public int getX1();
   
   /**
    * Gets the height of the shape (measured from top to down ie V).
    *
    * @return the height
    */
   public int getHeight();
   
   /**
    * Gets the top right corners y-value (1 is uppest).
    *
    * @return the y1
    */
   public int getY1();
   
   /**
    * Gets the width of the shape (measured from left to right ie ->).
    *
    * @return the width
    */
   public int getWidth();
   
   /**
    * Gets the line width. This will be used when as line thickness for drawing shapes.
    *
    * @return the line width
    */
   public int getLineWidth();
   
   /**
    * Gets the line color.
    *
    * @return the line color
    */
   public Color getLineColor();
   
   /**
    * Gets the area color.
    *
    * @return the area color
    */
   public Color getAreaColor();
}
