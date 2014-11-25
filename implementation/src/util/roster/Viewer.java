package util.roster;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.Collection;


/**
 * Class implementation of the viewer.
 * Each Viewer has an ID and a Name.
 */
public class Viewer {

    // the users that i made up when creating roster examples
    //
    //    doe, john    |    eve, linda     |     jim, frank     |     pam, jack

    // example of json data from mongodb
    // {
    //   "ID"              : 3
    //   "firstName"       : "Keith",
    //   "lastName"        : "Abdulla",
    //   "classCount"      : 2,
    //   "classes"         : [ "English 310", "CSC 307"],
    //   "grade"           : "Senior",
    //   "currentlyInClass": "true",
    //   "able2Draw"       : "false",
    //   "role"            : "student"
    // }

    private String firstName = "", lastName = "", role = "";
    private boolean currentlyInClass = false, able2Draw = false;
    private int classCount = 0, ID;
    private Collection<Classroom> classroom;




    /**
     * Returns a collection of all the roster the viewer is in
     *
     * @return  all the classrooms the user has for the quarter
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

    public String getRole() {
        return this.role;
    }


    /**
     * This takes the json data from mongodb and unmarshalls it
     * to a json to a viewer object.
     *
     * @param id the id of the viewer
     */
     public Viewer unmarshallViewerDataFromServer(int id, DB database) {


         // connect to the viewer database
        DBCollection collection = database.getCollection("viewers");

        // search by id
        BasicDBObject whereQuerey = new BasicDBObject();
        whereQuerey.put("ID", id);

        // return the json format
        //    the .find() returns a DBCursor
        String json = collection.find(whereQuerey).next().toString();




        return this;
    }

}
