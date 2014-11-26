package view.presentation;

import javax.swing.*;

import util.presentation.PresentationModel;

import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * This is the class
 * for the presentation view of 
 * the electric-classroom application,
 * includes all the tools that are in view*/
public class PresentationView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	private PresentationModel model;

	JEditorPane editorPane;
	
    public PresentationView (PresentationModel model) {
    	this.model = model;
    	model.addObserver(this);
        setupPresentationView();
    }

    public void setupPresentationView() {

        editorPane = new JEditorPane();
        try {
            editorPane.setPage(model.getCurrentUrl());

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

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("PresentationView observed update");
		try {
			editorPane.setPage(model.getCurrentUrl());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
