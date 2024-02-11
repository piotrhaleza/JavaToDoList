package Frames;

import javax.swing.*;

public abstract class AbstractFrame extends JFrame {

    // necessary empty constructor
    AbstractFrame(){}
    protected AbstractFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
