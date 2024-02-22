package Main.Panels.Auth;

import Main.Frames.LoginFrame;


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
