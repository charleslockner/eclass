package rmi;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

/**
 *
 * This class resembles a chat server that accepts any number of clients.
 * As the clients sign into "localhost", they can talk to other clients.
 *
 * source: https://code.google.com/p/kryonet/
 * @author nathan kaabdull
 *
 */
public class Server {
    private com.esotericsoftware.kryonet.Server server;
    private static int admin = 0;
    private String adminName = "";
    private int adminID = 0;

    /**
     * This creates a server and newConnection returns a ChatConnection.
     * ChatConnection returns a subclass of connection with more information, such as
     * the name of the user signing in.
     *
     * @throws IOException  if can't connect to the port
     */

       /*@
      ensures
         // it also ensures that length and
         messages.length() != 0 && messages != null
         && connection.name.length() !=0 && connection.name != null
         @*/
    public Server() throws IOException {
        server = new com.esotericsoftware.kryonet.Server() {
            protected Connection newConnection () {
                // By providing our own connection implementation, we can store per
                // connection state without a connection ID to state look up.
                return new ChatConnection();
            }
        };

        // For consistency, the classes to be sent over the network are
        // registered by the same method for both the client and server.
        Network.register(server);

        // adds a listener to the server so that when a client signs on
            // the server says, okay I have received you and I need to wrap some things
            // around you before anything happens further

        server.addListener(new Listener() {
            public void received (Connection c, Object object) {
                // We know all connections for this server are actually ChatConnections.
                ChatConnection connection = (ChatConnection)c;

                // if the user is just logging in then fire this
                if (object instanceof Network.RegisterName) {
                    // Ignore the object if a client has already registered a name. This is
                    // impossible with our client, but a hacker could send messages at any time.
                    if (connection.name != null) return;
                    // Ignore the object if the name is invalid.
                    String name = ((Network.RegisterName)object).name;
                    if (name == null) return;
                    name = name.trim();
                    if (name.length() == 0) return;
                    // Store the name on the connection.
                    connection.name = name;

                    // the first person to sign in - will be the designated instructor
                    if( admin == 0) {
                        adminName = name;
                        adminID = connection.getID();
                        admin = 10;
                    }

                    // Send a "connected" message to everyone except the new client.
                    Network.ChatMessage chatMessage = new Network.ChatMessage();
                    chatMessage.text = name + " connected.";
                    server.sendToAllExceptTCP(connection.getID(), chatMessage);
                    // Send everyone a new list of connection names.
                    updateNames();
                    return;
                }

                // if the user is writing a message then fire this
                if (object instanceof Network.ChatMessage) {
                    // Ignore the object if a client tries to chat before registering a name.
                    if (connection.name == null) {
                        return;
                    }
                    Network.ChatMessage chatMessage = (Network.ChatMessage)object;
                    // Ignore the object if the chat message is invalid.
                    String message = chatMessage.text;
                    if (message == null) {
                        return;
                    }
                    message = message.trim();
                    if (message.length() == 0) {
                        return;
                    }

                    // if any client writes @ + the instructors name ( the first client)
                    // then highlight it for the instructor
                    if( message.contains("@"+ adminName + " ")) {
                        Network.ChatMessage chatMessageAdmin = new Network.ChatMessage();
                        chatMessageAdmin.text = "`QinstQ`" + "A student has asked you a question.";
                        server.sendToTCP(adminID, chatMessageAdmin);
                    }




                    // Prepend the connection's name and send to everyone.
                    chatMessage.text = connection.name + ": " + message;
                    server.sendToAllTCP(chatMessage);
                    return;
                }
            }

            public void disconnected (Connection c) {
                ChatConnection connection = (ChatConnection)c;
                if (connection.name != null) {
                    // Announce to every
                    // one that someone (with a registered name) has left.
                    Network.ChatMessage chatMessage = new Network.ChatMessage();
                    chatMessage.text = connection.name + " disconnected.";
                    server.sendToAllTCP(chatMessage);
                    updateNames();
                }
            }
        });
        server.bind(Network.port);
        server.start();

        // Open a window to provide an easy way to stop the server.
        JFrame frame = new JFrame("Chat Server");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosed (WindowEvent evt) {
                server.stop();
            }
        });
        frame.getContentPane().add(new JLabel("Close to stop the chat server."));
        frame.setSize(320, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Whenever a new client is called, this is called on every single client
     * to update who has inserted the classroom.
     */
    void updateNames () {
        // All the clients that have entered the server, the server has kept a track of
        // and the since the connection is an extended collection with names, we can grab it for every client.
        Connection[] connections = server.getConnections();
        ArrayList names = new ArrayList(connections.length);

        // add all the connections to an array
        for (int i = connections.length - 1; i >= 0; i--) {
            ChatConnection connection = (ChatConnection)connections[i];
            names.add(connection.name);
        }
        // Send the names to everyone.
        Network.UpdateNames updateNames = new Network.UpdateNames();
        updateNames.names = (String[])names.toArray(new String[names.size()]);
        server.sendToAllTCP(updateNames);
    }

    /**
     * This holds all the connection information and the name of the client
     */
    static class ChatConnection extends Connection {
        public String name;
    }

    public static void main (String[] args) throws IOException {
        Log.set(Log.LEVEL_DEBUG);
        System.out.println("HMM");
        new Server();
    }
}