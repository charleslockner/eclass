package view.prep;

import javax.swing.*;

import util.presentation.PresentationModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/****
*
* The comment at the top of a .java file is a high-level description of the
* class defined in the file.  Start the description with the words "Class X"
* and then describe the purpose of the class and the major methods it
* provides.  The method descriptions in this header comment are generally
* brief, e.g., "Class X provides methods to add, delete, change, and find
* its elements."  Do not list all of the method details in the header
* comment, since full comments for each method appear below in the body of
* the class, at the site of each method declaration.  The header comment can
* describe the data representation used in the class in high-level terms if
* it's germane to explaining what the class is for.  The header comment does
* not describe low-level details of the data representation or any details of
* method implementation.
*
*
* @author Name and current email address of file's author(s); name is at
*         least first and last, with middle name or initial if necessary or
*         commonly used by author(s); email address appears in parentheses
*         following full name; multiple authors are comma-separated.  E.g.,
*         Gene Fisher (gfisher@calpoly.edu), John H. Smith (john_smith@
*         csun.edu).
*
*/
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
        
        this.add(backButton);
        this.add(nextButton);
        
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.previousSlide();
			}
		});
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.nextSlide();
			}
		});
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("LecturePrepView observed update");
	}
}
