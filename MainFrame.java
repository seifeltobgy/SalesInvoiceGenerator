package View;
import java.io. * ;
import java.text.SimpleDateFormat;

import Model.InvoiceLine;
import Model.InvoiceHeader;
import java.text.SimpleDateFormat;  
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    public JTable table;
	private JTable table_1;
    public List<InvoiceLine> InvoLines = new ArrayList<InvoiceLine>();
    public List<InvoiceHeader> invoHeader = new ArrayList<InvoiceHeader>();
    public int Selection;
    public String invNumLbl=" ";
   public JButton btnUpdateRow = new javax.swing.JButton();
	/**
	 * Launch the application.
	 */
	private final Action action = new SwingAction();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Invoice Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 31, 446, 498);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 220, 13);
		panel.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 426, 142);
		//////////////////////////////////////////////////////////
		panel.add(scrollPane);
//		
//		btnUpdateRow.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnUpdateRowActionPerformed(evt);
//            }
//        });
//		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(466, 31, 461, 498);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
	
		
		JLabel lblInvoiceNumber = new JLabel("Invoice Number");
		lblInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvoiceNumber.setBounds(10, 10, 107, 13);
		panel_1.add(lblInvoiceNumber);
		
		JLabel lblInvoiceNumber_1 = new JLabel(invNumLbl);
		lblInvoiceNumber_1.setForeground(new Color(0, 0, 0));
		lblInvoiceNumber_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvoiceNumber_1.setBounds(119, 10, 107, 13);
		panel_1.add(lblInvoiceNumber_1);
		
		JLabel lblInvoiceData = new JLabel("Invoice Date");
		lblInvoiceData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvoiceData.setBounds(10, 39, 96, 13);
		panel_1.add(lblInvoiceData);
		
		textField = new JTextField();
		textField.setBounds(119, 37, 309, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerData = new JLabel("Customer Data");
		lblCustomerData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustomerData.setBounds(10, 69, 96, 13);
		panel_1.add(lblCustomerData);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 67, 309, 19);
		panel_1.add(textField_1);
		
		JLabel lblInvoiceTotal = new JLabel("Invoice Total");
		lblInvoiceTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvoiceTotal.setBounds(10, 103, 96, 13);
		panel_1.add(lblInvoiceTotal);
		
		JLabel lblInvoiceNumber_1_1 = new JLabel(invNumLbl);
		lblInvoiceNumber_1_1.setForeground(Color.BLACK);
		lblInvoiceNumber_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvoiceNumber_1_1.setBounds(119, 103, 107, 13);
		panel_1.add(lblInvoiceNumber_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 126, 441, 362);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Invoice Items");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 10, 97, 13);
		panel_2.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 200), 2));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setBounds(10, 43, 421, 140);
		panel_2.add(table_1);
		
		JButton btnNewButton = new JButton("Create New Invoice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(50, 539, 169, 31);
		contentPane.add(btnNewButton);
		
		/////

		JButton btnNewButton_1 = new JButton("Delete Invoice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   int selectedRowIndex = table.getSelectedRow();
			        //Remove the selected row from the table
			        ((DefaultTableModel)table.getModel()).removeRow(selectedRowIndex);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(228, 539, 189, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdateRow = new JButton("Save");
		btnUpdateRow.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnUpdateRowActionPerformed(evt);
				} catch (CsvException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdateRow.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateRow.setBounds(600, 539, 87, 31);
		contentPane.add(btnUpdateRow);
		
		JButton btnNewButton_1_1_1 = new JButton("Cancel");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1.setBounds(718, 539, 87, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("File");
		menuBar.setBounds(0, 0, 31, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load File");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser= new JFileChooser();
				StringBuilder sb = new StringBuilder();
				String fileName = null;
				if(chooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
				{
					File chosenFile = chooser.getSelectedFile();
					fileName = chosenFile.getPath();
					//System.out.print(fileName);
				}
				else
				{
					sb.append("No file was selected");
				}
				
				
				//////READ FROM INVOICE LINE CSV USING BUFFERED READER///////
				try {

		            BufferedReader br = new BufferedReader(new FileReader(new File("InvoiceLine.csv")));
		            List<String[]> elements = new ArrayList<String[]>();
		            String line = null;
		            while((line = br.readLine())!=null) {
		                String[] splitted = line.split(",");
		                elements.add(splitted);
		            }
		            br.close();

		            Object[][] content2 = new Object[elements.size()][4];
		            
		            InvoiceLine invLine = null;
		            for(int i=0; i<elements.size(); i++) {
		            	invLine = new InvoiceLine();
		                content2[i][0] = elements.get(i)[0];
		            	invLine.setinvoiceNum(Integer.parseInt((String) content2[i][0]));
		            	
		                content2[i][1] = elements.get(i)[1];
		            	invLine.setitemName(content2[i][1].toString());
		            	
		                content2[i][2] = elements.get(i)[2];
		            	invLine.setitemPrice(Float.parseFloat(content2[i][2].toString()));
		            	
		                content2[i][3] = elements.get(i)[3];
		            	invLine.setcount(Integer.parseInt((String) content2[i][3]));
		            	
		            	InvoLines.add(invLine);
		            }

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
				////////CHECKING WHETHER LIST IS FILLED IN A RIGHT MANNER////////
				/*for(int i=0;i<InvoiceLines.size();i++)
				{
					System.out.print("Object #"+i+": ");
					System.out.print(InvoLines.get(i).getinvoiceNum());
					System.out.print(InvoLines.get(i).getitemName());
					System.out.print(InvoLines.get(i).getitemPrice());
					System.out.print(InvoLines.get(i).getCount());
				}*/
				
				
				//////READ FROM INVOICE HEADER CSV USING FILE CHOOSER AND BUFFERED READER///////
				try {

		            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
		            List<String[]> elements = new ArrayList<String[]>();
		            String line = null;
		            while((line = br.readLine())!=null) {
		                String[] splitted = line.split(",");
		                elements.add(splitted);
		            }
		            br.close();
		            String[] columNames = new String[] {
		                    "Invoice Number", "Date", "Customer Name"
		                };

		            Object[][] content = new Object[elements.size()][3];
		            
		            InvoiceHeader invHeader = null;
		            Date date1;
		            for(int i=0; i<elements.size(); i++) {
		            	invHeader = new InvoiceHeader();
		                content[i][0] = elements.get(i)[0];
		                //System.out.print(content[i][0]);
		                invHeader.setinvoiceNum(Integer.parseInt((String) content[i][0]));
		                
		                content[i][1] = elements.get(i)[1];
		                //System.out.print(content[i][1]);
		                date1=new SimpleDateFormat("dd-MM-yyyy").parse(content[i][1].toString());  
		                invHeader.setinvoiceDate(date1);
		                
		                content[i][2] = elements.get(i)[2];
		                //System.out.print(content[i][2]);
		                invHeader.setcustomerName(content[i][2].toString());
		                
		                invoHeader.add(invHeader);
		                
		                for(int j=0; j<InvoLines.size(); j++)
		                {
		                	if(InvoLines.get(j).getinvoiceNum() == invHeader.getinvoiceNum())
		                	{
		                		invHeader.setListValues(InvoLines.get(j));
		                	}
		                }
		            }
		            table = new JTable();
		            table.setModel(new DefaultTableModel(content,columNames));
					scrollPane.setViewportView(table);
					
					
					if(table != null && table.getModel() != null)
					{
						table.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseClicked(MouseEvent e) {
								
								    table = (JTable)e.getSource();
								    int row = table.getSelectedRow();
								    int column = 0;
								    String value = table.getModel().getValueAt(row, column).toString();
								    Selection = row;
								    //System.out.print(Selection);
								    String[] columns = new String[] {
							                    "Invoice Number", "Item Name", "Item Price","Count"
							                };
									List<InvoiceLine> TempLine = new ArrayList<InvoiceLine>();
									TempLine = invoHeader.get(Selection).getListValues();
									Object[][] content3 = new Object[TempLine.size()][4];
									float Total = 0;
									for(int i=0;i<TempLine.size();i++)
									{
										content3[i][0] = TempLine.get(i).getinvoiceNum();
										content3[i][1] = TempLine.get(i).getitemName();
										content3[i][2] = TempLine.get(i).getitemPrice();
										Total += Float.parseFloat(content3[i][2].toString());
										content3[i][3] = TempLine.get(i).getCount();
									}
									table_1.setModel(new DefaultTableModel(content3,columns));
									panel_2.remove(table_1);
									panel_2.add(table_1);
										
									invNumLbl = value;
									lblInvoiceNumber_1.setText(invNumLbl);
									
									value = String.valueOf(Total);
									lblInvoiceNumber_1_1.setText(value);
									
									value = invoHeader.get(row).getinvoiceDate().toString();
									textField.setText(value);
									
									value = invoHeader.get(row).getcustomerName();
									textField_1.setText(value);
							}
							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
					            
						});
					}

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save File");
		mnNewMenu.add(mntmNewMenuItem_1);
	}

    private void btnUpdateRowActionPerformed(java.awt.event.ActionEvent evt) throws CsvException, IOException{                                          

        int i = table_1.getSelectedRow();
         DefaultTableModel model = (DefaultTableModel)table.getModel();
        if(table.getSelectedRowCount() == 1)
        {
        	String name = textField_1.getText();
        	String Date  = textField.getText();
            model.setValueAt(name, table.getSelectedRow(), 2);
            model.setValueAt(Date, table.getSelectedRow(), 1);
          // String tempfile = "InvoiceHeader.csv";
       
            String fileName = "InvoiceHeader.csv";
          //  FileReader fileReader = new FileReader(fileName);
         //   Scanner scanner = new Scanner(fileReader);
            CSVReader reader = new CSVReader(new FileReader(new File("C:\\Users\\Seif\\Desktop\\ProjectFinal\\InvoiceHeader.csv")));
            List<String[]> csvBody = reader.readAll();
            // get CSV row column  and replace with by using row and column
            csvBody.get(i)[2] = name;
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(new File("C:\\Users\\Seif\\Desktop\\ProjectFinal\\InvoiceHeader.csv")));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
           
        }else{
            JOptionPane.showMessageDialog(null, "Error"); 
        }
     
    }           
    /////

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
