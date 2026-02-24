package controller.chain;

import java.awt.event.MouseEvent;
import java.util.Optional;

import controller.commands.IHandlerCommand;
import controller.commands.HandlerCommands.RepaintCommand;
import model.composite.DrawingComposite;
import model.enums.Corner;
import model.enums.ToolType;
import model.visitors.MoveShape;

public class MoveHandler implements IHandlerChain {
	private IHandlerChain next;

	@Override
	public void setNext(IHandlerChain nextIn) {
		next = nextIn;
	}

	@Override
	public Optional<IHandlerCommand> handle(ChainInfo info) {
		if (info.state.getToolType() != ToolType.SELECT) {
			return next.handle(info);
		}

		MouseEvent mouse = info.getMouse();
		
		if (mouse != null) {
			DrawingComposite selectedShape = info.state.getSelectedShape();
			MoveShape mover = new MoveShape(mouse.getPoint(), info.state.getLastMouseX(), info.state.getLastMouseY());
			
			if (mouse.getID() == MouseEvent.MOUSE_DRAGGED && info.state.getResizeCorner() == Corner.NONE && selectedShape != null) {
				selectedShape.accept(mover);
				
				info.state.setLastMouseX(mouse.getX());
				info.state.setLastMouseY(mouse.getY());
				
				return Optional.of(new RepaintCommand());
			}
		}

		return (next != null) ? next.handle(info) : Optional.empty();
	}
}
