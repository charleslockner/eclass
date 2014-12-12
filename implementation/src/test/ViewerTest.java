package test;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.roster.Viewer;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 *
 * Test case for the viewer class.
 *
 * @author kaabdull
 */
public class ViewerTest {

    private Viewer viewer;
    private Viewer viewer2;
    private DB db;


    /****
     *
     * Class ViewerTest is the companion testing class for class Viewer.
     * It implements the following module test plan:
     *                                                                         <ul>
     *                                                                      <p><li>
     *     Phase 1: Set up the database and get user data.
     *                                                                      <p><li>
     *     Phase 2: Test method getGrade
     *                                                                      <p><li>
     *     Phase 3: Test method getFirstName
     *                                                                      <p><li>
     *     Phase 4: Test method getLastName
     *                                                                      <p><li>
     *     Phase 5: Test getCurrentlyInClass
     *                                                                      <p><li>
     *     Phase 6: Test getID
     *                                                                      <p><li>
     *     Phase 7: Tear down database & make sure no connection
     *
     *                                                                        </ul>
     */

    @Before
    public void setUp() throws Exception {
        try {
            // talk to mongo
            MongoClientURI mongoClientURI =
                    new MongoClientURI("mongodb://kaabdull:eclass@ds055680.mongolab.com:55680/eclassroom");
            // establish the connection as an actual client now
            MongoClient mongoClient = new MongoClient(mongoClientURI);
            // find the database
            db = mongoClient.getDB("eclassroom");

            // IF ALL TEST PASS
            // WE KNOW UNMARSHAL VIEWER WORKS
            this.viewer = new Viewer().unmarshallViewerDataFromServer(5, db);
            this.viewer2 = new Viewer().unmarshallViewerDataFromServer(2, db);
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


    /**
     * Unit test the testGetGrade by building by grabbing an object from mongo db.
     * Test assert true for one case and another with a false test;
     *
     *
     *  Test
     *  Case    Input            Output                 Remarks
     * ====================================================================
     *   1      "Senior"        testGetGrade Senior
     *   2      "Fresh"         testGetGrade Fresh      make sure catches misspelling of freshman
     *
     *
     */
    @Test
    public void testGetGrade() throws Exception {
        assertEquals("testGetGrade Senior",this.viewer.getGrade(), "Senior");
        assertFalse("testGetGrade Fresh", this.viewer2.getGrade().equals("Fresh"));
    }

    /**
     * Unit test the testGetFirstName by building by grabbing an object from mongo db.
     * Test assert true for one case and another with a false test and another false test.
     *
     *
     *  Test
     *  Case    Input            Output                 Remarks
     * ====================================================================
     *   1      "Keith"        testGetFirstName Keith
     *   2      "Eve"          testGetFirstName Eve
     *   3      "keith"        testGetFirstName keith   make sure doesn't accept lower case k
     *
     *
     */
    @Test
    public void testGetFirstName() throws Exception {
        assertEquals("testGetFirstName Keith",this.viewer.getFirstName(), "Keith");
        assertTrue("testGetFirstNameFalse Eve", this.viewer2.getFirstName().equals("Eve"));
        assertFalse("testGetFirstNameFalse keith", this.viewer.getFirstName().equals("keith"));
    }

    /**
     * Unit test the testGetLastName by building by grabbing an object from mongo db.
     * Test assert true for one case
     *
     *
     *  Test
     *  Case    Input            Output                 Remarks
     * ====================================================================
     *   1      "Abdulla"       testGetLastName method  only case
     *
     *
     */
    @Test
    public void testGetLastName() throws Exception {
        assertEquals("testGetLastName method",this.viewer.getLastName(), "Abdulla");
    }

    @Test
    public void testGetAble2Draw() throws Exception {
        assertEquals("testGetAble2Draw method",this.viewer.getAble2Draw(), "true");
    }

    /**
     * Unit test the testGetCurrentlyInClass by building by grabbing an object from mongo db.
     * Test assert true for one case & one false case;
     *
     *
     *  Test
     *  Case    Input            Output                         Remarks
     * ====================================================================
     *   1      "false"       testGetCurrentlyInClass v
     *   2      "true"        testGetCurrentlyInClass v2
     *
     *
     */
    @Test
    public void testGetCurrentlyInClass() throws Exception {
        assertEquals("testGetCurrentlyInClass v",this.viewer.getCurrentlyInClass(), "false");
        assertFalse("testGetCurrentlyInClass v2", this.viewer2.getCurrentlyInClass().equals("true"));
    }

    @Test
    public void testGetRole() throws Exception {
        assertEquals("testGetRole method",this.viewer.getRole(), "student");
    }

    /**
     * Unit test the testGetID by building by grabbing an object from mongo db.
     * Test assert true for two cases;
     *
     *
     *  Test
     *  Case    Input            Output                         Remarks
     * ====================================================================
     *   1      5          testGetID method v
     *   2      2          testGetID method v2
     *
     *
     */
    @Test
    public void testGetId() throws Exception {
        assertEquals("testGetID method v",this.viewer.getId(), 5);
        assertEquals("testGetID method v2",this.viewer2.getId(), 2);
    }

    @Test
    public void testGetClassCount() throws Exception {
        assertEquals("testGetClassCount method",this.viewer.getClassCount(), 3);
    }

    @After
    public void tearDown() throws Exception {
        db.requestDone();
        assertTrue(db.getReadPreference().isSlaveOk() == false);
    }


}