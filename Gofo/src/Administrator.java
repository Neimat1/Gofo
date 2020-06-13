import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persons.Person;

import javax.swing.JLabel;
import javax.swing.JButton;
/**
 * this is class Administrator class
 * Date:10-june-2020
 * @author Eman,noura, alaa,neimat
 * @version 1.0
 * 
 *
 */

@SuppressWarnings("serial")
public class Administrator extends JFrame implements ActionListener {

	private JPanel contentPane;
	/**
	 * label named Hello_admin
	 */
	private JLabel label=new JLabel("Hello_admin");
	/**
	 * object from class person
	 */
	Person per;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame for admin page
	 * @param per is an object from person class to set admin details
	 */
	public Administrator(Person per) {
		this.per=per;
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label.setBounds(50,10, 131, 30);
		
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Update Info");
		btnNewButton.setBounds(146, 48, 131, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("Approve Playground");
		btnNewButton_1.setBounds(146, 88, 131, 30);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		
		JButton btnNewButton_2 = new JButton("Suspend Playground");
		btnNewButton_2.setBounds(146, 128, 131, 30);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		
		
		JButton btnNewButton_3 = new JButton("Delete Playground");
		btnNewButton_3.setBounds(146, 168, 131, 30);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
	
		
	}


	@Override
	/**
	 * to action listener with the buttons
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Update Info")
		{
			new SignUp(per);
		}
		if(e.getActionCommand()=="Approve Playground")
		{
			
			 new ShowAdminApprove();		
		}
		if(e.getActionCommand()=="Suspend Playground")
		{
			 new ShowAdminSuspend();
		}
		if(e.getActionCommand()=="Delete Playground")
		{

                   new ShowAdminDelete();
		}
		
	}

}
