package view.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.interfaces.IView;

public class MouseListeners implements MouseListener, MouseMotionListener{
	private IView currentView;
	
	public MouseListeners (IView currentViewIn) {
		currentView = currentViewIn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		e.getComponent().requestFocusInWindow();
		
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentView.relayMouseOrKeyEvent(e);
	}
}
