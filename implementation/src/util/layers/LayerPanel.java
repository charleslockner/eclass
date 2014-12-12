package util.layers;

import java.util.Collection;

import view.layers.LayerView;

import javax.swing.*;

import java.awt.*;

import javax.swing.JButton;

import java.awt.event.*;

/**
 * This class will represent the GUI Layer Panel. Layer panel contains 
 * a collection of layers. Methods of this class will perform
 * operations on this collection to reflect which layers
 * are currently in existance.
 * @author Charles Lockner (clockner@calpoly.edu), Oliver Xia (wxia@calpoly.edu)
 *
 */
public class LayerPanel {
	public JLayeredPane layeredPane;
	
	
	public void LayerPanel() {
		this.layeredPane = new JLayeredPane();
	}
	/**
	 * Create a new layer that will be viewable in this panel.
	 * Place it at index 0 of the layers collection.
	 * @param layer The layer to be added
	 */
    public int addLayer(JLabel label, Point origin, int offset, int i, Color[] layerColors, String[] layerStrings) {
        layeredPane.add(label, new Integer(i));
        origin.x += offset;
        origin.y += offset;
        i++;
        return layeredPane.getPosition(label);
    }
	
	/**
	 * Delete the specified layer.
	 * @param layer The layer to be deleted
	 */
    public void removeLayer(int i) {
        layeredPane.remove(--i);
    }
}

