package persons;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * this class to add persons in array list and store it in file
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */
public class Persons {
	/**
	 * array list to add persons
	 */
	private ArrayList<Person> lst=new ArrayList<Person>();
	public Persons()
	{
		loadPersons();
	}
	/**
	 * function to read persons from file
	 */
	
	public void loadPersons()
	{
		try {
            FileInputStream fis = new FileInputStream("Persons.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst=(ArrayList<Person>)ois.readObject();
            ois.close();
            fis.close();
            } catch (IOException e1) {
			lst=new ArrayList<Person>();					
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * function to store persons in file
	 */
	public void storePersons()
	{
	      try{
	          FileOutputStream fos= new FileOutputStream("Persons.bin");
	          ObjectOutputStream oos= new ObjectOutputStream(fos);
	          oos.writeObject(lst);
	          oos.close();
	          fos.close();
	        }catch(IOException ioe){
	             ioe.printStackTrace();
	         }
	}
	/**
	 * function to get all persons i added to array list
	 * @return  1st (person with his information)
	 */
	public ArrayList<Person> getList()
	{
		return lst;
	}
	/**
	 * function to delete all elements from array list
	 */
	public void deletearr()
	{
		lst.removeAll(lst);
	}
	/**
	 * function to check if array list is empty or not
	 * @return 1st ( removed person from array list)
	 */
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	/**
	 * function of arraylist's size
	 * @return size of array list
	 */
	public int size()
	{
		return lst.size();
		
	}
	/**
	 * function to add person in array list
	 * @param per to add person in array list
	 */
	public void add(Person per)
	{
		lst.add(per);
	}
	/**
	 * function to find person by email and check his email is valid or not
	 * @param email to enter email
	 * @param pass to enter password
	 * @return a person of entered his email and pass
	 */
	public Person findPersonByEmail(String email, String pass)
	{
		String regex="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
		for(Person per:lst)
		{
			//JOptionPane.showMessageDialog(null, "ayhaga");
			if(per.getEmail().equals(email) && per.getPassword().equals(pass))
			{
				if( email.matches(regex))
				{
					return per;
				}
				
			}
			
		}
		return null;
	}
	/**
	 * function to find person by enter ID
	 * @param ID to eneter ID
	 * @return a person of entered ID
	 */
	public Person findPersonByID(int ID)
	{
		for(Person per:lst)
		{
			if(per.getID()==ID)
			{
				return per;
			}
		}
		return null;
	}
	/**
	 * function to get person from array list
	 * @param i for person
	 * @return a person from array list
	 */
	public Person get(int i) {
		// TODO Auto-generated method stub
		return lst.get(i);
	}
	/**
	 * function to update person's information in array list
	 * @param per
	 */
	public void updateElement(Person per) {
		for(int i=0;i<lst.size();i++)
			if(per.getID()==lst.get(i).getID())
			{
				lst.set(i, per);
				break;
			}
	}
}
