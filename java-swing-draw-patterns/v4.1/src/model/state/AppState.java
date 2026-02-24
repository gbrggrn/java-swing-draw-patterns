package model.state;

import java.awt.Color;

import model.composite.DrawingComposite;
import model.enums.Corner;
import model.enums.ToolType;

public class AppState {
	private ToolType currentTool = ToolType.SELECT;
	private Color lineColor = Color.black;
	private Color fillColor = Color.black;
	private int lineThickness = 3;
	private DrawingComposite selectedShape = null;
	private Corner resizeCorner = Corner.NONE;
	private boolean isResizing = false;
	private int lastMouseX;
	private int lastMouseY;
	private int initMouseX;
	private int initMouseY;
	
	//Getters
	public ToolType getToolType() {
		return currentTool;
	}
	
	public Color getLineColor() {
		return lineColor;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	
	public int getLineThickness() {
		return lineThickness;
	}
	
	public DrawingComposite getSelectedShape() {
		return selectedShape;
	}
	
	public Corner getResizeCorner() {
		return resizeCorner;
	}
	
	public boolean isResizing() {
		return isResizing;
	}
	
	public int getLastMouseX() {
		return lastMouseX;
	}
	
	public int getLastMouseY() {
		return lastMouseY;
	}
	
	public int getInitMouseX() {
		return initMouseX;
	}
	
	public int getInitMouseY() {
		return initMouseY;
	}
	
	//Setters
	public void setToolType(ToolType toolTypeIn) {
		currentTool = toolTypeIn;
	}
	
	public void setLineColor(Color lineColorIn) {
		lineColor = lineColorIn;
	}
	
	public void setFillColor(Color fillColorIn) {
		fillColor = fillColorIn;
	}
	
	public void setLineThickness(int lineThicknessIn) {
		lineThickness = lineThicknessIn;
	}
	
	public void setSelectedShape(DrawingComposite selectedShapeIn) {
		selectedShape = selectedShapeIn;
	}
	
	public void setResizeCorner(Corner cornerIn) {
		resizeCorner = cornerIn;
	}
	
	public void setIsResizing(boolean isResizingIn) {
		isResizing = isResizingIn;
	}
	
	public void setLastMouseX(int lastMouseXIn) {
		lastMouseX = lastMouseXIn;
	}
	
	public void setLastMouseY(int lastMouseYIn) {
		lastMouseY = lastMouseYIn;
	}
	
	public void setInitMouseX(int initMouseXIn) {
		initMouseX = initMouseXIn;
	}
	
	public void setInitMouseY(int initMouseYIn) {
		initMouseY = initMouseYIn;
	}
}
