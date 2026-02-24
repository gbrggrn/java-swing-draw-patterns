package view.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.interfaces.IView;

public class KeyListeners implements KeyListener {
	private IView currentView;
	
	public KeyListeners(IView currentViewIn) {
		currentView = currentViewIn;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

}
