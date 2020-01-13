package BBlood;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BCity extends JFrame {

private JFrame frame;
BCity(){

	frame = new JFrame();
	frame.setBounds(500, 100, 700, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	frame.setVisible(true);	
	frame.setSize(700, 400);

	JLabel lblCity = new JLabel("Enter City:");
	lblCity.setBounds(109, 11, 114, 14);
	frame.getContentPane().add(lblCity);
	
    JTextField textField = new JTextField();
	textField.setBounds(238, 7, 100, 22);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
JButton btnSearch = new JButton("Search");
btnSearch.setBounds(391, 7, 89, 23);
frame.getContentPane().add(btnSearch);
btnSearch.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		textField.getText();
			
DefaultTableModel model = new DefaultTableModel();
JTable table = new JTable(model);
table.setBounds(40, 91, 604, 215);
frame.getContentPane().add(table);

model.addColumn("DonorId");
model.addColumn("DonorName");
model.addColumn("Sex");
model.addColumn("Age");
model.addColumn("BloodGroup");
model.addColumn("Date");
model.addColumn("Address");
model.addColumn("City");
model.addColumn("PhoneNo");

try {	
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "sql@1234");
			
	String query = "select DonorId, DonorName,Sex,Age,BloodGroup,Date,Address,City,PhoneNo from donor where City=? ";
	PreparedStatement ps = con.prepareStatement(query);
	
	String City=textField.getText();
	
	ps.setString(1, City);            
		
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
