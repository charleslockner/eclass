package view.layers;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;


/**
 *
 * Class the implements a layer viewer.
 *
 * @author oliver
 */
public class LayerView extends JPanel
        implements ActionListener,
        MouseMotionListener {
    private String[] layerStrings = { "Yellow (0)", "Magenta (1)",
            "Cyan (2)",   "Red (3)",
            "Green (4)" };
    private Color[] layerColors = { Color.yellow, Color.magenta,
            Color.cyan,   Color.red,
            Color.green };

    private JLayeredPane layeredPane;
    private JLabel dukeLabel;
    private JCheckBox onTop;
    private JComboBox layerList;
    private JButton addButton;
    private JButton removeButton;

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


        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(500, 500));
        layeredPane.setBorder(BorderFactory.createTitledBorder(
                "Move the Mouse to Move Square"));
        layeredPane.addMouseMotionListener(this);



        //Create and add the Duke label to the layered pane.
        dukeLabel = new JLabel();
        dukeLabel.setBounds(15, 225, 30, 30);
        dukeLabel.setOpaque(true);
        dukeLabel.setBackground(Color.BLACK);

        layeredPane.add(dukeLabel, new Integer(2), 0);

        //Add control pane and layered pane to this JPanel.
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(createControlPanel());
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(layeredPane);
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

    public void addLayer() {
        JLabel label = createColoredLabel(layerStrings[i], layerColors[i], origin);
        layeredPane.add(label, new Integer(i));
        origin.x += offset;
        origin.y += offset;
        i++;
    }

    public void removeLayer() {
        layeredPane.remove(--i);
    }

    //Create the control pane for the top of the frame.
    private JPanel createControlPanel() {
        addButton = new JButton();
        addButton.setText("Add Layer");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addLayer();
            }
        });

        removeButton = new JButton();
        removeButton.setText("Remove Layer");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeLayer();
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
                layeredPane.moveToFront(dukeLabel);
            else
                layeredPane.moveToBack(dukeLabel);

        } else if (LAYER_COMMAND.equals(cmd)) {
            int position = onTop.isSelected() ? 0 : 1;
            layeredPane.setLayer(dukeLabel,
                    layerList.getSelectedIndex(),
                    position);
        }
    }

}
