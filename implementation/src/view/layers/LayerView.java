package view.layers;

import javax.swing.*;

import java.awt.*;

import javax.swing.JButton;

import java.awt.event.*;

import util.layers.*;


/**
 *
 * Class the implements a layer viewer.
 *
 * @author Oliver Xia (wxia@calpoly.edu)
 */
public class LayerView extends JPanel implements ActionListener, MouseMotionListener {
    private String[] layerStrings = { "Yellow (0)", "Magenta (1)",
            "Cyan (2)",   "Red (3)",
            "Green (4)" };
    private Color[] layerColors = { Color.yellow, Color.magenta,
            Color.cyan,   Color.red,
            Color.green };

    private JLabel dukeLabel;
    private JCheckBox onTop;
    private JComboBox layerList;
    private JButton addButton;
    private JButton removeButton;
    private LayerPanel layerFunct;

    //Action commands
    private static String ON_TOP_COMMAND = "ontop";
    private static String LAYER_COMMAND = "layer";

    //Adjustments to put Duke's toe at the cursor's tip.
    private static final int XFUDGE = 40;
    private static final int YFUDGE = 57;

    //This is the origin of the first label added.
    private static Point origin = new Point(10, 20);

    //This is the offset for computing the origin for the next label.
    private static int offset = 35;
    private int i = 0;

    public LayerView()    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.layerFunct = new LayerPanel();

        //Create and set up the layered pane.
        layerFunct.layeredPane = new JLayeredPane();
        layerFunct.layeredPane.setPreferredSize(new Dimension(500, 500));
        layerFunct.layeredPane.setBorder(BorderFactory.createTitledBorder(
                "Move the Mouse to Move Square"));
        layerFunct.layeredPane.addMouseMotionListener(this);



        //Create and add the Duke label to the layered pane.
        dukeLabel = new JLabel();
        dukeLabel.setBounds(15, 225, 30, 30);
        dukeLabel.setOpaque(true);
        dukeLabel.setBackground(Color.BLACK);

        layerFunct.layeredPane.add(dukeLabel, new Integer(2), 0);

        //Add control pane and layered pane to this JPanel.
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(createControlPanel());
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(layerFunct.layeredPane);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LayerView.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    //Create and set up a colored label.
    private JLabel createColoredLabel(String text,
                                      Color color,
                                      Point origin) {
        JLabel label = new JLabel(text);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(origin.x, origin.y, 140, 140);
        return label;
    }

    //Create the control pane for the top of the frame.
    private JPanel createControlPanel() {
        addButton = new JButton();
        addButton.setText("Add Layer");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JLabel label = createColoredLabel(layerStrings[i], layerColors[i], origin);
                layerFunct.addLayer(label, origin, offset, i, layerColors, layerStrings);
            }
        });

        removeButton = new JButton();
        removeButton.setText("Remove Layer");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layerFunct.removeLayer(i);
            }
        });

        onTop = new JCheckBox("Top Position in Layer");
        onTop.setSelected(true);
        onTop.setActionCommand(ON_TOP_COMMAND);
        onTop.addActionListener(this);

        layerList = new JComboBox(layerStrings);
        layerList.setSelectedIndex(2);    //cyan layer
        layerList.setActionCommand(LAYER_COMMAND);
        layerList.addActionListener(this);

        JPanel controls = new JPanel();
        controls.add(layerList);
        controls.add(addButton);
        controls.add(removeButton);
        controls.add(onTop);
        controls.setBorder(BorderFactory.createTitledBorder(
                "Choose Square's Layer and Position"));
        return controls;
    }

    //Make Duke follow the cursor.
    public void mouseMoved(MouseEvent e) {
        dukeLabel.setLocation(e.getX()-XFUDGE, e.getY()-YFUDGE);
    }
    public void mouseDragged(MouseEvent e) {} //do nothing

    //Handle user interaction with the check box and combo box.
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (ON_TOP_COMMAND.equals(cmd)) {
            if (onTop.isSelected())
            	layerFunct.layeredPane.moveToFront(dukeLabel);
            else
            	layerFunct.layeredPane.moveToBack(dukeLabel);

        } else if (LAYER_COMMAND.equals(cmd)) {
            int position = onTop.isSelected() ? 0 : 1;
            layerFunct.layeredPane.setLayer(dukeLabel,
                    layerList.getSelectedIndex(),
                    position);
        }
    }

}
