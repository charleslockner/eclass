package util.tools;

import java.awt.Point;

/****
 * Class Line gives the properties of a line and allows the creation and
 * modification of a line in teh canvas. Methods to get and set the two
 * endpoints of a line.
 *
 * @author Eric Yun(eryun@calpoly.edu)
 */
public abstract class Line {
   /**
    * Point positionOne is one end of the line
    * Point positionTwo is the other end of the line
    */
   public Point positionOne;
   public Point positionTwo;

   /**
    * Constructor to create a new line
    *
    * @param x1 The x coordinate for positionOne point
    * @param y1 The y coordinate for positionOne point
    * @param x2 The x coordinate for positionTwo point
    * @param y2 The y coordinate for positionTwo point
    */
   public Line(int x1, int y1, int x2, int y2) {
      this.positionOne.setLocation(x1, y1);
      this.positionTwo.setLocation(x2, y2);
   }

   /**
    * Returns the first end of the line
    * @return positionOne The first end of the line
    */
   public Point getPositionOne(){
      return this.positionOne;
   }

   /**
    * Returns the second end of the line
    * @return positionTwo The second end of the line
    */
   public Point getPositionTwo(){
      return this.positionTwo;
   }

   /*@
      requires
         // positionOne Point must be within the boundaries of the layer canvas
         positionOne.getX() < 1000 && positionOne.getX() > 200
            && positionOne.getY() < 1000 && positionOne.getY() > 200

      ensures
         // positionOne Point must be within the boundaries of the layer canvas
         positionOne.getX() < 1000 && positionOne.getX() > 200
            && positionOne.getY() < 1000 && positionOne.getY() > 200
   @*/
   /**
    * Sets the first end of the line
    * @param positionOne The first end of the line
    */
   public void setPositionOne(Point positionOne){
      this.positionOne = positionOne;
   }

   /**
    * Sets the second end of the line
    * @param positionTwo The second end of the line
    */
   public void setPositionTwo(Point positionTwo){
      this.positionTwo = positionTwo;
   }
}
