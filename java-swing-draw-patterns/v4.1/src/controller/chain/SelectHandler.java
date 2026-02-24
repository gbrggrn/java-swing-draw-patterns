package controller.chain;

import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.Vector;

import controller.commands.IHandlerCommand;
import model.composite.DrawingComposite;
import model.enums.Corner;
import model.enums.ToolType;
import model.visitors.CornerCollision;
import model.visitors.ShapeCollision;

public class SelectHandler implements IHandlerChain {
	private IHandlerChain next;
	
	@Override
	public void setNext(IHandlerChain nextIn) {
		next = nextIn;
	}

	@Override
	public Optional<IHandlerCommand> handle(ChainInfo info) {
		MouseEvent mouse = info.getMouse();
		
		if (mouse != null && mouse.getID() == MouseEvent.MOUSE_PRESSED && info.state.getToolType() == ToolType.SELECT) {
			
			//Check corner collision if a shape is already selected
			DrawingComposite currentShape = info.state.getSelectedShape();
			
			if (currentShape != null) {
				CornerCollision cornerChecker = new CornerCollision(mouse.getPoint());
				if (currentShape.accept(cornerChecker) != Corner.NONE) {
					return (next != null) ? next.handle(info) : Optional.empty();
				}
			}
			
			//Check general collision second
			info.state.setSelectedShape(null);
			
			Vector<DrawingComposite> shapes = info.container.getDrawings();
			ShapeCollision collisionChecker = new ShapeCollision(mouse.getPoint());
			
			//Iterate over shapes and check collisions
			for (int i = shapes.size() -1; i >= 0; i--) {
				//Visit all shapes in the collection
				boolean hasCollided = shapes.get(i).accept(collisionChecker);
				//Set the selected shape if collision occurs
				if (hasCollided) {
					info.state.setSelectedShape(shapes.get(i));
					
					info.state.setLastMouseX(mouse.getPoint().x);
					info.state.setLastMouseY(mouse.getPoint().y);
					break;
				}
			}
		}
		
		//Always call next from here
		return next.handle(info);
	}
}
