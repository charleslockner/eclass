package util.layers;

import java.util.Collection;

/**
 * This class will represent the GUI Layer Panel. Layer panel contains 
 * a collection of layers. Methods of this class will perform
 * operations on this collection to reflect which layers
 * are currently in existance.
 * @author Charles Lockner (clockner@calpoly.edu)
 *
 */
public abstract class LayerPanel {
	Collection<Layer> layers;
	
	/**
	 * Create a new layer that will be viewable in this panel.
	 * Place it at index 0 of the layers collection.
	 * @param layer The layer to be added
	 */
	public abstract void newLayer(Layer layer);
	
	/**
	 * Delete the specified layer.
	 * @param layer The layer to be deleted
	 */
	public abstract void deleteLayer(Layer layer);
	
	/**
	 * Move the specified layer from the specified index to the other
	 * specified index in the layers collection.
	 * @param from The index of the selected layer
	 * @param to The index the layer will be moved to
	 */
	public abstract void moveLayer(Layer layer, int from, int to);
}

