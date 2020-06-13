import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import persons.Person;
import persons.Persons;
import playgrounds.BookingSchedule;
import playgrounds.BookingSlot;
import playgrounds.Playground;
import playgrounds.Playgrounds;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
/**
 * this class for Booking Schedule Form and it inherit from frame
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BookingScheduleForm extends JFrame {
/**
 * JPanel to display all components on a frame
 */
	private JPanel contentPane;
	/**
	 * details of BookingScheduleForm
	 */
	String[] header= {"Date","Start time","End Time","Player Name"};
	private DefaultTableModel model=new DefaultTableModel();
	/**
	 * table to show BookingScheduleForm
	 */
	private JTable table=new JTable(model);

	/**
	 * function to Create the frame of BookingSchedule 
	 * @param per is an object from class Person
	 */
	public BookingScheduleForm(Person per) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Playgrounds");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 23, 82, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		Vector<Integer> indeces=new Vector<Integer>();
		Playgrounds plst=new Playgrounds();
		for(int i=0;i<plst.size();i++)
		{
			Playground pgnd=plst.get(i);
			if(pgnd.getPlaygroundOwnerID()==per.getID())
			{
				comboBox.addItem(pgnd.getPlaygroundName());
				indeces.addElement(i);
			}
		}
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(119, 22, 146, 20);	
		contentPane.add(comboBox);
		
		table.setBounds(29, 97, 342, 153);
		model.addColumn("Date");
		model.addColumn("Start time");
		model.addColumn("End time");
		model.addColumn("Player name");
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Show schedule");
		btnNewButton.setBounds(289, 21, 108, 23);
		btnNewButton.addActionListener(new ActionListener() {
		BookingSchedule sc=new BookingSchedule();
		Persons pers=new Persons();
		/**
		 * to action listener with the buttons
		 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getItemCount()==0)return;
				Playground pgnd=plst.get(indeces.elementAt(comboBox.getSelectedIndex()));
				
				for(BookingSlot slot:sc.getSlots())
				{
					if(slot.getPlaygroundID()==pgnd.getPlaygroundID())
					{
						Vector<String> dat=new Vector<String>();
						dat.add(String.valueOf(slot.getSlotDate()));
						dat.add(String.valueOf(slot.getStartTime()));
						dat.add(String.valueOf(slot.getEndTime()));
						Person per=pers.findPersonByID(slot.getPlayerID());
						dat.add(per.getName());
						model.addRow(dat);
					}
				}
			}
			
		});
		contentPane.add(btnNewButton);
	}
}
