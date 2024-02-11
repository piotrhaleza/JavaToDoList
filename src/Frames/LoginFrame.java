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

    //Add dynamic placeholder to input
//    private void addPlaceholder(String placeholder, JTextComponent component){
//        final boolean[] inputChanged = {false};
//        //Check for the null exception
//        if(component==null){
//            throw new IllegalArgumentException("inputComponent cannot be null");
//        }
////        this.inputComponent = inputComponent;
////        this.inputChanged = false;
//
//        component.setText(placeholder);
//
//        //Sets text to be visible if input type is Password
//         setPasswordMask((char) 0, component);
//
//        // Set listener to detect if user changed the input manually
//        component.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                inputChanged[0] =true;
//            }
//        });
//
//
//        component.addFocusListener(new FocusListener() {
//            //If input is focused and user didn't change anything the placeholder would disappear
//            @Override
//            public void focusGained(FocusEvent e) {
//                if(!inputChanged[0] && component.getText().equals(placeholder)){
//                    component.setText("");
//
//                    //Sets text to be masked if input type is Password
//                     setPasswordMask('\u2022', component);
//                }
//            }
//
//            //If input loses focus, and it is empty, placeholder comes back and inputChanged resets.
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(component.getText().isEmpty()){
//                    inputChanged[0] = false;
//                    component.setText(placeholder);
//
//                    //Sets text to be visible if input type is Password
//                    setPasswordMask((char) 0, component);
//                }
//            }
//        });
//
//
//
//    }
//
//    private void setPasswordMask(char echoChar, JTextComponent component) {
//        if (component instanceof JPasswordField) {
//            ((JPasswordField) component).setEchoChar(echoChar);
//       }
//    }
}
