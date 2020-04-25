package com.company;

import java.io.WriteAbortedException;
import java.text.ParseException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException, WriteAbortedException {

        Scanner sc = new Scanner(System.in);
        int choice=-1;
        //HotelController.createHotel();
        //HotelController.displayAllRooms();

//        System.out.println("Welcome to Hotel California!\n\n");
//        while(choice!=100){
//            System.out.println("1. Create/Update/Search guest details: ");
//            System.out.println("2. Create/Update/Remove/Print a reservation: ");
//            System.out.println("3. Create/Update rooms details (include setting status like ‘Under Maintenance");
//            System.out.println("4. Place an order for room-service: ");
//            System.out.println("5. Create/Update/Remove room service menu items. ");
//            System.out.println("6. Check room availability: ");
//            System.out.println("7. Check In Guest");
//            System.out.println("8. Check In for prior reservation: ");
//            System.out.println("9. Check out and Bill invoice: ");
//            System.out.println("10. Print room statistics report: ");
//
//
//            System.out.print("Enter your choice: (Press 100 to exit)");
//            choice = Integer.parseInt(sc.nextLine());
//
//
//            if(choice==100) {
//                break;
//            }
//            switch(choice) {
//                case 1:
//                    System.out.println("Create/Update/Search guests detail (Search by name using keyword/s) ");
//                    GuestBoundary.enterGuest();
//                    break;
//                case 2:
//                    System.out.println("Create/Update/Remove/Print reservation");
//                    ReservationBoundary.enterReservation();
//                    break;
//                case 3:
//                    System.out.println("Create/Update rooms details (include setting status like ‘Under Maintenance");
//                    HotelBoundary.enterHotel();
//                    break;
//                case 4:
//                    System.out.println("Entering room service orders - list menu items for selection \n");
//                    RoomServiceBoundary.enterRoomService();
//                    break;
//                case 5:
//                    System.out.println("Create/Update/Remove room service menu items.");
//                    MenuBoundary.enterMenu();
//                    break;
//                case 6:
//                    System.out.println("Room availability");
//                    HotelController.displayAllVacantRoomNumbers();
//                    break;
//                case 7:
//                    System.out.println("Room reserving (for walk-in or reservation)");
//                    ReservationController.createReservationWalkIn();
//                    break;
//                case 8:
//                    System.out.println("Please enter the reservation Id of your booking:");
//                    int reservationId = sc.nextInt();
//                    ReservationController.checkInForReserved(reservationId);
//                    break;
//                case 9:
//                    System.out.println("Please enter the reservation Id: ");
//                    reservationId = sc.nextInt();
//                    ReservationController.checkOutOfHotel(reservationId);
//                    break;
//                case 10:
//                    HotelController.printRoomStatisticsReport();
//                    break;
//                default:
//                    System.out.println("Please choose correctly!");
//
//            }
//            System.out.println("1. Create/Update/Search guest details: ");
//            System.out.println("2. Create/Update/Remove/Print a reservation: ");
//            System.out.println("3. Create/Update rooms details (include setting status like ‘Under Maintenance");
//            System.out.println("4. Place an order for room-service: ");
//            System.out.println("5. Create/Update/Remove room service menu items. ");
//            System.out.println("6. Check room availability: ");
//            System.out.println("7. Check In Guest");
//            System.out.println("8. Check In for prior reservation: ");
//            System.out.println("9. Check out and Bill invoice: ");
//            System.out.println("10. Print room statistics report: ");
//
//
//            System.out.print("Enter your choice: (Press 100 to exit)");
//            choice = Integer.parseInt(sc.nextLine());
//
//        }
//        sc.close();
    }
}
