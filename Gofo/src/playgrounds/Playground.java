package playgrounds;

import java.io.Serializable;

@SuppressWarnings("serial")
/**
 * this is playground class
 * Date:10-jun-2020
 * @author noura,eman,neimat,alaa
 * @version 1.0
 *
 */
public class Playground implements Serializable {
/**
 * String  value for the first attribute
 */
	private String playgroundName;
	/**
	 * int value for the second attribute
	 */
	private int playgroundID;
	/**
	 * String value for the third attribute
	 */
	private String playgroundLocation;
	/**
	 * Double value for the fourth attribute
	 */
	private double playgroundSize;
	/**
	 * float value for the fifth attribute
	 */
	private float playgroundHours;
	/**
	 * object from enum 
	 */
	private AvailabilityStatus playgroundAvailbility;
	/**
	 * Double value for the sixth attribute
	 */
	private double playgroundPrice;
	/**
	 * String value for the seventh attribute
	 */
	private String playgroundComplain;
	/**
	 * float value for the eigth attribute
	 */
	private float playgroundCanclePeriod;
	/**
	 * int value for the ninth attribute
	 */
	private int playgroundOwnerID;
	/**
	 * This method to get Playground name value.      
     * @return returning string value (Playground's name)
	 */
	public String getPlaygroundName() {
		return playgroundName;
	}
	/**
	 * This method to set certain value to Playground name (attribute).
	 * @param playgroundName is setter value to set in playgroundName.
	 */
	public void setPlaygroundName(String playgroundName) {
		this.playgroundName = playgroundName;
	}
	/**
	 * This method to get PlaygroundID value.      
     * @return returning int value (Playground ID)
	 */
	public int getPlaygroundID() {
		return playgroundID;
	}
	/**
	 * This method to set certain value to PlaygroundID (attribute).
	 * @param playgroundID is setter value to set PlaygroundID
	 */
	public void setPlaygroundID(int playgroundID) {
		this.playgroundID = playgroundID;
	}
	/**
	 * This method to get PlaygroundLocation value.      
     * @return returning string value (PlaygroundLocation)
	 */
	public String getPlaygroundLocation() {
		return playgroundLocation;
	}
	/**
	 * This method to set certain value to PlaygroundLocation (attribute).
     * @param playgroundLocation is setter value to set in PlaygroundLocation.
	 */
	public void setPlaygroundLocation(String playgroundLocation) {
		this.playgroundLocation = playgroundLocation;
	}
	/**
	 * This method to get PlaygroundSize value.      
     * @return returning double value (PlaygroundSize)
	 */
	public double getPlaygroundSize() {
		return playgroundSize;
	}
	/**
	 * This method to set certain value to playgroundSize (attribute).
	 * @param playgroundSize is setter value to set in playgroundSize.
	 */
	public void setPlaygroundSize(double playgroundSize) {
		this.playgroundSize = playgroundSize;
	}
	/**
	 * This method to get PlaygroundHours value.      
     * @return returning float value (PlaygroundHours)
	 */
	public float getPlaygroundHours() {
		return playgroundHours;
	}
	/**
	 * This method to set certain value to  playgroundHours (attribute).
	 * @param playgroundHours  is setter value to set in playgroundHours.
	 */
	public void setPlaygroundHours(float playgroundHours) {
		this.playgroundHours = playgroundHours;
	}
	/**
	 * This method to get PlaygroundAvailbility  from AvailabilityStatus class.      
     * @return returning string  value from enum (PlaygroundAvailbility)
	 */
	public AvailabilityStatus getPlaygroundAvailbility() {
		return playgroundAvailbility;
	}
	/**
	 * This method to set certain value to PlaygroundAvailbility (attribute).
	 * @param playgroundAvailbility is setter value to set in PlaygroundAvailbility.
	 */
	public void setPlaygroundAvailbility(AvailabilityStatus playgroundAvailbility) {
		this.playgroundAvailbility = playgroundAvailbility;
	}
	/**
	 * This method to get playgroundPrice value.      
     * @return returning double value (playgroundPrice)
	 */
	public double getPlaygroundPrice() {
		return playgroundPrice;
	}
	/**
	 * This method to set certain value to playgroundPrice (attribute). 
	 * @param playgroundPrice is setter value to set in playgroundPrice.
	 */
	public void setPlaygroundPrice(double playgroundPrice) {
		this.playgroundPrice = playgroundPrice;
	}
	/**
	 * This method to get playgroundComplain value.      
     * @return returning string value (playgroundComplain)
	 */
	public String getPlaygroundComplain() {
		return playgroundComplain;
	}
	/**
	 * This method to set certain value to playgroundComplain (attribute).
	 * @param playgroundComplain is setter value to set in playgroundComplain.
	 */
	public void setPlaygroundComplain(String playgroundComplain) {
		this.playgroundComplain = playgroundComplain;
	}
	/**
	 * This method to get playgroundCanclePeriod value.      
     * @return returning string value (playgroundCanclePeriod)
	 */
	public float getPlaygroundCanclePeriod() {
		return playgroundCanclePeriod;
	}
	/**
	 * This method to set certain value to playgroundCanclePeriod (attribute).
	 * @param playgroundCanclePeriod is setter value to set in playgroundCanclePeriod.
	 */
	public void setPlaygroundCanclePeriod(float playgroundCanclePeriod) {
		this.playgroundCanclePeriod = playgroundCanclePeriod;
	}
	/**
 	 * This method to get playgroundOwnerID value.      
     * @return returning int value (playgroundOwnerID)
	 */
	public int getPlaygroundOwnerID() {
		return playgroundOwnerID;
	}
	/**
	 * This method to set certain value to playgroundOwnerID (attribute).
	 * @param playgroundOwnerID  is setter value to set in playgroundOwnerID.
	 */
	public void setPlaygroundOwnerID(int playgroundOwnerID) {
		this.playgroundOwnerID = playgroundOwnerID;
	}

}