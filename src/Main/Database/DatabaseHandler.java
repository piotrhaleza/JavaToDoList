package Main.Database;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class DatabaseHandler {

    private static final String CONFIG_FILE = "db_config.properties";
    private static DatabaseHandler instance;
    private Connection connection;




    private DatabaseHandler(){
        //Default private constructor that prevents external class initialization
    }
    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    //Function that allows only 1 connection to the database
    public void connect(){
            try {
                //Load JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Read configuration from properties file

                // Establish a connection
                try {
                    Properties properties = loadProperties();
                    connection = DriverManager.getConnection(
                            properties.getProperty("db.url"),
                            properties.getProperty("db.username"),
                            properties.getProperty("db.password")
                    );
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }

    }

//    public static ResultSet queryBuilder(String s){
//        connect();
//        ResultSet resultSet = null;
//        try{
//            Statement statement = connection.createStatement();
//            resultSet = statement.executeQuery(s);
//            connection.close();
//        }catch(SQLException e){ e.printStackTrace();}
//
//        return resultSet;
//    }

    public void closeConnection(){
        if(connection!=null){
            try {
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    // Create properties for database connection
    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getInput()) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    //Get configuration files as stream
    private InputStream getInput(){
        return DatabaseHandler.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
    }
}
