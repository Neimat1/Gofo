import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import persons.Person;
import persons.Persons;
import playgrounds.AvailabilityStatus;
import playgrounds.BookingSchedule;
import playgrounds.BookingSlot;
import playgrounds.Playground;
import playgrounds.Playgrounds;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * this is a gui for  BookingPlayground class
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class BookingPlayground extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * combobox to select from it
	 */
	JComboBox<String> comboBox; 
	/**
	 * JTextField to enter text
	 */
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * 1st is object from Playgrounds class
	 */
	Playgrounds lst=new Playgrounds();
	/**
	 * pgnd is an object from Playground class and set it to null
	 */
	Playground pgnd=null;
/**
 * per is an object from Person class
 */
	Person per;
	/**
	 * slot is an object from BookingSlot class
	 */
	BookingSlot slot=new BookingSlot(); 
	/**
	 * Double attribute (cost) and it set to zero
	 */
	double cost=0;
	/**
	 * function to Compute Cost of booking the playground
	 * 
	 * @return returning double value (cost of booking playground )
	 */
	double ComputeCost()
	{
		if(pgnd==null)pgnd=lst.get(comboBox.getSelectedIndex());
		try {
			slot.setStartTime(LocalTime.parse(textField_1.getText(), DateTimeFormatter.ISO_LOCAL_TIME));
			slot.setEndTime(LocalTime.parse(textField_2.getText(), DateTimeFormatter.ISO_LOCAL_TIME));
			double z=(double)(slot.getEndTime().toSecondOfDay()-slot.getStartTime().toSecondOfDay())/3600;
			double cost=z*pgnd.getPlaygroundPrice();
			textField_3.setText(String.valueOf(cost));
			return cost;
			
		}catch(Exception e)
		{
			return 0;
		}
		
	}
	
	/**
	 * this function of  Booking Playground and check if its AvailabilityStatus
	 * @param per is an object from person class
	 */
	public BookingPlayground(Person per) {
		this.per=per;
		setTitle("Booking Playground");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox= new JComboBox<String>();
		JLabel lblNewLabel = new JLabel("Playground");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 27, 78, 19);
		contentPane.add(lblNewLabel);
		comboBox = new JComboBox<String>();
		Vector<Integer> indeces=new Vector<Integer>(); 
		for(int i=0;i<lst.size();i++)
		{
			Playground pg=lst.get(i);
			if(pg.getPlaygroundAvailbility()==AvailabilityStatus.ACTIVE)
			{
				comboBox.addItem(pg.getPlaygroundName());
				indeces.addElement(i);
			}
		}
			
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setToolTipText("");
		comboBox.setBounds(144, 28, 114, 20);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				pgnd=lst.get(indeces.get(comboBox.getSelectedIndex()));
		    }			
		});
		contentPane.add(comboBox);
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(20, 74, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(144, 73, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Start Time");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 118, 69, 14);
		contentPane.add(lblNewLabel_2);
	
		textField_1 = new JTextField();
		textField_1.setBounds(144, 117, 114, 20);
		textField_1.getDocument().addDocumentListener(new DocumentListener(){
			  @Override
			 
			   public void insertUpdate(DocumentEvent e) {
				  cost=ComputeCost();
			   }

			   @Override
			   public void removeUpdate(DocumentEvent e) {
					  cost=ComputeCost();
			   }

			   @Override
			   public void changedUpdate(DocumentEvent e) {
					  cost=ComputeCost();
			   } 
		});
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("End Time");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 165, 69, 14);
		contentPane.add(lblNewLabel_3);
		textField_2 = new JTextField();
		textField_2.setBounds(144, 164, 114, 20);
		textField_2.getDocument().addDocumentListener(new DocumentListener(){
			  @Override
			   public void insertUpdate(DocumentEvent e) {
				  cost=ComputeCost();
			   }

			   @Override
			   public void removeUpdate(DocumentEvent e) {
				   cost=ComputeCost();
			   }
			   @Override
			   public void changedUpdate(DocumentEvent e) {
				   cost=ComputeCost();
			   } 
		});
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 *to action listener with the buttons
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pgnd==null)
					return;
				slot.setPlaygroundID(pgnd.getPlaygroundID());
				slot.setPlayerID(per.getID());
				SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);
				try {
				slot.setSlotDate(df.parse(textField.getText()+" "+textField_1.getText()));
				}catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,er.getMessage());
					textField.requestFocusInWindow();
					return;
				}
				BookingSchedule bs=new BookingSchedule();
				bs.addSlot(slot);
				bs.storeSchedule();
				per.removeFromWallet(cost);
				int ownerid=pgnd.getPlaygroundOwnerID();
				Persons pers=new Persons();
				pers.findPersonByID(ownerid).addToWallet(cost);
				pers.storePersons();
				JOptionPane.showMessageDialog(null,"You've booked successfully");
				dispose();
			}
			
		});
		btnNewButton.setBounds(230, 258, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(20, 258, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Total Price");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 207, 78, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(144, 206, 114, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
