import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import playgrounds.AvailabilityStatus;
import playgrounds.Playground;
import playgrounds.Playgrounds;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import persons.Person;
import persons.Persons;

import javax.swing.event.ListSelectionEvent;
/**
 * this class for ShowPlaygrounds informations and player can select from it
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ShowPlaygrounds extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * there is  a  relation list and listmodel ,in listmodel it show new added playground 
	 */
	DefaultListModel<String> listmodel=new DefaultListModel<String>(); 
	/**
	 * list to show playgrounds and when we click on any playground it show its details 
	 */
	private JList<String> list = new JList<String>(listmodel);
	private JTextField textField_4;

	/**
	 * function to Create the frame of ShowPlaygrounds details that playground owner added and player can book one from it
	 */
	public ShowPlaygrounds() {
		setTitle("Show Playgrounds");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Playgrounds lst=new Playgrounds();
		for(int i=0;i<lst.size();i++)
			if(lst.get(i).getPlaygroundAvailbility()==AvailabilityStatus.ACTIVE)
						listmodel.addElement(lst.get(i).getPlaygroundName());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index=list.getSelectedIndex();
				Playground pgnd=lst.get(index);
				textField.setText(String.valueOf(pgnd.getPlaygroundID()));
				textField_1.setText(pgnd.getPlaygroundLocation());
				textField_2.setText(String.valueOf(pgnd.getPlaygroundHours()));
				textField_3.setText(String.valueOf(pgnd.getPlaygroundPrice()));
				Person per=new Persons().findPersonByID(pgnd.getPlaygroundOwnerID());
				textField_4.setText(per.getName());
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setBounds(10, 35, 131, 226);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Playgrounds");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 11, 84, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Playground ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(161, 48, 88, 17);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(302, 48, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Playground Location");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(161, 96, 131, 17);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(302, 96, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Available Hours");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(161, 140, 131, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 139, 110, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(161, 186, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(302, 185, 110, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Playground Owner");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(161, 228, 131, 17);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(301, 228, 111, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
