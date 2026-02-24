package controller.commands;

import controller.chain.ChainInfo;
import model.DrawingFacade;

/**
 * This class holds the command classes possible for the chain to return as Optional.<br>
 * Each class implements the ICommand interface to include the execute() method.
 */
public class HandlerCommands {
	
	/**
	 * This class execute method is empty. The controller calls the view to repaint.
	 */
	public static class RepaintCommand implements IHandlerCommand {
		
		@Override
		public void execute(DrawingFacade model) {
			//Do nothing - controller calls repaint
		}	
	}
	
	/**
	 * This class is responsible for calling the creation of new shapes.
	 */
	public static class CreateCommand implements IHandlerCommand {
		private ChainInfo info;
		
		public CreateCommand(ChainInfo infoIn) {
			info = infoIn;
		}

		/**
		 * Sets the selected shape of AppState to the shape which the model creates.
		 */
		@Override
		public void execute(DrawingFacade model) {
			info.state.setSelectedShape(model.createShape(info.state));
		}
	}

	/**
	 * This class is responsible for calling deletion of shapes.
	 */
	public static class DeleteCommand implements IHandlerCommand {
		private ChainInfo info;
		
		public DeleteCommand(ChainInfo infoIn) {
			info = infoIn;
		}

		/**
		 * This method removes the selected shape from the container and sets the selected shape to null (no selection).<br>
		 * The model reference is superfluous in this case since info holds a reference to the container.<br>
		 * If the observer pattern was to be implemented then it would be pertinent to have the model mutate the container.
		 */
		@Override
		public void execute(DrawingFacade model) {
			info.container.remove(info.state.getSelectedShape());
			info.state.setSelectedShape(null);
		}
	}
}
