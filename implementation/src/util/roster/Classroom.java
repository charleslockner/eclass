package util.roster;

import java.io.Serializable;
import java.util.PriorityQueue;

/**
 * Class implementation of a classroom.
 *
 * @author kaabdull
 */
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;

    PriorityQueue<Viewer> rosterQueue =
            new PriorityQueue<Viewer>(3, new RosterComparatorAlphaInClass());

    private String name;
    private int currentlyInClass = 0;


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
    public int getNumberofViewersCurrentlyInClass() {
        return currentlyInClass;
    }

    /**
     *
     * Adds a viewer to the current session of the classroom.
     *
     * @param viewer the viewer being added
     */
    public void addViewerToCurrentSession(Viewer viewer) {
        rosterQueue.add(viewer);
    }

    /**
     *
     * Removes a viewer from the current session of the classroom.
     *
     * @param viewer the viewer being removed
     */
    public void removeViewerFromCurrentSession(Viewer viewer) {
        rosterQueue.remove(viewer);
        System.out.println("THIS WAS CALLED");
    }

}
