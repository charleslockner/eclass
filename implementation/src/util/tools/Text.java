package util.tools;

import java.awt.Point;

/**
 * Class implementation of a text block.
 */
public abstract class Text extends Shape {
   Point center;
   String block;
   
   /**
     * Create a new text block
     */
   abstract void createText(Point center, String block);
   
   /**
     * Moves the center of the text block
     */
   abstract void updateCenter(Point center);
   
   /**
     * Changes the string in the text block
     */
   abstract void updateBlock(String block);
   
   /**
     * Deletes the text block
     */
   abstract void delete();
}
