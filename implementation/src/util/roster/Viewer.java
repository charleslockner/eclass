package util.roster;

import util.roster.Classroom;

import java.util.Collection;

/**
 * Class implementation of the viewer.
 * Each Viewer has an ID and a Name.
 *
 */
public class Viewer  {


    // int id
    // int class count
    // [] of classes
    // String firstName
    // String secondName
    // String grade
    // boolean currentlyInClass
    // boolean able2Draw

    private int ID;
    private Collection<Classroom> classes;


    /**
     *
     * Returns a collection of all the roster the viewer is in
     *
     * @return
     */
    public Collection<Classroom> getCurrentClasses() {
        return classes;
    }


    /**
     * Return the viewer's id number
     *
     * @return the viewers id
     */
    public int getViewerID() {
        return ID;
    }

    public String viewersName() {
        return "HELLO";
    }


}
