package model.visitors;

import model.composite.DrawingContainer;
import model.shapes.Circle;
import model.shapes.Line;
import model.shapes.Rect;

public interface IShapeVisitor<R> {
	R visit (Rect Rect);
	R visit (Line line);
	R visit (Circle circle);
	R visit(DrawingContainer drawingContainer);
}
