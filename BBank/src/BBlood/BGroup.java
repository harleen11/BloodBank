package BBlood;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BGroup extends JFrame{
	private JFrame frame;

	BGroup()
{
frame = new JFrame();
frame.setBounds(500, 100, 700, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

frame.setVisible(true);	
frame.setSize(700, 400);

JLabel lblBG = new JLabel("Select Blood Group:");
lblBG.setBounds(90, 11, 120, 14);
frame.getContentPane().add(lblBG);

JComboBox<String> cmbox = new JComboBox<String>();
cmbox.addItem("Select");
cmbox.addItem("A+");
cmbox.addItem("B+");
cmbox.addItem("O+");
cmbox.addItem("AB+");
cmbox.addItem("A-");
cmbox.addItem("B-");
cmbox.addItem("O-");
cmbox.addItem("AB-");
cmbox.setBounds(238, 7, 100, 22);
frame.getContentPane().add(cmbox);

JButton btnSearch = new JButton("Search");
btnSearch.setBounds(391, 7, 89, 23);
frame.getContentPane().add(btnSearch);
btnSearch.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {

		cmbox.getItemAt(cmbox.getSelectedIndex()); 
		String[] columnNames= {"DonorId","DonorName","Sex","Age","BloodGroup","Date","Address","City","PhoneNo"};	
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				},
			new Object[] {
				"DId", "DName", "Sex", "Age", "BloodGroup", "Date", "Address", "City", "PhoneNo"
			}
					
		)
		);
		
//DefaultTableModel model = new DefaultTableModel();
//JTable table = new JTable(model);
table.setBounds(40, 91, 604, 215);
frame.getContentPane().add(table);

//String[] columnNames= {"DonorId","DonorName","Sex","Age","BloodGroup","Date","Address","City","PhoneNo"};

JTableHeader header=table.getTableHeader();


/*for(int i=0;i<table.getColumnCount();i++)
{
TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);

column1.setHeaderValue(columnNames[i]);
} 
*/

String BloodGroup= (String)cmbox.getSelectedItem();

model.addColumn("DonorId");
model.addColumn("DonorName");
model.addColumn("Sex");
model.addColumn("Age");
model.addColumn("BloodGroup");
model.addColumn("Date");
model.addColumn("Address");
model.addColumn("City");
model.addColumn("PhoneNo");

frame.add(table.getTableHeader());
//panel.setLayout(new BorderLayout());
//panel.add(table, BorderLayout.CENTER);

try {	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "sql@1234");
			
	String query = "select DonorId as DonorId, DonorName as DonorName,Sex as Sex,Age as Age,BloodGroup as BloodGroup,Date as Date,Address as Address,City as City,PhoneNo as PhoneNo from donor where BloodGroup=? ";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, BloodGroup);            
		
	ResultSet rs = ps.executeQuery();
	table.setModel(model);
	while(rs.next()) {
		model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getLong(9)});
	}
}catch(Exception e1) {
		System.out.println(e1);
		
}
	}
});

JButton button = new JButton("<");
button.setFont(new Font("Tahoma", Font.BOLD, 13));
button.setBounds(10, 329, 48, 23);
frame.getContentPane().add(button);
button.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		new BSearch();
		frame.dispose();	
	}
});
} 	
}
