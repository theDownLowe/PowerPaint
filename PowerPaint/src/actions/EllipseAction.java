package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import shapes.Ellipse;
import view.DrawingPanel;

/** 
 * Performs an action involving an ellipse when triggered.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:47 PM
 */
public class EllipseAction extends AbstractAction {

    // Class Constants
    
    /** A generated serial ID. */
    private static final long serialVersionUID = 3248836793360831479L;
    
    
    //Instance Fields
    
    /** The panel the action is being used on. **/
    private final DrawingPanel myPanel;
    
    
    // Constructors
    
    /**
     * Creates a new action object, with the given DrawingPanel.
     * 
     * @param thePanel panel which action is used on
     */
    public EllipseAction(final DrawingPanel thePanel) {
        super("Ellipse", new ImageIcon("images/ellipse.gif"));
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(Action.SELECTED_KEY, false);
    }
    
    
    // Instance Methods
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myPanel.setShape(new Ellipse());
    }
}
