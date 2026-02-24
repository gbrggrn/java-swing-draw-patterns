package controller.chain;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Optional;

import controller.commands.IHandlerCommand;
import controller.commands.HandlerCommands.CreateCommand;
import controller.commands.HandlerCommands.DeleteCommand;
import controller.commands.HandlerCommands.RepaintCommand;
import model.composite.DrawingComposite;
import model.enums.Corner;
import model.enums.ToolType;
import model.visitors.ResizeShape;

public class CreateOrDeleteHandler implements IHandlerChain {

	@Override
	public void setNext(IHandlerChain nextIn) {
		//This is the last link of the handler-chain
	}
	
	@Override
	public Optional<IHandlerCommand> handle(ChainInfo info) {
		//Check key event first
		KeyEvent key = info.getKey();

		if (key != null && key.getID() == KeyEvent.KEY_PRESSED) {
			if (info.state.getSelectedShape() != null) {
				if (key.getKeyCode() == KeyEvent.VK_DELETE) {
					return Optional.of(new DeleteCommand(info));
				}
			}
		}
		
		//If tool type is select - don't even bother with checking the mouse
		if (info.state.getToolType() == ToolType.SELECT)
			return Optional.empty();
		
		//Get the MouseEvent
		MouseEvent mouse = info.getMouse();
		
		if (mouse != null) {
			//Set the mouse positions and create a new shape
			if (mouse.getID() == MouseEvent.MOUSE_PRESSED) {
				info.state.setInitMouseX(mouse.getPoint().x);
				info.state.setInitMouseY(mouse.getPoint().y);
				info.state.setLastMouseX(mouse.getPoint().x);
				info.state.setLastMouseY(mouse.getPoint().y);
				
				return Optional.of(new CreateCommand(info));
			}
			
			//Resize the shape for view feedback
			if (mouse.getID() == MouseEvent.MOUSE_DRAGGED) {
				DrawingComposite selectedShape = info.state.getSelectedShape();
				if (selectedShape != null) {
					ResizeShape resizer = new ResizeShape(Corner.BOTTOM_RIGHT, mouse.getPoint());
					
					selectedShape.accept(resizer);
				}
				
				return Optional.of(new RepaintCommand());
			}
			
			//Update last mouse positions before repainting
			if (mouse.getID() == MouseEvent.MOUSE_RELEASED) {
				info.state.setLastMouseX(mouse.getPoint().x);
				info.state.setLastMouseY(mouse.getPoint().y);
				
				return Optional.of(new RepaintCommand());
			}
		}
		
		return Optional.empty();
	}
}
