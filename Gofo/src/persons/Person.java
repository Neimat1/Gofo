package persons;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * this class to make Sign in  , sign up ,create my profile
 * Date:10-jun-2020
 * @author noura,eman,alaa,neimat
 * @version 1.0
 *
 */


@SuppressWarnings("serial")

public class Person implements Serializable {
/**
 * enum for role
 */
	public enum Role {ADMIN,PLAYER,PLAYGROUNDOWNER};
	/**
	 * String value for the first attribute
	 */
	private String name;
	/**
	 * String value for the second attribute
	 */
	private String password;
	/**
	 * Int value for the third attribute
	 */
	private int ID;
	/**
	 * String value for the forth attribute
	 */
	private String email;
	/**
	 * String value for the fifth attribute
	 */
	private String phone;
	/**
	 * String value for the six attribute
	 */
	private String location;
	/**
	 * enum value for role attribute 
	 */
	private Role role;
	/**
	 * Int value for the eight attribute
	 */
	private int ewalletID;
	/**
	 * Double value for the ninth attribute
	 */
	private double ewalletAmount;
/**
 * function to create my profile
 */
	public void createMyProfile() {
		// TODO - implement Person.createMyProfile
		throw new UnsupportedOperationException();
	}
/**
 * function to log in
 */
	public void login() {
		// TODO - implement Person.login
		throw new UnsupportedOperationException();
	}
/**
 * function to sign up
 */
	public void signUp() {
		// TODO - implement Person.signUp
		throw new UnsupportedOperationException();
	}
/**
 * This method to get name value.      
 * @return returning string value (user's name)
 */
	public String getName() {
		return name;
	}
/**
 * This method to set certain value to name (attribute).
 * @param name is setter value to set in name.
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * This method to get password value.      
 * @return returning string value (user's password)
 */
	public String getPassword() {
		return password;
	}
/**
 * This method to set certain value to password (attribute).
 * @param password is setter value to set in password
 */
	public void setPassword(String password) {
		this.password = password;
	}
/**
 * This method to get ID value.      
 * @return returning int value (user's ID)
 * 
 */
	public int getID() {
		return ID;
	}
/**
 *  This method to set certain value to iD (attribute).
 *  @param iD is setter value to set in iD
 * 
 */
	public void setID(int iD) {
		ID = iD;
	}
/**
 * This method to get email value.      
 * @return returning string value (user's email)
 * 
 */
	public String getEmail() {
		return email;
	}
/**
 * function to set certain value to email (attribute) and check email is valid or not
 * @param email is setter value to set in email
 * @throws Exception
 */
	public void setEmail (String email) throws Exception {
		String ch="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern pattern = Pattern.compile(ch,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches())
		this.email = email;
		else
		{
			this.email = email;
			throw new Exception("Email is not correct");
		}
	}
/**
 * This method to get phone value.      
 * @return returning string value (user's phone)
 * 
 */
	public String getPhone() {
		return phone;
	}
/**
 *  This method to set certain value to phone (attribute).
 *  
 * @param phone is setter value to set in phone
 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
/**
 * This method to get location value.      
 * @return returning string value (user's location)
 */
	public String getLocation() {
		return location;
	}
/**
 * This method to set certain value to location (attribute).
 * @param location is setter value to set in location
 */
	public void setLocation(String location) {
		this.location = location;
	}
/**
 * This method to get role value.      
 * @return returning value from enum
 */
	public Role getRole() {
		return role;
	}
/**
 * This method to set certain value to role (attribute).
 * @param role is setter value to set in role
 */
	public void setRole(Role role) {
		this.role = role;
	}
/**
 * This method to get ewalletID value.      
 * @return returning int value (user's ewalletID)
 */
	public int getEwalletID() {
		return ewalletID;
	}
/**
 * This method to set certain value to ewalletID (attribute).
 * @param ewalletID is setter value to set in ewalletID
 */
	public void setEwalletID(int ewalletID) {
		this.ewalletID = ewalletID;
	}
/**
 * This method to get Ewallet Amount value.      
 * @return returning double value (user's Ewallet Amount)
 */
	public double getEwalletAmount() {
		return ewalletAmount;
	}
/**
 * This method to set certain value to ewalletAmount (attribute).
 * @param ewalletAmount is setter value to set in ewalletAmount
 */
	public void setEwalletAmount(double ewalletAmount) {
		this.ewalletAmount = ewalletAmount;
	}
	/**
	 * this method to add to user's ewallet
	 * @param amount to set amount  in ewalletAmount after adding
	 */
	public void addToWallet(double amount)
	{
		ewalletAmount+=amount;
	}
	/**
	 * this method to remove from user's ewallet
	 * @param amount to set amount in ewalletAmount after removing
	 */
	public void removeFromWallet(double amount)
	{
		ewalletAmount-=amount;
	}
}