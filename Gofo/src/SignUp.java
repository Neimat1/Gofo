import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Window;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import persons.Person;
import persons.Persons;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * this class to SignUp 
 *  Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class SignUp {
	/**
	 * JFrame for GofoLogin
	 */
	public JFrame frmGofoLogin;
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_7;
	/**
	 * JRadioButton to select role
	 */
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblNewLabel_7;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
    private JLabel lblNewLabel_8;
    private int mode=1;
	Person per;
	/**
	 * function to Create sign up.
	 */
	public SignUp() {
        mode=1;
        per=new Person();
		initialize();
	}
	/**
	 * function to update entered Person's information  
	 * @param per is an object from class Person 
	 */
	public SignUp(Person per)
	{
		mode=2;
		this.per=per;
		initialize();
		mapFromPerson(per);
	}

	/**
	 * function to Initialize the contents of the frame and details you will entered to sign up.
	 */
	private void initialize() {
		frmGofoLogin = new JFrame();
		frmGofoLogin.getContentPane().setFont(new Font("Adobe Arabic", Font.PLAIN, 15));
		frmGofoLogin.setTitle(mode==1?"Gofo SignUp":"Update Profile");
		frmGofoLogin.setBounds(100, 100, 372, 300);
		frmGofoLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGofoLogin.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmGofoLogin.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frmGofoLogin.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frmGofoLogin.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		frmGofoLogin.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("eMail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		frmGofoLogin.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		frmGofoLogin.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		if(mode==2)textField_2.setEnabled(false);
		
		lblNewLabel_3 = new JLabel("Password\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		frmGofoLogin.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		frmGofoLogin.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		frmGofoLogin.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		frmGofoLogin.getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Location");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		frmGofoLogin.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 2;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 6;
		frmGofoLogin.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Role");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		frmGofoLogin.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("Playground Owner");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 7;
		frmGofoLogin.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Player");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 3;
		gbc_rdbtnNewRadioButton_1.gridy = 7;
		frmGofoLogin.getContentPane().add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		if(mode!=1)
		{
			rdbtnNewRadioButton.setVisible(false);
			rdbtnNewRadioButton_1.setVisible(false);
		}
		lblNewLabel_7 = new JLabel("eWallet ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		frmGofoLogin.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 8;
		frmGofoLogin.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		lblNewLabel_8 = new JLabel("Balance");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 9;
		frmGofoLogin.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 2;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 9;
		frmGofoLogin.getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		btnNewButton = new JButton("Cancel");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 10;
		frmGofoLogin.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton(mode==1?"Register\r\n":"Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				per=mapToPerson();
				Persons lst=new Persons();
				if(mode==1)
				{
					VerificationCodeDlg dlg=new VerificationCodeDlg(per.getEmail());
					if(!dlg.isCorrect())
					{
						JOptionPane.showMessageDialog(null,"You are not registered");
						return;
					}					
					if(lst.isEmpty())per.setID(1); else per.setID(lst.size()+1);
					lst.add(per);
				}
				else {
					lst.updateElement(per);
				}
				lst.storePersons();
				if(mode==1)
					JOptionPane.showMessageDialog(null, "You're successfully registered", "Registeration " , JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Your profile is saved", "Update" , JOptionPane.INFORMATION_MESSAGE);
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();				
			}
		});
		btnNewButton .addActionListener(new ActionListener()
		{
		
		
		/**
		 * to action listener with the buttons
		 */

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				
			}
	
		}
		);

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		frmGofoLogin.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		frmGofoLogin.setVisible(true);
	}
	/**
	 * function to set Person's informations
	 * @return returning entered informations
	 */
	private Person mapToPerson()
	{ 
		per.setName(textField.getText() + " " + textField_1.getText());
		try {
			per.setEmail(textField_2.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textField_2.requestFocusInWindow();
			return null;
		}
		try
		{
			per.setPassword(textField_3.getText());
			per.setPhone(textField_4.getText());
			per.setLocation(textField_5.getText());
			if(mode==1)
			{
				if(rdbtnNewRadioButton_1.isSelected())per.setRole(Person.Role.PLAYER);
				else if(rdbtnNewRadioButton.isSelected())per.setRole(Person.Role.PLAYGROUNDOWNER);				
			}
			per.setEwalletID(Integer.parseInt(textField_6.getText()));
			per.setEwalletAmount(Double.parseDouble(textField_7.getText()));
			
		}catch(Exception ex)
		{
			
		}
		return per;
	}
	/**
	 * function to show your informations
	 * @param per is a person who sign up
	 * @return returning entered informations
	 */
	public Person mapFromPerson(Person per)
	{
		try {
			String[] m=per.getName().split(" ");
			textField.setText(m[0]);
			textField_1.setText(m[1]);			
		}catch(Exception ex)
		{
			
		}
		textField_2.setText(per.getEmail());
		textField_3.setText(per.getPassword());
		
		textField_4.setText(per.getPhone());
		textField_5.setText(per.getLocation());
		if(per.getRole()==Person.Role.ADMIN)
		{
			rdbtnNewRadioButton.setVisible(false);
			rdbtnNewRadioButton_1.setVisible(false);
		}else if(per.getRole()==Person.Role.PLAYER)
		{
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton.setSelected(false);
		}else
		{
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton.setSelected(true);			
		}
		if(per.getRole()==Person.Role.PLAYER|| per.getRole()==Person.Role.PLAYGROUNDOWNER)
		{
			textField_6.setText(String.valueOf(per.getEwalletID()));
			textField_7.setText(String.valueOf(per.getEwalletAmount()));
		}else
		{
			lblNewLabel_6.setVisible(false);
			lblNewLabel_7.setVisible(false);
			lblNewLabel_8.setVisible(false);
			textField_6.setVisible(false);
			textField_7.setVisible(false);			
		}
		return per;
	}
}
