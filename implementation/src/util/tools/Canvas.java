package util.tools;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;


/****
 * Canvas class which contains an ArrayList called array to hold the various shapes
 * drawn on screen. Shapes can be added or deleted from the array.
 *
 * @author Eric Yun (eryun@calpoly.edu)
 */
public class Canvas {
    private ArrayList<Shape> array = new ArrayList<Shape>();

    /* Constructor */
    public Canvas()
    {
    }

    /**
     * Adds the specified shape to the end of the canvas array.
     *
     * @param shape The shape to be added to the canvas array
     */
    public void add(Shape shape)
    {
        array.add(shape);
    }

    /**
     * Removes the shape from the canvas array at the specified index.
     *
     * @param index The array index to remove the shape from
     * @return The shape being removed from the array
     */
    public Shape delete(int index)
    {
        return array.remove(index);
    }
}