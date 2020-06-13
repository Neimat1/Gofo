import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import playgrounds.AvailabilityStatus;
import playgrounds.Playground;
import playgrounds.Playgrounds;
/**
 * this class for approve Playground
 * * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class ShowAdminApprove{
	
	private JFrame frame=new JFrame();
	/**
	 * combo box to select from it
	 */
	private JComboBox<String> combo1 ;
	/**
	 * button named APProve 
	 */
	private JButton btn=new JButton("APProve");
	/**
	 * function to approve playground that playground owner added and  this approve made by admin 
	 */
	
	public ShowAdminApprove()
	{
		combo1=new JComboBox<String>();
		Vector<Integer> indeces=new Vector<Integer>();
		Playgrounds play=new Playgrounds();
		for(int i=0;i<play.size();i++)
		{
			Playground playi=play.get(i);
			if(playi.getPlaygroundAvailbility().equals((AvailabilityStatus.SUSPENDED)))
			{
				combo1.addItem(playi.getPlaygroundName());
				indeces.add(i);
			}
		}
		frame.add(combo1);
	    combo1.setBounds(100, 10, 150, 20);
	    frame.add(btn);
	    btn.setBounds(100, 40, 150, 20);	    
	    
	    btn.addActionListener(new ActionListener() {
	    	/**
	    	 * to action listener with the buttons
	    	 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(combo1.getItemCount()==0)return;
				int index=indeces.get(combo1.getSelectedIndex());
				play.get(index).setPlaygroundAvailbility(AvailabilityStatus.ACTIVE);
				play.storePlaygrounds();
				indeces.removeElementAt(combo1.getSelectedIndex());
				combo1.removeItemAt(combo1.getSelectedIndex());
				JOptionPane.showMessageDialog(null,AvailabilityStatus.ACTIVE ,"APProve_PLayground", JOptionPane.INFORMATION_MESSAGE);
			}
	    });
		frame.setTitle("APProve_PLayground");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400,200);	
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
