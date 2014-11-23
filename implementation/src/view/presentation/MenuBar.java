package view.presentation;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		super();
		FileMenu file = new FileMenu();
		EditMenu edit = new EditMenu();
		ToolsMenu tools = new ToolsMenu();
		NavigationMenu nav = new NavigationMenu();
		
		this.add(file);
		this.add(edit);
		this.add(tools);
		this.add(nav);
	}
}
