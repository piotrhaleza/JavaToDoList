package Main.Panels.Auth;

import Main.Frames.LoginFrame;
import Main.Utilities.QueryExecutor;

import javax.swing.*;


//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class LoginPanelEvents implements IBtnEventHandler {

    private final int MAX_INPUT_LENGTH = 255;

    private final LoginFrame loginFrame;
    private final LoginPanel loginPanel;
    private JButton submitBtn;
    private final String username;
    private final char[] password;

    LoginPanelEvents(LoginFrame loginFrame, LoginPanel loginPanel){
        this.loginFrame = loginFrame;
        this.loginPanel = loginPanel;

        this.submitBtn = loginPanel.getSubmitBtn();
        this.username = loginPanel.getLoginInput().getText();
        this.password = loginPanel.getPasswordInput().getPassword();
    }
    @Override
    public void switchView(){
        loginFrame.switchToRegisterView();
    }

    @Override
    public void handleSubmit() {
        if(validateInputs()){
            //TODO: Send API request to authenticate the user, and put that into User class
        }
    }

    @Override
    public boolean validateInputs() {
        return username.length() <= MAX_INPUT_LENGTH && password.length <= MAX_INPUT_LENGTH;
    }
    @Override
    public void debounceValidateInputs(int time){
        return;
    }


}
