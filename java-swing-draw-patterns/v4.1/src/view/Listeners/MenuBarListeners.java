package view.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.enums.MenuChoice;
import view.SwingView;

public class MenuBarListeners implements ActionListener {
	private SwingView connectedView;
	
	public MenuBarListeners(SwingView connectedViewIn) {
		connectedView = connectedViewIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open")) {
			connectedView.relayMenuEvent(MenuChoice.OPEN);
		}
		
		if (e.getActionCommand().equals("new")) {
			connectedView.relayMenuEvent(MenuChoice.NEW);
		}
		
		if (e.getActionCommand().equals("save")) {
			connectedView.relayMenuEvent(MenuChoice.SAVE);
		}
		
		if (e.getActionCommand().equals("saveAs")) {
			connectedView.relayMenuEvent(MenuChoice.SAVEAS);
		}
		
		if (e.getActionCommand().equals("exit")) {
			connectedView.relayMenuEvent(MenuChoice.EXIT);
		}
	}

}
