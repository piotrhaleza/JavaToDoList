package Panels.Auth;

import Frames.LoginFrame;

import javax.swing.*;


//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class LoginPanelEvents implements IBtnEventHandler {

    private final LoginFrame loginFrame;

    LoginPanelEvents(LoginFrame frame){
        this.loginFrame = frame;
    }
    public void switchView(){
        loginFrame.switchToRegisterView();
    }
}
