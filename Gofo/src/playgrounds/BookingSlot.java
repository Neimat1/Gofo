package playgrounds;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@SuppressWarnings("serial")
/**
 * this class for booking slot
 * Date:10-jun-2020
 * @author noura,eman,neimat,alaa
 * @version: 1.0 
 */
public class BookingSlot implements Serializable{
/**
 *  Date value for the first attribute
 */
	private Date slotDate;
	/**
	 * LocalTime value for the second attribute
	 */
	private LocalTime startTime;
	/**
	 * LocalTime value for the third attribute
	 */
	private LocalTime endTime;
	/**
	 * boolean value for the forth attribute
	 */
	private boolean status;
	/**
	 * int value for the fifth attribute
	 */
	private int playerID;
	/**
	 * int value for the first attribute
	 */
	private int playgroundID;
/**
 *  This method to get slotDate value.      
 * @return returning date value (slotDate)
 */
	public Date getSlotDate() {
		return this.slotDate;
	}

	/**
	 *  This method to set certain value to slotDate (attribute).
	 * @param slotDate is setter value to set in slotDate.
	 */
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
/**
 *  This method to get startTime value.      
 * @return returning LocalTime  value (booking startTime)
 */
	public LocalTime getStartTime() {
		return this.startTime;
	}

	/**
	 * This method to set certain value to startTime  (attribute).
	 * @param startTime is setter value to set in startTime.
	 */
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
/**
 *  This method to get endTime value.      
 * @return returning LocalTime value (booking endTime)
 */
	public LocalTime getEndTime() {
		return this.endTime;
	}

	/**
	 * This method to set certain value to endTime (attribute). 
	 * @param endTime is setter value to set in endTime.
	 */
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
/**
 *  This method to get status value.      
 * @return returning boolean value (playground's status)
 */
	public boolean getStatus() {
		return this.status;
	}

	/**
	 * This method to set certain value to status (attribute).
	 * @param status is setter value to set in status.
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
/**
 *  This method to get playerID value.      
 * @return returning int value (playerID)
 */
	public int getPlayerID() {
		return playerID;
	}
/**
 * This method to set certain value to playerID (attribute).
 * @param playerID is setter value to set in playerID.
 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
/**
 *  This method to get playgroundID value.      
 * @return returning int value (playground ID)
 */
	public int getPlaygroundID() {
		return playgroundID;
	}
/**
 * This method to set certain value to playgroundID (attribute). 
 * @param playgroundID is setter value to set in playgroundID.
 */
	public void setPlaygroundID(int playgroundID) {
		this.playgroundID = playgroundID;
	}
}