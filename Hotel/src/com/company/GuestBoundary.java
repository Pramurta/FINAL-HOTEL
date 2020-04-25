package com.company;
import java.util.Scanner;
import java.text.ParseException;

public class GuestBoundary {

	public static void enterGuest() throws ParseException {

		System.out.println("Choose to: \n 1 Update guest details \n 2 Search Guest details"
				+ "\n 3 Remove guest \n 4 Exit");
		Scanner sc = new Scanner(System.in);

		int decision = Integer.parseInt(sc.nextLine());
		while (decision != 4) {
			switch (decision) {
				case 1:
					GuestController.UpdateGuest();
					break;

				case 2:
					GuestController.searchGuest();
					break;

				case 3:
					GuestController.removeGuest();
					break;
				case 4:
					break;
				default:
					System.out.println("Enter a valid number");
			}
			System.out.println("Choose to: \n 1 Update guest details \n 2 Search Guest "
					+ "\n 3 Remove guest \n 4 Exit");
			decision = Integer.parseInt(sc.nextLine());
		}
	}
}

