/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** 
 * Class for a new custom menu bar.
 * 
 * @author Trevor N. Lowe
 * @version November 10, 2015 - 12:03 PM
 */
public class MenuBar extends JMenuBar {

    // Class Constants
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = -650689703231349781L;

    /** Text in about menu. **/
    private static final String ABOUT_TEXT = "TCSS 305 PowerPaint, Autumn 2015";
    
    /** Minimum thickness on the slider. **/
    private static final int THICK_MIN = 0;
    
    /** Maximum thickness on the slider. **/
    private static final int THICK_MAX = 20;
    
    /** Major increments on the slider. **/
    private static final int SLIDER_MAJOR = 5;
    
    /** Minor increments on the slider. **/
    private static final int SLIDER_MINOR = 1;
    
    /** Initial value on the slider. **/
    private static final int THICK_INITIAL = 1;
    
    
    // Instance Fields
    
    /** Button group for tools. **/
    private final ButtonGroup myGroup;
    
    /** The tool menu with button group. **/
    private final JMenu myToolMenu;
    
    // Constructors
    
    /**
     * Constructs a new menu bar object.
     * 
     * @param theFrame the JFrame in which the menu bar is attached
     * @param thePanel the JPanel used for drawing
     */
    public MenuBar(final JFrame theFrame, final DrawingPanel thePanel) {
        super();
        myGroup = new ButtonGroup();
        myToolMenu = new JMenu("Tools");
        
        setup(theFrame, thePanel);
    }
    
    
    // Instance Methods
    
    /**
     * Sets up the menu bar.
     * 
     * @param theFrame the JFrame which the menu is attached
     * @param thePanel the JPanel used for drawing
     */
    private void setup(final JFrame theFrame, final DrawingPanel thePanel) {
        
        add(fileMenuSetup(theFrame, thePanel));
        add(optionMenuSetup(theFrame, thePanel));
      
        // Sets up the tool menu
        myToolMenu.setMnemonic(KeyEvent.VK_T);
        add(myToolMenu);
        
        add(helpMenuSetup(theFrame));
    }
    
    /**
     * Sets up the file menu.
     * 
     * @param theFrame the JFrame which the menu is attached
     * @param thePanel the JPanel used for drawing
     * @return the file menu
     */
    private JMenu fileMenuSetup(final JFrame theFrame, final DrawingPanel thePanel) {
        
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        // Undo all changes Button
        final JMenuItem undoAll = new JMenuItem("Undo all changes");
        undoAll.setMnemonic(KeyEvent.VK_U);
        undoAll.setEnabled(false);
        undoAll.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.clear();
            }
        });
        
        // Undo Button
        final JMenuItem undo = new JMenuItem("Undo");
        undo.setEnabled(false);
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.undo();
                if (thePanel.isEmptyShapes()) {
                    undo.setEnabled(false);
                }
                thePanel.repaint();
            }
        });
        
        // Redo Button
        final JMenuItem redo = new JMenuItem("Redo");
        redo.setEnabled(false);
        redo.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.redo();
                if (thePanel.isEmptyUndo()) {
                    redo.setEnabled(false);
                }
                thePanel.repaint();
            }
        });
        
        thePanel.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent theEvent) {
                final boolean isEnabled = thePanel.isEmptyShapes();
                undoAll.setEnabled(isEnabled);
                undo.setEnabled(isEnabled);
                redo.setEnabled(!thePanel.isEmptyUndo());
                System.out.println("Hello");
            }
            
        });
        
        fileMenu.add(undoAll);
        fileMenu.addSeparator();
        fileMenu.add(undo);
        fileMenu.add(redo);
        fileMenu.addSeparator();
        
        // Exit button
        final JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        fileMenu.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame,
                                                       WindowEvent.WINDOW_CLOSING));
            }
        });
        
        return fileMenu;
    }
    
    /**
     * Sets up the option menu.
     * 
     * @param theFrame the JFrame which the menu is attached
     * @param thePanel the JPanel used for drawing
     * @return the option menu
     */
    private JMenu optionMenuSetup(final JFrame theFrame, final DrawingPanel thePanel) {
        
        final JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic(KeyEvent.VK_O);
        
        // Grid
        final JMenuItem grid = new JCheckBoxMenuItem("Grid");
        grid.setMnemonic(KeyEvent.VK_G);
        grid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.changeGrid();
                thePanel.repaint();
            }
        });
        optionMenu.add(grid);
        optionMenu.addSeparator();
        
        // Thickness
        final JMenu thickness = new JMenu("Thickness");
        thickness.setMnemonic(KeyEvent.VK_T);
        final JSlider thickSlider = new JSlider(JSlider.HORIZONTAL, THICK_MIN,
                                                THICK_MAX, THICK_INITIAL);
        thickSlider.setMajorTickSpacing(SLIDER_MAJOR);
        thickSlider.setMinorTickSpacing(SLIDER_MINOR);
        thickSlider.setPaintTicks(true);
        thickSlider.setPaintLabels(true);
        thickSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                
                thePanel.setThickness(thickSlider.getValue());
            }
        });
        thickness.add(thickSlider);
        optionMenu.add(thickness);
        optionMenu.addSeparator();
        
        //Color
        final JMenuItem color = new JMenuItem("Color...");
        color.setMnemonic(KeyEvent.VK_C);
        color.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final Color newColor = JColorChooser.showDialog(theFrame, 
                                                                "Choose a color",
                                                                thePanel.getShapeColor());
                if (newColor != null) {
                    thePanel.setShapeColor(newColor);
                }
            }
        });
        optionMenu.add(color);
        
        return optionMenu;
    }
    
    /**
     * Sets up the help menu.
     * 
     * @param theFrame the JFrame which the menu is attached
     * @return the help menu 
     */
    private JMenu helpMenuSetup(final JFrame theFrame) {
        
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(theFrame, ABOUT_TEXT);
            }
        });
        helpMenu.add(about);
        
        return helpMenu;
    }
    
    /** 
     * Creates a new Radio button on the tool bar.
     * 
     * @param theAction action to be added to a button
     */
    public void createToolButton(final Action theAction) {
        
        final JRadioButtonMenuItem button = new JRadioButtonMenuItem(theAction);
        myGroup.add(button);
        myToolMenu.add(button);
    }
}
