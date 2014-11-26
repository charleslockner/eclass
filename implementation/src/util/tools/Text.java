package util.tools;

import java.awt.Point;

/****
 * Class Text gives the properties of a text and allows the creation and
 * modification of a text in the canvas. Methods to get and set the
 * position and content of the text.
 *
 * @author Eric Yun(eryun@calpoly.edu)
 */
public abstract class Text {
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
      position.setLocation(x, y);
      this.block = block;
   }

   /**
    * Gets the location of the text block
    * @return position The position of the text block
    */
   public Point getLocation() {
      return this.position;
   }

   /**
    * Gets the content of the text block
    * @return block The written content of the text block
    */
   public String getBlock(){
      return this.block;
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
    * Sets the position of the text block
    * @param position The position of the text block
    */
   public void setPosition(Point position){
      this.position = position;
   }

   /**
    * Sets the written content of the text block
    * @param block The written text string
    */
   abstract void setBlock(String block);
}
