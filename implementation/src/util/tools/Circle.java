package util.tools;

import java.awt.Point;

/**
 * Class implementation of the circle
 */
public abstract class Circle extends Shape {
   Point center;
   int radius;
   
   /**
     * Creates a new circle
     */
   abstract void createCircle(Point center, int radius);
   
   /**
     * Moves the center of the circle
     */
     
   /*@ 
      requires
         // new center Point must be within the boundaries of the layer canvas
         center.x < 200 && center.x > -200
            && center.y < 200 && center.y > -200
            
      ensures
         // center Point must be within the boundaries of the layer canvas
         center.x < 200 && center.x > -200
            && center.y < 200 && center.y > -200
   @*/
   abstract void updateCenter(Point center);
   
   /**
     * Changes the radius of the circle
     */
   abstract void updateRadius(int radius);
   
   /**
     * Deletes the circle
     */
   abstract void delete();
}
