package view.components;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JToolBar;

import view.Listeners.MenuBarListeners;
import view.Listeners.ToolBarListeners;

public class Components {
	ToolBarListeners toolBarListeners;
	MenuBarListeners menuBarListeners;
	
	public Components(ToolBarListeners toolBarListenersIn, MenuBarListeners menuBarListenersIn) {
		toolBarListeners = toolBarListenersIn;
		menuBarListeners = menuBarListenersIn;
	}
	
	//Main JFrame MenuBar
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(createFileMenu());
		
		return menuBar;
	}
	
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		
		menu.add(createOpenItem());
		menu.add(createNewItem());
		menu.add(createSaveItem());
		menu.add(createSaveAsItem());
		menu.add(createExitItem());
		
		return menu;
	}
	
	private JMenuItem createOpenItem() {
		JMenuItem item = new JMenuItem("Open");
		item.addActionListener(menuBarListeners);
		item.setActionCommand("open");
		
		return item;
	}
	
	private JMenuItem createNewItem() {
		JMenuItem item = new JMenuItem("New");
		item.addActionListener(menuBarListeners);
		item.setActionCommand("new");
		
		return item;
	}
	
	private JMenuItem createSaveItem() {
		JMenuItem item = new JMenuItem("Save");
		item.addActionListener(menuBarListeners);
		item.setActionCommand("save");
		
		return item;
	}
	
	private JMenuItem createSaveAsItem() {
		JMenuItem item = new JMenuItem("Save as");
		item.addActionListener(menuBarListeners);
		item.setActionCommand("saveAs");
		
		return item;
	}
	
	private JMenuItem createExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		item.addActionListener(menuBarListeners);
		item.setActionCommand("exit");

		return item;
	}
	
	//Tool bar
	public JToolBar createToolBar() {
		JToolBar bar = new JToolBar("Toolbar");
		
		bar.add(createShapeChooserComboBox());
		bar.add(createlineColorButton());
		bar.add(createFillColorButton());
		bar.add(createLineThicknessChooserSlider());
		
		return bar;
	}
	
	public JComboBox<String> createShapeChooserComboBox() {
		String[] content = { "Select", "Line", "Circle", "Rectangle" };
		JComboBox<String> box = new JComboBox<String>(content);
		box.setSelectedIndex(0);
		box.addActionListener(toolBarListeners);
		box.setActionCommand("shape");
		
		return box;
	}
	
	public JButton createlineColorButton() {
		JButton button = new JButton("Choose line color");
		button.setToolTipText("Choose line color for your shape");
		button.setActionCommand("lineColor");
		button.addActionListener(toolBarListeners);
		
		return button;
	}
	
	public JButton createFillColorButton() {
		JButton button = new JButton("Choose fill color");
		button.setToolTipText("Choose fill color for your shape");
		button.setActionCommand("fillColor");
		button.addActionListener(toolBarListeners);
		
		return button;
	}
	
	public JColorChooser createColorChooser() {
		
		return new JColorChooser();
	}
	
	public JSlider createLineThicknessChooserSlider() {
		JSlider slider = new JSlider(1, 10);
		slider.addChangeListener(toolBarListeners);
		slider.setToolTipText("Choose line thickness");
		slider.setLabelTable(slider.createStandardLabels(1));
		slider.setPaintLabels(true);
		
		return slider;
	}
}
