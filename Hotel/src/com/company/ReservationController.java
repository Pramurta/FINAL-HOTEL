package com.company;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.io.File;
import java.util.List;
//
//public class ReservationController {
//    private static ArrayList<Reservation> reservations;
//
//    static {
//        reservations = new ArrayList<Reservation>();
//    }
//
//    public static ArrayList<Reservation> getReservations() {
//        return reservations;
//    }
//
//    /**
//     * finds reservation using String and then passes to findingreservation o find the reservation if found this method
//     * passes true otherwise it passes false and thats how this works
//     * @param guestName
//     * @return boolean
//     */
//
//    public static boolean reservationFindings(String guestName){
//        Reservation reservation;
//        // finding the reservations by name
//        reservation = findingReservationGuest(guestName);
//        if(reservation == null){
//            return false;
//        } else {
//            reservation.setReservationStatus(Reservation.ReservationStatus.CHECKEDIN);
//            reservationInfo(reservation);
//            return true;
//        }
//    }
//
//    /**
//     * @param reservation
//     * getting the information of the reservation and printing using a boundary class functions
//     */
//    private static void reservationInfo(Reservation reservation){
//        ArrayList<String> completeRoomNums = new ArrayList<String>();
//        for(Room room: reservation.getRooms()){
//            completeRoomNums.add(room.getCompleteRoomNumber());
//        }
//        ReservationBoundary.printingReservationDetails(completeRoomNums);
//    }
//
//    /**
//     * finds the reservation
//     * @param guestName
//     * @return Reservation
//     */
//
//    private static Reservation findingReservationGuest(String guestName){
//        for(Reservation reservation: reservations){
//            if(guestName.equals(reservation.getGuest().getName())){
//                return reservation;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Used to set up the reservation object and change the status also adds the reservation to the reservation
//     * array list
//     * @param numberofGuests
//     * @param guest
//     * @param room
//     * @param reservationId
//     */
//
//    public static void settingUpReservationObject(int numberofGuests, Guest guest, Room room, int reservationId, Date toDate,
//                                                  Date fromDate){
//        Reservation reservation = new Reservation();
//        reservation.setNumberOfGuestStaying(numberofGuests);
//        reservation.getRooms().add(room);
//        reservation.setReservationNumber(reservationId);
//        reservation.setGuest(guest);
//        reservation.setReservationStatus(Reservation.ReservationStatus.CONFIRMED);
//        reservation.setToDate(toDate);
//        reservation.setFromDate(fromDate);
//        getReservations().add(reservation);
//    }
//
//    public static void setReservations(ArrayList<Reservation> reservations) {
//        ReservationController.reservations = reservations;
//    }
//
//    public static Reservation findReservation(String completeRoomNum){
//        for(Reservation reservation: reservations){
//            for(Room room: reservation.getRooms()){
//                if(completeRoomNum.equals(room.getCompleteRoomNumber())){
//                    System.out.println("Reservation found");
//                    return reservation;
//                }
//            }
//        }
//        System.out.println("Room not checked in, please enter correct room number");
//        return null;
//    }
//
//
//
//
//}

