package view.components;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private Components components;
	
	public MainFrame(DrawingPanel panel, Components componentsIn) {
		components = componentsIn;
		configureMainFrame();
		this.add(panel);
	}
	
	public void configureMainFrame() {
		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SHAPES!");
		this.setJMenuBar(components.createMenuBar());
		this.add(components.createToolBar(), BorderLayout.NORTH);
	}
}