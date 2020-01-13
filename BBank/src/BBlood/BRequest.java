package BBlood;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class BRequest extends JFrame {
	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField tf9;
	private JTextField tf10;
	private JTextField tf11;
	
public BRequest() {
	frame = new JFrame();
	frame.setBounds(500, 100, 700, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);


	frame.setVisible(true);	
	frame.setSize(700, 400);
	
	JLabel lblPatientDetails = new JLabel("Patient Details");
	lblPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPatientDetails.setBounds(171, 11, 103, 22);
	frame.getContentPane().add(lblPatientDetails);
	
	JLabel lblHospitalDetails = new JLabel("Hospital Details");
	lblHospitalDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblHospitalDetails.setBounds(497, 6, 135, 33);
	frame.getContentPane().add(lblHospitalDetails);
	
	JLabel lblName = new JLabel("Name");
	lblName.setBounds(10, 62, 49, 14);
	frame.getContentPane().add(lblName);
	
	JLabel lblEmail = new JLabel("E-Mail");
	lblEmail.setBounds(10, 103, 49, 14);
	frame.getContentPane().add(lblEmail);
	
	JLabel lblSex = new JLabel("Sex");
	lblSex.setBounds(10, 151, 49, 14);
	frame.getContentPane().add(lblSex);
	
	JLabel lblDob = new JLabel("DOB");
	lblDob.setBounds(10, 196, 49, 14);
	frame.getContentPane().add(lblDob);
	
	JLabel lblBloodGroup = new JLabel("Blood Group");
	lblBloodGroup.setBounds(10, 245, 74, 14);
	frame.getContentPane().add(lblBloodGroup);
	
	JLabel lblWeight = new JLabel("Weight (in kgs)");
	lblWeight.setBounds(10, 289, 98, 22);
	frame.getContentPane().add(lblWeight);
	
	tf1 = new JTextField();
	tf1.setBounds(69, 59, 110, 20);
	frame.getContentPane().add(tf1);
	tf1.setColumns(10);
	
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
	
	cmbox.setBounds(94, 241, 85, 22);
	frame.getContentPane().add(cmbox);
	
	tf2 = new JTextField();
	tf2.setBounds(69, 100, 110, 20);
	frame.getContentPane().add(tf2);
	tf2.setColumns(10);
	
	tf3 = new JTextField();
	tf3.setBounds(118, 290, 61, 20);
	frame.getContentPane().add(tf3);
	tf3.setColumns(10);
	
	JRadioButton rdbtnMale = new JRadioButton("Male");
	rdbtnMale.setBounds(54, 147, 61, 23);
	frame.getContentPane().add(rdbtnMale);
	
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	rdbtnFemale.setBounds(117, 147, 70, 23);
	frame.getContentPane().add(rdbtnFemale);
	
	JDateChooser dateChooser = new JDateChooser();
	dateChooser.setBounds(69, 196, 110, 20);
	frame.getContentPane().add(dateChooser);
	
	JSeparator separator = new JSeparator();
	separator.setToolTipText("");
	separator.setBackground(Color.WHITE);
	separator.setForeground(Color.RED);
	separator.setOrientation(SwingConstants.VERTICAL);
	separator.setBounds(206, 44, 19, 287);
	//separator.setBounds(250, 313, -28, -254);
	frame.getContentPane().add(separator);
	
	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(225, 81, 49, 14);
	frame.getContentPane().add(lblAddress);
	
	JLabel lblCity = new JLabel("City");
	lblCity.setBounds(225, 151, 49, 19);
	frame.getContentPane().add(lblCity);
	
	JLabel lblPhoneNo = new JLabel("Phone No.");
	lblPhoneNo.setBounds(225, 228, 61, 14);
	frame.getContentPane().add(lblPhoneNo);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.RED);
	separator_1.setOrientation(SwingConstants.VERTICAL);
	separator_1.setBounds(430, 47, 25, 287);
	//separator_1.setBounds(407, 208, 1, 2);
	frame.getContentPane().add(separator_1);
	
	tf4 = new JTextField();
	tf4.setBounds(284, 78, 117, 22);
	frame.getContentPane().add(tf4);
	tf4.setColumns(10);
	
	tf5 = new JTextField();
	tf5.setBounds(284, 148, 110, 20);
	frame.getContentPane().add(tf5);
	tf5.setColumns(10);
	
	tf6 = new JTextField();
	tf6.setBounds(296, 225, 105, 20);
	frame.getContentPane().add(tf6);
	tf6.setColumns(10);
	
	JLabel lblHName = new JLabel("H Name");
	lblHName.setBounds(449, 81, 85, 14);
	frame.getContentPane().add(lblHName);
	
	JLabel lblHAddress = new JLabel("H Address");
	lblHAddress.setBounds(449, 130, 70, 14);
	frame.getContentPane().add(lblHAddress);
	
	JLabel lblDName = new JLabel("Doctor Name");
	lblDName.setBounds(445, 182, 85, 14);
	frame.getContentPane().add(lblDName);
	
	JLabel lblHPhone = new JLabel("H PhoneNo.");
	lblHPhone.setBounds(449, 228, 79, 14);
	frame.getContentPane().add(lblHPhone);
	
	JLabel lblHEmail = new JLabel("H E-Mail");
	lblHEmail.setBounds(449, 282, 49, 14);
	frame.getContentPane().add(lblHEmail);
	
	tf7 = new JTextField();
	tf7.setBounds(517, 78, 140, 20);
	frame.getContentPane().add(tf7);
	tf7.setColumns(10);
	
	tf8 = new JTextField();
	tf8.setBounds(517, 127, 140, 20);
	frame.getContentPane().add(tf8);
	tf8.setColumns(10);
	
	tf9 = new JTextField();
	tf9.setBounds(540, 179, 117, 20);
	frame.getContentPane().add(tf9);
	tf9.setColumns(10);
	
	tf10 = new JTextField();
	tf10.setBounds(540, 225, 117, 20);
	frame.getContentPane().add(tf10);
	tf10.setColumns(10);
	
	tf11 = new JTextField();
	tf11.setBounds(522, 279, 135, 20);
	frame.getContentPane().add(tf11);
	tf11.setColumns(10);
	
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(273, 289, 89, 23);
	frame.getContentPane().add(btnSubmit);
	
	btnSubmit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)throws NumberFormatException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "sql@1234");
			PreparedStatement ps = con.prepareStatement("insert into patient(Name,EMail,Sex,DOB,BGroup,Weight,Address,City,PhoneNo,HName,HAddress,Doctor,HPhNo,HEmail) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		   
			String Name=tf1.getText();
			String EMail=tf2.getText();
			String Sex=null;
			
			//java.util.Date utilDOB = new java.util.Date();
		    //java.sql.Date sqlDOB = new java.sql.Date(utilDOB.getTime());
			
			java.sql.Date sqlDOB = new java.sql.Date(dateChooser.getDate().getTime());
		//	java.util.Date d = dateChooser.getDate();
			
		    String BGroup=(String)cmbox.getSelectedItem();;
			int Weight=Integer.parseInt(tf3.getText());
			String Address=tf4.getText();
			String City=tf5.getText();
			long PhoneNo=Long.parseLong(tf6.getText());
			String HName=tf7.getText();
			String HAddress=tf8.getText();
			String Doctor=tf9.getText();
			long HPhNo=Long.parseLong(tf10.getText());
			String HEmail=tf11.getText();
			
		    if(rdbtnMale.isSelected()) 
		        Sex="Male";
		else if(rdbtnFemale.isSelected()) 
		        Sex="Female";    
			
			ps.setString(1, Name);
		    ps.setString(2, EMail);
		    ps.setString(3, Sex);
		    ps.setDate(4,sqlDOB);
		    //  ps.setDate(4, sqlDOB);
		    ps.setString(5, BGroup);
		    ps.setInt(6, Weight);
		    ps.setString(7, Address);
		    ps.setString(8, City);
		    ps.setLong(9, PhoneNo);
		    ps.setString(10, HName);
		    ps.setString(11, HAddress);
		    ps.setString(12, Doctor);
		    ps.setLong(13, HPhNo);
		    ps.setString(14, HEmail);

		int res= ps.executeUpdate();

		if(res>0) {
			frame.dispose();
			System.out.println("Your request for blood has been registerd successfully");
			JOptionPane.showMessageDialog(frame, "Your request for blood has been registerd successfully");
		}
		else {
			frame.dispose();
			System.out.println("Something Wrong");
			JOptionPane.showMessageDialog(frame,"Something Wrong","Alert",JOptionPane.WARNING_MESSAGE);
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
