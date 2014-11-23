package view.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**This is the class for the tools 
 * button in the top tool-bar*/
public class ToolsMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	public ToolsMenu() {
		super("Tools");
		JMenuItem roster = new JMenuItem("launchRoster");
		JMenuItem layer = new JMenuItem("launchLayer");
		JMenuItem drawing = new JMenuItem("launchDrawing");
		JMenuItem chat = new JMenuItem("launchChat");
		JMenuItem toolbox = new JMenuItem("launchToolbox");
		JMenuItem slideControl = new JMenuItem("Slide Control Panel");
		
		this.add(roster);
		this.add(layer);
		this.add(drawing);
		this.add(chat);
		this.add(toolbox);
		this.add(slideControl);
		
		roster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchRoster();
			}
		});
		
		layer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchLayerPanel();
			}
		});
		
		drawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchDrawingPanel();
			}
		});
		
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchChatPanel();
			}
		});
		
		toolbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchToolbox();
			}
		});
		
		slideControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchSlideControlPanel();
			}
		});
	}
	
   /**These functions are for the tools
    * in the tools drop-down menu*/
	
	/**This is the function that will launch
    * the Roster panel into view*/
	public void launchRoster() {
		System.out.println("ToolsMenu.launchRoster");
	}
   
   /**This is the function that will 
    * launch the layer panel into view*/
	public void launchLayerPanel() {
		System.out.println("ToolsMenu.launchLayerPanel");
	}
   
   /**This is the function that will 
    * launch the drawing panel into view*/
	public void launchDrawingPanel() {
		System.out.println("ToolsMenu.launchDrawingPanel");
	}
   
   /**This is the function that will 
    * launch the chat panel into view*/
	public void launchChatPanel() {
		System.out.println("ToolsMenu.launchChatPanel");
	}
   
   /**This is the function that will 
    * launch the tool-box into view*/
	public void launchToolbox() {
		System.out.println("ToolsMenu.launchToolbox");
	}
   
   /**This is the function that will 
    * launch the navigation menu into view*/
	public void launchSlideControlPanel() {
		System.out.println("ToolsMenu.launchSlideControlPanel");
	}
}
