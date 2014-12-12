package test;

import java.awt.Color;

import org.junit.Test;

import util.layers.*;

import java.awt.*;

import javax.swing.*;

import java.util.Collection;

import static org.junit.Assert.*;

/****
*
* Class LayerViewTest is the companion testing class for classes Layers.
* It implements the following module test plan:
*                                                                         <ul>
*                                                                      <p><li>
*     Phase 1: Unit test the constructor.
*                                                                      <p><li>
*     Phase 2: Unit test for adding layers.                                           
*                                                                      <p><li>
*     Phase 3: Repeat phases 1 through 2.
*                                                                      <p><li>
*     Phase 4: Stress test(Not implemented)
*                                                                        </ul>
*     @author Oliver Xia (wxia@calpoly.edu)                                                                   
*/

public class LayerViewTest {
	LayerPanel layeredPane;
	
	/**
     * Unit test constructors for LayerPanel classes by building one object
     * of each. Only one test needed as only one instance of LayerPanel is ever 
     * needed since it will be used for adding layers for the rest of the tests.
     * 
     *  Test
     *  Case    Input                  Output                Remarks
     * ====================================================================================
     *   1      x = 0, y = 0,          Proper init done      Only case
     *          block = "Test"                       
     *
     */
    @Test
    public void testLayerPanelConstructor() {
    	layeredPane = new LayerPanel();
    }

    
	/**
     * Unit test getPosition for Text by calling getPosition on a text with
     * different fields for the x and y coordinates of it's location.
     * 
     *  Test
     *  Case    Input                       Output           Remarks
     * ====================================================================================
     *   1      JPanel                   number of Layers       Failed

     */
    @Test
    public void testAddLayer() {
    	int i = 0;
        String[] layerStrings = { "Yellow (0)", "Magenta (1)",
                "Cyan (2)",   "Red (3)",
                "Green (4)" };
        Color[] layerColors = { Color.yellow, Color.magenta,
                Color.cyan,   Color.red,
                Color.green };

    	JLabel test = new JLabel();
        int num = layeredPane.addLayer(test, new Point(5,5), 5, i++, layerColors, layerStrings);
        assertEquals(1, num);
    }

}