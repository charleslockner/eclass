package util.tools;

import java.awt.Point;

/**
 * Class implemenetation of the rectangle
 */
public abstract class Rectangle extends Shape {
   Point center;
   int length;
   int width;
   
   /**
     * Creates a new rectangle
     */
   abstract void createRectangle(Point center, int length, int width);
   
   /**
     * Moves the center of the rectangle
     */
   abstract void updateCenter(Point center);
   
   /**
     * Changes the length fo the rectangle
     */
   abstract void updateLength(int length);
   
   /**
     * Changes the width of the rectangle
     */
   abstract void updateWidth(int width);
   
   /**
     * Deletes the rectangle
     */
   abstract void delete();
}
