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
	
	public String getNextUrl() {
		if (urlNdx < slideUrls.size() - 1)
			urlNdx++;
		return getCurrentUrl();
	}
	
	public String getPrevUrl() {
		if (urlNdx > 0)
			urlNdx--;
		return getCurrentUrl();
	}

	public void nextSlide() {
		if (urlNdx < slideUrls.size() - 1)
			urlNdx++;
		
		
		
		notifyObservers();
		clearChanged();
	}
}