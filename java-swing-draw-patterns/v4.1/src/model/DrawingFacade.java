	package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import view.utils.DrawingUtil;
import model.composite.DrawingContainer;
import model.composite.DrawingShape;
import model.shapes.*;
import model.state.AppState;

/**
 * This class is a facade for the model.
 */
public class DrawingFacade {
	DrawingUtil drawEngine;
	DrawingContainer container;
	Random rand;
	String currentFilePath;
	AppState currentState;
	
	public DrawingFacade() {
		rand = new Random();
		drawEngine = new DrawingUtil();
		container = new DrawingContainer();
		currentFilePath = null;
		currentState = new AppState();
	}
	
	public void setContainer(DrawingContainer containerIn) {
		container = containerIn;
	}

	public String getCurrentFilePath() {
		return currentFilePath;
	}
	
	public DrawingContainer getContainer() {
		return container;
	}
	
	public AppState getAppState() {
		return currentState;
	}
	
	/**
	 * Wipes the current file path and creates a new (empty) drawing container.
	 * @return The new container instance
	 */
	public DrawingContainer createNew() {
		currentFilePath = null;
		container = new DrawingContainer();
		
		return container;
	}
	
	/**
	 * Creates shapes and adds them to the container.
	 * @param state The application state class where all user parameters to create shapes exist.
	 * @return The shape as its superclass (DrawingComposite)
	 */
	public DrawingShape createShape(AppState state) {
		switch (state.getToolType()) {
		case LINE:
			Line newLine = new Line(drawEngine,
					state.getInitMouseX(),
					state.getInitMouseY(),
					state.getLastMouseX(),
					state.getLastMouseY(),
					state.getLineThickness(),
					state.getLineColor());
			container.add(newLine);
			return newLine;
		case CIRCLE:
			int x = Math.min(state.getInitMouseX(), state.getLastMouseX());
		    int y = Math.min(state.getInitMouseY(), state.getLastMouseY());

		    int width = Math.abs(state.getLastMouseX() - state.getInitMouseX());
		    int height = Math.abs(state.getLastMouseY() - state.getInitMouseY());

		    Circle newCircle = new Circle(drawEngine,
		            x,
		            y,
		            width,
		            height,
		            state.getLineThickness(),
		            state.getLineColor(),
		            state.getFillColor());
		    container.add(newCircle);
			return newCircle;
		case RECT:
			int xR = Math.min(state.getInitMouseX(), state.getLastMouseX());
		    int yR = Math.min(state.getInitMouseY(), state.getLastMouseY());

		    int widthR = Math.abs(state.getLastMouseX() - state.getInitMouseX());
		    int heightR = Math.abs(state.getLastMouseY() - state.getInitMouseY());
		    
			Rect newRect = new Rect(drawEngine,
					xR,
					yR,
					widthR,
					heightR,
					state.getLineThickness(),
					state.getLineColor(),
					state.getFillColor());
			container.add(newRect);
			return newRect;
		default:
			throw new IllegalArgumentException("Unknown shape");
		}
	}
	
	/**
	 * Writes the container object to a file.
	 * @param containerIn The container to be saved
	 * @param filePath The file path to save to
	 */
	public void save(DrawingContainer containerIn, String filePath) {
		try {
			FileOutputStream fStream = new FileOutputStream(filePath);
			ObjectOutputStream oStream = new ObjectOutputStream(fStream);
			
			oStream.writeObject(containerIn);
			oStream.close();
		} catch (Exception e) {
			System.out.println("Save unsuccessful...");
			e.printStackTrace();
		}
		
		currentFilePath = filePath;
	}
	
	/**
	 * Reads a container object from a file.
	 * @param filePath The path of the file to read.
	 * @return The read container object.
	 */
	public DrawingContainer open(String filePath) {
		DrawingContainer openedContainer = new DrawingContainer();
		
		try {
			FileInputStream fStream = new FileInputStream(filePath);
			ObjectInputStream oStream = new ObjectInputStream(fStream);
			
			openedContainer = (DrawingContainer) oStream.readObject();
			oStream.close();
		} catch(Exception e) {
			System.out.println("Could not open file...");
			e.printStackTrace();
			openedContainer = null;
			return openedContainer;
		}
		
		currentFilePath = filePath;
		return openedContainer;
	}
}