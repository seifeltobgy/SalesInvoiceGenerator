package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DesignPreview extends JFrame implements ActionListener {


    //JFrame window = new JFrame("LEFTANDRIGHT");
   // JPanel panelL = new JPanel();
    //JPanel panelR = new JPanel();
   // JPanel leftPanel = new JPanel();
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private JTextField Date;
    private JTextField Name;

    private JLabel Total;
    public DesignPreview()
    {
        super("Design Preview");


       // window.add(panelL,BorderLayout.WEST);
       // window.add(leftPanel,BorderLayout.EAST);

     //   leftPanel.setBackground(Color.Gray);
       // leftPanel.setBounds(0,0,250,250);
       // add(leftPanel);
        //setLayout(new FlowLayout());
setLayout(new GridLayout(2,2,20,10));
        add(new JLabel("Invoice Number:"));
        add(new JLabel("Invoice Date:"));
        add(new JLabel("Customer Name:"));

        Total = new JLabel("Invoice Total");
        b1 = new JButton("Create New Invoice");
        b2 = new JButton("Delete Invoice");
        b3 = new JButton("Save");
        b4 = new JButton("Cancel");

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        add(Total);
        Date = new JTextField(20);
        Name = new JTextField(15);
        add(Date);
        add(Name);
        Table T = new Table();

        add(T);
        pack();
      //  window.setVisible(true);
   // window.setSize(500,500);

         setSize(1000,1000);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new DesignPreview().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
