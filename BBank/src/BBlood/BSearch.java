package BBlood;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BSearch extends JFrame  {
	private JFrame frame;
	
BSearch(){
	
frame = new JFrame();
frame.setBounds(500, 100, 300, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

frame.setVisible(true);	
frame.setSize(300, 300);

JLabel lblSearch = new JLabel("Search Donor By:");
lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
lblSearch.setBounds(73, 11, 145, 31);
frame.getContentPane().add(lblSearch);

JRadioButton rdbtnBlood = new JRadioButton("Blood Group");
rdbtnBlood.setFont(new Font("Tahoma", Font.PLAIN, 12));
rdbtnBlood.setBounds(73, 69, 111, 23);
frame.getContentPane().add(rdbtnBlood);
rdbtnBlood.addActionListener(new ActionListener()	{				
		public void actionPerformed(ActionEvent e)
		{
			if(rdbtnBlood.isSelected()) {
				new BGroup();
				frame.dispose();
			}
			
		}});
JRadioButton rdbtnCity = new JRadioButton("City");
rdbtnCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
rdbtnCity.setBounds(73, 130, 111, 23);
frame.getContentPane().add(rdbtnCity);
rdbtnCity.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(rdbtnCity.isSelected()) {
			new BCity();
			frame.dispose();
		}
	}
});
JRadioButton rdbtnDate = new JRadioButton("Date of Donation");
rdbtnDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
rdbtnDate.setBounds(73, 195, 120, 23);
frame.getContentPane().add(rdbtnDate);
rdbtnDate.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(rdbtnDate.isSelected()) {
			new BDate();
			frame.dispose();
			
		}
		}
});		
}
}
