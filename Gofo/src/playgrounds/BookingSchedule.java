package playgrounds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * this class for book playground
 * Date:10-jun-2020
 * @author noura,eman,neimat,alaa
 * @version 1.0
 */
public class BookingSchedule {
/**
 * array list for booking slot of playground
 */
	private ArrayList<BookingSlot> slots;
/**
 * function to read booking slot from file
 */
	public void loadSchedule()
	{
		try {
            FileInputStream fis = new FileInputStream("Schedule.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            slots=(ArrayList<BookingSlot>)ois.readObject();
            ois.close();
            fis.close();
            } catch (IOException e1) {
            slots=new ArrayList<BookingSlot>();					
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * function to store booking slot in file
	 */
	public void storeSchedule()
	{
	      try{
	          FileOutputStream fos= new FileOutputStream("Schedule.bin");
	          ObjectOutputStream oos= new ObjectOutputStream(fos);
	          oos.writeObject(slots);
	          oos.close();
	          fos.close();
	        }catch(IOException ioe){
	             ioe.printStackTrace();
	         }
	}
/**
 * function to add slot of playground
 * @param s is an object of class BookingSlot to add in array list
 */
	public void addSlot(BookingSlot s) {
		slots.add(s);
	}

	/**
	 * 
	 * function to remove slot of playground
	 * @param bs is an object of class BookingSlot to remove in array list
	 */
	public void removeSlot(BookingSlot bs) {
		// TODO - implement BookingSchedule.removeSlot
		throw new UnsupportedOperationException();
	}

	/**
	 * function to change slot status
	 * @param bs is an object from BookingSlot class
	 * @param s boolean value to express about if slots status is changed or not
	 */
	public void changeSlotStatus(BookingSlot bs, boolean s) {
		// TODO - implement BookingSchedule.changeSlotStatus
		throw new UnsupportedOperationException();
	}
/**
 * default constructor
 */
	public BookingSchedule() {
		loadSchedule();
	}
/**
 * function to get all slots i added to array list  
 * @return slots (slots with its information)
 */
	public ArrayList<BookingSlot> getSlots() {
		return slots;
	}
/**
 * function to set slots of playground in array list
 * @param slots is an object from array list to set slots in it
 */
	public void setSlots(ArrayList<BookingSlot> slots) {
		this.slots = slots;
	}
}