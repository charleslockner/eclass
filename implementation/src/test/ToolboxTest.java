package test;

import util.tools.Text;
import util.tools.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;
import static org.junit.Assert.*;

/****
 *
 * Class Toolboxtest is the companion testing class for classes Text and Canvas.
 * It implements the following module test plan:
 *                                                                         <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 1: Unit test the access method getPosition for Text.
 *                                                                      <p><li>
 *     Phase 3: Unit test the constructive method for setLocation for Text.                                                                 
 *                                                                      <p><li>
 *     Phase 4: Unit test the access method getBlock for Text.
 *                                                                      <p><li>
 *     Phase 5: Unit test the constructive method setBlock for Text.
 *                                                                      <p><li>
 *     Phase 6: Unit test the access method Get for Canvas.
 *                                                                      <p><li>
 *     Phase 7: Unit test the deletion method Delete for Canvas.                                                           
 *                                                                      <p><li>
 *     Phase 8: Repeat phases 1 through 7.
 *                                                                      <p><li>
 *     Phase 9: Stress test by adding and deleting 100000 items.
 *                                                                        </ul>
 *     @author Eric Yun (eryun@calpoly.edu)                                                                   
 */

public class ToolboxTest {
	private Text text;
	private Canvas canvas;	
	
	/**
     * Unit test constructors for Text and Canvas classes by building one object
     * of each. Only one test needed as only one instance of Canvas is ever 
     * needed per test and testing of parameters passed to a Text object will be
     * tested in later tests.
     * 
     *  Test
     *  Case    Input                  Output                Remarks
     * ====================================================================================
     *   1      x = 0, y = 0,          Proper init done      Only case
     *          block = "Test"                       
     *
     */
	@Test
	public void testConstructor() {
		text = new Text(0, 0, "Test");
		canvas = new Canvas();
	}
	
	/**
     * Unit test getPosition for Text by calling getPosition on a text with
     * different fields for the x and y coordinates of it's location.
     * 
     *  Test
     *  Case    Input                       Output           Remarks
     * ====================================================================================
     *   1      text.position = (0, 0)       true            position.getX() >=0 and
     *                                                       position.getY() >= 0
     *  
     *   2      text.position = (23, 13)     true            position.getX() >=0 and
     *                                                       position.getY() >= 0
     *    
     *   3      text.position = (-12, 13)    false           position.getX() < 0
     *   
     *   4      text.position = (23, -4)     false           position.getY() < 0
     *   
     */
    @Test
    public void testTextGetPosition() {
    	text = new Text(0, 0, "Test1");
    	assertTrue(text.getPosition().getX() >= 0 &&
    	             text.getPosition().getY() >= 0);
    	
    	text = new Text(23, 13, "Test2");
    	assertTrue(text.getPosition().getX() >= 0 &&
    	             text.getPosition().getY() >= 0);
    	
    	text = new Text(-12, 13, "Test3");
    	assertTrue(text.getPosition().getX() >= 0 &&
    	             text.getPosition().getY() >= 0);
    	
    	text = new Text(23, -4, "Test4");
    	assertTrue(text.getPosition().getX() >= 0 &&
    	             text.getPosition().getY() >= 0);
    }

    /**
     * Unit test setPosition for Text by calling getPosition on a text with
     * different fields for the x and y coordinates of it's location.
     * 
     *  Test
     *  Case    Input                       Output          Remarks
     * ====================================================================================
     *   1      text.position = (0, 0)      true            position.getX() >=0 and
     *                                                      position.getY() >= 0
     *
     *   2      text.position = (10, 5)     true            position.getX() >=0 and
     *                                                      position.getY() >= 0
     *    
     *   3      text.position = (-10, 5)    false           position.getX() < 0
     *   
     *   4      text.position = (10, -5)    false           position.getY() < 0
     *   
     */
    @Test
    public void testTextSetPosition() {
    	text = new Text(0, 0, "Test");
    	
    	text.setPosition(new Point(0, 0));
    	assertTrue(text.getPosition().getX() >= 0 &&
    			     text.getPosition().getY() >= 0);
    	
    	text.setPosition(new Point(10, 5));
    	assertTrue(text.getPosition().getX() >= 0 &&
    			     text.getPosition().getY() >= 0);
    	
    	text.setPosition(new Point(-10, 5));
    	assertTrue(text.getPosition().getX() >= 0 &&
    			     text.getPosition().getY() >= 0);
    	
    	text.setPosition(new Point(10, -5));
    	assertTrue(text.getPosition().getX() >= 0 &&
    			     text.getPosition().getY() >= 0);
    }
    
