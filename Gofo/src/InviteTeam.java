import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persons.Person;
import persons.Persons;
import persons.Team;
import persons.Teams;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
/**
 * this is class to InviteTeam
 * * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class InviteTeam extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * there is  a  relation list and listmodel ,in listmodel it show new added Player in invited team
	 */
	DefaultListModel<String> listmodel=new DefaultListModel<String>();
	/**
	 * 
	 * list to show invited team and when we click on any invited team it show its details 
	 */
	JList<String> list = new JList<String>(listmodel);
	/**
	 * team is an object from class Team and sets to null
	 */
	Team team=null;
	/**
	 * vector to store emails of invited team
	 */
	Vector<String> emails=new Vector<String>();
	
	/**
	 * function to  Create the frame of InviteTeam and i can't do it if i don't construct team
	 * @param per is an object from class Person
	 */
	public InviteTeam(Person per) {
		setTitle("Invite Team");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Team:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 74, 65, 14);
		contentPane.add(lblNewLabel);
		
		Teams teams=new Teams();
		Vector<String> tmp = new Vector<String>();
		Vector<Team>   perteams=new Vector<Team>();
		for(int i=0;i< teams.getList().size();i++)
		{
			Team team=teams.get(i);
			if(team.getMembers().elementAt(0)==per.getID())
			{
				tmp.addElement(team.getName());
				perteams.add(team);
			}
		}
		Persons pers=new Persons();
		if(perteams.size()==1)
		{
			team=perteams.get(0);
			emails.clear();
			for(int id:team.getMembers())
			{
				Person per1=pers.findPersonByID(id);
				listmodel.addElement(per1.getName());
				emails.add(per1.getEmail());
			}			
		}
		JComboBox<String> comboBox = new JComboBox<String>(tmp);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				team=perteams.get(comboBox.getSelectedIndex());
				emails.clear();
				for(int id:team.getMembers())
				{
					Person per1=pers.findPersonByID(id);
					listmodel.addElement(per1.getName());
					emails.add(per1.getEmail());
				}
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(56, 72, 134, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Members");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(223, 23, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		list.setBounds(223, 48, 116, 172);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Invite");
		btnNewButton.setBounds(48, 197, 89, 23);
		btnNewButton.addActionListener(new ActionListener()
				{
/**
 * to action listener with the buttons
 */
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(team!=null)
						{
							String msg=per.getName() + " invites you to play with him";
							MailUtil.sendEmail(emails, "Gofo Invitation", msg);
							JOptionPane.showMessageDialog(null, "An invitation is sent to the team");
							dispose();
						}
						
					}
			
				}
				
				);
		
		contentPane.add(btnNewButton);
	}

}
