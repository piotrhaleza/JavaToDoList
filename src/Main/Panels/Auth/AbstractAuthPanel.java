package Main.Panels.Auth;




import Main.Utilities.ComponentUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** AbstractClass which containes mutual variables for LoginPanel and RegisterPanel for the LoginFrame class component.
 * It uses the ComponentUtils class which creates most basic components without specific modifiers.
 * */
public abstract class AbstractAuthPanel extends JPanel {

    //Inputs size
    private final Dimension inputDimension;

    //Things used in both Login, Register panels
//    protected JPanel inputPanel;
//    protected JPanel buttonsPanel;
    protected JTextField loginInput;
    protected JPasswordField passwordInput;
    protected JButton submitBtn;
    protected JButton switchFormBtn;
    protected JButton continueAsGuestBtn;

    protected IBtnEventHandler eventHandler;

    protected AbstractAuthPanel(){
        inputDimension = new Dimension(250, 40);
    }
    //Custom input size constructor
    protected AbstractAuthPanel(Dimension dimension){
        this.inputDimension = dimension;
    }



    protected JTextField createTextField(String placeholder) {

        return ComponentUtils.createTextField(placeholder, inputDimension);
    }
    protected JPasswordField createPasswordField(String placeholder) {

        return ComponentUtils.createPasswordField(placeholder, inputDimension);
    }
    protected void customizeInputField(JTextField field, Dimension dimension) {
        ComponentUtils.customizeInputField(field,dimension);
    }


    protected JButton createBtn(String text, ActionListener action){
        return ComponentUtils.createBtn(text, action);
    }

    protected JPanel createPanel (LayoutManager layoutManager, JComponent... components){
        return ComponentUtils.createPanel(layoutManager, components);
    }

    protected void addEventListenerToInputs(Runnable method, JTextComponent... components) throws IllegalArgumentException{
        if(components==null) throw new IllegalArgumentException("Array of components cannot be null");
        for(JTextComponent comp : components){
            if(comp==null) throw new IllegalArgumentException("Component in an array cannot be null");
            comp.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    //Make sure that the code runs on EDT just in case
                    SwingUtilities.invokeLater(method);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    //Make sure that the code runs on EDT just in case
                    SwingUtilities.invokeLater(method);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    //Make sure that the code runs on EDT just in case
                    SwingUtilities.invokeLater(method);
                }
            });
        }

    }

    //Getters created, so it would be easier to validate inputs in separate class
    public JPasswordField getPasswordInput(){
        return passwordInput;
    }
    public JTextField getLoginInput(){
        return loginInput;
    }
    public JButton getSubmitBtn(){
        return submitBtn;
    }
}
