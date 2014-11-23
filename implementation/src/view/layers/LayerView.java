package view.layers;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Keithmaynn on 11/19/14.
 */
public class LayerView extends JPanel {

    public LayerView() {
        setup();
    }

    public void setup() {
        //Create a text area.
        JTextArea textArea = new JTextArea(
                "This is an editable JTextArea. " +
                        "A text area is a \"plain\" text component, " +
                        "which means that although it can display text " +
                        "in any font, all of the text is in the same font."
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 500));
        areaScrollPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Layers"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        areaScrollPane.getBorder()));

        add(areaScrollPane);
    }

}
