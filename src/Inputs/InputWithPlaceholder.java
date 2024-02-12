package Inputs;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//CustomInput class gives the ability to create JTextComponents and inherited with dynamic placeholders.
//Constructor accepts argument as Parent Class -> JTextComponent and then its
public class InputWithPlaceholder<T extends JTextComponent>{

    private static final char DEFAULT_ECHO_CHAR = (char) 0;
    private static final char PASSWORD_MASK_CHAR = '\u2022';

    private boolean inputChanged;
    private final T inputComponent;
    private final String placeholder;

    public InputWithPlaceholder(final String placeholder, T inputComponent){

        //Check for the null exception
        if(inputComponent==null || placeholder.isEmpty()){
            throw new IllegalArgumentException("Arguments cannot be empty");
        }
        this.inputComponent = inputComponent;
        this.inputChanged = false;
        this.placeholder = placeholder;

        inputComponent.setText(placeholder);

        //Sets text to be visible if input type is Password
        setPasswordMask(DEFAULT_ECHO_CHAR);

        // Set listener to detect if user changed the input manually
       addKeyEventListener();
       addFocusEventListener();

    }


    //If instance of input is type of Password, encode or decode method.
    private void setPasswordMask(char echoChar) {
        if (inputComponent instanceof JPasswordField) {
            ((JPasswordField) inputComponent).setEchoChar(echoChar);
        }
    }

    //Add key listener in order to check if User provided changes to input
    private void addKeyEventListener() {
        inputComponent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                inputChanged = true;
            }
        });
    }

    //Check if input is focused or not, then perform methods based on input type and input value.
    //If user provided any changes before focus nothing happens
    private void addFocusEventListener() {
        inputComponent.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!inputChanged && inputComponent.getText().equals(placeholder)) {
                    inputComponent.setText("");
                    setPasswordMask(PASSWORD_MASK_CHAR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputComponent.getText().isEmpty()) {
                    inputChanged = false;
                    inputComponent.setText(placeholder);
                    setPasswordMask(DEFAULT_ECHO_CHAR);
                }
            }
        });
    }

    // Factory method for creating a PlaceholderInput specified as JTextField
    public static JTextField createTextFieldInput(String placeholder) {
        return new InputWithPlaceholder<>(placeholder, new JTextField()).getInputComponent();
    }

    // Factory method for creating a PlaceholderInput specified as JPasswordField
    public static JPasswordField createPasswordFieldInput(String placeholder) {
        return new InputWithPlaceholder<>(placeholder, new JPasswordField()).getInputComponent();
    }


    private T getInputComponent() {
        return inputComponent;
    }
}
