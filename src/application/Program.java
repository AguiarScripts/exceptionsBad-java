package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkIn)) {
			System.out.println("Erro, a data de checkout tem que ser depois de checkin oh animal");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation:oh burro tem que ser no futuro");
			}
			else if (!checkout.after(checkIn)) {
				System.out.println("Erro, a data de checkout tem que ser depois de checkin oh animal jegue"); 
			}
			else {
			
			
			reservation.updateDates(checkIn, checkout);
			System.out.println("Reservation: " + reservation);
			}
		}
		
		
		
		sc.close();
	}

}
