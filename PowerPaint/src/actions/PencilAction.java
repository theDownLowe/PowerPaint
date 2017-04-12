package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import shapes.Pencil;
import view.DrawingPanel;

/** 
 * Performs an action involving a pencil when triggered.
 * 
 * @author Trevor N. Lowe
 * @version November 19, 2015 - 12:47 PM
 */
public class PencilAction extends AbstractAction {

    // Class Constants
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = -244445573283689354L;
    
    
    // Instance Methods
    
    /** The panel the action is being used on. **/
    private final DrawingPanel myPanel;
    
    
    // Constructors
    
    /**
     * Creates a new action object, with the given DrawingPanel.
     * 
     * @param thePanel panel which action is used on
     */
    public PencilAction(final DrawingPanel thePanel) {
        super("Pencil", new ImageIcon("images/pencil.gif"));
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
        putValue(Action.SELECTED_KEY, true);
    }
    
    
    // Instance Methods
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myPanel.setShape(new Pencil());
    }
}
