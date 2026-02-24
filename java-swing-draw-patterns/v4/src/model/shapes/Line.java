package model.shapes;

import java.awt.Color;
import java.awt.Graphics;

import model.*;
import view.DrawingUtilInterface;

public class Line extends DrawingShape {
	
	private static final long serialVersionUID = 1L;

	public void draw(Graphics g) {
		di.drawLine(this, g);
	}
	
	public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int width, Color color) {
		super(di);
		setX1(x1);
		setWidth(x2);
		setY1(y1);
		setHeight(y2);
		setLineWidth(width);
		setLineColor(color);
		setAreaColor(Color.BLACK);
	}
}