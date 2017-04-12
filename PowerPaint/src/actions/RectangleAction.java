package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import shapes.Rectangle;
import view.DrawingPanel;

/** 
 * Performs an action involving a pencil when triggered.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:47 PM
 */
public class RectangleAction extends AbstractAction {

    // Class Constants
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = -58578684170274764L;
    
    
    // Instance Fields
    
    /** The panel the action is being used on. **/
    private final DrawingPanel myPanel;
    
    // Constructors
    
    /**
     * Creates a new action object, with the given DrawingPanel.
     * 
     * @param thePanel panel which action is used on
     */
    public RectangleAction(final DrawingPanel thePanel) {
        super("Rectangle", new ImageIcon("images/rectangle.gif"));
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.SELECTED_KEY, false);
    }
    
    
    // Instance Methods
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myPanel.setShape(new Rectangle());
    }
}
