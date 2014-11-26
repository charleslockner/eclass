package util.presentation;

import java.util.ArrayList;
import java.util.Observable;

/**
 * This class is responsible for managing the presentation slides. This class
 * holds methods related to navigating from slide to slide.
 * 
 * @author Charles Lockner (clockner@calpoly.edu)
 */
public class PresentationModel extends Observable {
	public ArrayList<String> slideUrls;
	public int urlNdx = 0;
	
	/**
	 * Constructor for the presentation model class. This is responsible for setting up
	 * all of the slide urls
	 * pre: The urls must be valid strings
     * post: The slideUrls will contain at least 1 url, several more should be added
	 */
	public PresentationModel() {
		slideUrls = new ArrayList<String>();
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/index.html");
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/index.html");
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/indexFile.html");
	}

	/**
	 * Gets the current url
	 * @return the current url
	 */
	public String getCurrentUrl() {
		return slideUrls.get(urlNdx);
	}
	
	/**
	 * Sets the current slide the designated slide number
	 * @param index the index of the slide
	 * pre: The slideUrls must have at least 1 element
	 * post: The slide index will be between 0 and slideUrls.size() - 1
	 */
	public void setSlide(int index) {
		if (index > slideUrls.size() - 1)
			urlNdx = slideUrls.size() - 1;
		else if (index < 0)
			urlNdx = 0;
		else
			urlNdx = index;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	/**
	 * Decrements the urlNdx and notifies observers that the slide has changed
	 * pre: The slideUrls must have at least 1 element
	 * post: The slide index will be between 0 and slideUrls.size() - 1
	 */
	public void previousSlide() {
		if (urlNdx > 0)
			urlNdx--;
		
		setChanged();
		notifyObservers();
		clearChanged();
	}	
	
	/**
	 * Increments the urlNdx and notifies observers that the slide has changed
	 * pre: The slideUrls must have at least 1 element
	 * post: The slide index will be between 0 and slideUrls.size() - 1
	 */
	public void nextSlide() {
		if (urlNdx < slideUrls.size() - 1)
			urlNdx++;
						
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
