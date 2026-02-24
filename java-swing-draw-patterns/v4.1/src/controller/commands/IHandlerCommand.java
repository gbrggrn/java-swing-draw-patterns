package controller.commands;

import model.DrawingFacade;

/**
 * This interface defines each Command-class.
 */
public interface IHandlerCommand {
	void execute(DrawingFacade model);
}
