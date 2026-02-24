package view.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.enums.ToolBarChoice;
import view.SwingView;

public class ToolBarListeners implements ActionListener, ChangeListener {
	private SwingView connectedView;
	
	public ToolBarListeners(SwingView connectedViewIn) {
		connectedView = connectedViewIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("shape")) {
			connectedView.relayToolBarEvent(ToolBarChoice.SHAPE, e, null);
		}
		
		if (e.getActionCommand().equals("lineColor")) {
			connectedView.relayToolBarEvent(ToolBarChoice.LINECOLOR, e, null);
		}
		
		if (e.getActionCommand().equals("fillColor")) {
			connectedView.relayToolBarEvent(ToolBarChoice.FILLCOLOR, e, null);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		connectedView.relayToolBarEvent(ToolBarChoice.LINETHICKNESS, null, e);
	}

}
