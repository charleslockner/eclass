package util.tools;

import java.awt.Point;

/****
 * Class Rectangle gives the properties of a rectangle and allows the
 * creation and modification of a rectangle in the canvas. Methods to
 * get and set the top left corner position, length, and width of a
 * rectangle.
 *
 * @author Eric Yun(eryun@calpoly.edu)
 */
public abstract class Rectangle {
   /**
    * Point position sets the location of the top left corner of the rectangle
    * int length sets the length of the rectangle
    * int width sets the width of the rectangle
    */
   Point position;
   int length;
   int width;

   /**
    * Constructor to create a new rectangle
    *
    * @param x The x coordinate of the rectangle's top left corner
    * @param y The y coordinate of the rectangle's top left corner
    * @param length The length of the rectangle
    * @param width The width of the rectangle
    */
   public Rectangle(int x, int y, int length, int width) {
      position.setLocation(x, y);
      this.length = length;
      this.width = width;
   }

   /**
    * Returns the top left corner of the rectangle
    * @return position The top left corner of the rectangle
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
    * Sets the top left corner of the rectangle
    * @param position The top left corner of the rectangle
    */
   public void setPosition(Point position){
      this.position = position;
   }

   /**
    * Changes the length of the rectangle
    * @param length The length of the rectangle
    */
   public void setLength(int length){
      this.length = length;
   }

   /**
    * Changes the width of the rectangle
    * @param width The width of the rectangle
    */
   public void setWidth(int width){
      this.width = width;
   }
}
