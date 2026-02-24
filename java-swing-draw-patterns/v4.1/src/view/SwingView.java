package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import controller.DrawingController;
import model.enums.ViewChoices.OkCancel;
import model.enums.ViewChoices.OpenOrSave;
import model.enums.ViewChoices.YesNoCancel;
import model.composite.DrawingContainer;
import model.enums.MenuChoice;
import model.enums.ToolBarChoice;
import model.enums.ToolType;
import model.state.AppState;
import view.Listeners.KeyListeners;
import view.Listeners.MenuBarListeners;
import view.Listeners.MouseListeners;
import view.Listeners.ToolBarListeners;
import view.components.Components;
import view.components.DrawingPanel;
import view.components.MainFrame;
import view.interfaces.IView;

/**
 * This class is responsible for setting up and displaying a swing view.
 */
public class SwingView implements IView {
	MainFrame mainFrame;
	DrawingController controller;
	Components components;
	
	public SwingView(DrawingController controllerIn) {
		controller = controllerIn;
		components = new Components(new ToolBarListeners(this), new MenuBarListeners(this));
	}
	
	/**
	 * This method is responsible for setting up the UI.
	 */
	@Override
	public void runUI(DrawingContainer containerIn, AppState currentState) {
		DrawingPanel panel = new DrawingPanel(containerIn, currentState);
		MouseListeners mouse = new MouseListeners(this);
		KeyListeners key = new KeyListeners(this);
		panel.addMouseListener(mouse);
		panel.addMouseMotionListener(mouse);
		panel.addKeyListener(key);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		mainFrame = new MainFrame(
				panel,
				components);
		mainFrame.setVisible(true);
	}
	
	/**
	 * This method relays a menu event to the controller.
	 */
	@Override
	public void relayMenuEvent(MenuChoice choiceIn) {
		controller.handleMenuEvent(choiceIn);
	}
	
	@Override
	public void relayToolBarEvent(ToolBarChoice choiceIn, ActionEvent ae, ChangeEvent ce) {
		controller.handleToolBarEvent(choiceIn, ae, ce);
	}

	/**
	 * This method relays a mouse-, or key-event to the controller.
	 */
	@Override
	public void relayMouseOrKeyEvent(InputEvent e) {
		controller.handleMouseOrKeyEvent(e);
	}
	
	/**
	 * This method shows a color chooser and returns the chosen color.
	 * @param colorChoice The choice of either line-, or fill color.
	 * @param currentState The current AppState
	 * @return The chosen Color
	 */
	@Override
	public Color showColorChooser(ToolBarChoice colorChoice, AppState currentState) {
		Color choice = Color.BLACK;
		
		switch (colorChoice) {
		case LINECOLOR:
			choice = JColorChooser.showDialog(mainFrame, "Choose line color", currentState.getLineColor());
			if (choice != null) {
				return choice;
			}
			break;
		case FILLCOLOR:
			choice = JColorChooser.showDialog(mainFrame, "Choose fill color", currentState.getFillColor());
			if (choice != null) {
				return choice;
			}
			break;
		default:
			return choice;
		}
		
		return choice;
	}
	
	/**
	 * This method checks which tool the user has selected.
	 * @param e The ActionEvent that triggered this call.
	 * @return The chosen ToolType.
	 */
	@Override
	public ToolType getSelectedTool(ActionEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<String> box = (JComboBox<String>) e.getSource();
		int selectedIndex = box.getSelectedIndex();
		ToolType tool = ToolType.SELECT;
		
		if (selectedIndex == 1) {
			tool = ToolType.LINE;
		}
		else if (selectedIndex == 2) {
			tool = ToolType.CIRCLE;
		}
		else if (selectedIndex == 3) {
			tool = ToolType.RECT;
		}
		
		return tool;
	}
	
	/**
	 * Returns the currently chosen line thickness value.
	 * @param e The ChangeEvent that triggered this call.
	 * @return The current line thickness value.
	 */
	@Override
	public int getLineThickness(ChangeEvent e) {
		JSlider slider = (JSlider) e.getSource();
		return slider.getValue();
	}

	/**
	 * This method calls repaint on the content pane.
	 */
	@Override
	public void repaint() {
		mainFrame.getContentPane().repaint();
	}

	/**
	 * Displays error message
	 * @param message the message to be displayed
	 */
	@Override
	public void viewError(String message) {
		JOptionPane.showMessageDialog(
				null,
				message,
				"Something went wrong",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Displays confirmation message
	 * @param message the message to be displayed
	 */
	@Override
	public void viewConfirmation(String message) {
		JOptionPane.showMessageDialog(
				null,
				message,
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Queries user to confirm save before exit.
	 * @return the user choice
	 */
	@Override
	public YesNoCancel confirmSaveBeforeExit() {
		int option = JOptionPane.showConfirmDialog(
				null,
				"Do you want to save before exiting?",
				"Save before exit",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		return optionConverterYesNoCancel(option);
	}

	/**
	 * Queries user to confirm save before open.
	 * @return the user choice
	 */
	@Override
	public YesNoCancel confirmSaveBeforeOpen() {
		int option = JOptionPane.showConfirmDialog(
				null,
				"Do you want to save before opening?",
				"Save before open",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		return optionConverterYesNoCancel(option);
	}

	/**
	 * Queries user to confirm exit.
	 * @return the user choice
	 */
	@Override
	public OkCancel confirmExit() {
		int option = JOptionPane.showConfirmDialog(
				null,
				"Are you sure you want to exit?",
				"Confirm exit",
				JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		return optionConverterOkCancel(option);
	}

	/**
	 * Queries user to confirm creation of a new record.
	 * @return the user choice
	 */
	@Override
	public OkCancel confirmCreateNew() {
		int option = JOptionPane.showConfirmDialog(
				null,
				"Unsaved progress will be lost",
				"Create new document?",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		
		return optionConverterOkCancel(option);
	}

	/**
	 * @param choice the user choice of "open" or "save"
	 * @return null if cancelled : path of selected file if approved
	 */
	@Override
	public String requestFilePath(OpenOrSave choice) {
		final JFileChooser fileChooser = new JFileChooser();
		int result;
		
		switch(choice) {
		case OPEN:
			result = fileChooser.showOpenDialog(null);
			break;
		case SAVE:
			result = fileChooser.showSaveDialog(null);
			break;
		default:
			return null;
		}
		
		if (result == JFileChooser.APPROVE_OPTION)
			return fileChooser.getSelectedFile().getPath();
		else
			return null;
		
	}

	/**
	 * This method disposes the current instance of mainFrame.
	 */
	@Override
	public void disposeSelf() {
		mainFrame.setVisible(false);
		mainFrame.dispose();
	}
	
	/**
	 * Converts a JOptionPane option into an enum YES, NO or CANCEL option.
	 * @param option the JOptionPane option to be converted
	 * @return the converted enum option
	 */
	public YesNoCancel optionConverterYesNoCancel(int option) {
		switch (option) {
			case JOptionPane.YES_OPTION:
				return YesNoCancel.YES;
			case JOptionPane.NO_OPTION:
				return YesNoCancel.NO;
			default:
				return YesNoCancel.CANCEL;
		}
	}
	
	/**
	 * Converts a JOptionPane option into an enum OK or CANCEL option.
	 * @param option the JOptionPane option to be converted
	 * @return the converted enum option
	 */
	public OkCancel optionConverterOkCancel(int option) {
		switch (option) {
			case JOptionPane.OK_OPTION:
				return OkCancel.OK;
			default:
				return OkCancel.CANCEL;
		}
	}
}
