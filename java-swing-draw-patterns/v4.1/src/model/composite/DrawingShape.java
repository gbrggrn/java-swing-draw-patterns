package model.composite;

import java.awt.Color;
import java.awt.Graphics;

import view.interfaces.DrawingUtilInterface;

/**
 * The Class DrawingShape.You need to use this class as a superclass for all you're
 * shapes. The DrawingAPI (which is placed in the View package) relies on DrawingShape as input to drawing the different shapes on screen.
 */
@SuppressWarnings("serial")
public abstract class DrawingShape implements DrawingComposite {
	
	/** The di. */
	protected DrawingUtilInterface di;
	
	/** The width. */
	int width;
	
	/** The x1. */
	int x1;
	
	/** The y1. */
	int y1;
	
	/** The height. */
	int height;
	
	/** The lineWidth. */
	int lineWidth;
	
	/** The line color. */
	Color lineColor;
	
	/** The area color. */
	Color areaColor;
	
	/**
	 * Instantiates a new drawing shape.
	 *
	 * @param di the di
	 */
	public DrawingShape(DrawingUtilInterface di) {
		this.di=di;
	}
	

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#setDrawingAPI(se.kau.isgc08.lab4.view.DrawingUtilInterface)
	 */
	public void setDrawingAPI (DrawingUtilInterface di) {
		this.di=di;
	}
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getX1()
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * Sets the x1.
	 *
	 * @param x1 the new x1
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getWidth()
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param w the new width
	 */
	public void setWidth(int w) {
		this.width = w;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getY1()
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * Sets the y1.
	 *
	 * @param y1 the new y1
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the line width.
	 *
	 * @param w the new line width needs to be an even number to make shapefills right.
	 */
	public void setLineWidth(int w) {
		lineWidth=w;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getLineWidth()
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	/**
	 * Sets the line color.
	 *
	 * @param c the new line color
	 */
	public void setLineColor(Color c) {
		lineColor=c;
	}

	/**
	 * Sets the area color.
	 *
	 * @param c the new area color
	 */
	public void setAreaColor(Color c) {
		areaColor=c;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getLineColor()
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getAreaColor()
	 */
	public Color getAreaColor() {
		return areaColor;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#add(se.kau.isgc08.lab4.model.DrawingComposite)
	 */
	public void add(DrawingComposite d) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#remove(se.kau.isgc08.lab4.model.DrawingComposite)
	 */
	public void remove(DrawingComposite d) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
