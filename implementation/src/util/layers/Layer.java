package util.layers;

/**
 * Describes a layer that will be used by the client to draw on and move around.
 * @author charleslockner
 *
 */
public abstract class Layer {
	/**
	 * Renames this layer
	 * @param newName The new name of this layer
	 */
	public abstract void rename(String newName);
	
	/**
	 * Change the opacity of this layer to the selected value between 0 and 1
	 * @param val The value to set the opacity to
	 */
	public abstract void changeOpacity(float val);

	/**
	 * If this layer is publicly visible, makes it private, otherwise makes it public.
	 */
	public abstract void togglePublic();
}
