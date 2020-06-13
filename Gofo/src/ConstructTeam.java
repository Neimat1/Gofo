import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persons.Person;
import persons.Persons;
import persons.Team;
import persons.Teams;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
/**
 * class to ConstructTeam
 *Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class ConstructTeam extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;
	/**
	 * there is  a  relation list and listmodel ,in listmodel it show new added Player 
	 */
	DefaultListModel<String> listmodel = new DefaultListModel<String>();
	/**
	 * list to show constructed team and when we click on any team it show its details 
	 */
	private JList<String> list = new JList<String>(listmodel);
	/**
	 * team is an object from class Team to construct team
	 */
	private Team team=new Team();
	/**
	 * function to Create the frame of construct team by adding players who isn't a member in other teams
	 * 
	 * @param per is an object from class Person
	 */
	public ConstructTeam(Person per) {
		setTitle("Construct Team");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Team Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 11, 73, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 11, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 54, 63, 17);
		contentPane.add(lblNewLabel_1);
		
		Persons lst=new Persons();
		Vector<Integer> persIDs=new Vector<Integer>();
		Vector<String> persNames=new Vector<String>();
		for(int i=0;i<lst.size();i++)
		{
			Person p=lst.get(i);
			if(p.getRole()==Person.Role.PLAYER)
				{
				persNames.add(p.getName());	
				persIDs.add(p.getID());
				}
		}
		JComboBox<String> comboBox = new JComboBox<String>(persNames);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(82, 53, 159, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Team members");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(21, 87, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		list.setBounds(21, 112, 152, 175);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(301, 264, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
/**
 * to action listener with the buttons
 */
			@Override
			public void actionPerformed(ActionEvent e) {
				Teams teams=new Teams();
				int n=teams.size();
				if(n==0)
				{
					team.setID(1);
				}
				else 
				{ 
					team.setID(teams.size()+1);
				}
				team.setName(textField.getText());	
				teams.add(team);
				teams.storeTeams();
				JOptionPane.showMessageDialog(null, "Team is stored successfully");
				dispose();
			}
			
		});
		contentPane.add(btnNewButton);
	    team.addPlayer(per.getID());
	    listmodel.addElement(per.getName());
		
		JButton btnNewButton_1 = new JButton("Add member");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int id=persIDs.get(comboBox.getSelectedIndex());
				if(!team.isAMember(id))
					{
					team.addPlayer(id);
				    listmodel.addElement((String)comboBox.getSelectedItem());
					}else
					{
						JOptionPane.showMessageDialog(null, "Player is already added");
					}
					}
		});
		btnNewButton_1.setBounds(251, 52, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove member");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty())return;
				listmodel.remove(list.getSelectedIndex());
			}
			
		}
				);
		btnNewButton_2.setBounds(212, 164, 132, 23);
		contentPane.add(btnNewButton_2);
	}
}
