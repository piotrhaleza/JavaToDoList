package Panels.Auth;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterPanel extends AbstractAuthPanel{

    private final int GRID_LAYOUT_ROWS = 2;
    private final int GRID_LAYOUT_COLS = 1;
    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JTextField loginInput;
    private JPasswordField passwordInput;
    private JPasswordField repeatPasswordInput;
    private JButton submitBtn;
    private JButton switchFormBtn;
    private JButton continueAsGuestBtn;
    public RegisterPanel(){
        createPanel();
    }

    //Constructor with custom inputs size
    public RegisterPanel(Dimension dimension){
        super(dimension);
        createPanel();
    }

    private void createPanel(){

        this.setLayout(new GridLayout(GRID_LAYOUT_ROWS,GRID_LAYOUT_COLS));
        submitBtn = createStyledBtn("Stwórz konto");
        switchFormBtn = createStyledBtn("Posiadasz już konto? Zaloguj się");
        continueAsGuestBtn = createStyledBtn("Kontynuuj jako gość");
        ArrayList<JButton> btnList = new ArrayList<>(Arrays.asList(submitBtn,switchFormBtn,continueAsGuestBtn));
        buttonsPanel = createBtnPanel(btnList);

        loginInput = createTextField("Login");
        passwordInput = createPasswordField("Hasło");
        repeatPasswordInput = createPasswordField("Powtórz hasło");
        ArrayList<JTextComponent> inputList = new ArrayList<>(Arrays.asList(loginInput,passwordInput,repeatPasswordInput));
        inputPanel = createInputPanel(inputList);

        this.add(inputPanel);
        this.add(buttonsPanel);
    }
}
