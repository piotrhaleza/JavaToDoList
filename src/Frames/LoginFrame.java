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

    private static final String loginView = "LoginPanel";
    private static final String registerView = "RegisterPanel";
    static CardLayout cl;
    static JPanel containerPanel;


    public LoginFrame(){}
    public LoginFrame(String title){
        super(title);
        cl = new CardLayout();

        containerPanel = new JPanel();
        containerPanel.setLayout(cl);
        containerPanel.add(new LoginPanel(), loginView);

        containerPanel.add(new RegisterPanel(), registerView);

        cl.show(containerPanel, loginView);


        //Set up the frame
        this.setLayout(new BorderLayout());
        this.add(containerPanel);
       //this.setResizable(false);
        this.setMinimumSize(new Dimension(250,250));
        this.setLocationRelativeTo(null); // Center the frame on the screen

        this.pack();


    }

    public static void switchToLoginView(){
        cl.show(containerPanel, loginView);

    }
    public static void switchToRegisterView(){
        cl.show(containerPanel, registerView);

    }



}
