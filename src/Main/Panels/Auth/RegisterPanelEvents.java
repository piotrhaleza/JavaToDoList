package Main.Panels.Auth;

import Main.Frames.LoginFrame;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.util.Arrays;

//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class RegisterPanelEvents implements IBtnEventHandler {

    private final LoginFrame loginFrame;
    private final RegisterPanel registerPanel;


    RegisterPanelEvents(LoginFrame loginFrame, RegisterPanel registerPanel){
        this.loginFrame = loginFrame;
        this.registerPanel = registerPanel;
    }
    public void switchView(){
        loginFrame.switchToLoginView();
    }


    //Validator class that validates the register form inputs
    private class InputsValidator{
        private JTextField usernameInput;
        private JPasswordField passwordInput;
        private JPasswordField repeatPasswordInput;

        /**
         *
         * @param usernameInput First argument has to be usernameInput of register form
         * @param passwordInput Second argument has to be passwordField of register form (do not change the order of password/repeatPassword)
         * @param repeatPasswordInput Third argument has to be repeatPasswordField of register form.
         */
        InputsValidator(JTextField usernameInput, JPasswordField passwordInput, JPasswordField repeatPasswordInput){
            this.usernameInput = usernameInput;
            this.passwordInput = passwordInput;
            this.repeatPasswordInput = repeatPasswordInput;
        }
        private boolean validatePassword(){
            char[] passwordValue = passwordInput.getPassword();

            if(passwordValue.length < 8){
                if(passwordValue.length != 0){
                    // TODO: Add passwordField appearance change on invalid password length
                }
                return false;
            }
            return true;
        }

        private boolean validateRepeatPassword(){
            char[] passwordFirst = passwordInput.getPassword();
            char[] passwordSecond = repeatPasswordInput.getPassword();

            if(!Arrays.equals(passwordFirst, passwordSecond)) {
                if(passwordSecond.length != 0 ) {
                    // TODO: Add repeatPasswordField appearance change on invalid password length
                }
                return false;
            }
            return true;
        }

//        private boolean validateUsername(String username){
//
//        }

        public boolean validate(){
            return (validatePassword() && validateRepeatPassword());
        }
    }
}
