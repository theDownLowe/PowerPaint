/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package view;

import actions.EllipseAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * GUI controller for the PowerPaint program.
 * 
 * @author Trevor N. Lowe
 * @version November 10, 2015 - 10:57 AM
 */
public class PowerPaintGUI {
  
    // Constructors

    /** Constructs a new PowerPaintGUI object. **/
    public PowerPaintGUI() {
        
        this.setup();
    }
    
    
    // Instance Methods
    
    /** Sets up the GUI with all of the correct elements. **/
    private void setup() {
        final JFrame frame = new JFrame("PowerPaint");
        final ImageIcon icon = new ImageIcon("images/w.gif");
        frame.setIconImage(icon.getImage());
        
        final DrawingPanel panel = new DrawingPanel();
        final MenuBar menuBar = new MenuBar(frame, panel);
        final ToolBar toolBar = new ToolBar();

        final Action[] actions = {new PencilAction(panel), new LineAction(panel),
                                  new RectangleAction(panel), new EllipseAction(panel)};
        
        for (final Action action : actions) {
            menuBar.createToolButton(action);
            toolBar.createToolBarButton(action);
        }
        
        
        
        frame.setJMenuBar(menuBar);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.SOUTH);

        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final Toolkit kit = Toolkit.getDefaultToolkit();
        frame.setLocation(
                          (int) (kit.getScreenSize().getWidth() / 2 - frame.getWidth() / 2),
                          (int) (kit.getScreenSize().getHeight() / 2 - frame.getHeight() / 2));
        
        frame.setVisible(true);
    }    
}