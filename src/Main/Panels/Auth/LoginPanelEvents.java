package Main.Panels.Auth;

import Main.Frames.LoginFrame;


//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class LoginPanelEvents implements IBtnEventHandler {

    private final LoginFrame loginFrame;
    private final LoginPanel loginPanel;

    LoginPanelEvents(LoginFrame loginFrame, LoginPanel loginPanel){
        this.loginFrame = loginFrame;
        this.loginPanel = loginPanel;
    }
    public void switchView(){
        loginFrame.switchToRegisterView();
    }
}
