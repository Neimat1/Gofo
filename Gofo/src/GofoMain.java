
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import persons.Person;
import persons.Persons;
/**
 * this is first page of program and sign in
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 */

@SuppressWarnings("serial")

public class GofoMain extends JFrame implements ActionListener {

	/**
	 * this is a function GofoMain
	 * @param args array of string arguments
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new GofoMain();
	}
	
/**
 * grid system of the page
 */
	JPanel pan=new JPanel(new GridBagLayout()); 
	/**
	 * label for email and TextField to enter email
	 */
	
	JLabel lbl1=new JLabel ("Email: ");
	JTextField tf1=new JTextField (20); //the user enter the email
	/**
	 * label for Password and TextField to enter Password
	 */
	JLabel lbl2=new JLabel ("Password: ");
	JPasswordField tf2=new JPasswordField (20);//the user enter the password
	/**
	 * buttons for sign in and sign up and cancel
	 */
	JButton btn1=new JButton("Cancel");
	JButton btn2=new JButton("Sign in");
	JButton btn3=new JButton("Sign up");
	/**
	 * function to addAdmin of program
	 */
	void  addAdminIfNotThere()
	{
		/**
		 * take object from class Persons
		 */
		Persons lst=new Persons();
		boolean found=false;
		/**
		 * for loop to add person who entered his role as admin in the list
		 */
		for(Person per:lst.getList())
		{
			if(per.getRole()==Person.Role.ADMIN)
			{
				found=true;
				break;
			}
		}
		if(found)return;
		/**
		 * take per as object from class Person
		 */
		Person per=new Person();
		try {
			per.setEmail("GofoProject2020@gmail.com");
			per.setPassword("admin");
			per.setRole(Person.Role.ADMIN);
			lst.add(per);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lst.storePersons();
	}
	
	/**
	 * for creation the page of sign  with gui
	 */
	public GofoMain()
	{
		pan.setBackground(Color.lightGray);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        /**
         * to add the labels and PasswordField and buttons to the frame or page 
         */
        constraints.gridx = 0;
        constraints.gridy = 0;     
        pan.add(lbl1, constraints);
        constraints.gridx = 1;
        pan.add(tf1, constraints);
       constraints.gridx = 0;
        constraints.gridy = 1;     
        pan.add(lbl2, constraints); 
        constraints.gridx = 1;
        pan.add(tf2, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
//        constraints.gridwidth = 2;
       constraints.anchor = GridBagConstraints.CENTER;
        pan.add(btn1, constraints);
        constraints.gridx = 1;
 //       constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        pan.add(btn2, constraints);
        constraints.gridx = 2;
 //       constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        pan.add(btn3, constraints);
        
         
        /**
         *  set border for the panel
         */
        pan.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Gofo Login"));
        this.add(pan);
        pack();
        setLocationRelativeTo(null);
        /**
         * to visible the sign in page for user 
         */
		this.setVisible(true); 
		addAdminIfNotThere();
	}

	/**
	 *  to action listener with the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn1)) //if the user press cancel close the sign in page
		{
			 JComponent comp = (JComponent) e.getSource();
			  Window win = SwingUtilities.getWindowAncestor(comp);
			  win.dispose();
		}
		/**
		 * if the user press sign in the user added to the list of persons
		 */
		
		else if(e.getSource().equals(btn2)) 
		{
		
			Persons lst=new Persons();			
			Person per=lst.findPersonByEmail(tf1.getText(), String.valueOf(tf2.getPassword()));
			lst.deletearr();
			if(per==null)
				JOptionPane.showMessageDialog(null, "Error in user name or password", "Error " , JOptionPane.INFORMATION_MESSAGE);
		   
			else {
				 /**
				 * if the role is player 
				 */
				    if(per.getRole()==Person.Role.PLAYER)
					new PlayerMenu(per);
				/**
				 * if the role is playground owner
				 */
				else if(per.getRole()==Person.Role.PLAYGROUNDOWNER)
					new PlaygroundOwnerMenu(per);
				else if(per.getRole()==Person.Role.ADMIN)
				{
					Administrator admin=new Administrator(per);
					admin.setVisible(true);
				}	
			}
	}
		
		/**
		 * if the user press sign up the signup is opened
		 */
		else if(e.getSource().equals(btn3))
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new SignUp();						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
