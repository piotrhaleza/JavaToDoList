package Main.Panels.Auth;

import Main.Frames.LoginFrame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterPanel extends AbstractAuthPanel {

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;
    private JPasswordField repeatPasswordInput;

    private IBtnEventHandler eventHandler;

    private final LoginFrame loginFrame;

    public RegisterPanel(LoginFrame loginFrame){

        //Constructor requires the frame on which methods should be executed
        eventHandler = new RegisterPanelEvents(loginFrame);
        this.loginFrame=loginFrame;
        createPanel();

    }

    //Constructor with custom inputs size
    public RegisterPanel(Dimension dimension, LoginFrame loginFrame){
        super(dimension);
        this.loginFrame=loginFrame;
        createPanel();
    }

    //Constructor for hypothetical case when someone wanted to use different event handler
    public RegisterPanel(IBtnEventHandler eventHandler, LoginFrame loginFrame){
        this.eventHandler = eventHandler;
        this.loginFrame=loginFrame;
    }
    private void createPanel(){

        //UI creation logic
        this.setLayout(new GridLayout(GRID_LAYOUT_ROWS,GRID_LAYOUT_COLS));
        //Add created Panels to main AuthPanel
        this.add(createInputPanel());
        this.add(createBtnPanel());


    }

    private JPanel createBtnPanel(){
        //Create Panel with inputs from AbstractAuthPanel function
        submitBtn = new JButton("Stwórz konto");


        switchFormBtn = new JButton("Posiadasz już konto? Zaloguj się");
        //Switch the LoginFrame view to login panel
        switchFormBtn.addActionListener(e -> eventHandler.switchView());


        continueAsGuestBtn = new JButton("Kontynuuj jako gość");

        //Create Panel with buttons from AbstractAuthPanel function
        ArrayList<JComponent> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));

        return createPanel(btnList, new FlowLayout(FlowLayout.CENTER,5,5));
    }
    private JPanel createInputPanel(){
        //Set up inputs
        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        repeatPasswordInput = createPasswordField("Powtórz hasło");

        //Order in this ArrayList is important
        //Create Panel with inputs from AbstractAuthPanel function
        ArrayList<JComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput,repeatPasswordInput));

        return createPanel(inputList, new GridLayout(inputList.size(),1));
    }

}