public class ReservationController{
    public static void createReservationWalkIn() throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the reservation ID:");
        int reservationId = sc.nextInt();
        System.out.println("Please enter the details of the guest under whom the reservation will be made: ");
        Guest guest = GuestController.createGuest();
        Calendar cal = Calendar.getInstance();
//        Date fromDate = cal.getTime();
        sc.nextLine();
        System.out.println("Please enter the check-In date:(DD-MM-YYYY hh:mm:ss) ");
        String d = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date fromDate = format.parse(d);
        cal.setTime(fromDate);
        System.out.println("Please mention the length of your stay:");
        int dayStaying = sc.nextInt();
        cal.add(Calendar.DAY_OF_MONTH, dayStaying);
        Date toDate = cal.getTime();
        System.out.println("Enter the number of adults: ");
        int numberOfAdults = sc.nextInt();
        System.out.println("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();
        System.out.println("Please enter the number of rooms you would like to book: ");
        int numRoom = sc.nextInt();
        ArrayList<Integer> rNums=new ArrayList<Integer>();
        HotelController.displayAllVacantRoom();
        ArrayList<Room> roomsBooked = new ArrayList<Room>();
        for(int i=0;i<numRoom;i++){
            System.out.println("Please select the type of room for room "+(i+1)+"\n" +
                    "1. Single\n" +
                    "2. Double\n" +
                    "3. Deluxe\n" +
                    "4. VIP");
            int c = sc.nextInt();
            Room.RoomType roomType;
            if (c == 1) {
                roomType = Room.RoomType.SINGLE;
            } else if (c == 2) {
                roomType = Room.RoomType.DOUBLE;
            } else if (c == 3) {
                roomType = Room.RoomType.DELUXE;
            } else {
                roomType = Room.RoomType.VIP;
            }

            System.out.println("Please select the type of bed for room "+(i+1)+"\n" +
                    "1. Single\n" +
                    "2. Double\n" +
                    "3. Master");
            c = sc.nextInt();
            Room.BedType bedType = null;
            if (c == 1) {
                bedType = Room.BedType.SINGLE_BED;
            } else if (c == 2) {
                bedType = Room.BedType.DOUBLE_BED;
            } else if (c == 3) {
                bedType = Room.BedType.MASTER_BED;
            }

            System.out.println("Please select the facing view for room "+(i+1)+"\n" +
                    "1. City\n" +
                    "2. Sea\n" +
                    "3. Park\n" +
                    "4. Pool\n" +
                    "5. Mountain\n" +
                    "6. No View");
            c = sc.nextInt();
            Room.FacingView facingView = null;
            if (c == 1) {
                facingView = Room.FacingView.CITY_VIEW;
            } else if (c == 2) {
                facingView = Room.FacingView.SEA_VIEW;
            } else if (c == 3) {
                facingView = Room.FacingView.PARK_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.POOL_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.MOUNTAIN_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.NO_VIEW;
            }

            System.out.println("Should the room be WiFi enabled?(y/n)");
            boolean wifi;
            char w = sc.next().charAt(0);
            if(w=='y'){
                wifi=true;
            }
            else{
                wifi=false;
            }
            System.out.println("Should smoking be allowed in the room?(y/n)");
            boolean smoking;
            char s = sc.next().charAt(0);
            if(s=='y'){
                smoking=true;
            }
            else{
                smoking=false;
            }
            List roomList = FileIO.readSerializedObject("Hotel.dat");
            ArrayList<Room> availableRooms = HotelController.findRoomsForCheckInGuests(roomType,bedType,facingView,wifi,smoking);
            if(availableRooms!=null) {
                System.out.println("The rooms available are");
                for (int j = 0; j < availableRooms.size(); j++) {
                    Room r = (Room) availableRooms.get(j);
                    System.out.println("Room number: "+r.getRoomNumber());
                }
                System.out.println("Choose the room number: ");
                String rNum = sc.next();
                for(int k=0;k<availableRooms.size();k++){
                    Room r = (Room) availableRooms.get(k);
                    if(r.getRoomNumber().equals(rNum)){
                        roomsBooked.add(r);
                        r.setStatus(Room.RoomStatus.OCCUPIED);
                    }
                }
                for(int l=0;l<roomList.size();l++){
                    Room r = (Room) roomList.get(l);
                    if(r.getRoomNumber().equals(rNum)){
                        r.setStatus(Room.RoomStatus.OCCUPIED);
                        FileIO.writeSerializedObject("Hotel.dat",roomList);
                        break;
                    }
                }
            }
        }
        Reservation reservation = new Reservation(reservationId,guest,roomsBooked,numberOfAdults,numberOfChildren,fromDate,toDate, Reservation.ReservationStatus.CHECKEDIN);
        File file = new File("Reservation.dat");
        boolean exists = file.exists();
        if(exists){
            List list = FileIO.readSerializedObject("Reservation.dat");
            list.add(reservation);
            FileIO.writeSerializedObject("Reservation.dat",list);
        }
        else{
            List list = new ArrayList<Reservation>();
            list.add(reservation);
            FileIO.writeSerializedObject("Reservation.dat",list);
        }
    }

