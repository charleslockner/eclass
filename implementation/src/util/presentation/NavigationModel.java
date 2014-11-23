package util.presentation;

public abstract class NavigationModel {
   
   /**
    * This is the corresponding function to previousSection.
    * */
	abstract void previousSection();
	
	/**
	 * This is the corresponding function to collapse.
	 * */
	abstract void collapse();
	
	/**
	 * This is the corresponding function to presentationView.
	 * */
	abstract void presentationView();
	
	/**
	 * This is the corresponding function to expand.
	 * */
	abstract void expand();
	
	/**
	 * This is the corresponding function to nextSection.
	 * */
	abstract void nextSection();
}
