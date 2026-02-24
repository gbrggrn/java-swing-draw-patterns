package controller.chain;

import java.awt.event.MouseEvent;
import java.util.Optional;

import model.composite.DrawingComposite;
import model.enums.Corner;
import model.enums.ToolType;
import model.visitors.CornerCollision;
import model.visitors.ResizeShape;
import controller.commands.IHandlerCommand;
import controller.commands.HandlerCommands.RepaintCommand;

public class ResizeHandler implements IHandlerChain {
	private IHandlerChain next;

	@Override
	public void setNext(IHandlerChain nextIn) {
		next = nextIn;
	}

	@Override
	public Optional<IHandlerCommand> handle(ChainInfo info) {
		DrawingComposite selectedShape = info.state.getSelectedShape();
		MouseEvent mouse = info.getMouse();
		
		if (mouse != null) {
			ResizeShape resizer = new ResizeShape(info.state.getResizeCorner(), mouse.getPoint());

			if (mouse.getID() == MouseEvent.MOUSE_PRESSED && info.state.getToolType() == ToolType.SELECT) {
				if (selectedShape != null) {
					CornerCollision cornerChecker = new CornerCollision(mouse.getPoint());
					Corner corner = selectedShape.accept(cornerChecker);
					
					if (corner != Corner.NONE) {
						info.state.setResizeCorner(corner);
						info.state.setIsResizing(true);
						
						return Optional.empty();
					}
				}
			}

			if (mouse.getID() == MouseEvent.MOUSE_DRAGGED && info.state.getToolType() == ToolType.SELECT) {
				if (info.state.isResizing()) {
					selectedShape.accept(resizer);
					
					return Optional.of(new RepaintCommand());
				}
			}

			if (mouse.getID() == MouseEvent.MOUSE_RELEASED && info.state.getToolType() == ToolType.SELECT) {
				if (info.state.isResizing()) {
					info.state.setIsResizing(false);
					info.state.setResizeCorner(Corner.NONE);

					return Optional.empty();
				}
			
				return Optional.of(new RepaintCommand());
			}
		}
		
		//If next is not null -> call next in the chain : else return empty optional
		return (next != null) ? next.handle(info) : Optional.empty();
	}
}
