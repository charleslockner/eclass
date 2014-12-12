package util.tools;

import java.util.ArrayList;

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
    public void add(Object object)
    {
        if (object != null)
    		array.add(object);
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
        if (array.size() > 0 && index < array.size())
    		return array.get(index);
        else
        	return null;
    }
    
    /**
     * Removes the last element in the canvas, and returns its content.
     *
     * @return The object being removed from the array
     */
    /*@
       requires
          array.size() > 0
    @*/
    public Object delete()
    {
        if (array.size() > 0)
    		return array.remove(array.size() - 1);
        else
        	return null;
    }
}