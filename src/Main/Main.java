package Main;

import Main.Database.DatabaseHandler;
import Main.Frames.LoginFrame;
import Main.Utilities.queryExecutor;

import javax.xml.crypto.Data;


public class Main {
    public static void main(String[] args) {
        //Creating Main loginFrame instance
        new LoginFrame("Formularz logowania");

        String sql = "INSERT INTO test (ID) Values (?)";
        Object[] values = {2137};
        queryExecutor.executeStatement(sql, values);

    }


}