/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package view;

/**
 * Main class for PowerPaint program.
 * 
 * @author Trevor N. Lowe
 * @version November 10, 2015 - 10:42 AM
 */
public final class PowerPaintMain {
    
    // Constructors
    
    /** Empty constructor for the class to prevent instantiation. **/
    private PowerPaintMain() {
        throw new IllegalStateException();
    }
    
    
    // Main Method
    
    /**
     * Main method for PowerPaint.
     * 
     * @param theArgs Ignored command line parameters
     */
    public static void main(final String [] theArgs) {
        
        new PowerPaintGUI();
    }
}
