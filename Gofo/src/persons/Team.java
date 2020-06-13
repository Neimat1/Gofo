package persons;

import java.io.Serializable;
import java.util.Vector;

@SuppressWarnings("serial")
/**
 * this class for team
 * Date:10-jun-2020
 * @author noura, eman,neimat,alaa
 * @version 1.0
 */
public class Team implements Serializable {
/**
 * Int value for the first attribute
 */
	private int ID;
	/**
	 * String value for the second attribute
	 */
	private String name;
	/**
	 * vector to store team's member in it
	 */
	private Vector<Integer> members=new Vector<Integer>();
/**
 * * This method to get name value.      
 * @return returning string value (team's member name)
 * 
 */
		public String getName() {
		return this.name;
	}

	/**
	 * This method to set certain value to name (attribute).
     * @param name is setter value to set in name.
	
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method to add player in team
	 * @param pID is  player ID i want to add in team
	 */
	public void addPlayer(int pID) {
		members.add(pID);
	}

	/**
	 * this method to remove player from team
	 * @param p is player i want to remove from team
	 */
	public void removePlayer(Player p) {
		// TODO - implement Team.removePlayer
		throw new UnsupportedOperationException();
	}
/**
 * constructor for class team
 */
	public Team() {

	}
/**
 * function to get team's member from vector
 * @return returning team's members
 */
	public Vector<Integer> getMembers() {
		return members;
	}
/**
 * This method to set certain value to members (attribute).
 * @param members is setter value to set in members
 */
	public void setMembers(Vector<Integer> members) {
		this.members = members;
	}
/**
 * This method to get ID value.      
 * @return returning int value (member's ID)
 * 
 */
	public int getID() {
		return ID;
	}
/**
 *  This method to set certain value to iD (attribute).
 * @param iD is setter value to set in iD
 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * function to check if player is member in team or not
	 * @param id is the member's id
	 * @return boolean value express  if player is member in team or not
	 */
    public boolean isAMember(int id)
    {
    	for(int p:members)
    	{
    		if(p==id)return true; 
    	}
    	return false;
    }
}