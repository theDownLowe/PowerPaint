/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * A ellipse shape to be used by the GUI.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:18 PM
 */
public final class Ellipse extends AbstractShape {
    
    // Constructors
    
    /** Creates a new ellipse with default values. **/
    public Ellipse() {
        
        super();
    }
    
    /**
     * Creates a new ellipse with the given values.
     * 
     * @param theInitial initial Point of ellipse
     * @param theFinal final point of ellipse
     * @param theColor color of ellipse
     * @param theThickness thickness of ellipse
     */
    public Ellipse(final Point theInitial, final Point theFinal, 
                     final Color theColor, final int theThickness) {
        
        super(theInitial, theFinal, theColor, theThickness);
    }
    
    /**
     * Creates and returns an ellipse to be added to the DrawingPanel.
     * 
     * @return Shape an ellipse to be added to the DrawingPanel
     */
    public Shape drawShape() {
     
        final Ellipse2D.Double ellipse = new Ellipse2D.Double();
        final int x1 = getInitialPoint().getX();
        final int y1 = getInitialPoint().getY();
        final int x2 = getFinalPoint().getX();
        final int y2 = getFinalPoint().getY();
        ellipse.setFrameFromDiagonal(x1, y1, x2, y2);
        
        return ellipse;
    }
}

