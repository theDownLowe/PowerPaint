/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

import java.awt.Color;
import java.awt.Shape;

/**
 * The Shape interface class used in the GUI.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:15 PM
 */
public interface ShapeTool {    
    
    // Mutators
    
    /**
     * Sets the shape's start point.
     * 
     * @param thePoint shape's new initial Point
     */
    void setPointInitial(final Point thePoint);
    
    /**
     * Sets the shape's end point.
     * 
     * @param thePoint shape's new final Point
     */
    void setPointFinal(final Point thePoint);
    
    /**
     * Sets the shape's color.
     * 
     * @param theColor shape's new color
     */
    void setColor(final Color theColor);
    
    /**
     * Sets the shape's thickness.
     * 
     * @param theThickness shape's new thickness
     */
    void setThickness(final int theThickness);
    
    /**
     * Sets the shapes truth value of if it printable.
     * 
     * @param theIsPrintable true if printable
     */
    void setPrintable(final boolean theIsPrintable);
    
    
    // Accessors
    
    /**
     * Returns the starting Point of shape.
     * 
     * @return initial point of shape
     */
    Point getInitialPoint();
    
    /**
     * Returns the ending Point of shape.
     * 
     * @return final Point of shape
     */
    Point getFinalPoint();
    
    /**
     * Returns the color of the shape.
     * 
     * @return shape's color
     */
    Color getColor();
    
    /**
     * Returns the thickness of the shape.
     * 
     * @return shape's thickness
     */
    int getThickness();
    
    /**
     * Returns true if shape is printable.
     * 
     * @return true if printable
     */
    boolean isPrintable();
    
    /**
     * Creates the current shape.
     * 
     * @return current shape
     */
    Shape drawShape();
}
