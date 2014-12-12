package util.tools;

import java.awt.Point;

/****
 * Class Text gives the properties of a text and allows the creation and
 * modification of a text in the canvas. Methods to get and set the
 * position and content of the text.
 *
 * @author Eric Yun(eryun@calpoly.edu)
 */
public class Text {
   /**
    * Point position is the location of the text block
    * String block contains the actual written text
    */
   Point position;
   String block;

   /**
    * Constructor to create a new text block
    *
    * @param x The x coordinate of the text's position
    * @param y The y coordinate of the text's position
    * @param block The written text
    */
   public Text(int x, int y, String block) {
      this.position = new Point(x, y);
      this.block = block;
   }

   /**
    * Gets the location of the text block
    * @return position The position of the text block
    */
   /*@
      ensures
         this.position.getX() >= 0 && this.position.getY() >= 0
   @*/
   public Point getPosition() {
      return this.position;
   }

   /**
    * Gets the content of the text block
    * @return block The written content of the text block
    */
   /*@
      ensures
         this.block instanceof String
   @*/
   public String getBlock() {
      return this.block;
   }

   /**
    * Sets the position of the text block
    * @param position The position of the text block
    */
   /*@
      requires
         this.position.getX() > 0 && this.position.getY() > 0
   @*/
   public void setPosition(Point position){
      this.position = position;
   }


   /**
    * Sets the written content of the text block
    * @param block The written text string
    */
   /*@
      requires
         this.block instanceof String
   @*/
   public void setBlock(String block) {
      this.block = block;
   }
}