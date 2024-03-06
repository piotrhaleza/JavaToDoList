package Main.Utilities;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

//PH: to raczej powinen byc interfejs bo jak ci sie zachce innaczej kodowac to co nowa metoda raczej bez sensu
//This class is going to be moved to the API later on
public class PasswordHashing {

    final static String HASH_ALGORITHM = "SHA-256";

    /**
     *
     * @param plainText String representation of password which we want to encode
     * @return hashed version of password that should be placed in the database
     */
    public static String hashPassword(String plainText) throws IllegalArgumentException{
        if(plainText == null || plainText.isEmpty() ){
            throw new IllegalArgumentException("Password cannot be empty");
        }

        try {
            // Create a MessageDigest instance with the desired algorithm SHA-256 in that case
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);

            // Update the digest with the bytes of the plain text password
            messageDigest.update(plainText.getBytes());

            // Get the hashed password as a byte array
            byte[] hashedBytes = messageDigest.digest();

            // Convert the byte array to a base64 string
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     *
     * @param plainText String that represents the password that we want to verify with hashed version
     * @param hashedPassword String that represents the hashed version of password that we want to compare the provided plainText
     * @return Boolean value whether those passwords are the same
     */
    public static boolean verifyPassword(String plainText, String hashedPassword){
        if(plainText == null || plainText.isEmpty()) throw new IllegalArgumentException("Password to be verified cannot be empty");
        if(hashedPassword == null || hashedPassword.isEmpty()) throw new IllegalArgumentException("Hashed version of password cannot be empty");

        //Variable for readability
        String hashedInput = hashPassword(plainText);
        return hashedInput.equals(hashedPassword);
    }
}
