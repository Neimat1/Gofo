package playgrounds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * this class for playgrounds
 * Date:10-jun-2020
 * @author noura,eman,neimat,alaa
 * @version 1.0
 *
 */
public class Playgrounds {
	/**
	 * array list to add Playground
	 */
	private ArrayList<Playground> lst=new ArrayList<Playground>();
	/**
	 * default constructor
	 */
	public Playgrounds()
	{
		loadPlaygrounds();
	}
	/**
	 * function to read playgrounds from file
	 */
	public void loadPlaygrounds()
	{
		try {
            FileInputStream fis = new FileInputStream("Playgrounds.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst=(ArrayList<Playground>)ois.readObject();
            ois.close();
            fis.close();
            } catch (IOException e1) {
			lst=new ArrayList<Playground>();					
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * function to store playgrounds in file
	 */
	public void storePlaygrounds()
	{
	      try{
	          FileOutputStream fos= new FileOutputStream("Playgrounds.bin");
	          ObjectOutputStream oos= new ObjectOutputStream(fos);
	          oos.writeObject(lst);
	          oos.close();
	          fos.close();
	        }catch(IOException ioe){
	             ioe.printStackTrace();
	         }
	}
	/**
	 * function to get all playgrounds i added to array list
	 * @return  1st (playground with its information)
	 * 
	 */
	public ArrayList<Playground> getList()
	{
		return lst;
	}
	/**
	 * function to check if array list is empty or not
	 * @return 1st ( removed playground from array list)
	 */
	
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	/**
	 * function of arraylist's size
	 * @return size of array list
	 * 
	 */
	public int size()
	{
		return lst.size();
	}
	/**
	 * function to add playground in array list
	 * @param pgnd is an object from playground class to add playgrounds in array list
	 */
	public void add(Playground pgnd)
	{
		lst.add(pgnd);
	}
	/**
	 * function to find Playground By entered its ID
	 * @param ID is playground's ID
	 * @return a playground of entered ID
	 */
	public int findPlaygroundByID(int ID)
	{
		int i=0;
		for(Playground pgnd:lst)
		{
			if(pgnd.getPlaygroundID()==ID)
			{
				return i;
			}else i++;
		}
		return i;
	}
	/**
	 * function to set playground
	 * @param index is the index of playground in array list
	 * @param pgnd is an object from playground class 
	 */
	public void set(int index, Playground pgnd)
	{
		lst.set(index, pgnd);
	}
	/**
	 * function to get playground
	 * @param index is the index of playground in array list
	 * @return returning playground with its index
	 */
	public Playground get(int index)
	{
		return lst.get(index);
	}
}
