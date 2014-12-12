package test;
import junit.framework.Assert;

import org.junit.Test;

import util.presentation.PresentationModel;
import static org.junit.Assert.*;

/**
 * Class PresentationModelTest is the companion testing class for class 
 * PresentationModel. It implements the following module test plan:
 * 
 * Phase 1: Unit test the constructor
 * Phase 2: Unit test the getCurrentURL method
 * Phase 3: Unit test the setSlide method
 * Phase 4: Unit test the previousSlide Method
 * Phase 5: Unit test the nextSlide method
 * Phase 6: Repeat phases 1 through 5.
 * 
 * @author Charles Lockner (clockner@calpoly.edu)
 */
@SuppressWarnings("deprecation")
public class PresentationModelTest extends PresentationModel {

    private PresentationModel model;
    
	/**
	 * Simple constructor for this test class
	 */
	protected PresentationModelTest() {
		super();
	}

    /**
     * Unit test the constructor by building the model.  No further
     * constructor testing is necessary since this is the only way we use the constructor,
     * aka, we only init once.
     *
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      null             Proper init done   Only case
     *
     */
	@Test
    protected void testPresentationModel() {
        model = new PresentationModel();  // setup & invoke
        Assert.assertTrue(
        	model.slideUrls.get(0) == "http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/index.html" &&
        	model.slideUrls.get(1) == "http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/index.html" &&
        	model.slideUrls.get(2) == "http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/section2/overview/indexFile.html" &&
        	model.slideUrls.size() == 3 &&
        	model.urlNdx == 0);
    }
	
	/**
	 * Unit test getCurrentUrl. This method is really only a getter, so we
	 * are only going to test it once. Using this method to test the other
	 * methods in this class should be adequate.
	 * 
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      null             the first url      Only case
	 */
	@Test()
	protected void testGetCurrentUrl() {
		testPresentationModel();
		assertEquals("testGetCurrentUrl method", this.model.getCurrentUrl(), "http://users.csc.calpoly.edu/~kaabdull/projects/work/electric-classroom/requirements/index.html");
	}
	
	/**
	 * Unit test setSlide.
	 * 
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      1                urlNdx set to 1    between bounds
     *   2      -1               urlNdx set to 0    below bounds
     *   3      5                urlNdx set to 2    above bounds
	 */
	@Test()
	public void testSetSlide() {
		testPresentationModel();
		model.urlNdx = 1;
		model.previousSlide();
		assertEquals("testSetSlide set to 1", model.urlNdx, 1);
		
		model.urlNdx = -1;
		model.previousSlide();
		assertEquals("testSetSlide set to -1", model.urlNdx, 0);
		
		model.urlNdx = 5;
		model.previousSlide();
		assertEquals("testSetSlide set to 5", model.urlNdx, 2);
	}
	
	/**
	 * Unit test previousSlide. 
	 * 
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      urlNdx == 1      urlNdx == 0        actually changing urlNdx
     *   2      urlNdx == 0      urlNdx == 0        should do nothing
	 */
	@Test
	public void testPreviousSlide() {
		testPresentationModel();
		model.urlNdx = 1;
		model.previousSlide();
		assertEquals("testPreviousSlide should change", model.urlNdx, 0);
		
		testPresentationModel();
		model.urlNdx = 0;
		model.previousSlide();
		assertEquals("testPreviousSlide should do nothing", model.urlNdx, 0);
	}
	
	/**
	 * Unit test nextSlide. 
	 * 
     *  Test
     *  Case    Input            Output             Remarks
     * ====================================================================
     *   1      urlNdx == 1      urlNdx == 2        actually changing urlNdx
     *   2      urlNdx == 2      urlNdx == 2        should do nothing
	 */
	@Test
	public void nextSlide() {
		testPresentationModel();
		model.urlNdx = 1;
		model.previousSlide();
		assertEquals("testNextSlide should change", model.urlNdx, 2);
		
		testPresentationModel();
		model.urlNdx = 2;
		model.nextSlide();
		assertEquals("testNextSlide should do nothing", model.urlNdx, 2);
	}
}