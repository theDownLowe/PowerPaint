package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import shapes.Line;
import view.DrawingPanel;

/** 
 * Performs an action involving a line when triggered.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:47 PM
 */
public class LineAction extends AbstractAction {

    // Class Constants
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = 4135521059143578916L;

    
    // Instance Fields
    
    /** The panel the action is being used on. **/
    private final DrawingPanel myPanel;
    
    
    // Constructors
    
    /**
     * Creates a new action object, with the given DrawingPanel.
     * 
     * @param thePanel panel which action is used on
     */
    public LineAction(final DrawingPanel thePanel) {
        super("Line", new ImageIcon("images/line.gif"));
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, false);
    }
    
    
    // Instance Methods
    
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myPanel.setShape(new Line());
    }
}
