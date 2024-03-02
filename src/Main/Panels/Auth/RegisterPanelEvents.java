package Main.Panels.Auth;

import Main.Frames.LoginFrame;
import Main.Utilities.PasswordHashing;
import Main.Utilities.QueryExecutor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.JTextComponent;
import javax.xml.validation.Validator;
import java.awt.*;
import java.util.Arrays;

//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class RegisterPanelEvents implements IBtnEventHandler {

    private final LoginFrame loginFrame;
    private final RegisterPanel registerPanel;

    private JButton submitBtn;
    private InputsValidator inputsValidator;


    RegisterPanelEvents(LoginFrame loginFrame, RegisterPanel registerPanel){
        this.loginFrame = loginFrame;
        this.registerPanel = registerPanel;
        this.submitBtn = registerPanel.getSubmitBtn();



        inputsValidator = new InputsValidator(
                registerPanel.getLoginInput(),
                registerPanel.getPasswordInput(),
                registerPanel.getRepeatPasswordInput()
        );

    }
    @Override
    public void switchView(){
        loginFrame.switchToLoginView();
    }

    @Override
    public void handleSubmit() {
       if(validateInputs()){
           String username = registerPanel.getLoginInput().getText();
           char[] password = registerPanel.getPasswordInput().getPassword();

           //Hash Password in order to insert that to the database, hashing method accepts String.
           String hashedPassword = PasswordHashing.hashPassword(new String(password));

           //Open separate thread for Database operation
           //TODO: Implement SwingWorker as long as code has not been moved to the API, in order to ensure thread safety.
           //TODO: change that into API request
           new Thread(() -> {
               try {
                   QueryExecutor.executeStatement("INSERT INTO Users (Username, Password) VALUES (?,?)", username, hashedPassword);
               } catch (Exception e) {
                   // Handle exceptions appropriately
                   e.printStackTrace();
               }
           }).start();
       }
       else{
           return;
       }
    }

    @Override
    public boolean validateInputs(){
        //If everything is okay, enable the register button option.
        //TODO: Do the same validation in the API backend later on.
        boolean validated = inputsValidator.validate();

        //TODO: Change that into JavaFX property
        submitBtn.setEnabled(validated);
        return validated;
    }



    //Validator class that validates the register form inputs
    private class InputsValidator{

        //TODO: Change hardcoded 255 value into API request for DB metadata
        private final int MAX_INPUT_LENGTH = 255;
        private final int MIN_PASSWORD_LENGTH = 8;
        private Color INVALID_INPUT_COLOR = new Color(250,100,100);
        private Color VALID_INPUT_COLOR = Color.white;
        private JTextField usernameInput;
        private JPasswordField passwordInput;
        private JPasswordField repeatPasswordInput;

        //Eventual placeholders for inputs
        private String usernamePlaceholder;
        private char[] passwordPlaceholder;
        private char[] repeatPasswordPlaceholder;


        /**
         *
         * @param usernameInput First argument has to be usernameInput of register form
         * @param passwordInput Second argument has to be passwordField of register form (do not change the order of password/repeatPassword)
         * @param repeatPasswordInput Third argument has to be repeatPasswordField of register form.
         */
        private InputsValidator(JTextField usernameInput, JPasswordField passwordInput, JPasswordField repeatPasswordInput){
            this.usernameInput = usernameInput;
            this.passwordInput = passwordInput;
            this.repeatPasswordInput = repeatPasswordInput;

            //Set up placeholders
            usernamePlaceholder = usernameInput.getText();
            passwordPlaceholder = passwordInput.getPassword();
            repeatPasswordPlaceholder = repeatPasswordInput.getPassword();
        }
        private boolean validatePassword(){

            char[] passwordValue = passwordInput.getPassword();

            //If value provided is equal to placeholder return immediately false
            if(Arrays.equals(passwordValue, passwordPlaceholder)) return false;

            if(passwordValue.length < MIN_PASSWORD_LENGTH || passwordValue.length > MAX_INPUT_LENGTH){
                if(passwordValue.length != 0){
                    customizeInputAfterValidation(passwordInput, INVALID_INPUT_COLOR);
                }
                return false;
            }
            customizeInputAfterValidation(passwordInput, VALID_INPUT_COLOR);
            return true;
        }

        private boolean validateRepeatPassword(){

            char[] passwordFirst = passwordInput.getPassword();
            char[] passwordSecond = repeatPasswordInput.getPassword();

            //If value provided is equal to placeholder return immediately false
            if(Arrays.equals(passwordSecond, repeatPasswordPlaceholder)) return false;

            //No need to check if passwords matches, if the first one is invalid.
            if(!validatePassword()) return false;

            if(!Arrays.equals(passwordFirst, passwordSecond)) {
                if(passwordSecond.length != 0 ) {
                    customizeInputAfterValidation(repeatPasswordInput, INVALID_INPUT_COLOR);
                }
                return false;
            }

            customizeInputAfterValidation(repeatPasswordInput, VALID_INPUT_COLOR);
            return true;
        }

        private boolean validateUsername(){
            String username = usernameInput.getText();

            //If value provided is equal to placeholder return immediately false
            if(username.equals(usernamePlaceholder)) return false;

            if(username.length() > MAX_INPUT_LENGTH){
                customizeInputAfterValidation(usernameInput, INVALID_INPUT_COLOR);
                return false;
            }

            customizeInputAfterValidation(usernameInput, VALID_INPUT_COLOR);
            return true;
        }

        private void customizeInputAfterValidation(JTextComponent comp, Color color){
          //  comp.setBorder(BorderFactory.createLineBorder(color));
            comp.setBackground(color);
        }

        public boolean validate(){
            return (validatePassword() && validateUsername() && validateRepeatPassword());
        }
    }
}
