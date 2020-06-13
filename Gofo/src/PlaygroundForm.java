import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persons.Person;
import playgrounds.Playground;
import playgrounds.Playgrounds;
import playgrounds.AvailabilityStatus;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
/**
 * class for PlaygroundForm
 ** Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class PlaygroundForm extends JFrame implements ActionListener{
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
	private JTextField textField_4;
	/**
	 * JRadioButton to show the availability status of playground and you select from it
	 */
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;	
	private JTextField textField_6;
	private Playground pgnd=new Playground();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Person per;
	
	/**
	 * function to Create the frame of PlaygroundForm and entered playground details
	 * @param per is an object from class Person
	 */
public PlaygroundForm(Person per) {
		this.per=per;
		setTitle("Playground");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 383);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(18, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Playground Name :");
		lblNewLabel.setBounds(10, 24, 108, 17);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 23, 204, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Playground ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 52, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 54, 204, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Playground Location :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 83, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 81, 204, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Playground Size :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 108, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 106, 204, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Playground Hours :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 133, 124, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(148, 131, 204, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Playground Availability :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 158, 140, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Playground Price / hour:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 185, 140, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(148, 183, 204, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setBounds(333, 310, 89, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(29, 310, 89, 23);
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("Suspended");
		rdbtnNewRadioButton.setBounds(148, 155, 81, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Active");
		rdbtnNewRadioButton_1.setBounds(231, 155, 55, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Deleted");
		rdbtnNewRadioButton_2.setBounds(284, 155, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
	}
/**
 * function to select the availability status of playground
 */
private void mapFromPlaygraound()
{
	textField.setText(pgnd.getPlaygroundName());
	textField_1.setText(String.valueOf(pgnd.getPlaygroundID()));
	textField_2.setText(pgnd.getPlaygroundLocation());
	textField_3.setText(String.valueOf(pgnd.getPlaygroundSize()));
	textField_4.setText(String.valueOf(pgnd.getPlaygroundHours()));
	switch(pgnd.getPlaygroundAvailbility())
	{
	case ACTIVE:
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(false);
		break;
	case SUSPENDED:
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_2.setSelected(false);
		break;
	case DELETED:
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(true);
		break;	
	}
	textField_6.setText(String.valueOf(pgnd.getPlaygroundPrice()));
}
/**
 * function to show what i entered to add playground
 */
private void mapToPlayground()
{
	pgnd.setPlaygroundName(textField.getText());
	pgnd.setPlaygroundID(Integer.parseInt(textField_1.getText()));
	pgnd.setPlaygroundLocation(textField_2.getText());
	pgnd.setPlaygroundSize(Double.parseDouble(textField_3.getText()));
	pgnd.setPlaygroundHours(Integer.parseInt(textField_4.getText()));
	rdbtnNewRadioButton.setSelected(false);rdbtnNewRadioButton.setEnabled(false);
	rdbtnNewRadioButton_1.setSelected(true);rdbtnNewRadioButton_1.setEnabled(false);
	rdbtnNewRadioButton_2.setSelected(false);rdbtnNewRadioButton_2.setEnabled(false);
	
	if(rdbtnNewRadioButton.isSelected())
		pgnd.setPlaygroundAvailbility(AvailabilityStatus.ACTIVE);
	else if(rdbtnNewRadioButton_1.isSelected())
		pgnd.setPlaygroundAvailbility(AvailabilityStatus.SUSPENDED);
	else
		pgnd.setPlaygroundAvailbility(AvailabilityStatus.DELETED);
	pgnd.setPlaygroundPrice(Double.parseDouble(textField_6.getText()));
	pgnd.setPlaygroundOwnerID(per.getID());
}
/**
 * to action listener with the buttons
 */
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton btn=(JButton)e.getSource();
	if(btnNewButton.equals(btn))
	{
		mapToPlayground();
		Playgrounds lst=new Playgrounds();
		if(lst.size()==0)
			lst.add(pgnd);
		else {
			int i=lst.findPlaygroundByID(pgnd.getPlaygroundID());
			if(i==lst.size())lst.add(pgnd);else lst.set(i, pgnd);
		}
		lst.storePlaygrounds();
		JOptionPane.showMessageDialog(null, "You've successfully added a Playground");
		this.dispose();
	}else if(btnNewButton_1.equals(btn))
	{
		this.dispose();
	}
}
}
