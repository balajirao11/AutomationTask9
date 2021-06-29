package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {
 
 private static FileReaderManager fileReaderManager = new FileReaderManager();
 private static ConfigFileReader configFileReader;
 
 private FileReaderManager() {
 }
 
 public static FileReaderManager getInstance( ) {
       return fileReaderManager;
 }
 
 //getConfigReader() method returns the instance of the ConfigFileReader but this method is not static. 
 //So that client has to use the getInstance() method to access other public methods of the FileReaderManager 
 //like FileReaderManager.getInstance().getConfigReader()

 public ConfigFileReader getConfigReader() {
 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
 }
}