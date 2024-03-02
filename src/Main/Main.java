package Main;

import Main.Frames.LoginFrame;
import Main.Utilities.PasswordHashing;
import Main.Utilities.QueryExecutor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


public class Main {
    public static void main(String[] args) {
        //Creating Main loginFrame instance
        new LoginFrame("Formularz logowania");

    }


}