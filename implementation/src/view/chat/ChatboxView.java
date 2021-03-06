package view.chat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * This class resembles the user interface of the chat box. The user
 *
 * This source was taken from https://code.google.com/p/kryonet
 * with some modifications
 *
 * @author nathan kaabdull
 *
 */
public class ChatboxView extends JFrame {
    CardLayout cardLayout;
    JProgressBar progressBar;
    JList messageList;
    JTextField sendText;
    JButton sendButton;
    JList nameList;

    public ChatboxView(String host) {
        super("Chat Client");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 200);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);
        {
            JPanel panel = new JPanel(new BorderLayout());
            contentPane.add(panel, "progress");
            panel.add(new JLabel("Connecting to " + host + "..."));
            {
                panel.add(progressBar = new JProgressBar(), BorderLayout.SOUTH);
                progressBar.setIndeterminate(true);
            }
        }
        {
            JPanel panel = new JPanel(new BorderLayout());
            contentPane.add(panel, "chat");
            {
                JPanel topPanel = new JPanel(new GridLayout(1, 2));
                panel.add(topPanel);
                {
                    topPanel.add(new JScrollPane(messageList = new JList()));
                    messageList.setCellRenderer(new MyListCellThing());
                    messageList.setModel(new DefaultListModel());
                }
                {
                    topPanel.add(new JScrollPane(nameList = new JList()));
                    nameList.setModel(new DefaultListModel());
                }
                DefaultListSelectionModel disableSelections = new DefaultListSelectionModel() {
                    public void setSelectionInterval (int index0, int index1) {
                    }
                };
                messageList.setSelectionModel(disableSelections);
                nameList.setSelectionModel(disableSelections);

            }
            {
                JPanel bottomPanel = new JPanel(new GridBagLayout());
                panel.add(bottomPanel, BorderLayout.SOUTH);
                bottomPanel.add(sendText = new JTextField(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                bottomPanel.add(sendButton = new JButton("Send"), new GridBagConstraints(1, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER, 0, new Insets(0, 0, 0, 0), 0, 0));
            }
        }


        sendText.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                sendButton.doClick();
            }
        });
    }

    public void setSendListener (final Runnable listener) {
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent evt) {
                if (getSendText().length() == 0) return;
                listener.run();
                sendText.setText("");
                sendText.requestFocus();
            }
        });
    }

    public void setCloseListener (final Runnable listener) {
        addWindowListener(new WindowAdapter() {
            public void windowClosed (WindowEvent evt) {
                listener.run();
            }

            public void windowActivated (WindowEvent evt) {
                sendText.requestFocus();
            }
        });
    }

    public String getSendText () {
        return sendText.getText().trim();
    }

    public void setNames (final String[] names) {
        // This listener is run on the client's update thread, which was started by client.start().
        // We must be careful to only interact with Swing components on the Swing event thread.
        EventQueue.invokeLater(new Runnable() {
            public void run () {
                cardLayout.show(getContentPane(), "chat");
                DefaultListModel model = (DefaultListModel)nameList.getModel();
                model.removeAllElements();
                for (String name : names)
                    model.addElement(name);
            }
        });
    }

    public void addMessage (final String message) {
        EventQueue.invokeLater(new Runnable() {
            public void run () {
                DefaultListModel model = (DefaultListModel)messageList.getModel();
                model.addElement(message);
                messageList.ensureIndexIsVisible(model.size() - 1);
            }
        });
    }

    public class MyListCellThing extends JLabel implements ListCellRenderer {

        ArrayList<Integer> listInt = new ArrayList<Integer>();


        public MyListCellThing() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            // Assumes the stuff in the list has a pretty toString

            String incomingMessage = value.toString();

            if ( incomingMessage.contains("`QinstQ`")) {
                listInt.add(index);
                String actualMSg = incomingMessage.split("`QinstQ`")[1];
                setText(actualMSg);
            } else {
                setText(incomingMessage);
            }

            if (listInt.size() > 0 && listInt.contains(index)) {
                setBackground(Color.ORANGE);
            } else {
                setBackground(Color.WHITE);
            }

            return this;
        }
    }

}