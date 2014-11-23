package view.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**This is the class for the edit 
 * button in the top tool-bar*/
public class EditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public EditMenu() {
		super("Edit");
		JMenuItem undoItem = new JMenuItem("Undo");
		JMenuItem redoItem = new JMenuItem("Redo");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");
		JMenuItem cutItem = new JMenuItem("Cut");
		JMenuItem sourceItem = new JMenuItem("Source Toggle");
		
		this.add(undoItem);
		this.add(redoItem);
		this.add(copyItem);
		this.add(pasteItem);
		this.add(cutItem);
		this.add(sourceItem);
		
		undoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		
		redoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redo();
			}
		});
		
		copyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy("");
			}
		});
		
		pasteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paste("");
			}
		});
		
		cutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cut("");
			}
		});
		
		sourceItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sourceFile();
			}
		});
	}

   /**These are the functions for the 
    * tools in the edit drop-down menu*/
	
   /**This is the function that will 
    * undo the user's most recent edit*/
	public void undo() {
		System.out.println("EditMenu.undo");
	}
   
   /**This is the function that will re-do any 
    * changes the user recently discarded */
	public void redo() {
		System.out.println("EditMenu.redo");
	}
   
   /**This is the function that will copy 
    * any content that is highlighted*/
	public void copy(String toCopy) {
		System.out.println("EditMenu.copy");
	}
   
   /**This is the function that will paste 
    * the copied content to the current location*/
	public void paste(String toPaste) {
		System.out.println("EditMenu.paste");
	}
   
   /**This is the function that will 
    * cut the highlighted content*/
	public void cut(String toCut) {
		System.out.println("EditMenu.cut");
	}
   
   /**This is the function that will allow 
    * the user to look at the source file*/
	public void sourceFile() {
		System.out.println("EditMenu.sourceFile");
	}
}