package view.prep;

import javax.swing.*;

import util.presentation.PresentationModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class LecturePrepView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	PresentationModel model;
	
    public LecturePrepView(PresentationModel model) {
    	this.model = model;
    	this.model.addObserver(this);
        setup();
    }

    public void setup() {
        // create the tools

        setPreferredSize(new Dimension(250, 400));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Lecture Prep"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        
		JButton backButton = new JButton("Back");
		JButton nextButton = new JButton("Next");
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.nextSlide();
			}
		});
        
        this.add(backButton);
        this.add(nextButton);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("LecturePrepView observed update");
	}
}
