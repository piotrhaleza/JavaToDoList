package Main.Database;

import Main.Utilities.PropertiesLoader;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class DatabaseHandler {


    //Path to file with database properties format
    private static final String CONFIG_FILE = "config/db_config.properties";

    //Singleton instance
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
                //PropertiesLoader is external utility class created only to load properties from files or streams
                try {
                    Properties properties = PropertiesLoader.loadPropertiesFromFile(CONFIG_FILE);
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

    public Connection getConnection(){
        return connection;
    }


}
