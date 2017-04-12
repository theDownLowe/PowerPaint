/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package shapes;

/**
 * A custom Point class used in the AbstractShape class for the GUI.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:10 PM
 */
public final class Point {

    // Class Constants
    
    /** The default X coordinate. **/
    private static final int X_INITIAL = 0;
    
    /** The default Y coordinate. **/
    private static final int Y_INITIAL = 0;
    
    
    // Instance Fields
    
    /** The Points X coordinate. **/
    private final int myX;
    
    /** The Points Y coordinate. **/
    private final int myY;
    
    
    // Constructors
    
    /** Creates a new Point with initial coordinates (0,0). **/
    public Point() {
        
        this.myX = X_INITIAL;
        this.myY = Y_INITIAL;
    }
    
    /**
     * Creates a new Point with the given X and Y values.
     * 
     * @param theX the X coordinate
     * @param theY the Y coordinate
     */
    public Point(final int theX, final int theY) {
        this.myX = theX;
        this.myY = theY;
    }
    
    /**
     * Creates a copy of the given point.
     * 
     * @param thePoint the Point to be copied
     * @throws NullPointerException when thePoint is null
     */
    public Point(final Point thePoint) throws NullPointerException {
        
        this.myX = thePoint.myX;
        this.myY = thePoint.myY;
    }
    
    
    // Instance Methods
    
    /**
     * Returns the X coordinate.
     * 
     * @return X coordinate
     */
    public int getX() {
        
        return myX;
    }
    
    /**
     * Returns the Y coordinate.
     * 
     * @return Y coordinate
     */
    public int getY() {
        
        return myY;
    }
}
