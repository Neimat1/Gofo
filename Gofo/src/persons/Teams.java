package persons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * this class for team
 * Date:10-jun-2020
 * @author noura,eman,neimat,alaa
 * @version 1.0
 */
public class Teams {
	/**
	 * array list of team members
	 */
	private ArrayList<Team> lst=new ArrayList<Team>();
	/**
	 * default constructor
	 */
	public Teams()
	{
		loadTeams();
	}
	/**
	 * function to read from file
	 */
	public void loadTeams()
	{
		try {
            FileInputStream fis = new FileInputStream("Teams.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lst=(ArrayList<Team>)ois.readObject();
            ois.close();
            fis.close();
            } catch (IOException e1) {
			lst=new ArrayList<Team>();					
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * function to store team's members in file
	 */
	public void storeTeams()
	{
	      try{
	          FileOutputStream fos= new FileOutputStream("Teams.bin");
	          ObjectOutputStream oos= new ObjectOutputStream(fos);
	          oos.writeObject(lst);
	          oos.close();
	          fos.close();
	        }catch(IOException ioe){
	             ioe.printStackTrace();
	         }
	}
	/**
	 * this function to get team's members from array list
	 * @return 1st (member index with its information)
	 */
	public ArrayList<Team> getList()
	{
		return lst;
	}
	/**
	 * function to check if array list is empty or not
	 * @return 1st ( removed member from array list)
	 * 
	 */
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	/**
	 * this function of size of array list
	 * @return 1st.size (size of members in array list )
	 */
	public int size()
	{
		return lst.size();
	}
	/**
	 * function to add team
	 * @param team is object from class Team  to add team in array list
	 */
	public void add(Team team)
	{
		lst.add(team);
	}
	/**
	 * function to get team
	 * @param index is the index of  member in team
	 * @return 1st (team member i want)
	 */
	public Team get(int index)
	{
		return lst.get(index);
	}
	/**
	 * function to find team by id
	 * @param ID of the team
	 * @return tm (team i entered its ID)
	 */
	public Team findTeamByID(int ID)
	{
		for(Team tm:lst)
		{
			if(tm.getID()==ID)
			{
				return tm;
			}
		}
		return null;
	}
}
