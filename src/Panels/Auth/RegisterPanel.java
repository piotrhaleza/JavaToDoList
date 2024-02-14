package Panels.Auth;

import Frames.LoginFrame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterPanel extends AbstractAuthPanel{

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;
    private JPasswordField repeatPasswordInput;

    public RegisterPanel(){
        createPanel();
    }

    //Constructor with custom inputs size
    public RegisterPanel(Dimension dimension){
        super(dimension);
        createPanel();
    }

    private void createPanel(){

        this.setLayout(new GridLayout(GRID_LAYOUT_ROWS,GRID_LAYOUT_COLS));

        //Set up buttons
        submitBtn = new JButton("Stwórz konto");


        switchFormBtn = new JButton("Posiadasz już konto? Zaloguj się");
        //Switch the LoginFrame view to login panel
        switchFormBtn.addActionListener(e -> switchView());


        continueAsGuestBtn = new JButton("Kontynuuj jako gość");

        //Order in this ArrayList is important
        ArrayList<JComponent> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createPanel(btnList, new FlowLayout(FlowLayout.CENTER,5,5));

        //Set up inputs
        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        repeatPasswordInput = createPasswordField("Powtórz hasło");

        //Order in this ArrayList is important
        ArrayList<JComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput,repeatPasswordInput));
        inputPanel = createPanel(inputList, new GridLayout(inputList.size(),1));

        //Add created Panels to main AuthPanel
        this.add(inputPanel);
        this.add(buttonsPanel);


    }

    private void switchView(){
        LoginFrame.switchToLoginView();
    }


}
