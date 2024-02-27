package Main.Utilities;

import Main.Database.DatabaseHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

   // public PropertiesLoader(){}

    public static Properties loadPropertiesFromFile(String fileName){
        try(InputStream input = loadStreamFromFile(fileName)) {
            return loadFromInputStream(input);
        }
        catch(IOException e) {
            e.printStackTrace();
            return new Properties();
        }

    }


    //Function created specifically, it would be easier to unit test the whole properties mechanism
    public static Properties loadFromInputStream(InputStream input){
        Properties properties = new Properties();
        try (input) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static InputStream loadStreamFromFile(String fileName){
        return PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName);
    }
}
