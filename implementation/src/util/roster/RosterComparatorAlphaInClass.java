package util.roster;

import java.io.Serializable;
import java.util.Comparator;

/**
 * This class will sort by priority - who is in class and their last name.
 *
 * @author kaabdull
 *
 */
public class RosterComparatorAlphaInClass implements Comparator<Viewer>, Serializable
{
    @Override
    public int compare(Viewer x, Viewer y)
    {

        if( (x.getCurrentlyInClass().equals("true")
                && y.getCurrentlyInClass().equals("true")) ||
                (x.getLastName().equals("false") && y.getLastName().equals("false")) )
        {
            return x.getLastName().compareTo(y.getLastName());
        }
        else if (x.getCurrentlyInClass().equals("true") &&
                y.getCurrentlyInClass().equals("false")) {
            return 1;
        } else {
            return -1;
        }
    }
}

