import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
/**
 * this class for VerificationCode to make person regist sucessfully 
 *  Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")

public class VerificationCodeDlg extends JDialog {
	/**
	 * JPanel to display all components on a frame
	 */
	private JPanel contentPane;
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;
	/**
	 * boolean value for Verification Code
	 */
	boolean correct=false;
	/**
	 * function to check if Verification Code is right or not
	 * @return returning boolean value
	 */
	public boolean isCorrect()
	{
		return correct;
	}
	/**
	 * Create the frame.
	 */
	/**
	 * this function to VerificationCode 
	 * @param email email that person entered in SignUp form
	 */
	public VerificationCodeDlg(String email) {
		Random rnd=new Random();	
		String genCode=String.valueOf(1000+rnd.nextInt(8999));
		MailUtil.sendEmail(email, "Gofo account verification","Your verification code is:"+genCode);
		setModal(true);
		setTitle("Enter The Verification Code");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Verification Code");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 71, 131, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(186, 73, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Verify");
		btnNewButton.setBounds(142, 120, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
/**
 * to action listener with the buttons
 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(genCode.equals(textField.getText()))
						{
						correct=true;
						dispose();
						}
				else
						JOptionPane.showMessageDialog(null,"Error in verification code");
							
			}
		}
				);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

}
