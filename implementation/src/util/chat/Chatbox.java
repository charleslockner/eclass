package util.chat;


import com.mongodb.*;

import java.net.UnknownHostException;

/**
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

    public String getOneChat() {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", 1);
        return collection.find(whereQuery).next().toString();
    }

}
