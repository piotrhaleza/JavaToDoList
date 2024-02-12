package Frames;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inputs.InputWithPlaceholder;


public class LoginFrame extends AbstractFrame {

    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    private JButton submitBtn;
    private JButton showRegisterBtn;
    private JButton continueAsGuestBtn;

    private JLabel Header;

    private final Dimension dimension = new Dimension(250,40);


    public LoginFrame(String title){
        super(title);

        submitBtn = new JButton("Zaloguj się");


        showRegisterBtn = new JButton("Zarejestruj się");

        continueAsGuestBtn = new JButton("Kontynuuj jako gość");


        //Panels
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,1,0,2));

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonsPanel.setPreferredSize(new Dimension(250,70));

        //Inputs setup
        loginInput =  InputWithPlaceholder.createTextFieldInput("Login");
        loginInput.setPreferredSize(dimension);
        loginInput.setHorizontalAlignment(SwingConstants.CENTER);


        passwordInput = InputWithPlaceholder.createPasswordFieldInput("Hasło");
        passwordInput.setPreferredSize(dimension);
        passwordInput.setHorizontalAlignment(SwingConstants.CENTER);

        //Buttons setup


        //Add elements to panels
        inputPanel.add(loginInput);
        inputPanel.add(passwordInput);

        buttonsPanel.add(submitBtn);
        buttonsPanel.add(showRegisterBtn);
        buttonsPanel.add(continueAsGuestBtn);

        //Set up the frame
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(inputPanel);
        this.add(buttonsPanel);
       // this.add(submitBtn);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // Center the frame on the screen

        this.pack();



    }
}
