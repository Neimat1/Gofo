package persons;

import java.sql.Time;
import java.util.Date;

import playgrounds.BookingSlot;
import playgrounds.Playground;

@SuppressWarnings("serial")
/**
 * this class to implement all methods that player want to do and it inherit from class person
 * Date : 10-jun-2020
 * @author noura
 * @version 1.0
 *
 */
public class Player extends Person {
/**
 * function to update profile
 */
	public void updateProfile() {
		// TODO - implement Player.updateProfile
		throw new UnsupportedOperationException();
	}
/**
 * function to show playgrounds of playground owner
 */
	public void showPlaygrounds() {
		// TODO - implement Player.showPlaygrounds
		throw new UnsupportedOperationException();
	}

	/**
	 * function to  book a playground slot 
	 * @param s for set a booking slot 
	 */
	public void bookAPlaygroundSlot(BookingSlot s) {
		// TODO - implement Player.bookAPlaygroundSlot
		throw new UnsupportedOperationException();
	}

	/**
	 * function to calculate price of booked playground  
	 * @param p booked playground 
	 * @param d date of booked playground
	 * @param t time of booked playground
	 */
	public double calculatePrice(Playground p, Date d, Time t) {
		// TODO - implement Player.calculatePrice
		throw new UnsupportedOperationException();
	}
/**
 * function to cancel booking
 */
	public void cancleBooking() {
		// TODO - implement Player.cancleBooking
		throw new UnsupportedOperationException();
	}
/**
 * function to invite team
 */
	public void inviteTeam() {
		// TODO - implement Player.inviteTeam
		throw new UnsupportedOperationException();
	}
/**
 * function to create team
 */
	public void createTeam() {
		// TODO - implement Player.createTeam
		throw new UnsupportedOperationException();
	}
/**
 * function to view playing slots
 */
	public void viewPlayingSlots() {
		// TODO - implement Player.viewPlayingSlots
		throw new UnsupportedOperationException();
	}

}