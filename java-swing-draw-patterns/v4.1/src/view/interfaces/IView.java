package view.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.event.ChangeEvent;
import model.enums.ViewChoices.OkCancel;
import model.enums.ViewChoices.OpenOrSave;
import model.enums.ViewChoices.YesNoCancel;
import model.state.AppState;
import model.composite.DrawingContainer;
import model.enums.MenuChoice;
import model.enums.ToolBarChoice;
import model.enums.ToolType;

public interface IView {
	void runUI(DrawingContainer containerIn, AppState currentState);
	void relayMenuEvent(MenuChoice choiceIn);
	void relayToolBarEvent(ToolBarChoice choice, ActionEvent ae, ChangeEvent ce);
	void relayMouseOrKeyEvent(InputEvent e);
	Color showColorChooser(ToolBarChoice colorChoice, AppState currentState);
	ToolType getSelectedTool(ActionEvent e);
	int getLineThickness(ChangeEvent e);
	void repaint();
	void viewError(String message);
	void viewConfirmation(String message);
	YesNoCancel confirmSaveBeforeExit();
	YesNoCancel confirmSaveBeforeOpen();
	OkCancel confirmExit();
	OkCancel confirmCreateNew();
	String requestFilePath(OpenOrSave choice);
	void disposeSelf();
}
