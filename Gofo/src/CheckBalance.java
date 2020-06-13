import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persons.Person;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
/**
 * class to CheckBalance of player or playground owner
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class CheckBalance extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;

	/**
	 * function to Create the frame of CheckBalance of ewallet it appear my balance
	 * @param per is an object from class Person
	 */
	public CheckBalance(Person per) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your balance is :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(43, 99, 109, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(174, 98, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(per.getEwalletAmount()));
	}
}
