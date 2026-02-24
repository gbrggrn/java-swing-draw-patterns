package view;

import java.awt.Graphics;
import javax.swing.JPanel;

import model.DrawingComposite;


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
	
	/** Gets the DrawingComposite attributte currently drawing on the screen estate. */
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
	public DrawingPanel (DrawingComposite dc) {
		this.dc=dc;
	}
	/**
	 * Is called everytime the GUI refreshes and calls the DrawingComposites draw method passing the
	 * Graphics instance holding the drawable screen estate to it.
	 *
	 * @param g the Graphics instance holding the screen estate to draw upon.
	 */
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dc.draw(g);
	}
	
}
