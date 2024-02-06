import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        // Create a JFrame instance (the main window)
        JFrame frame = new JFrame("My Java Frame Application");

        // Set the size of the frame
        frame.setSize(400, 300);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel (a text label)
        JLabel label = new JLabel("Hello, Java Frame!");

        // Add the label to the frame's content pane
        frame.getContentPane().add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}