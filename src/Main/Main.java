package Main;

import Main.Database.DatabaseHandler;
import Main.Frames.LoginFrame;

import javax.xml.crypto.Data;


public class Main {
    public static void main(String[] args) {
        //Creating Main loginFrame instance
        new LoginFrame("Formularz logowania");
        DatabaseHandler handler = DatabaseHandler.getInstance();
        handler.connect();
       // handler.closeConnection();
    }


}