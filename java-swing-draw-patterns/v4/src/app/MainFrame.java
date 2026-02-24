package app;

import javax.swing.JFrame;

import view.DrawingPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public MainFrame(DrawingPanel panel) {
		configureMainFrame();
		this.add(panel);
	}
	
	public void configureMainFrame() {
		this.setSize(800,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SHAPES!");
	}
}
