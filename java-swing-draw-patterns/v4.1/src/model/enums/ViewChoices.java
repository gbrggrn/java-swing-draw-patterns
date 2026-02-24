package model.enums;

/**
 * This class holds enum representations for choices.<br>
 * These are used to enable readable communication when switching views, instead of, for example, numbered choices in consoleView.
 */
public class ViewChoices {
	public enum YesNoCancel {
		YES, NO, CANCEL
	}
	
	public enum OkCancel {
		OK, CANCEL
	}
	
	public enum ViewType {
		CONSOLE, SWING
	}
	
	public enum OpenOrSave {
		OPEN, SAVE
	}
}