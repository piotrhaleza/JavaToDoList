package Main.Database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class DatabaseHandler {

    private static final String CONFIG_FILE = "db_config.properties";
    private static Connection connection;


    //Function that allows only 1 connection to the database
    private static void connect(){
        if(connection == null){
            try {
                //Load JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Read configuration from properties file
                Properties properties = new Properties();
                try (InputStream input = DatabaseHandler.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
                    properties.load(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Establish a connection
                try {
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

    public static void closeConnection(){
        if(connection!=null){
            try {
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
