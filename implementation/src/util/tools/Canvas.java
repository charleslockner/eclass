package util.tools;

import java.util.ArrayList;
import java.awt.geom.*;
import util.tools.Text;


/****
 * Canvas class which contains an ArrayList called array to hold the various objects
 * drawn on screen. Objects can be added or deleted from the array.
 *
 * @author Eric Yun (eryun@calpoly.edu)
 */
public class Canvas {
    private ArrayList<Object> array = new ArrayList<Object>();

    /**
     * Adds the specified object to the end of the canvas array.
     *
     * @param object The object to be added to the canvas array
     */
    /*@
      requires
         this.block instanceof Text || this.block instanceof Line2D
           || this.block instanceof Ellipse2D || this.block instanceof Rectangle
   @*/
    public void add(Object object)
    {
        array.add(object);
    }

    /**
     * Removes the last element in the canvas, and returns its content.
     *
     * @return The object being removed from the array
     */
    public Object delete()
    {
        return array.remove(array.size() - 1);
    }

    /**
     * Returns the object at the specified position in the canvas array.
     *
     * @param index The element position in the array
     * @return The object at the specified position in the array
     */
    /*@
      requires
         index >= 0 && index < array.size()
   @*/
    public Object get(int index)
    {
        return array.get(index);
    }
}