package view.tools;

import javax.swing.*;
import java.awt.*;

/****
 *
 * Class ToolboxView provides a single method to set up the gui for the toolbox
 *
 * @author Eric Yun (eryun@calpoly.edu)
 */

public class ToolboxView extends JPanel {
    /**
     * Constructor to set up the layout of the toolbox
     */
    public ToolboxView(){
        setUpTable();
    }

    /**
     * Method to set up the gui layout for the toolbox panel, containing buttons
     * for a line, circle, rectangle, and text.
     */
    public void setUpTable() {
        /**
         * Creates the various tool buttons
         */
        JButton line = new JButton();
        JButton circle = new JButton();
        JButton rectangle = new JButton();
        JButton text = new JButton();

        /**
         * Set text for each of the buttons
         */
        line.setText("line");
        circle.setText("circle");
        rectangle.setText("rectangle");
        text.setText("text");


        /**
         * Set manager layout
         */
        setLayout(new FlowLayout());
        add(line);
        add(circle);
        add(rectangle);
        add(text);

        setPreferredSize(new Dimension(250, 250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Toolbox"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
    }
}