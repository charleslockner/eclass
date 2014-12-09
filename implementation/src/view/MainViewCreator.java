package view;

import rmi.ChatClient;
import util.chat.Chatbox;
import util.presentation.PresentationModel;
import view.layers.LayerView;
import view.prep.LecturePrepView;
import view.presentation.*;
import view.presentation.MenuBar;
import view.roster.RosterView;
import view.tools.ToolboxView;

import javax.swing.*;

import java.awt.*;              //for layout managers and more

/**
* Class MainViewCreator is in charge of setting up all the views in the application,
* as well as adding them to the main application frame.
* @author Charles Lockner (clockner@calpoly.edu), Keith Abdulla (kaabdull@calpoly.edu)
*/
public class MainViewCreator extends JPanel {

	PresentationModel presentationModel = new PresentationModel();
	
        /* creates our roster view */
    RosterView rosterView = new RosterView();
        /* creates our toolbox view */
    ToolboxView toolboxView = new ToolboxView();
        /* creates our layer view */
    LayerView layerView = new LayerView();
        /* creates our presentation view */
    PresentationView presentationView = new PresentationView(presentationModel);
        /* creates our chat box view */
        /* creates our chat box view */
    LecturePrepView lecturePrepView = new LecturePrepView(presentationModel);

    /**
     * The initilization for the main screen.
     */
    public void setup() {

        /* Left Pane => roster view + layer view + toolbox view  */
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(rosterView,
                BorderLayout.PAGE_START);
        leftPane.add(layerView,
                BorderLayout.CENTER);
        leftPane.add(toolboxView,
                BorderLayout.PAGE_END);

        /* center pane is our presentation view panel */

        /* right pane = chatbox + lecture prep view */
        JPanel rightPane = new JPanel(new BorderLayout());
        //rightPane.add(chatboxView, BorderLayout.PAGE_START);
        rightPane.add(lecturePrepView, BorderLayout.PAGE_END);


        add(leftPane, BorderLayout.LINE_START);
        add(presentationView, BorderLayout.CENTER);
        add(rightPane, BorderLayout.LINE_END);
    }

    /**
     * This is the creator for all the gui jpanel elements
     */
    public MainViewCreator() {
        setLayout(new BorderLayout());
        setup();
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Electric Classroom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new MainViewCreator());
        frame.setJMenuBar(new MenuBar());

        frame.setMinimumSize(new Dimension(1000,850));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}