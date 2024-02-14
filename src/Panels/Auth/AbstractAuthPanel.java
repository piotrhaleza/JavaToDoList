package Panels.Auth;




import Utilities.ComponentUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** AbstractClass which containes mutual variables for LoginPanel and RegisterPanel for the LoginFrame class component.
 * It uses the ComponentUtils class which creates most basic components without specific modifiers.
 * */
public abstract class AbstractAuthPanel extends JPanel {

    //Inputs size
    private final Dimension inputDimension;

    //Things used in both Login, Register panels
    protected JPanel inputPanel;
    protected JPanel buttonsPanel;
    protected JTextField loginInput;
    protected JPasswordField passwordInput;
    protected JButton submitBtn;
    protected JButton switchFormBtn;
    protected JButton continueAsGuestBtn;

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


    protected JPanel createPanel (ArrayList<JComponent> list, LayoutManager layoutManager){
        return ComponentUtils.createPanel(list,layoutManager);
    }


}
