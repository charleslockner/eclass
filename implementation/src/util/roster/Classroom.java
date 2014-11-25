package util.roster;

import java.util.PriorityQueue;

/**
 * Class implementation of a classroom
 */
public class Classroom {

    PriorityQueue<Viewer> queue = new PriorityQueue<Viewer>(3, new RosterComparatorAlphaInClass());

    private String name;
    private int currentlyInClass;


    public Classroom(String name) {
        this.name = name;
    }




    public String getNameOfClass() {
        return name;
    }

    /**
     *
     * Useful for the roster view and sorting the users.
     *
     * @return the number of current viewers in the class
     */
    public int getNumberofViewersCurrentlyInClass() { return currentlyInClass; }

    public void addViewerToCurrentSession() {

    }

}
