package model;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import view.DrawingPanel;
import view.DrawingUtil;
import model.shapes.*;

public class DrawingFacade {
	DrawingUtil drawEngine;
	DrawingContainer container;
	DrawingPanel drawPanel;
	Random rand;
	
	public DrawingFacade() {
		rand = new Random();
		drawEngine = new DrawingUtil();
		container = new DrawingContainer();
		drawPanel = new DrawingPanel(container);
	}
	
	public void setContainer(DrawingContainer containerIn) {
		container = containerIn;
	}
	
	public DrawingContainer getContainer() {
		return container;
	}
	
	public ArrayList<Integer> generateNumbers(){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i <= 4; i ++) {
			int randNumber = rand.nextInt(500);
			numbers.add(i, randNumber);
		}
		System.out.println(numbers);
		return numbers;
	}
	
	public ArrayList<Color> generateColors(){
		ArrayList<Color> colors = new ArrayList<Color>();
		
		for (int i = 0; i <= 2; i++) {
			Color randColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			
			colors.add(i, randColor);
		}
		System.out.println(colors);
		return colors;
	}
	
	public DrawingShape createShape(ShapeChoice shapeChoiceIn, DrawingUtil drawEngineIn, ArrayList<Integer> numbersIn, ArrayList<Color> colorsIn) {
		switch (shapeChoiceIn) {
			case LINE:
				return new Line(drawEngineIn, numbersIn.get(0), numbersIn.get(1), numbersIn.get(2), numbersIn.get(3), numbersIn.get(4), colorsIn.get(0));
			case CIRCLE:
				return new Circle(drawEngineIn, numbersIn.get(0), numbersIn.get(1), numbersIn.get(2), numbersIn.get(3), numbersIn.get(4), colorsIn.get(0), colorsIn.get(1));
			case RECT:
				return new Rect(drawEngineIn, numbersIn.get(0), numbersIn.get(1), numbersIn.get(2), numbersIn.get(3), numbersIn.get(4), colorsIn.get(0), colorsIn.get(1));
			default:
				return new DrawingShape(null);
		}
	}
	
	public DrawingShape getShape(ShapeChoice shapeChoiceIn) {
		return createShape(shapeChoiceIn, drawEngine, generateNumbers(), generateColors());
	}
	
	public DrawingPanel addRandShapes() {
		for(int i = 0; i <= rand.nextInt(1, 5); i++) {
			container.add(getShape(ShapeChoice.values()[rand.nextInt(0, 3)]));
		}
		
		return drawPanel;
	}
	
	public void save(DrawingContainer containerIn) {
		try {
			FileOutputStream fStream = new FileOutputStream("drawing.dat");
			ObjectOutputStream oStream = new ObjectOutputStream(fStream);
			
			oStream.writeObject(containerIn);
			oStream.close();
		} catch (Exception e) {
			System.out.println("Save unsuccessful...");
			e.printStackTrace();
		}
	}
	
	public DrawingContainer open() {
		DrawingContainer openedContainer = new DrawingContainer();
		
		try {
			FileInputStream fStream = new FileInputStream("drawing.dat");
			ObjectInputStream oStream = new ObjectInputStream(fStream);
			
			openedContainer = (DrawingContainer) oStream.readObject();
			oStream.close();
		} catch(Exception e) {
			System.out.println("Could not open file...");
			e.printStackTrace();
		}
		
		return openedContainer;
	}
}
