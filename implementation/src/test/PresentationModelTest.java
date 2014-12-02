package test;
import org.junit.Before;
import org.junit.Test;
import util.presentation.PresentationModel;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * Test case for the presentation model class.
 * @author Charles Lockner (clockner@calpoly.edu)
 */
public class PresentationModelTest {

    private PresentationModel model;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCurrentUrl() throws Exception {
        assertEquals("testGetCurrentUrl method", this.model.getCurrentUrl(), "Senior");
    }

}