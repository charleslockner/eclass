package util.presentation;


/**
 * This class is responsible for handling functions related to the edit menu
 * @author Charles Lockner (clockner@calpoly.edu)
 */
public abstract class EditModel {
   
   /**
    * This is the corresponding function for undo.
    * */
	abstract void modelUndo();
	
	/**
	 * This is the corresponding function for redo.
	 * */
	abstract void modelRedo();
	
	/**
	 * This is the corresponding function for copy.
	 * */
	abstract void modelCopy();
	
	/**
	 * This is the corresponding function for paste.
	 * */
	abstract void modelPaste();
	
	/**
	 * This is the corresponding function for paste.
	 * */
	abstract void modelCut();
	
	/**
	 * This is the corresponding function for sourceFile.
	 * */
	abstract void modelSourceFile();
}
