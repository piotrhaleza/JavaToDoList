package Main.Utilities;

import Main.Inputs.InputWithPlaceholder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ComponentUtils {
    //Method to create JTextField with specified size
    public static JTextField createTextField(String placeholder, Dimension dimension) {
        //InputWithPlaceholder is external class that provides the Factory Methods in order to create
        //inputs with placeholders.
        JTextField inputField = InputWithPlaceholder.createTextFieldInput(placeholder);
        customizeInputField(inputField, dimension);
        return inputField;
    }

    //Method to create JPasswordField with specified size
    public static JPasswordField createPasswordField(String placeholder, Dimension dimension) {

        //InputWithPlaceholder is external class that provides the Factory Methods in order to create
        //inputs with placeholders.
        JPasswordField passwordField = InputWithPlaceholder.createPasswordFieldInput(placeholder);
        customizeInputField(passwordField, dimension);
        return passwordField;
    }

    //Method to customize the specific input, currently only the dimension and center text align
    public static void customizeInputField(JTextField field, Dimension dimension) {
        field.setPreferredSize(dimension);
        field.setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Method to create panel with JComponents, the argument is array of JComponents
    public static JPanel createPanel(LayoutManager layoutManager,JComponent... components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("At least one component must be provided");
        }

        JPanel panel = new JPanel();
        panel.setLayout(layoutManager);
        for (JComponent comp : components) {
            panel.add(comp);
        }
        return panel;
    }

    /**
     *
     * @param text text that will be shown on the button itself
     * @param action override method from ActionListener interface in that case "onClick"
     * @return created button with the onClick event implemented
     */
    public static JButton createBtn(String text, ActionListener action){
        JButton btn = new JButton(text);
        btn.addActionListener(action);
        return btn;
    }
}
