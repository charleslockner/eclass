package test;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.junit.Before;
import org.junit.Test;
import util.roster.Viewer;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

public class ViewerTest {

    private Viewer viewer;

    @Before
    public void setUp() throws Exception {
        try {
            // talk to mongo
            MongoClientURI mongoClientURI =
                    new MongoClientURI("mongodb://kaabdull:eclass@ds055680.mongolab.com:55680/eclassroom");
            // establish the connection as an actual client now
            MongoClient mongoClient = new MongoClient(mongoClientURI);
            // find the database
            DB db = mongoClient.getDB("eclassroom");

            // IF ALL TEST PASS
            // WE KNOW UNMARSHAL VIEWER WORKS
            this.viewer = new Viewer().unmarshallViewerDataFromServer(5, db);
        } catch( UnknownHostException e) {
            assert(false);
            System.err.println("Unkown Host Exception : " + e);
        }

    }

    /*{
        "ID": 5,
            "firstName": "Keith",
            "lastName": "Abdulla",
            "classCount": 3,
            "classes": [
        "CSC 307",
                "Math 143",
                "Artificial Intelligence"
        ],
        "grade": "Senior",
            "currentlyInClass": "false",
            "able2Draw": "true",
            "role": "student"
    } */

    @Test
    public void testGetGrade() throws Exception {
        assertEquals("testGetGrade method",this.viewer.getGrade(), "Senior");
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertEquals("testGetFirstName method",this.viewer.getFirstName(), "Keith");
    }

    @Test
    public void testGetLastName() throws Exception {
        assertEquals("testGetLastName method",this.viewer.getLastName(), "Abdulla");
    }

    @Test
    public void testGetAble2Draw() throws Exception {
        assertEquals("testGetAble2Draw method",this.viewer.getAble2Draw(), "true");
    }

    @Test
    public void testGetCurrentlyInClass() throws Exception {
        assertEquals("testGetCurrentlyInClass method",this.viewer.getCurrentlyInClass(), "false");
    }

    @Test
    public void testGetRole() throws Exception {
        assertEquals("testGetRole method",this.viewer.getRole(), "student");
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals("testGetID method",this.viewer.getId(), 5);
    }

    @Test
    public void testGetClassCount() throws Exception {
        assertEquals("testGetClassCount method",this.viewer.getClassCount(), 3);
    }

}