    public static void checkInForReserved(int reservationId){
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        Date date = new Date();
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getReservationNumber()==reservationId){
                long diff =date.getTime()-reservation.getFromDate().getTime();
                long diffHours = diff / (60 * 60 * 1000) % 24;
                if(diffHours>5){
                    System.out.println("Sorry! The reservation has expired.");
                    reservation.setReservationStatus(Reservation.ReservationStatus.EXPIRED);
                    GuestController.removeGuestByObject(reservation.getGuest());
                    for(int j=0;j<reservation.getRooms().size();j++){
                        Room room = (Room)reservation.getRooms().get(j);
                        room.setStatus(Room.RoomStatus.VACANT);
                        FileIO.writeSerializedObject("Hotel.dat",reservation.getRooms());
                    }
                    ReservationController.removeAReservation(reservation.getReservationNumber());
                }
                else{
                    System.out.println("Check-in successful!");
                    reservation.setReservationStatus(Reservation.ReservationStatus.CHECKEDIN);
                    for(int j=0;j<reservation.getRooms().size();j++){
                        Room room = (Room)reservation.getRooms().get(j);
                        room.setStatus(Room.RoomStatus.OCCUPIED);
                        FileIO.writeSerializedObject("Hotel.dat",reservation.getRooms());
                    }
                }
                FileIO.writeSerializedObject("Reservation.dat",reservationList);
            }
        }
    }



    public static void removeAReservation(int reservationId){
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getReservationNumber()==reservationId && reservation.getReservationStatus()== Reservation.ReservationStatus.CONFIRMED){
                GuestController.removeGuestByObject(reservation.getGuest());
                List roomList = FileIO.readSerializedObject("Hotel.dat");
                for(int j=0;j<reservation.getRooms().size();j++){
                    Room room = (Room)reservation.getRooms().get(j);
                    for(int k=0;k<roomList.size();k++){
                        Room r = (Room)roomList.get(k);
                        if(r.getRoomNumber().equals(room.getRoomNumber())){
                            r.setStatus(Room.RoomStatus.VACANT);
                            FileIO.writeSerializedObject("Hotel.dat",roomList);
                        }
                    }
                }
               reservationList.remove(reservation);
                FileIO.writeSerializedObject("Reservation.dat",reservationList);
            }
        }
    }

    public static void removeAReservationAnyway(int reservationId){
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getReservationNumber()==reservationId){
                GuestController.removeGuestByObject(reservation.getGuest());
                List roomList = FileIO.readSerializedObject("Hotel.dat");
                for(int j=0;j<reservation.getRooms().size();j++){
                    Room room = (Room)reservation.getRooms().get(j);
                    for(int k=0;k<roomList.size();k++){
                        Room r = (Room)roomList.get(k);
                        if(r.getRoomNumber().equals(room.getRoomNumber())){
                            r.setStatus(Room.RoomStatus.VACANT);
                            FileIO.writeSerializedObject("Hotel.dat",roomList);
                        }
                    }
                }
                reservationList.remove(reservation);
                FileIO.writeSerializedObject("Reservation.dat",reservationList);
                break;
            }
        }
    }

    public static void printReservationDetails(int reservationId){
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getReservationNumber()==reservationId){
                System.out.println("Reservation-ID: "+reservation.getReservationNumber());
                System.out.println("Reservation-Status: "+reservation.getReservationStatus());
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String checkInDate = dateFormat.format(reservation.getFromDate());
                System.out.println("\nCheck-in date: "+checkInDate);
                String checkOutDate = dateFormat.format(reservation.getToDate());
                System.out.println("\nCheck-out date: "+checkOutDate+"\n");
                System.out.println("\nNumber of adults staying: "+reservation.getNumberOfAdultsStaying()+"\n");
                System.out.println("\nNumber of children staying: "+reservation.getNumberOfChildrenStaying()+"\n");
                System.out.println("\n");
                System.out.println("Details of the guest staying: ");
                System.out.println("\n");
                GuestController.displayASingleGuestDetails(reservation.getGuest());
                System.out.println("Details of the room(s) booked: ");
                ArrayList<Room> roomsBooked = reservation.getRooms();
                for(int j=0;j<roomsBooked.size();j++){
                    Room room = (Room)roomsBooked.get(j);
                    HotelController.displayARoom(room);
                    System.out.println("\n");
                }
            }
        }
    }

    public static void printAllReservationDetails(){
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
                System.out.println("Reservation-ID: "+reservation.getReservationNumber());
                System.out.println("Reservation-Status: "+reservation.getReservationStatus());
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String checkInDate = dateFormat.format(reservation.getFromDate());
                System.out.println("\nCheck-in date: "+checkInDate);
                String checkOutDate = dateFormat.format(reservation.getToDate());
                System.out.println("\nCheck-out date: "+checkOutDate);
                System.out.println("\nNumber of adults staying: "+reservation.getNumberOfAdultsStaying());
                System.out.println("\nNumber of children staying: "+reservation.getNumberOfChildrenStaying());
                System.out.println("Details of the guest staying: ");
                GuestController.displayASingleGuestDetails(reservation.getGuest());
                System.out.println("\n");
                System.out.println("Details of the room(s) booked: ");
                System.out.println("\n");
                ArrayList<Room> roomsBooked = reservation.getRooms();
                for(int j=0;j<roomsBooked.size();j++){
                    Room room = (Room)roomsBooked.get(j);
                    HotelController.displayARoom(room);
                    System.out.println("\n");
                }
                System.out.println("\n");
        }
    }

    public static void updateReservationDetails(int reservationId) throws ParseException{
        Scanner sc = new Scanner(System.in);
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getReservationNumber()==reservationId && reservation.getReservationStatus()== Reservation.ReservationStatus.CONFIRMED){
                System.out.println("What would you like to modify?\n" +
                        "1. Number of adults staying\n" +
                        "2. Number of children staying\n" +
                        "3. Check-In Date\n" +
                        "4. Check-Out Date\n" +
                        "5. Room selection\n" +
                        "6. Exit");
                int choice=sc.nextInt();
                while(choice!=6){
                    switch(choice){
                        case 1:
                            System.out.println("Initially, the number of adults staying were: "+reservation.getNumberOfAdultsStaying());
                            System.out.println("Enter the new number of adults staying: ");
                            int numberOfAdults = sc.nextInt();
                            reservation.setNumberOfAdultsStaying(numberOfAdults);
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;
                        case 2:
                            System.out.println("Initially, the number of children staying were: "+reservation.getNumberOfChildrenStaying());
                            System.out.println("Enter the new number of children staying: ");
                            int numberOfChildren = sc.nextInt();
                            reservation.setNumberOfAdultsStaying(numberOfChildren);
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;
                        case 3:
                            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                            String checkInDate = dateFormat.format(reservation.getFromDate());
                            System.out.println("The initial check-in date: "+checkInDate);
                            System.out.println("Enter the new check-in date: (DD-MM-YYYY HH:MM:SS)");
                            String d = sc.nextLine();
                            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                            Date newCheckInDate = format.parse(d);
                            reservation.setFromDate(newCheckInDate);
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;
                        case 4:
                            dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                            String checkOutDate = dateFormat.format(reservation.getToDate());
                            System.out.println("The initial check-out date: "+checkOutDate);
                            System.out.println("Enter the new check-out date: (DD-MM-YYYY HH:MM:SS)");
                            d = sc.nextLine();
                            format = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                            Date newCheckOutDate = format.parse(d);
                            reservation.setToDate(newCheckOutDate);
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;
                        case 5:
                            System.out.println("The initial rooms were: ");
                            for(int k=0;k<reservation.getRooms().size();k++){
                                Room room = (Room)reservation.getRooms().get(k);
                                HotelController.displayARoom(room);
                                System.out.println("\n");
                            }
                            System.out.println("How many of your previous room bookings do you want to change?");
                            int numChange = sc.nextInt();
                            System.out.println("The vacant rooms available are: \n");
                            HotelController.displayAllVacantRoom();
                            for(int l=0;l<numChange;l++){
                                System.out.println("Enter the room number of the room you want to book: ");
                                String roomNumBook = sc.next();
                                List roomList = FileIO.readSerializedObject("Hotel.dat");
                                for(int m=0;m<roomList.size();m++){
                                    Room room = (Room)roomList.get(m);
                                    if(room.getRoomNumber().equals(roomNumBook)){
                                        room.setStatus(Room.RoomStatus.RESERVED);
                                        FileIO.writeSerializedObject("Hotel.dat",roomList);
                                        reservation.addRoom(room);
                                        FileIO.writeSerializedObject("Reservation.dat",reservationList);
                                    }
                                }
                            }
                            for(int l=0;l<numChange;l++){
                                System.out.println("Enter the room number of the room you want to cancel booking: ");
                                String roomNumBook = sc.next();
                                List roomList = FileIO.readSerializedObject("Hotel.dat");
                                for(int m=0;m<roomList.size();m++){
                                    Room room = (Room)roomList.get(m);
                                    if(room.getRoomNumber().equals(roomNumBook)){
                                        room.setStatus(Room.RoomStatus.VACANT);
                                        FileIO.writeSerializedObject("Hotel.dat",roomList);
                                        reservation.removeRoom(room);
                                        FileIO.writeSerializedObject("Reservation.dat",reservationList);
                                    }
                                }
                            }
                            break;
                        default: System.out.println("Enter valid number: ");
                    }
                    System.out.println("What would you like to modify?\n" +
                            "1. Number of adults staying\n" +
                            "2. Number of children staying\n" +
                            "3. Check-In Date\n" +
                            "4. Check-Out Date\n" +
                            "5. Room selection\n" +
                            "6. Exit");
                    choice=sc.nextInt();
                }
            }
        }
    }


    public static void checkOutOfHotel(int reservationId){
        System.out.println("Thank you for choosing our hotel!");
        System.out.println("5% GST will be charged on all room service orders and room charges. \n");

        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservationId==reservation.getReservationNumber()){
                int weekdays=0,weekends=0;
                long diff = reservation.getToDate().getTime()-reservation.getFromDate().getTime();
                int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                Date loopDate = new Date(reservation.getFromDate().getTime());
                for(int k=0;k<diffDays+1;k++){
                    Calendar c = Calendar.getInstance();
                    c.setTime(loopDate);
                    if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                            c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                        weekends++;
                    }
                    else{
                        weekdays++;
                    }
                    c.add(Calendar.DATE, 1);
                    loopDate = c.getTime();
                }
                System.out.println("Total length of stay: "+(diffDays+1));
                System.out.println("The number of weekdays stayed: ");
                System.out.println("The number of rooms you have booked: "+reservation.getRooms().size());
                System.out.println("The details of the room(s) is/are: ");
                double TotalRoomCharge = 0,TotalRoomChargeGst=0;
                for(int j=0;j<reservation.getRooms().size();j++){
                    Room room = (Room)reservation.getRooms().get(j);
                    System.out.println("Room Type: " + room.getRoomType());
                    System.out.println("Bed Type: " + room.getBedType());
                    System.out.println("Room Status: " + room.getStatus());
                    System.out.println("Facing View: " + room.getFacing());
                    System.out.println("Room Rate: " + room.getRoomRate());
                    System.out.println("Room Weekend Rate: " + room.getRoomWeekendRate());
                    System.out.println("Room Number: " + room.getRoomNumber());
                    System.out.println("WiFi enabled: " + room.isWifiEnabled());
                    System.out.println("Smoking allowance: " + room.isSmoking());
                    System.out.println("The weekend rate: "+weekends*room.getRoomWeekendRate());
                    double weekendRate = weekends*room.getRoomWeekendRate();
                    System.out.println("The weekday rate: "+weekdays*room.getRoomRate());
                    double weekdayRate = weekdays*room.getRoomRate();
                    double totalRoomCharge = weekdayRate+weekendRate;
                    TotalRoomCharge+=totalRoomCharge;
                    System.out.println("Total room charge(excluding GST): "+totalRoomCharge);
                    double gstRoom = 0.05*totalRoomCharge;
                    double totalRoomChargeGst = totalRoomCharge+gstRoom;
                    TotalRoomChargeGst+=totalRoomChargeGst;
                    System.out.println("Total room charge(including 5% GST): "+totalRoomChargeGst);
                    System.out.println("\n");
                }
                System.out.println("\n");
                System.out.println("Final Total room charge(excluding GST): "+TotalRoomCharge);
                System.out.println("Final Total room charge(including 5% GST): "+TotalRoomChargeGst);
                System.out.println("\n\n");
                System.out.println("Room service charges:\n ");
                double totalCostOfRoomServicesForAllRooms=0;
                for(int j=0;j<reservation.getRooms().size();j++){
                    Room room = (Room)reservation.getRooms().get(j);
                    double costOfRoomServices = 0;
                    System.out.println("Room Number: " + room.getRoomNumber());
                    for(int k=0;k<room.getRoomServices().size();k++){
                        RoomService rs = (RoomService)room.getRoomServices().get(k);
                        System.out.println("Room service id: " + rs.getRoomServiceId());
                        System.out.println("Room number: " + room.getRoomNumber());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        System.out.println("Date and time when the room service was ordered: " + formatter.format(rs.getDate()));
                        System.out.println("Your remarks: " + rs.getRemarks());
                        System.out.println("The order status: " + rs.getRoomServiceStatus());
                        System.out.println("Menu Items selected: \n");
                        double costOfRoomService = 0;
                        for (int l = 0; l < rs.getItemsSelected().size(); l++) {
                            MenuItem m = (MenuItem) rs.getItemsSelected().get(l);
                            System.out.println("Name: " + m.getName());
                            System.out.println("Description: " + m.getDescription());
                            System.out.println("Price: " + m.getPrice());
                            costOfRoomService+=m.getPrice();
                            System.out.println("\n");
                        }
                        costOfRoomServices+=costOfRoomService;
                    }
                    totalCostOfRoomServicesForAllRooms+=costOfRoomServices;
                    System.out.println("Total cost of room services of this room excluding GST: "+costOfRoomServices);
                    double gstRoomServices = 0.05*costOfRoomServices;
                    System.out.println("Total cost of room services of this room (including 5% GST): "+(costOfRoomServices+gstRoomServices));
                }
                System.out.println("Total cost of room services of all rooms excluding GST: "+totalCostOfRoomServicesForAllRooms);
                double totalGstRoomServices = 0.05*totalCostOfRoomServicesForAllRooms;
                double TOTAL_ROOM_SERVICES = totalCostOfRoomServicesForAllRooms+totalGstRoomServices;
                System.out.println("Total cost of room services of this room (including 5% GST): "+TOTAL_ROOM_SERVICES);
                double TOTAL_COST = TOTAL_ROOM_SERVICES+TotalRoomChargeGst;
                System.out.println("\n\nTotal cost including GST: "+TOTAL_COST);
                System.out.println("Please indicate your payment method: \n" +
                        "1. Cash\n" +
                        "2. Credit Card");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                System.out.println("Payment is successful! \n");
                switch(choice){
                    case 1:
                        System.out.println("Total cash in hand: "+reservation.getGuest().getCash());
                        System.out.println("Total cash left after deduction: "+(reservation.getGuest().getCash()-TOTAL_COST));
                        ReservationController.removeAReservation(reservation.getReservationNumber());
                        break;
                    case 2:
                        System.out.println("Credit card holder name: "+reservation.getGuest().getCreditCard().getCardHolderName());
                        System.out.println("Credit card number: "+reservation.getGuest().getCreditCard().getCreditCardnumber());
                        System.out.println("Expiry date of credit card: "+reservation.getGuest().getCreditCard().getExpiryDate());
                        System.out.println("Amount deducted: "+TOTAL_COST);
                }
                removeAReservation(reservation.getReservationNumber());
             break;
            }
        }
    }

    public static void createReservationBefore() throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the reservation ID:");
        int reservationId = sc.nextInt();
        System.out.println("Please enter the details of the guest under whom the reservation will be made: ");
        Guest guest = GuestController.createGuest();
        Calendar cal = Calendar.getInstance();
