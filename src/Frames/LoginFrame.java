package Frames;


import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Inputs.InputWithPlaceholder;


public class LoginFrame extends AbstractFrame {

    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    private JPasswordField repeatPasswordInput;
    private JButton submitBtn;
    private JButton switchFormBtn;
    private JButton continueAsGuestBtn;

    private JLabel Header;

    private final Dimension dimension = new Dimension(250,40);


    public LoginFrame(String title){
        super(title);
        CardLayout cl = new CardLayout();

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(cl);
        containerPanel.add(createLoginPanel(), "LoginPanel");
        containerPanel.add(createRegisterPanel(), "RegisterPanel");
        cl.show(containerPanel, "LoginPanel");

//        submitBtn = new JButton("Zaloguj się");
//
//
//        showRegisterBtn = new JButton("Zarejestruj się");
//
//        continueAsGuestBtn = new JButton("Kontynuuj jako gość");


        //Panels
//        inputPanel = new JPanel();
//        inputPanel.setLayout(new GridLayout(2,1,0,2));
//
//        buttonsPanel = new JPanel();
//        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//        buttonsPanel.setPreferredSize(new Dimension(250,70));

        //Inputs setup


        //Buttons setup


        //Add elements to panels
       // inputPanel.add(loginInput);
       // inputPanel.add(passwordInput);

       // buttonsPanel.add(submitBtn);
        //buttonsPanel.add(showRegisterBtn);
       // buttonsPanel.add(continueAsGuestBtn);

        //Set up the frame
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(containerPanel);
        //this.add(inputPanel);
       // this.add(buttonsPanel);
       // this.add(submitBtn);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // Center the frame on the screen

        this.pack();



    }
//    private void initializeRepeatingComponents(){
////        submitBtn = new JButton("Zaloguj się");
////        switchFormBtn = new JButton("Zarejestruj się");
//
//        continueAsGuestBtn = new JButton("Kontynuuj jako gość");
//        loginInput = createInputField("Login");
//        passwordInput = createPasswordField("Hasło");
//
//
//    }
    private JTextField createTextField(String placeholder) {
        JTextField inputField = InputWithPlaceholder.createTextFieldInput(placeholder);
        customizeInputField(inputField);
        return inputField;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField passwordField = InputWithPlaceholder.createPasswordFieldInput(placeholder);
        customizeInputField(passwordField);
        return passwordField;
    }
    private void customizeInputField(JTextField field) {
        field.setPreferredSize(dimension);
        field.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private JPanel createBtnPanel (ArrayList<JButton> list){
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for(JButton btn : list){
            btnPanel.add(btn);
        }
        return btnPanel;
    }
    private JPanel createInputPanel (ArrayList<JTextComponent> list){
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(list.size(),1));
        for(JTextComponent input : list){
            inputPanel.add(input);
        }
        return inputPanel;
    }
    private JPanel createLoginPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2,1));

        submitBtn = new JButton("Zaloguj się");
        switchFormBtn = new JButton("Zarejestruj się");
        continueAsGuestBtn = new JButton("Kontynuuj jako gość");
        ArrayList<JButton> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createBtnPanel(btnList);

        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        ArrayList<JTextComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput));
        inputPanel = createInputPanel(inputList);

        loginPanel.add(inputPanel);
        loginPanel.add(buttonsPanel);


        return loginPanel;
    }

    private JPanel createRegisterPanel(){
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(2,1));

        submitBtn = new JButton("Stwórz konto");
        switchFormBtn = new JButton("Posiadasz już konto? Zaloguj się");
        continueAsGuestBtn = new JButton("Kontynuuj jako gość");
        ArrayList<JButton> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createBtnPanel(btnList);

        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        repeatPasswordInput = createPasswordField("Powtórz hasło");
        ArrayList<JTextComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput,repeatPasswordInput));
        inputPanel = createInputPanel(inputList);

        registerPanel.add(inputPanel);
        registerPanel.add(buttonsPanel);

        return registerPanel;
    }
}
