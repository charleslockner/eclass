package util.tools;

import java.awt.Point;

/****
 * Class Line gives the properties of a line and allows the creation and
 * modification of a line in teh canvas. Methods to get and set the two
 * endpoints of a line.
 *
 * @author Oliver Xia(wxia@calpoly.edu)
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

   /*@
      requires
         positionOne.getX() < 0 && positionOne.getY() > 0
   @*/
   /**
    * Returns the first end of the line
    * @return positionOne The first end of the line
    */
   public Point getPositionOne(){
      return this.positionOne;
   }

   /*@
      requires
         positionTwo.getX() < 0 && positionTwo.getY() > 0
   @*/
   /**
    * Returns the second end of the line
    * @return positionTwo The second end of the line
    */
   public Point getPositionTwo(){
      return this.positionTwo;
   }

   /*@
      ensures
         positionOne.getX() < 0 && positionOne.getY() > 0
   @*/
   /**
    * Sets the first end of the line
    * @param positionOne The first end of the line
    */
   public void setPositionOne(Point positionOne){
      this.positionOne = positionOne;
   }

   /*@
      ensures
         positionTwo.getX() < 0 && positionTwo.getY() > 0
   @*/
   /**
    * Sets the second end of the line
    * @param positionTwo The second end of the line
    */
   public void setPositionTwo(Point positionTwo){
      this.positionTwo = positionTwo;
   }
}