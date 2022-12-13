package View;

import javax.swing.*;

public class DesignPreview extends JFrame {


    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    public DesignPreview()
    {
        super("Design Preview");
        b1 = new JButton("B1");
        b1 = new JButton("B2");
        b1 = new JButton("B3");
        b1 = new JButton("B4");
        setSize(600,600);
        setLocation(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new DesignPreview().setVisible(true);
    }
}
