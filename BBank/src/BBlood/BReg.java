package BBlood;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class BReg extends JFrame {
   
	private JFrame frame;
	private JTextField textfield1;
	private JPasswordField passfield;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	private JTextField textfield7;
	private JTextField textfield8;
	BReg() 
{	 
frame = new JFrame();
frame.setBounds(500, 100, 700, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

frame.setVisible(true);	
frame.setSize(700, 400);

JLabel lblLogin = new JLabel("Login Info");
lblLogin.setBounds(60, 11, 70, 14);
frame.getContentPane().add(lblLogin);

JLabel lblUsername = new JLabel("Username");
lblUsername.setBounds(10, 51, 70, 14);
frame.getContentPane().add(lblUsername);

JLabel lblPassword = new JLabel("Password");
lblPassword.setBounds(10, 115, 70, 14);
frame.getContentPane().add(lblPassword);

JLabel lblEmail = new JLabel("E-Mail");
lblEmail.setBounds(10, 175, 70, 14);
frame.getContentPane().add(lblEmail);

textfield1 = new JTextField();
textfield1.setBounds(90, 48, 96, 20);
frame.getContentPane().add(textfield1);
textfield1.setColumns(10);

passfield = new JPasswordField();
passfield.setBounds(90, 112, 96, 20);
frame.getContentPane().add(passfield);

textfield2 = new JTextField();
textfield2.setBounds(90, 172, 96, 20);
frame.getContentPane().add(textfield2);
textfield2.setColumns(10);

JLabel lblDonor = new JLabel("Donor Info");
lblDonor.setBounds(304, 11, 70, 14);
frame.getContentPane().add(lblDonor);

JSeparator separator = new JSeparator();
separator.setForeground(Color.RED);
separator.setOrientation(SwingConstants.VERTICAL);
separator.setBounds(206, 11, 25, 341);
frame.getContentPane().add(separator);

JLabel lblDonorId = new JLabel("Donor Id");
lblDonorId.setBounds(226, 51, 70, 14);
frame.getContentPane().add(lblDonorId);

JLabel lblDonorName = new JLabel("Donor Name");
lblDonorName.setBounds(226, 92, 80, 14);
frame.getContentPane().add(lblDonorName);

JLabel lblAge = new JLabel("Age");
lblAge.setBounds(226, 137, 49, 17);
frame.getContentPane().add(lblAge);

JLabel lblContact = new JLabel("Contact Info");
lblContact.setBounds(551, 11, 70, 14);
frame.getContentPane().add(lblContact);

JSeparator separator_1 = new JSeparator();
separator_1.setOrientation(SwingConstants.VERTICAL);
separator_1.setForeground(Color.RED);
separator_1.setBounds(450, 11, 25, 341);
frame.getContentPane().add(separator_1);

textfield3 = new JTextField();
textfield3.setBounds(306, 48, 96, 20);
frame.getContentPane().add(textfield3);
textfield3.setColumns(10);

textfield4 = new JTextField();
textfield4.setBounds(316, 89, 96, 20);
frame.getContentPane().add(textfield4);
textfield4.setColumns(10);

textfield5 = new JTextField();
textfield5.setBounds(285, 134, 35, 20);
frame.getContentPane().add(textfield5);
textfield5.setColumns(10);

JLabel lblSex = new JLabel("Sex");
lblSex.setBounds(232, 178, 49, 14);
frame.getContentPane().add(lblSex);

JRadioButton rdbtnMale = new JRadioButton("Male");
rdbtnMale.setBounds(271, 175, 61, 23);
frame.getContentPane().add(rdbtnMale);

JRadioButton rdbtnFemale = new JRadioButton("Female");
rdbtnFemale.setBounds(333, 175, 111, 23);
frame.getContentPane().add(rdbtnFemale);

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

cmbox.setBounds(333, 222, 83, 22);
frame.getContentPane().add(cmbox);

JLabel lblBloodGroup = new JLabel("Blood Group");
lblBloodGroup.setBounds(232, 226, 88, 18);
frame.getContentPane().add(lblBloodGroup);

JLabel lblAddress = new JLabel("Address");
lblAddress.setBounds(477, 51, 49, 14);
frame.getContentPane().add(lblAddress);

JLabel lblCity = new JLabel("City");
lblCity.setBounds(477, 115, 49, 17);
frame.getContentPane().add(lblCity);

JLabel lblPhoneNo = new JLabel("Phone No");
lblPhoneNo.setBounds(477, 175, 67, 14);
frame.getContentPane().add(lblPhoneNo);

textfield6 = new JTextField();
textfield6.setBounds(554, 48, 96, 20);
frame.getContentPane().add(textfield6);
textfield6.setColumns(10);

textfield7 = new JTextField();
textfield7.setBounds(554, 112, 96, 20);
frame.getContentPane().add(textfield7);
textfield7.setColumns(10);

textfield8 = new JTextField();
textfield8.setBounds(554, 172, 96, 20);
frame.getContentPane().add(textfield8);
textfield8.setColumns(10);

JLabel lblDate = new JLabel("Date of Donation");
lblDate.setBounds(226, 302, 110, 14);
frame.getContentPane().add(lblDate);

//date selection from calendar
JDateChooser dateChooser = new JDateChooser();
dateChooser.setBounds(333, 296, 96, 20);
frame.getContentPane().add(dateChooser);

JButton btnSubmit = new JButton("Submit");
btnSubmit.setBounds(522, 261, 89, 23);
frame.getContentPane().add(btnSubmit);

btnSubmit.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "sql@1234");
		PreparedStatement ps = con.prepareStatement("insert into donor(Username,Password,DonorId, DonorName,Sex,Age,EMail,BloodGroup,Date,Address,City,PhoneNo) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		 String Username = textfield1.getText();
			@SuppressWarnings("deprecation")   //@SuppressWarnings are use to restrict the compiler to show the certain warning on the console screen.
			int Password = Integer.parseInt(passfield.getText());
			int DonorId = Integer.parseInt(textfield3.getText());
			String DonorName = textfield4.getText();
			String Sex = null ; 
			int Age = Integer.parseInt(textfield5.getText());
			String EMail = textfield2.getText();
			String BloodGroup=(String)cmbox.getSelectedItem();
			java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
			
			String Address = textfield6.getText();
			String City = textfield7.getText();
		    long PhoneNo = Long.parseLong(textfield8.getText());
		
		    if(rdbtnMale.isSelected()) 
		        Sex="Male";
		else if(rdbtnFemale.isSelected()) 
		        Sex="Female";    
		    
		ps.setString(1, Username);
		ps.setInt(2, Password);
		ps.setInt(3,DonorId);
		ps.setString(4,DonorName);
		ps.setString(5, Sex);
		ps.setInt(6, Age);
		ps.setString(7, EMail);
		ps.setString(8, BloodGroup);
	    ps.setDate(9, sqlDate);
		ps.setString(10, Address);
		ps.setString(11, City);
		ps.setLong(12, PhoneNo);
		
		int res= ps.executeUpdate();
		
	if(res>0) {
		frame.dispose();
		System.out.println("Donor added");
		JOptionPane.showMessageDialog(frame, "Donor Added");
	}
	else {
		frame.dispose();
		System.out.println("Something Wrong");
		JOptionPane.showMessageDialog(frame, "Something Wrong");	
	}

	}catch(Exception e1) {
		frame.dispose();
		System.out.println(e1);
		JOptionPane.showMessageDialog(frame,"Something Wrong","Alert",JOptionPane.WARNING_MESSAGE);
    }
	  
	}	
	
});

}
}
