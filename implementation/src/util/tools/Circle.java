package util.tools;

import java.awt.Point;

/****
 * Class Circle gives the properties of a circle and allows the creation and
 * modification of a circle in the canvas. Methods to get and set the center
 * position and radius of a circle.
 *
 * @author Eric Yun(eryun@calpoly.edu)
 */
public abstract class Circle {

   /**
    * Point position is the center point of the circle
    * int radius is the radius of the circle, which marks the boundary of the
    * circle from its epicenter
    */
   Point position;
   int radius;

   /**
    * Constructor to create a new rectangle
    *
    * @param x The x coordinate of the circle's center
    * @param y The y coordinate of the circle's center
    * @param radius The length of the circle
    */
   public Circle(int x, int y, int radius) {
      position.setLocation(x, y);
      this.radius = radius;
   }

   /**
    * Returns the center position of the rectangle
    * @return position The center of the circle
    */
   public Point getPosition(){
      return this.position;
   }
     
   /*@ 
      requires
         // position Point must be within the boundaries of the layer canvas
         position.getX() < 1000 && position.getX() > 200
            && position.getY() < 1000 && position.getY() > 200
            
      ensures
         // position Point must be within the boundaries of the layer canvas
         position.getX() < 1000 && position.getX() > 200
            && position.getY() < 1000 && position.getY() > 200
   @*/
   /**
    * Sets the position of the circle
    * @param position The center position of the circle
    */
   public void setPosition(Point position){
      this.position = position;
   }

   /**
    * Sets the radius of the circle
    * @param radius The radius of the circle
    */
   public void setRadius(int radius) {
      this.radius = radius;
   }
}