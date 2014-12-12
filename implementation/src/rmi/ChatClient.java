package rmi;


import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JOptionPane;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import rmi.Network.ChatMessage;
import rmi.Network.RegisterName;
import rmi.Network.RosterUpdate;
import rmi.Network.UpdateNames;
import com.esotericsoftware.minlog.Log;
import view.MainViewCreator;
import view.chat.ChatboxView;


/**
 *
 * This class resembles a client in a chat service box. When users launch the program
 * they are added to the server, and the server attaches itself to the client to mutate
 * upon them.
 *
 * source taken from : https://code.google.com/p/kryonet/source
 * with modifications
 *
 * @author nathan kaabdull
 *
 */
public class ChatClient {
    ChatboxView chatboxView;
    Client client;
    String name;

    public ChatClient () {
        client = new Client();
        client.start();

        // For consistency, the classes to be sent over the network are
        // registered by the same method for both the client and server.
        Network.register(client);

        client.addListener(new Listener() {
            public void connected (Connection connection) {
                RegisterName registerName = new RegisterName();
                registerName.name = name;
                client.sendTCP(registerName);
            }

            // this is the data the is being sent FROM THE SERVER to THE CLIENT
                // : message
                // : new_User_SignIn
            public void received (Connection connection, Object object) {
                if (object instanceof UpdateNames) {
                    UpdateNames updateNames = (UpdateNames)object;
                    chatboxView.setNames(updateNames.names);
                    return;
                }

                if (object instanceof ChatMessage) {
                    ChatMessage chatMessage = (ChatMessage)object;
                    chatboxView.addMessage(chatMessage.text);
                    return;
                }

                if (object instanceof RosterUpdate) {
                    //ChatMessage chatMessage = (ChatMessage)object;
                    //chatboxView.addMessage(chatMessage.text);
                    return;
                }
            }

            public void disconnected (Connection connection) {
                EventQueue.invokeLater(new Runnable() {
                    public void run () {
                        // Closing the frame calls the close listener which will stop the client's update thread.
                        chatboxView.dispose();
                    }
                });
            }
        });

        final String host = "localhost";
        // Request the user's name.
        String input = (String)JOptionPane.showInputDialog(null, "Name:", "Connect to chat server", JOptionPane.QUESTION_MESSAGE, null,
                null, "Your Name");
        if (input == null || input.trim().length() == 0) System.exit(1);
        name = input.trim();

        // All the ugly Swing stuff is hidden in ChatFrame so it doesn't clutter the KryoNet example code.
        chatboxView = new ChatboxView(host);
        // This listener is called when the send button is clicked.
        chatboxView.setSendListener(new Runnable() {
            public void run () {
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.text = chatboxView.getSendText();
                client.sendTCP(chatMessage);
            }
        });
        // This listener is called when the chat window is closed.
        chatboxView.setCloseListener(new Runnable() {
            public void run () {
                client.stop();
            }
        });


        chatboxView.setLocation(1000,100);
        chatboxView.setVisible(true);

        // We'll do the connect on a new thread so the ChatFrame can show a progress bar.
        // Connecting to localhost is usually so fast you won't see the progress bar.
        new Thread("Connect") {
            public void run () {
                try {
                    client.connect(5000, host, Network.port);
                    // Server communication after connection can go here, or in Listener#connected().
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    /**
     *
     * Main point in the client program the starts up the client.
     * This also creates the main GUI for the user to manipulate
     * the electric classroom.
     *
     * @param args n\a
     */
    public static void main (String[] args) {
        new ChatClient();
        new MainViewCreator().createAndShowGUI();
    }
}