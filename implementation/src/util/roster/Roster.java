package util.roster;

import java.util.Collection;

/**
 * Class implementation of the roster
 */
public abstract class Roster {
   Collection<Viewer> db;

   
   /**
    * Returns the number of active viewers in the roster
    */
   abstract int getNumberOfViewers();
   
   /**
    * Adds a new viewer to the roster
    */
   abstract int addtoRoster(Viewer viewer, int num);

   /**
    * Removes a viewer from the roster
    */
   abstract int removeFromRoster(Viewer viewer, int num);
}
