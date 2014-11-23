package view.tools;

import javax.swing.*;
import java.awt.*;

public class ToolboxView extends JPanel {

    public ToolboxView(){
        setUpTable();
    }

    public void setUpTable() {

        // create the tools
        JButton circle = new JButton();
        JButton square = new JButton();
        JButton rectangle = new JButton();
        JButton line = new JButton();

        // set text on the tools
        circle.setText("circle");
        square.setText("square");
        rectangle.setText("rectangle");
        line.setText("line");


        // set manager layout
        setLayout(new FlowLayout());
        add(circle);
        add(square);
        add(rectangle);
        add(line);

        setPreferredSize(new Dimension(250, 250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Toolbox"),
                BorderFactory.createEmptyBorder(5,5,5,5)));

    }

}
