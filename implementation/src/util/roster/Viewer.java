package util.roster;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;
import java.util.Collection;

/**
 * Class implementation of the viewer.
 * Each Viewer has an ID and a Name.
 *
 */
public class Viewer  {

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

    public String getRole() { return this.role; }


    /**
     * This takes the json data from mongodb and unmarshalls it
     * to a json to a viewer object.
     *
     * @param id the id of the viewer
     */
    public Viewer unmarshallViewerDataFromServer(int id) {
        try {
            MongoClientURI mongoClientURI =
                    new MongoClientURI("mongodb://kaabdull:eclass@ds055680.mongolab.com:55680/eclassroom");
                    /* establish the connection as an actual client now */
            MongoClient mongoClient = new MongoClient(mongoClientURI);
                    /* find the database */
            DB db = mongoClient.getDB("eclassroom");
                    /* connect to the viewer database */
            DBCollection collection = db.getCollection("viewers");

        } catch (UnknownHostException e) {
            System.err.println();
        }


        return this;
    }

}
