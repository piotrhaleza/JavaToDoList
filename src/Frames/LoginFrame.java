package Frames;


import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Inputs.InputWithPlaceholder;
import Panels.Auth.LoginPanel;
import Panels.Auth.RegisterPanel;
import org.intellij.lang.annotations.Flow;


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
        containerPanel.add(new LoginPanel(), "LoginPanel");
        containerPanel.add(new RegisterPanel(), "RegisterPanel");
        cl.show(containerPanel, "LoginPanel");


        //Set up the frame
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        this.add(containerPanel);
        //this.add(inputPanel);
       // this.add(buttonsPanel);
       // this.add(submitBtn);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // Center the frame on the screen

        this.pack();



    }
}
