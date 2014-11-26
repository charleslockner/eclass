package view.chat;

import com.mongodb.BasicDBObject;
import util.chat.Chatbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * This class creates the view for the chat box.
 *
 */
public class ChatboxView extends JPanel {

    private JEditorPane convoPane;
    private JScrollPane convoScrollPane;
    private JTextArea textArea;
    private JButton submitButton;
    private Chatbox chatbox = new Chatbox();

    /**
     * Constructor for the chatbox view.
     * Inside of it we just set the entirity of the view up.
     */
    public ChatboxView() {
        setupChatboxView();
    }

    /**
     *
     * Set up the chat box view
     *   - set up timer action lister to resemble pulling
     *   - then update it is an ajax
     *
     */
    public void setupChatboxView() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /* this is where you will see the conversation occur */
        this.convoPane = new JEditorPane();
        convoPane.setEnabled(false);
        this.convoScrollPane = new JScrollPane(convoPane);

        //action listener

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convoPane.setText(chatbox.getAllChats());
            }
        };

        Timer timer = new Timer(2000, actionListener);
        timer.start();

        //

        // THIS IS WHERE YOU CAN WRITE A CHAT RESPONSE
        this.textArea = new JTextArea("Write to the chat...", 5, 10);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // button to click to submit your response
        this.submitButton = new JButton();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BasicDBObject document = new BasicDBObject();
                document.put("date", new Date());
                document.put("chat", textArea.getText());
                chatbox.getChatCollection().insert(document);
                // when button is clicked, erase the text
                convoPane.setText("");
            }
        });


        /* sets preferred size for all JComponents */
        convoScrollPane.setPreferredSize(new Dimension(250, 200));
        textArea.setPreferredSize(new Dimension(250, 200));
        submitButton.setPreferredSize(new Dimension(10, 20));

        /* sets minimum size for all the JComponents */
        convoScrollPane.setMinimumSize(new Dimension(250, 100));
        textArea.setMinimumSize(new Dimension(250, 100));
        submitButton.setMinimumSize(new Dimension(10, 20));



        /* do single edits on convo panel */
        convoScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        convoScrollPane.setMinimumSize(new Dimension(10, 10));

        /* do single edits on text area */
        textArea.setLineWrap(true);


        /* do single edits on the button */
        submitButton.setText("submit chat");

        /* set the border of the chat box */
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Chatbox"),
                BorderFactory.createEmptyBorder(5,5,5,5)));


        /* add all the sub components we've been adding into ONE chat box view */
        add(convoScrollPane);
        add(scrollPane);
        add(submitButton);


    }


}
