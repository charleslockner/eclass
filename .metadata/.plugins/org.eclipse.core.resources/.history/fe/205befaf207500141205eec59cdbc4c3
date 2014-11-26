package view.presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**This is the class
 * for the presentation view of 
 * the electric-classroom application,
 * includes all the tools that are in view*/
public class PresentationView extends JPanel {


    public PresentationView () {
        setupPresentationView();
    }


    public void setupPresentationView() {

        JEditorPane editorPane = new JEditorPane();
        try {
            editorPane.setPage("http://users.csc.calpoly.edu/~kaabdull/" +
                    "projects/work/electric-classroom/requirements/index.html");

            JScrollPane scrollPane = new JScrollPane(editorPane);
            scrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setPreferredSize(new Dimension(500,1000));
            scrollPane.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createCompoundBorder(
                                    BorderFactory.createTitledBorder("Presentation"),
                                    BorderFactory.createEmptyBorder(5, 5, 5, 5)),
                            scrollPane.getBorder()));


            add(scrollPane);



        } catch (IOException e) {
            editorPane.setContentType("text/html");
            editorPane.setText("<html> Could not connect to www.google.com .</html>");
        }
    }

}
