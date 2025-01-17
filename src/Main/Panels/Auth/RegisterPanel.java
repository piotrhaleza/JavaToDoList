package Main.Panels.Auth;

import Main.Frames.LoginFrame;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterPanel extends AbstractAuthPanel {

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;
    private JPasswordField repeatPasswordInput;
    private boolean submitBtnEnabled = false;



  //  private final LoginFrame loginFrame;

    public RegisterPanel(LoginFrame loginFrame){
        createPanel();

        //Constructor requires the frame on which methods should be executed and instance of RegisterPanel
        eventHandler = new RegisterPanelEvents(loginFrame, this);
       // this.loginFrame=loginFrame;


    }

    //Constructor with custom inputs size
    public RegisterPanel(Dimension dimension, LoginFrame loginFrame){
        super(dimension);
        createPanel();

        //Constructor requires the frame on which methods should be executed, and instance of RegisterPanel
        eventHandler = new RegisterPanelEvents(loginFrame, this);
        //this.loginFrame=loginFrame;

    }

    //Constructor for hypothetical case when someone wanted to use different event handler
    public RegisterPanel(IBtnEventHandler eventHandler){
        this.eventHandler = eventHandler;
        //this.loginFrame=loginFrame;
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
        submitBtn = createBtn("Stwórz konto", e -> eventHandler.handleSubmit());
        submitBtn.setEnabled(submitBtnEnabled);

        //Switch the LoginFrame view to log in panel
        switchFormBtn = createBtn("Posiadasz już konto? Zaloguj się", e -> eventHandler.switchView());


        continueAsGuestBtn = new JButton("Kontynuuj jako gość");

        //Create Panel with buttons from AbstractAuthPanel function
        //ArrayList<JComponent> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));

        return super.createPanel(new FlowLayout(FlowLayout.CENTER,5,5), submitBtn, switchFormBtn, continueAsGuestBtn);
    }
    private JPanel createInputPanel(){
        //Set up inputs
        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło (Minimum 8 znaków)");
        repeatPasswordInput = createPasswordField("Powtórz hasło");
        addEventListenerToInputs(() -> eventHandler.debounceValidateInputs(250), loginInput, passwordInput, repeatPasswordInput);

        //Order in this ArrayList is important
        //Create Panel with inputs from AbstractAuthPanel function
        //ArrayList<JComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput,repeatPasswordInput));

        return super.createPanel(new GridLayout(3,1, 2, 2), loginInput, passwordInput, repeatPasswordInput);
    }

    //Getter created, so it would be easier to validate repeatPasswordInput
    public JPasswordField getRepeatPasswordInput(){
        return repeatPasswordInput;
    }

}
