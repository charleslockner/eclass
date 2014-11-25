package util.roster;

import util.roster.Classroom;

import java.util.Collection;

/**
 * Class implementation of the viewer.
 * Each Viewer has an ID and a Name.
 *
 */
public class Viewer  {


    // int classCount
    // [] of classes
    // String firstName
    // String lastName
    // String grade
    // boolean currentlyInClass
    // boolean able2Draw

    // { "classCount":2 ,
    //   "classes":[ "English 310", "CSC 307"],
    //   "firstName": "Keith",
    //   "lastName":"Abdulla",
    //   "grade": "Senior",
    //   "currentlyInClass": "true",
    //   "able2Draw" : "false"
    // }

    private String firstName = "", lastName = "";
    private boolean currentlyInClass = false, able2Draw = false;
    private int classCount = 0, ID;
    private Collection<Classroom> classroom;


    /**
     *
     * Returns a collection of all the roster the viewer is in
     *
     * @return
     */
    public Collection<Classroom> getCurrentClasses() {
        return this.classroom;
    }


    public void setAble2Draw(boolean able) {
        able2Draw = able;
    }

    public void setCurrentlyInClass(boolean inClass) {
        this.currentlyInClass = inClass;
    }


    //


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean getAble2Draw() {
        return this.able2Draw;
    }


    public boolean getCurrentlyInClass() {
        return this.currentlyInClass;
    }

    public int getId() {
        return this.ID;
    }

    public int getClassCount() {
        return this.classCount;
    }


    /**
     * This takes the json data from mongodb and unmarshalls it
     * to a json to a viewer object.
     *
     * @param id the id of the viewer
     */
    public void unmarshallViewerDataFromServer(int id) {

    }

}
