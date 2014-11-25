package util.roster;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;


/**
 * Class implementation of the viewer.
 * Each Viewer has an ID and a Name.
 */
public class Viewer {

    // the users that i made up when creating roster examples
    //
    //    doe, john    |    eve, linda     |     jim, frank     |     pam, jack

    // example of json data for a viewer
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

    private String firstName = "", lastName = "", role = "", grade = "";
    private String currentlyInClass = "false", able2Draw = "false";
    private int classCount = 0, ID;
    private Collection<Classroom> classrooms;

    /**
     * Returns a collection of all the roster the viewer is in
     *
     * @return  all the classrooms the user has for the quarter
     */
    public Collection<Classroom> getCurrentClasses() {
        return this.classrooms;
    }


    public void setAble2Draw(String able) {
        able2Draw = able;
    }

    public void setCurrentlyInClass(String inClass) {
        this.currentlyInClass = inClass;
    }


    public String getGrade() { return this.grade; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAble2Draw() {
        return this.able2Draw;
    }

    public String getCurrentlyInClass() {
        return this.currentlyInClass;
    }

    public String getRole() {
        return this.role;
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
     public Viewer unmarshallViewerDataFromServer(int id, DB database) {


         // connect to the viewer database
        DBCollection collection = database.getCollection("viewers");

        // search by id
        BasicDBObject whereQuerey = new BasicDBObject();
        whereQuerey.put("ID", id);

        // return the json format
        //    the .find() returns a DBCursor
        String jsonString = collection.find(whereQuerey).next().toString();

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

        try {
            JSONObject json = new JSONObject(jsonString);
            this.ID = json.getInt("ID");
            this.firstName = json.getString("firstName");
            this.lastName = json.getString("lastName");
            this.classCount = json.getInt("classCount");

            //JSONArray jsonArray = json.getJSONArray("classes");
            // adding classrooms is a little bit more complex - need to figure out implementation of classroom first

            this.grade = json.getString("grade");
            this.currentlyInClass = json.getString("currentlyInClass");
            this.able2Draw = json.getString("able2Draw");
            this.role = json.getString("role");


        } catch (JSONException e) {
            System.err.println("JSON EXECEPTION " + e);
        }

        System.out.println("STUDENT ROLE IS : " + getRole());

        return this;
    }

}
