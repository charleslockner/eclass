package util.tools;

import java.awt.Point;

/**
 * Class implementation of a line
 */
public abstract class Line extends Shape {
   Point one;
   Point two;
   
   /**
     * Creates a new line
     */
   abstract void createLine(Point one, Point two);
   
   /**
     * Moves the first end of the line
     */
   abstract void updateOne(Point one);
   
   /**
     * Moves the second end of the line
     */
   abstract void updateTwo(Point two);
   
   /**
     * Deletes the line
     */
   abstract void delete();
}
