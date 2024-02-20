package Panels.Auth;

import Frames.LoginFrame;

import javax.swing.*;

//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class RegisterPanelEvents implements IBtnEventHandler{

    private final LoginFrame loginFrame;

    RegisterPanelEvents(LoginFrame frame){
        this.loginFrame = frame;
    }
    public void switchView(){
        loginFrame.switchToLoginView();
    }
}
