package view.roster;

import javax.swing.*;
import java.awt.*;

public class RosterView extends JPanel {

    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
            { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
    Object columnNames[] = { "Column One", "Column Two", "Column Three" };

    public RosterView (){
          setUpTable();
    }

    public void setUpTable() {

        JTable tables = new JTable(rowData, columnNames);
        setLayout(new BorderLayout());
        add(tables);

        setPreferredSize(new Dimension(250, 250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Roster"),
                BorderFactory.createEmptyBorder(5,5,5,5)));

    }




}
