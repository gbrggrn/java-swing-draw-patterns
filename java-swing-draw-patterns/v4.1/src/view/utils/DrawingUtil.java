package view.utils;

import java.awt.Graphics;

import model.composite.DrawingShape;
import view.interfaces.DrawingUtilInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawingUtil. This class holds the functionality for drawing on screen estate. Each method requires a valid
 * DrawingUtil and Graphics instances to work.
 */
@SuppressWarnings("serial")
public class DrawingUtil implements DrawingUtilInterface {
	
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.view.DrawingAPIInterface#drawCircle(se.kau.isgc08.lab4.model.DrawingShape)
	 */
	public void drawCircle(DrawingShape d, Graphics g) {
		if (d.getAreaColor()!=null) {
			GraphicsUtil.fillOval(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(), d.getAreaColor());
		}
		GraphicsUtil.drawOval(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
                d.getLineWidth(), d.getLineColor());
	}
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.view.DrawingAPIInterface#drawRect(se.kau.isgc08.lab4.model.DrawingShape)
	 */
	public void drawRect(DrawingShape d,  Graphics g) {
		if (d.getAreaColor()!=null) {
			GraphicsUtil.fillRect(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(), d.getAreaColor());
		}
		GraphicsUtil.drawRect(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
                d.getLineWidth(), d.getLineColor());
	}
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.view.DrawingAPIInterface#drawLine(se.kau.isgc08.lab4.model.DrawingShape)
	 */
	public void drawLine(DrawingShape d, Graphics g) {
		GraphicsUtil.drawLine(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
                d.getLineWidth(), d.getLineColor());
	}

}
