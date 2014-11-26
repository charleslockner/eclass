package util.presentation;

import java.util.ArrayList;
import java.util.Observable;

public class PresentationModel extends Observable {
	public ArrayList<String> slideUrls;
	public int urlNdx = 0;
	
	public PresentationModel() {
		slideUrls = new ArrayList<String>();
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/index.html");
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/index.html");
		slideUrls.add("http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/indexFile.html");
	}

	public String getCurrentUrl() {
		return slideUrls.get(urlNdx);
	}
	
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
	
	public void previousSlide() {
		if (urlNdx > 0)
			urlNdx--;
		
//		System.out.println("hi there");
		
		setChanged();
		notifyObservers();
		clearChanged();
	}	
	
	public void nextSlide() {
		if (urlNdx < slideUrls.size() - 1)
			urlNdx++;
		
//		System.out.println("bye there");
				
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
