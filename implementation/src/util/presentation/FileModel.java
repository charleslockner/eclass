package util.presentation;

/**
 * This class is responsible for handling functions related to the file menu
 * @author Charles Lockner (clockner@calpoly.edu)
 */
public abstract class FileModel {
   
   /**
    * This is the corresponding function for newFile.
    * */
   abstract void modelNewFile();
	   
   /**
   * This is the corresponding function for openFile.
   * */
   abstract void modelOpenFile(String fileName);
   
   /**
   * This is the corresponding function for saveFile.
   * */
   abstract void modelSaveFile();
   
   /**
    * This is the corresponding function for saveFileAs.
    * */
   abstract void modelSaveFileAs(String fileName);
   
   /**
    * This is the corresponding function for exportFileAs.
    * */
   abstract void modelExportFileAs(String fileName);
   
}