//        Date fromDate = cal.getTime();
        sc.nextLine();
        System.out.println("Please enter the check-In date:(DD-MM-YYYY hh:mm:ss) ");
        String d = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date fromDate = format.parse(d);
        cal.setTime(fromDate);
        System.out.println("Please mention the length of your stay:");
        int dayStaying = sc.nextInt();
        cal.add(Calendar.DAY_OF_MONTH, dayStaying);
        Date toDate = cal.getTime();
        System.out.println("Enter the number of adults: ");
        int numberOfAdults = sc.nextInt();
        System.out.println("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();
        System.out.println("Please enter the number of rooms you would like to book: ");
        int numRoom = sc.nextInt();
        ArrayList<Integer> rNums=new ArrayList<Integer>();
        ArrayList<Room> roomsBooked = new ArrayList<Room>();
        for(int i=0;i<numRoom;i++){
            System.out.println("Please select the type of room for room "+(i+1)+"\n" +
                    "1. Single\n" +
                    "2. Double\n" +
                    "3. Deluxe\n" +
                    "4. VIP");
            int c = sc.nextInt();
            Room.RoomType roomType;
            if (c == 1) {
                roomType = Room.RoomType.SINGLE;
            } else if (c == 2) {
                roomType = Room.RoomType.DOUBLE;
            } else if (c == 3) {
                roomType = Room.RoomType.DELUXE;
            } else {
                roomType = Room.RoomType.VIP;
            }

            System.out.println("Please select the type of bed for room "+(i+1)+"\n" +
                    "1. Single\n" +
                    "2. Double\n" +
                    "3. Master");
            c = sc.nextInt();
            Room.BedType bedType = null;
            if (c == 1) {
                bedType = Room.BedType.SINGLE_BED;
            } else if (c == 2) {
                bedType = Room.BedType.DOUBLE_BED;
            } else if (c == 3) {
                bedType = Room.BedType.MASTER_BED;
            }

            System.out.println("Please select the facing view for room "+(i+1)+"\n" +
                    "1. City\n" +
                    "2. Sea\n" +
                    "3. Park\n" +
                    "4. Pool\n" +
                    "5. Mountain\n" +
                    "6. No View");
            c = sc.nextInt();
            Room.FacingView facingView = null;
            if (c == 1) {
                facingView = Room.FacingView.CITY_VIEW;
            } else if (c == 2) {
                facingView = Room.FacingView.SEA_VIEW;
            } else if (c == 3) {
                facingView = Room.FacingView.PARK_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.POOL_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.MOUNTAIN_VIEW;
            }  else if (c == 3) {
                facingView = Room.FacingView.NO_VIEW;
            }

            System.out.println("Should the room be WiFi enabled?(y/n)");
            boolean wifi;
            char w = sc.next().charAt(0);
            if(w=='y'){
                wifi=true;
            }
            else{
                wifi=false;
            }
            System.out.println("Should smoking be allowed in the room?(y/n)");
            boolean smoking;
            char s = sc.next().charAt(0);
            if(s=='y'){
                smoking=true;
            }
            else{
                smoking=false;
            }
            List roomList = FileIO.readSerializedObject("Hotel.dat");
            ArrayList<Room> availableRooms = HotelController.findRoomsForCheckInGuests(roomType,bedType,facingView,wifi,smoking);
            if(availableRooms!=null) {
                System.out.println("The rooms available are");
                for (int j = 0; j < availableRooms.size(); j++) {
                    Room r = (Room) availableRooms.get(j);
                    System.out.println("Room number: "+r.getRoomNumber());
                }
                System.out.println("Choose the room number: ");
                String rNum = sc.next();
                for(int k=0;k<availableRooms.size();k++){
                    Room r = (Room) availableRooms.get(k);
                    if(r.getRoomNumber().equals(rNum)){
                        roomsBooked.add(r);
                        r.setStatus(Room.RoomStatus.RESERVED);
                    }
                }
                for(int l=0;l<roomList.size();l++){
                    Room r = (Room) roomList.get(l);
                    if(r.getRoomNumber().equals(rNum)){
                        r.setStatus(Room.RoomStatus.RESERVED);
                        FileIO.writeSerializedObject("Hotel.dat",roomList);
                        break;
                    }
                }
            }
        }
        Reservation reservation = new Reservation(reservationId,guest,roomsBooked,numberOfAdults,numberOfChildren,fromDate,toDate, Reservation.ReservationStatus.CONFIRMED);
        File file = new File("Reservation.dat");
        boolean exists = file.exists();
        if(exists){
            List list = FileIO.readSerializedObject("Reservation.dat");
            list.add(reservation);
            FileIO.writeSerializedObject("Reservation.dat",list);
        }
        else{
            List list = new ArrayList<Reservation>();
            list.add(reservation);
            FileIO.writeSerializedObject("Reservation.dat",list);
        }
    }



}

