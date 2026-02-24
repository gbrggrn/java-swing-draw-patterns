package view.components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.composite.DrawingComposite;
import model.state.AppState;


// TODO: Auto-generated Javadoc
/**
 * The Class DrawingPanel. This class contains the screen estate used for drawing. In previos version of the 
 * DrawingAPI this was direct part of the DrawingAPI, but to enable serialization in this version this is
 * moved to a separate class. 
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
	
	/** The DrawingComposite attribute. This should reference the DrawingComposite we want to draw on the
	 * screen estate. */
	private DrawingComposite dc;
	private AppState currentState;
	
	/** Gets the DrawingComposite attribute currently drawing on the screen estate. */
	public DrawingComposite getDc() {
		return dc;
	}
	/** Sets the DrawingComposite attribute. This should reference the DrawingComposite we want to draw on the
	 * screen estate. */
	public void setDc(DrawingComposite dc) {
		this.dc = dc;
	}
	/**
	 * Instantiates a new drawing panel.
	 *
	 * @param dc the DrawingComposite to draw.
	 */
	public DrawingPanel (DrawingComposite dc, AppState currentStateIn) {
		this.dc=dc;
		currentState = currentStateIn;
	}
	
	/**
	 * Is called everytime the GUI refreshes and calls the DrawingComposites draw method passing the
	 * Graphics instance holding the drawable screen estate to it.
	 * @param g the Graphics instance holding the screen estate to draw upon.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dc.draw(g);
		
		DrawingComposite shape = currentState.getSelectedShape();
		
		if (shape != null) {
			drawResizeMarkers(g, shape);
		}
	}
	
	/**
	 * Draws the resize-markers when a shape is selected.
	 * @param g the Graphics instance holding the screeen estate to draw upon.
	 * @param shape The shape in whose corners the resize-markers should be drawn.
	 */
	public void drawResizeMarkers(Graphics g, DrawingComposite shape) {
		int x = shape.getX1();
		int y = shape.getY1();
		int w = shape.getWidth();
		int h = shape.getHeight();
		int markerSize = 10;
		int half = markerSize / 2;
		g.setColor(Color.WHITE);
		
		//Top left
		g.fillRect(x - half, y - half, markerSize, markerSize);
		//Top right
		g.fillRect(x + w - half, y - half, markerSize, markerSize);
		//Bottom left
		g.fillRect(x - half, y + h - half, markerSize, markerSize);
		//Bottom right
		g.fillRect(x + w - half, y + h - half, markerSize, markerSize);
	}
	
}