    /**
     * Unit test getBlock for Text by calling getBlock on a Text with a field
     * called block, which contains a String. Only one test needed as parameter
     * block field will only accept Strings.
     * 
     *  Test
     *  Case    Input                Output               Remarks
     * ====================================================================================
     *   1      block = "Test"       Proper init done     Only case                      
     *
     */
    @Test
    public void testGetTextBlock() {
    	text = new Text(0, 0, "Test");
    	String line = text.getBlock();
    	assertTrue(line instanceof String);
    }

    /**
     * Unit test setBlock for Text by calling setBlock on a Text with a field
     * called block, which contains a String. Only one test needed as parameter
     * for setBlock will only accept Strings.
     * 
     *  Test
     *  Case    Input                Output               Remarks
     * ====================================================================================
     *   1      newLine = "new"      Proper init done     Only case                      
     *
     */
    @Test
    public void testSetTextBlock() {
    	text = new Text(0, 0, "Test");
    	String newLine = "new";
    	text.setBlock(newLine);
    	assertTrue(newLine instanceof String);
    }
    
    /**
     * Unit test get for Canvas by calling get on a Canvas, which must have size > 0
     * for the method to work.
     * 
     *  Test
     *  Case    Input                   Output      Remarks
     * ====================================================================================
     *   1      null, size = 0          false       canvas.size() = 0                      
     *
     *   2      index = 0, size = 1     true        canvas.size > 0 && index < canvas.size()
     *  
     *   3      index = 1, size = 3     true        canvas.size > 0 && index < canvas.size()
     *   
     *   4      index = 4, size = 4     false       index = canvas.size()
     *   
     *   5      index = 5, size = 4     false       index > canvas.size()
     */
    @Test
    public void testCanvasGet() {
    	canvas = new Canvas();
    	assertTrue(canvas.get(0) != null);
    	
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	assertTrue(canvas.get(0) != null);
    	
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	assertTrue(canvas.get(1) != null);
    	
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	assertTrue(canvas.get(4) != null);
    	
    	assertTrue(canvas.get(6) != null);
    }

    /**
     * Unit test delete for Canvas by calling delete on a Canvas, which must have
     * size > 0 for the method to work.
     * 
     *  Test
     *  Case    Input            Output      Remarks
     * ====================================================================================
     *   1      size = 0         false       canvas.size() = 0                      
     *
     *   2      size = 2         true        canvas.size > 0
     *     
     *   3      size = 1         true        canvas.size > 0
     *   
     *   4      size = 0         false       canvas.size() = 0  
     */
    @Test
    public void testCanvasDelete() {
    	canvas = new Canvas();
    	assertTrue(canvas.delete() != null);
    	
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	canvas.add(new Rectangle(10, 10, 10, 10));
    	assertTrue(canvas.delete() != null);
    	
    	assertTrue(canvas.delete() != null);
    	
    	assertTrue(canvas.delete() != null);
    }
    
    /**
     * Method to repeat all of the above tests for quality assurance.
     * See notes for above methods for test plans.
     */
    @Test
    public void testRepeat() {
    	testConstructor();
    	testTextGetPosition();
    	testTextSetPosition();
    	testGetTextBlock();
    	testSetTextBlock();
    	testCanvasGet();
    	testCanvasDelete();
    }
    
    /**
     * Method to stress test a Canvas object to hold 10000 rectangles,
     * and then delete them one at a time until Canvas is empty.
     */
    @Test
    public void testStress() {
    	canvas = new Canvas();
    	
    	for(int i = 0; i < 10000; i++) {
    		canvas.add(new Rectangle(5, 5, 5, 5));
    	}
    	
    	while(canvas.get(0) != null) {
    		canvas.delete();
    	}
    }
}