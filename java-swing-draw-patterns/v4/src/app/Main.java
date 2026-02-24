package app;

import model.DrawingFacade;

public class Main {

	public static void main(String[] args) {
		DrawingFacade facade = new DrawingFacade();
		
		MainFrame mainFrame = new MainFrame(facade.addRandShapes());
		
		mainFrame.setVisible(true);
		
		sleep();
		
		facade.save(facade.getContainer());
		
		mainFrame.setVisible(false);
		
		sleep();
		
		facade.setContainer(facade.open());
		
		mainFrame.repaint();
		
		mainFrame.setVisible(true);
		
		/*DrawingFacade facade = new DrawingFacade();
		
		facade.addCircle(20, 20, 80, 80, 1, Color.BLUE, null);
		facade.addLine(3, 3, 50, 50, 1, Color.RED);
		facade.addCircle(150, 150, 50, 250, 20, Color.BLUE, Color.CYAN);
		facade.addRect(320, 200, 80, 80, 5, Color.GREEN, Color.PINK);
		
		JFrame frame = new JFrame("SHAPES!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		frame.add(facade.getPanel());
		frame.setVisible(true);
		
		facade.addRect(320, 200, 80, 80, 5, Color.BLACK, null);
		
		frame.repaint();*/
	}
	
	public static void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			System.exit(1);
			ie.printStackTrace();
		}
		
		return;
	}
}