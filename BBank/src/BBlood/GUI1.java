package BBlood;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class GUI1 extends JFrame {
		
GUI1(){
	
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
	frame.setBounds(500, 100, 709, 500);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lbl = new JLabel("BLOODBANK");
	lbl.setForeground(new Color(220, 20, 60));
	lbl.setFont(new Font("Garamond", Font.BOLD | Font.ITALIC, 40));
	lbl.setBounds(54, 33, 300, 46);
	
	frame.getContentPane().add(lbl);
	
	JButton btn1 = new JButton("Search Donors");
	btn1.setBackground(UIManager.getColor("Button.background")); 
	btn1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new BSearch();
			frame.dispose();
		}
	});
	btn1.setBounds(90, 124, 173, 36);
	
	frame.getContentPane().add(btn1);
	
	JButton btn2 = new JButton("Register as Donor");	
	btn2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btn2.setForeground(new Color(0, 0, 0));
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        new BReg();	
        frame.dispose();
		}

	});
	btn2.setBackground(UIManager.getColor("Button.background"));
	btn2.setBounds(70, 233, 199, 36);
	
	frame.getContentPane().add(btn2);
	
	JButton btn3 = new JButton("Request Donor");
	btn3.setBackground(UIManager.getColor("Button.background"));
	btn3.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new BRequest();
			frame.dispose();
		}
	});
	btn3.setBounds(90, 353, 167, 36);
	
    frame.getContentPane().add(btn3);
	
    //steps to add image
    JLabel lblNewLabel = new JLabel("new label"); 
    Image imag=new ImageIcon(this.getClass().getResource("/donate.jpg")).getImage();
    	lblNewLabel.setIcon(new ImageIcon(imag));
    	lblNewLabel.setBounds(380, 74, 245, 349);
    	frame.getContentPane().add(lblNewLabel);   
    	frame.setSize(709, 500);
       frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	
}
	
}
