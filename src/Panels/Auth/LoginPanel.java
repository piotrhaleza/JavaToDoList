package Panels.Auth;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginPanel extends AbstractAuthPanel{

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;
    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    private JButton submitBtn;
    private JButton switchFormBtn;
    private JButton continueAsGuestBtn;
    public LoginPanel(){
        createPanel();
    }

    //Constructor with custom inputs size
    public LoginPanel(Dimension dimension){
        super(dimension);
        createPanel();
    }

    private void createPanel(){

        this.setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));

        submitBtn = createStyledBtn("Zaloguj się");
        switchFormBtn = createStyledBtn("Zarejestruj się");
        continueAsGuestBtn = createStyledBtn("Kontynuuj jako gość");
        ArrayList<JButton> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createBtnPanel(btnList);

        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        ArrayList<JTextComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput));
        inputPanel = createInputPanel(inputList);

        this.add(inputPanel);
        this.add(buttonsPanel);
    }
}
