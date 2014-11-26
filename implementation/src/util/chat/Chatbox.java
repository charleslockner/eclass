package util.chat;


import com.mongodb.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;

/**
 *
 * Class resembles the functionality of the chatbox.
 *
 * @author kaabdull
 */
public class Chatbox {

    private DBCollection collection;

    public Chatbox() {
        try {

                    /* creats a mongo client ur to connect to eclassrooms database */
            MongoClientURI mongoClientURI =
                    new MongoClientURI("mongodb://kaabdull:eclass@ds055680.mongolab.com:55680/eclassroom");
                    /* establish the connection as an actual client now */
            MongoClient mongoClient = new MongoClient(mongoClientURI);
                    /* find the database */
            DB db = mongoClient.getDB("eclassroom");
                    /* connect to the viewer database */
            this.collection = db.getCollection("chats");


        } catch (UnknownHostException e) {
            System.err.println(e);
        }
    }

    public DBCollection getChatCollection() {
        return this.collection;
    }

    public String getAllChats() {
        BasicDBObject whereQuery = new BasicDBObject();
        StringBuilder stringBuilder = new StringBuilder();


        DBCursor cursor = collection.find(whereQuery);
        while( cursor.hasNext() ) {
            try {
                JSONObject json = new JSONObject(cursor.next().toString());
                stringBuilder.append(json.getString("chat") + "\n");
            } catch( JSONException e) {
                System.err.println("JSON error : " + e);
            }
        }

        return stringBuilder.toString();
    }

}
