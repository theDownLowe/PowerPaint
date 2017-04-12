/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * A line shape to be used by the GUI.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:18 PM
 */
public final class Line extends AbstractShape {
    
    // Constructors
    
    /** Creates a new line with default values. **/
    public Line() {
        
        super();
    }
    
    /**
     * Creates a new line with the given values.
     * 
     * @param theInitial initial Point of line
     * @param theFinal final point of line
     * @param theColor color of line
     * @param theThickness thickness of line
     */
    public Line(final Point theInitial, final Point theFinal, 
                     final Color theColor, final int theThickness) {
        
        super(theInitial, theFinal, theColor, theThickness);
    }
    
    /**
     * Creates and returns a line to be added to the DrawingPanel.
     * 
     * @return Shape a line to be added to the DrawingPanel
     */
    public Shape drawShape() {
        
        final Line2D.Double line = new Line2D.Double();
        final int x1 = getInitialPoint().getX();
        final int y1 = getInitialPoint().getY();
        final int x2 = getFinalPoint().getX();
        final int y2 = getFinalPoint().getY();
        line.setLine(x1, y1, x2, y2);
        
        return line;
    }
}

