/*
 * TCSS 305
 * Assignment 5 - PowerPaint
 */

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import shapes.Pencil;
import shapes.Point;
import shapes.ShapeTool;

/** 
 * Drawing panel for PowerPaintGUI.
 * 
 * @author Trevor N. Lowe
 * @version November 10, 2015 - 12:56 PM
 */
public class DrawingPanel extends JPanel {

    // Class Constants
    
    /** A generated serial ID. **/
    private static final long serialVersionUID = 6581788221264616073L;

    /** Default panel size. **/
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
    
    /** Background color. **/
    private static final Color BACKGROUND = Color.WHITE;
    
    /** Spacing on the grid. **/
    private static final int GRID_SPACING = 10;
    
    
    // Instance Fields
    
    /** True if grid is enabled. **/
    private boolean myGrid;
    
    /** The current shape. **/
    private ShapeTool myShape;
    
    /** A list of shapes. **/
    private final List<ShapeTool> myShapes;

    /** A stack of undone shapes. **/
    private final ArrayDeque<ShapeTool> myUndo;
    
    
    // Constructors
    
    /** Creates a new DrawingPanel object. **/
    public DrawingPanel() {
        super();
        setPreferredSize(DEFAULT_SIZE);
        setBackground(BACKGROUND);
        myGrid = false;
        myShape = new Pencil();
        myShapes = new ArrayList<ShapeTool>();
        myUndo = new ArrayDeque<ShapeTool>();
        addCrosshairListener();
        addShapeListener();
        addDragListener();
    }
    
    
    // Instance Methods
    
    /** Clears the current panel. **/
    public void clear() {
        
        if (myShapes != null) {
            myShapes.clear();
        }
        repaint();
    }
    
    // private class 
    
    /** Changes the cursor when the mouse exits and enters the panel. **/
    private void addCrosshairListener() {
        
        addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(final MouseEvent theEvent) {
                newCursor(true);
            }
            
            public void mouseExited(final MouseEvent theEvent) {
                newCursor(false);
            }

            private void newCursor(final boolean theCursor) {
                if (theCursor) {
                    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }
    
    /** Listener for drawing new shapes. **/
    private void addShapeListener() {
        
        addMouseListener(new MouseAdapter() {    
            public void mousePressed(final MouseEvent theEvent) {   
                myShape.setPrintable(true);
                final int x = theEvent.getX();
                final int y = theEvent.getY();
                final Point point = new Point(x, y);
                myShape.setPointInitial(point);
            }
            public void mouseReleased(final MouseEvent theEvent) {
                final int x = theEvent.getX();
                final int y = theEvent.getY();
                final Point point = new Point(x, y);
                myShape.setPointFinal(point);
                myShapes.add(myShape);
                newShape();
            }
        });
    }
    
    /** Creates a newShape of the same type as the current shape. **/
    private void newShape() {
        
        final Color color = myShape.getColor();
        final int thickness = myShape.getThickness();
        try {
            myShape = myShape.getClass().newInstance();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        myShape.setColor(color);
        myShape.setThickness(thickness);
        myShape.setPrintable(false);
    }
    
    /** Adds a mouse drag listener to the panel to drag shapes. **/
    private void addDragListener() {
        addMouseMotionListener(new MouseAdapter() {
            
            public void mouseDragged(final MouseEvent theEvent) {
                final int x = theEvent.getX();
                final int y = theEvent.getY();
                final Point point = new Point(x, y);
                myShape.setPointFinal(point);
                repaint();
            } 
        });
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        
        super.paintComponent(theGraphics);
        final Graphics2D graphics2D = (Graphics2D) theGraphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw current shape
        if (myShapes != null) {   
            for (final ShapeTool s : myShapes) {
                graphics2D.setColor(s.getColor());
                if (s.getThickness() != 0) {
                    graphics2D.setStroke(new BasicStroke((float) s.getThickness()));
                    graphics2D.draw(s.drawShape());
                }
            }
        }
        
        // Draw previous shapes
        if (myShape != null && myShape.isPrintable() && myShape.getThickness() != 0) {
            graphics2D.setColor(myShape.getColor());
            graphics2D.setStroke(new BasicStroke((float) myShape.getThickness()));
            graphics2D.draw(myShape.drawShape());
        }
        
        // Draw grid
        if (myGrid) {
            paintGrid(graphics2D);
        }
    }
    
    /**
     * Draws lines for the grid starting from the upper left hand corner.
     * 
     * @param theGraphics2D graphics on which grid is painted
     */
    private void paintGrid(final Graphics2D theGraphics2D) {
        
        final int height = this.getHeight();
        final int width = this.getWidth();
        final Line2D.Double  line = new Line2D.Double();
        theGraphics2D.setColor(Color.BLACK);
        theGraphics2D.setStroke(new BasicStroke(1));

        // Draws the Vertical grid lines
        for (int i = 0; i < width; i++) {
            if (i % GRID_SPACING == 0) {
                line.setLine(i, 0, i, height);
                theGraphics2D.draw(line);
            }
        }
        
        // Draws the Horizontal grid lines
        for (int i = 0; i < height; i++) {
            if (i % GRID_SPACING == 0) {
                line.setLine(0, i, width, i);
                theGraphics2D.draw(line);
            }
        }
    }
    
    /** Changes the grid from on to off or off to on. **/
    public void changeGrid() {
        
        // Bitwise inversion
        myGrid ^= true;
    }
    
    /**
     * Returns the current shape's color.
     * 
     * @return current shape's color
     */
    public Color getShapeColor() {
        
        return myShape.getColor();
    }
    
    /**
     * Sets the current shape's color.
     * 
     * @param theColor Color which the shape is being set to
     */
    public void setShapeColor(final Color theColor) {
        
        myShape.setColor(theColor);
    }
    
    /**
     * Sets the current shape's thickness.
     * 
     * @param theThickness shape's new thickness
     */
    public void setThickness(final int theThickness) {
        
        myShape.setThickness(theThickness);
    }
    
    /**
     * Sets the panel's current shape.
     * 
     * @param theShape new shape for panel
     */
    public void setShape(final ShapeTool theShape) {
        
        final Color color = myShape.getColor();
        final int thickness = myShape.getThickness();
        myShape = theShape;
        myShape.setColor(color);
        myShape.setThickness(thickness);
    }
    
    /**
     * Returns true if the list of shapes is empty.
     * 
     * @return true if list of shapes is empty
     */
    public boolean isEmptyShapes() {
        
        return myShapes.isEmpty();
    }
    
    /**
     * Returns true if the stack of undo is empty.
     * 
     * @return true if stack of undo is empty
     */
    public boolean isEmptyUndo() {
        
        return myUndo.isEmpty();
    }
    
    /** Undoes the previously created shape. **/
    public void undo() {
        
        myUndo.push(myShapes.get(myShapes.size() - 1));
        myShapes.remove(myShapes.size() - 1);
    }
    
    /** Redoes the previous undo. **/
    public void redo() {
        
        myShapes.add(myUndo.pop());
    }
}