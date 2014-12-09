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
    public Object get(int index)
    {
        return array.get(index);
    }
}