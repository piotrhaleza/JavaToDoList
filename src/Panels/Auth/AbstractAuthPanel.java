package Panels.Auth;

import Inputs.InputWithPlaceholder;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractAuthPanel extends JPanel {

    //Inputs size
    private final Dimension dimension;

    protected AbstractAuthPanel(){
        dimension = new Dimension(250, 40);
    }
    //Custom input size constructor
    protected AbstractAuthPanel(Dimension dimension){
        this.dimension = dimension;
    }

    //Method to create customized button for the future
    protected JButton createStyledBtn(String text){
        return new JButton(text);
    }

    //Method to create JTextField with specified size
    protected JTextField createTextField(String placeholder) {

        //InputWithPlaceholder is external class that provides the Factory Methods in order to create
        //inputs with placeholders.
        JTextField inputField = InputWithPlaceholder.createTextFieldInput(placeholder);
        customizeInputField(inputField, dimension);
        return inputField;
    }
    //Method to create JPasswordField with specified size
    protected JPasswordField createPasswordField(String placeholder) {

        //InputWithPlaceholder is external class that provides the Factory Methods in order to create
        //inputs with placeholders.
        JPasswordField passwordField = InputWithPlaceholder.createPasswordFieldInput(placeholder);
        customizeInputField(passwordField, dimension);
        return passwordField;
    }

    //Method to customize the specific input, currently only the dimension and text align
    protected void customizeInputField(JTextField field, Dimension dimension) {
        field.setPreferredSize(dimension);
        field.setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Method to create panel with buttons, the argument is array of buttons that should be implemented into panel itself
    protected JPanel createBtnPanel (ArrayList<JButton> list){
        JPanel btnPanel = new JPanel();

        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for(JButton btn : list){
            btnPanel.add(btn);
        }
        return btnPanel;
    }
    //Method to create panel with inputs, the argument is array of inputs that should be implemented into panel itself
    protected JPanel createInputPanel (ArrayList<JTextComponent> list){
        JPanel inputPanel = new JPanel();

        //set the layout of rows equal to size of inputs array
        inputPanel.setLayout(new GridLayout(list.size(),1));
        for(JTextComponent input : list){
            inputPanel.add(input);
        }
        return inputPanel;
    }

}
