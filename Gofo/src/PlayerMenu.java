import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import persons.Person;
/**
 * class to show PlayerMenu and he can do what he want
 * * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class PlayerMenu implements ActionListener{
/**
 * label for say Hello Player and his name
 */
public JLabel label;
/**
 * object from class Person
 */
private Person per;
private JButton [][] buttons=new JButton[6][1];
/**
 * function to show PlayerMenu and he can do what he want
 * @param per1 is an object from class Person and his role is Player
 */
	public PlayerMenu(Person per1){
		per=per1;
		JFrame frame=new JFrame();	
		JLabel label=new JLabel("Hello Player: " + per.getName()); 
		JPanel panel=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel.add(label);	
		String  [][]player_function= {{"Update_Profile"},{"Show_playGrounds"},{"Book_playground"},{"Check_eWallet"},{"Invite_Team"},{"Create_Team"}};
		String[]BE= {"Back","Exit"};
		JButton[]buttons2=new JButton[2];
		for(int i=0 ;i<6;i++)
		{
			for(int j=0 ;j<1;j++)
			{
				buttons[i][j]=new JButton(player_function[i][j]);
				buttons[i][j].setBackground(Color.LIGHT_GRAY);
			    buttons[i][j].setForeground(Color.GRAY);
			    buttons[i][j].addActionListener(this);
				panel2.add(buttons[i][j]);
			}
		}
		for(int i=0 ;i<2;i++)
		{
			buttons2[i]=new JButton(BE[i]);
		
			buttons2[i].setBackground(Color.DARK_GRAY);
		    buttons2[i].setForeground(Color.BLUE);
		    panel3.add(buttons2[i]);
		}
		
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		panel.setLayout(new GridLayout(1,1));
		
		panel2.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));
		panel2.setLayout(new GridLayout(4,2));
		
		
		frame.add(panel,BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.AFTER_LAST_LINE);
		frame.add(panel3,BorderLayout.AFTER_LINE_ENDS);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("GOFO_PLAYER");
		frame.pack();
		frame.setVisible(true);	
	}
	/**
	 * to action listener with the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		if(btn.equals(buttons[0][0]))
		{
			new SignUp(per);
		}else if(btn.equals(buttons[1][0]))
		{
			new ShowPlaygrounds().setVisible(true);
		}else if(btn.equals(buttons[2][0]))
		{
			new BookingPlayground(per).setVisible(true);
		}
		else if(btn.equals(buttons[3][0]))
		{
		new CheckBalance(per).setVisible(true);
		}
		else if(btn.equals(buttons[4][0]))
		{
			new InviteTeam(per).setVisible(true);
		}else if(btn.equals(buttons[5][0]))
		{
			new ConstructTeam(per).setVisible(true);
		}
		
		
	}
		
		
	}


