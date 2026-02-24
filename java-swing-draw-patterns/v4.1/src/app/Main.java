package app;

import controller.DrawingController;
import model.DrawingFacade;
import view.SwingView;

public class Main {

	public static void main(String[] args) {
		DrawingController controller = new DrawingController(new DrawingFacade());
		controller.setView(new SwingView(controller));
		controller.initiateRun();
	}
}