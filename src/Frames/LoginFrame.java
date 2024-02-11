package Frames;


import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Inputs.InputWithPlaceholder;


public class LoginFrame extends AbstractFrame {

    // Creates frame with specific title
    private JTextField loginInput;
    private JPasswordField passwordInput;

    public LoginFrame(String title){
        super(title);
        final Dimension dimension = new Dimension(300,40);


        loginInput =  InputWithPlaceholder.createTextFieldInput("Login").getInputComponent();



        loginInput.setPreferredSize(dimension);
        loginInput.setHorizontalAlignment(SwingConstants.CENTER);


        passwordInput = InputWithPlaceholder.createPasswordFieldInput("Hasło").getInputComponent();
        passwordInput.setSize(dimension);
        passwordInput.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new GridLayout(3,1));
        this.add(loginInput);
        this.add(passwordInput);
        // Sets the size of frame to its elements
        this.pack();
    }
}
