package rmi;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

/**
 *
 * Class that resembles the network that the client and server are associated
 * with. The port can be interchangeable and by using the kryo library this
 * project can actual connect on multiple computers on a local network such as
 * 192.168.0.2 or etc...
 *
 * @author Keithmaynn
 *
 */
public class Network {

    static public final int port = 54548;

    /**
     * This registers objects that are going to be sent over the network.
     * This needs to be set up so that kryo serializes these classes in order for
     * anything to be sent over from server to client and vice versa.
     */
    static public void register (EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(RegisterName.class);
        kryo.register(String[].class);
        kryo.register(UpdateNames.class);
        kryo.register(ChatMessage.class);
    }

    /**
     * The class manages when clients are just signing onto the server.
     */
    static public class RegisterName {
        public String name;
    }

    /**
     *  The class that manages when clients are sign off and must update
     *  the name list column.
     */
    static public class UpdateNames {
        public String[] names;
    }

    /**
     *  The class tha manages chat messages being sent across from
     *  client to server to other clients.
     */
    static public class ChatMessage {
        public String text;
    }
}
