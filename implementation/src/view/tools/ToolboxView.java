package view.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

/****
 *
 * Class ToolboxView provides a single method to set up the gui for the toolbox
 *
 * @author Eric Yun (eryun@calpoly.edu)
 */

public class ToolboxView extends JPanel {

    ArrayList<Object> canvas = new ArrayList<Object>();
    int lineX1 = 10;
    int lineY1 = 60;
    int lineX2 = 40;
    int lineY2 = 90;
    int circX = 10;
    int circY = 50;
    int rectX = 10;
    int rectY = 50;
    int textX = 10;
    int textY = 50;

    /**
     * Constructor to set up the layout of the toolbox
     */
    public ToolboxView() {
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



        line.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.add(new Line2D.Double(lineX1, lineY1, lineX2, lineY2));
                lineX1 += 20;
                lineY1 += 10;
                lineX2 += 20;
                lineY2 += 10;
                repaint();
            }
        });

        circle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.add(new Ellipse2D.Double(circX, circY, 40, 40));
                circX += 30;
                circY += 30;
                repaint();
            }
        });

        rectangle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.add(new Rectangle(rectX, rectY, 40, 40));
                rectX += 50;
                rectY += 40;
                repaint();
            }
        });

        text.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.add(new String("Hello there"));
                textX += 30;
                textY += 30;
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(int i = 0; i < canvas.size(); i++) {
            if(canvas.get(i) instanceof java.lang.String) {
                g2.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                g2.drawString((String)canvas.get(i), textX, textY);
            }
            else {
                g2.draw((Shape)canvas.get(i));
            }
        }
    }
}