/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

import java.awt.Color;
import java.awt.Shape;

/**
 * An abstract shape class to parent different shapes for the GUI.
 * Shapes:
 *  Pencil
 *  Line
 *  Rectangle
 *  Ellipse
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:25 PM
 */
public abstract class AbstractShape implements ShapeTool {

    // Instance Methods
    
    /** Start Point for shape. **/
    private Point myPointInitial;
    
    /** End point for shape. **/
    private Point myPointFinal;
    
    /** Color of shape. **/
    private Color myColor;
    
    /** Thickness of shape. **/
    private int myThickness;
    
    /** True if printable. **/
    private boolean myIsPrintable;
    
    
    // Constructors
    
    /** Creates a default AbstractShape. **/
    protected AbstractShape() {
        
        this(new Point(), new Point(), Color.BLACK, 1);
    }
    
    /**
     * Creates an AbstractShape with the given values.
     * 
     * @param theInitial the initial point of shape
     * @param theFinal the final point of shape
     * @param theColor the color of shape
     * @param theThickness the thickness of shape
     */
    protected AbstractShape(final Point theInitial, final Point theFinal,
                         final Color theColor, final int theThickness) {
        
        this.myPointInitial = theInitial;
        this.myPointFinal = theFinal;
        this.myColor = theColor;
        this.myThickness = theThickness;
        this.myIsPrintable = false;
    }
    
    // Instance Methods (Mutators)
    
    @Override
    public void setPointInitial(final Point thePoint) {
        
        myPointInitial = new Point(thePoint);
    }
    
    @Override
    public void setPointFinal(final Point thePoint) {
        
        myPointFinal = new Point(thePoint);
    }
    
    @Override
    public void setColor(final Color theColor) {
        
        myColor = theColor;
    }
    
    @Override
    public void setThickness(final int theThickness) {
        
        myThickness = theThickness;
    }
    
    @Override
    public void setPrintable(final boolean theIsPrintable) {
        
        myIsPrintable = theIsPrintable;
    }
    
    
    // Instance Methods (Accessors)
    
    @Override
    public abstract Shape drawShape();
    
    @Override
    public Point getInitialPoint() {
        
        return new Point(myPointInitial);
    }
    
    @Override
    public Point getFinalPoint() {
        
        return new Point(myPointFinal);
    }
    
    @Override
    public Color getColor() {
        
        return myColor;
    }
    
    @Override
    public int getThickness() {
        
        return myThickness;
    }
    
    @Override
    public boolean isPrintable() {

        return myIsPrintable;
    }
}
