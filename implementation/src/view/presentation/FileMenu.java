package view.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**This is the class for the file 
 * button in the top tool-bar*/
public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

/**These are the functions for the 
    * tools in the file drop-down menu*/
	
	public FileMenu() {
		super("File");
		
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem saveAsItem = new JMenuItem("Save as...");
		JMenuItem exportItem = new JMenuItem("Export");
		
		this.add(newItem);
		this.add(openItem);
		this.add(saveItem);
		this.add(saveAsItem);
		this.add(exportItem);
		
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile("");
			}
		});
		
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFileAs("");
			}
		});
		
		exportItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportFileAs("");
			}
		});
	}
	
   /**This is the function that will open 
    * a new file for the user to edit*/
   public void newFile() {
	   System.out.println("FileMenu.newFile");
   }
   
   /**This is the function that will open the 
    * specified file from the user's input*/
   public void openFile(String fileName) {
	   System.out.println("FileMenu.openFile");
   }
   
   /**This is the function that will 
    * save the current file 
    * and overwrite the previously 
    * saved file of the same name*/
   public void saveFile() {
	   System.out.println("FileMenu.saveFile");
   }
   
   /**This is the function that will save the current 
    * working file into the specified file 
    * name from the user input*/
   public void saveFileAs(String fileName) {
	   System.out.println("FileMenu.saveFileAs");
   }
   
   /**This function will export the file as a 
    * presentation under the specified file 
    * name from the user*/
   public void exportFileAs(String fileName) {
	   System.out.println("FileMenu.exportFileAs");
   }
}
