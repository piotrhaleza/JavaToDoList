package Panels.Auth;

import Frames.LoginFrame;

//*Class created only to provide implementations for BtnHandlers on AuthPanel*/
public class RegisterPanelEvents implements IBtnEventHandler{
    public void switchView(){
        LoginFrame.switchToLoginView();
    }
}
