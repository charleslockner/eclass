package view.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**This class is for the navigation bar on the bottom 
 * left corner of the presentation view*/
public class NavigationMenu extends JMenu {
	
	private static final long serialVersionUID = 1L;

	public NavigationMenu() {
		super("Navigation");
		JMenuItem previous = new JMenuItem("Previous");
		JMenuItem collapse = new JMenuItem("Collapse");
		JMenuItem presentation = new JMenuItem("Presentation Mode");
		JMenuItem expand = new JMenuItem("Expand");
		JMenuItem next = new JMenuItem("Next");
		
		this.add(previous);
		this.add(collapse);
		this.add(presentation);
		this.add(expand);
		this.add(next);
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousSection();
			}
		});
		
		collapse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				collapse();
			}
		});
		
		presentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presentationView();
			}
		});
		
		expand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expand();
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextSection();
			}
		});
	}
	
   /**the function for the button that brings the user 
    * back one section*/
	public void previousSection() {
		System.out.println("NavigationMenu.previousSection");
	}
  
   /**The function for collapsing the
    * subsection of the slide*/
	public void collapse() {
		System.out.println("NavigationMenu.collapse");
	}
   
   /**The function for going into 
    * presentation/full screen mode*/
	public void presentationView() {
		System.out.println("NavigationMenu.presentationView");
	}
   
   /**The function for expanding a subsection*/
	public void expand() {
		System.out.println("NavigationMenu.expand");
	}
   
   /**The function for moving
    * the user to the next section of
    * the presentation*/
	public void nextSection() {
		System.out.println("NavigationMenu.nextSection");
	}
}
