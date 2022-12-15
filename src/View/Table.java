package View;

import javax.swing.*;

public class Table extends JPanel {

   private JTable table;
   private String[] cols = {"No.","Date","Customer","Total"};
   private String[][] data={{"1","21/11/22","seif","2000"}};
    public Table() {
      //  super("Table demo");
        table= new JTable(data,cols);
        add(new JScrollPane(table));
        setSize(400, 500);
        setLocation(100, 200);
      //  setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
        public static void main(String[] args) {
            new Table().setVisible(true);
        }

}
