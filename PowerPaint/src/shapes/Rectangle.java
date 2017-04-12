/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;




/**
 * A rectangle shape to be used by the GUI.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:18 PM
 */
public final class Rectangle extends AbstractShape {
    
    // Constructors
    
    /** Creates a new rectangle with default values. **/
    public Rectangle() {
        
        super();
    }
    
    /**
     * Creates a new rectangle with the given values.
     * 
     * @param theInitial initial Point of rectangle
     * @param theFinal final point of rectangle
     * @param theColor color of rectangle
     * @param theThickness thickness of rectangle
     */
    public Rectangle(final Point theInitial, final Point theFinal, 
                     final Color theColor, final int theThickness) {
        
        super(theInitial, theFinal, theColor, theThickness);
    }
    
    /**
     * Creates and returns a rectangle to be added to the DrawingPanel.
     * 
     * @return Shape a rectangle to be added to the DrawingPanel
     */
    public Shape drawShape() {
        
        final Rectangle2D.Double rectangle = new Rectangle2D.Double();
        final int x1 = getInitialPoint().getX();
        final int y1 = getInitialPoint().getY();
        final int x2 = getFinalPoint().getX();
        final int y2 = getFinalPoint().getY();
        rectangle.setFrameFromDiagonal(x1, y1, x2, y2);
        
        return rectangle;
    }
}
