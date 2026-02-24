package controller;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.util.Optional;

import javax.swing.event.ChangeEvent;

import controller.chain.ChainInfo;
import controller.chain.CreateOrDeleteHandler;
import controller.chain.IHandlerChain;
import controller.chain.MoveHandler;
import controller.chain.ResizeHandler;
import controller.chain.SelectHandler;
import controller.commands.IHandlerCommand;
import model.DrawingFacade;
import model.enums.MenuChoice;
import model.enums.ToolBarChoice;
import model.enums.ViewChoices.OpenOrSave;
import model.state.AppState;
import view.interfaces.IView;

/**
 * This controller controls the drawing program flow.
 */
public class DrawingController {
	
	DrawingFacade facade;
	IView currentView;
	IHandlerChain chainHead;
	
	public DrawingController(DrawingFacade facadeIn) {
		facade = facadeIn;
		initChain();
	}
	
	/**
	 * Initiates the first run of the application.
	 */
	public void initiateRun() {
		currentView.runUI(facade.getContainer(), facade.getAppState());
	}
	
	/**
	 * Sets the current view instance.
	 * @param viewIn The current view instance
	 */
	public void setView(IView viewIn) {
		this.currentView = viewIn;
	}
	
	/**
	 * Calls the method that handles the specific menu choices.
	 * @param choiceIn The enum MenuChoice
	 */
	public void handleMenuEvent(MenuChoice choiceIn) {
		switch (choiceIn) {
		case OPEN:
			openFile();
			break;
		case NEW:
			createNew();
			break;
		case SAVE:
			saveFile();
			break;
		case SAVEAS:
			saveFile();
			break;
		case EXIT:
			exit();
			break;
		}
	}
	
	public void handleToolBarEvent(ToolBarChoice choiceIn, ActionEvent ae, ChangeEvent ce) {
		switch (choiceIn) {
		case SHAPE:
			facade.getAppState().setToolType(currentView.getSelectedTool(ae));
			break;
		case LINECOLOR:
			facade.getAppState().setLineColor(currentView.showColorChooser(choiceIn, facade.getAppState()));
			break;
		case FILLCOLOR:
			facade.getAppState().setFillColor(currentView.showColorChooser(choiceIn, facade.getAppState()));
			break;
		case LINETHICKNESS:
			facade.getAppState().setLineThickness(currentView.getLineThickness(ce));
			break;
		default:
			break;
		}
	}
	
	/**
	 * Bundles event, state and container in ChainInfo.<br>
	 * Sends that information down the handler chain.
	 * @param mouseEvent The triggered MouseEvent
	 * @param state The current state
	 */
	public void handleMouseOrKeyEvent(InputEvent inputEventIn) {
		//Retrieve AppState from the facade
		AppState state = facade.getAppState();
		
		//Bundle info
		ChainInfo info = new ChainInfo(inputEventIn, state, facade.getContainer());
		
		//Await the chain returning a command
		Optional<IHandlerCommand> command = chainHead.handle(info);
		
		//If command is present, pass facade to the execute method so the model can be mutated
		command.ifPresent(cmd -> { 
			cmd.execute(facade);}
		);
		
		//Always repaint after chain iteration
		currentView.repaint();
	}
	
	/**
	 * Instantiates the classes that makes up the chain of command for handling shapes.<br>
	 * Sets next() for every class in the chain (linking it).
	 */
	public void initChain() {
		//Instantiate chain links
		chainHead = new SelectHandler();
		IHandlerChain secondLink = new ResizeHandler();
		IHandlerChain thirdLink = new MoveHandler();
		IHandlerChain fourthLink = new CreateOrDeleteHandler();
		
		//Link up chain
		chainHead.setNext(secondLink);
		secondLink.setNext(thirdLink);
		thirdLink.setNext(fourthLink);
	}
	
	/**
	 * Controls the flow for "Open" menu functionality.
	 */
	public void openFile() {
		switch(currentView.confirmSaveBeforeOpen()) {
		case YES:
			saveFile();
		case NO:
			String filePath = currentView.requestFilePath(OpenOrSave.OPEN);
			if (filePath != null) {
				currentView.disposeSelf();
				//Call the run-method to get the feeling of "switching" window when opening a file
				currentView.runUI(facade.open(filePath), facade.getAppState());
			}
			break;
		case CANCEL:
			break;
		default:
				break;
		}
	}
	
	/**
	 * Controls the flow for "Save" menu functionality.
	 */
	public void saveFile() {
		if (facade.getCurrentFilePath() == null) {
			String filePath = currentView.requestFilePath(OpenOrSave.SAVE);
			if (filePath != null) {
				facade.save(facade.getContainer(), filePath);
			}
		}
		else {
			facade.save(facade.getContainer(), facade.getCurrentFilePath());
		}
	}
	
	/**
	 * Controls the flow for "New" menu functionality.
	 */
	public void createNew() {
		switch(currentView.confirmCreateNew()) {
		case OK:
			currentView.disposeSelf();
			//Call the run-method to get the feeling of "switching" window when opening a file
			currentView.runUI(facade.createNew(), facade.getAppState());
			break;
		case CANCEL:
			break;
		default:
			break;
		}
	}
	
	/**
	 * Controls the flow for "Exit" menu functionality.
	 */
	public void exit() {
		switch(currentView.confirmExit()) {
		case OK:
			switch(currentView.confirmSaveBeforeExit()) {
			case YES:
				saveFile();
				break;
			case NO:
				System.exit(0);
				break;
			case CANCEL:
				break;
			}
			break;
		case CANCEL:
			break;
		default:
			break;
		}
	}
}
