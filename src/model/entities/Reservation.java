package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkout) {
		if (!checkout.after(checkIn)) {
			throw new DomainException( "a data de checkout tem que ser depois de checkin oh animal jegue"); 
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkout) {
		Date now = new Date();
		if (checkIn.before(now) || checkout.before(now)) {
			throw new DomainException( "oh burro tem que ser no futuro");
		}
		if (!checkout.after(checkIn)) {
			throw new DomainException( "a data de checkout tem que ser depois de checkin oh animal jegue"); 
		}
		this.checkIn = checkIn;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber 
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}

}
