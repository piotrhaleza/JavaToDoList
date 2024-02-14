package Panels.Auth;

import Frames.LoginFrame;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginPanel extends AbstractAuthPanel{

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;

    public LoginPanel(){
        createPanel();
    }

    //Constructor with custom inputs size
    public LoginPanel(Dimension dimension){
        super(dimension);
        createPanel();
    }

    private void createPanel(){

        this.setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));

        submitBtn = new JButton("Zaloguj się");

        switchFormBtn = new JButton("Zarejestruj się");
        //Switch the LoginFrame view to register panel
        switchFormBtn.addActionListener(e -> switchView());

        continueAsGuestBtn = new JButton("Kontynuuj jako gość");
        ArrayList<JComponent> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createPanel(btnList, new FlowLayout(FlowLayout.CENTER,5,5));

        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        ArrayList<JComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput));
        inputPanel = createPanel(inputList, new GridLayout(inputList.size(),1));



        this.add(inputPanel);
        this.add(buttonsPanel);
    }

    private void switchView(){
        LoginFrame.switchToRegisterView();
    }
}
