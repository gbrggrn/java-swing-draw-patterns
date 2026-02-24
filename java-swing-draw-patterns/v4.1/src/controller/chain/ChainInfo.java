package controller.chain;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import model.composite.DrawingContainer;
import model.state.AppState;

/**
 * This class contains the data the handler-chain needs to work.
 */
public class ChainInfo {
	public InputEvent event;
	public AppState state;
	public DrawingContainer container;
	
	public ChainInfo(InputEvent eventIn, AppState stateIn, DrawingContainer containerIn) {
		this.event = eventIn;
		this.state = stateIn;
		this.container = containerIn;
	}
	
	/**
	 * If event is instance of MouseEvent: Cast event to MouseEvent and return it.<br>
	 * Else return null.
	 * @return The MouseEvent or null
	 */
	public MouseEvent getMouse() {
		return (event instanceof MouseEvent) ? (MouseEvent) event : null;
	}
	
	/**
	 * If event is instance of KeyEvent: Cast event to KeyEvent and return it. <br>
	 * Else return null.
	 * @return The KeyEvent or null
	 */
	public KeyEvent getKey() {
		return (event instanceof KeyEvent) ? (KeyEvent) event : null;
	}
	
	/**
	 * Fallback: return the raw InputEvent
	 * @return The raw InputEvent
	 */
	public InputEvent getEvent() {
		return event;
	}
}