/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/** 
 * Class for a new custom tool bar.
 * 
 * @author Trevor N. Lowe
 * @version November 10, 2015 - 12:03 PM
 */
public class ToolBar extends JToolBar {

    // Instance Fields
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = 7280568427508955229L;
    
    /** Custom menu bar. **/
    private final ButtonGroup myGroup;
    
    
    // Constructors
    
    /** Creates a new ToolBar object. **/
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }
    
    
    // Instance Methods
    
    /**
     * Creates a new toggle button to be added to the tool bar.
     * 
     * @param theAction The action to be added to a button
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton button = new JToggleButton(theAction);
        myGroup.add(button);
        add(button);
    }
}
