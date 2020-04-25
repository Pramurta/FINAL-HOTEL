package com.company;


import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.WriteAbortedException;

public class HotelController extends FileIO{

//    public static void changeStatus(int roomNumber){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Change the status to: \n");
//        for(int i = 0; i< Room.RoomStatus.values().length; i++){
//            System.out.println(i + " for " + Room.RoomStatus.values()[i] + "\n");
//        }
//        int decision = Integer.parseInt(sc.nextLine());
//        Hotel.getRoom(roomNumber).setStatus(Room.RoomStatus.values()[decision]);
//
//
//    }
//
//    public static void printRooms(){
//        Hotel.hotelRooms();
//    }
//
//    public static void changing_room_cost(double cost, int room_num){
//        Hotel.change_room_price(cost, room_num);
//
//    }
//    public static void printRoomServiceOrders(int floor, int room_num){
//        Room room = Hotel.getRooms().get(floor * Hotel.ROOMS_ON_EACH_FLOOR + room_num);
//
//    }
//
//    public static Room findingRoom(RoomType roomType, BedType bedType, FacingView facingView){
//        for(Room room: Hotel.getRooms()){
//            if(room.getStatus() == RoomStatus.VACANT){
//                if(room.getRoomType() == roomType && room.getBedType() == bedType && room.getFacing() == facingView){
//                    room.setStatus(RoomStatus.OCCUPIED);
//                    return room;
//                }
//            }
//        }
//        return null;
//    }

    public static void createRoom(Room room){
        File tempFile = new File("Hotel.dat");
        boolean exists = tempFile.exists();
        if(exists){
            List roomList = readSerializedObject("Hotel.dat");
            roomList.add(room);
            writeSerializedObject("Hotel.dat",roomList);
        }
        else{
            List list = new ArrayList<Room>();
            list.add(room);
            writeSerializedObject("Hotel.dat",list);
        }

    }

    public static Room returnRoomOnPassingRoomId(String rNum){
        List roomList = readSerializedObject("Hotel.dat");
        for(int i=0;i<roomList.size();i++){
            Room r = (Room) roomList.get(i);
            if(r.getRoomNumber().equals(rNum)){
                return r;
            }
        }
        Room room = (Room) roomList.get(0);
        return room;
    }

    public static void displayAllRooms(){
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            System.out.println("Room Number: "+r.getRoomNumber());
            System.out.println("Room Type: "+r.getRoomType());
            System.out.println("Bed Type: "+r.getBedType());
            System.out.println("Room Status: "+r.getStatus());
            System.out.println("Facing View: "+r.getFacing());
            System.out.println("Room Rate: "+r.getRoomRate());
            System.out.println("Room Weekend Rate: "+r.getRoomWeekendRate());
            System.out.println("WiFi enabled: "+r.isWifiEnabled());
            System.out.println("Smoking allowance: "+r.isSmoking());
            System.out.println("\n");
        }
    }

    public static void displayARoom(Room room){
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(room.getRoomNumber().equals(r.getRoomNumber())) {
                System.out.println("Room Number: " + r.getRoomNumber());
                System.out.println("Room Type: " + r.getRoomType());
                System.out.println("Bed Type: " + r.getBedType());
                System.out.println("Room Status: " + r.getStatus());
                System.out.println("Facing View: " + r.getFacing());
                System.out.println("Room Rate: " + r.getRoomRate());
                System.out.println("Room Weekend Rate: " + r.getRoomWeekendRate());
                System.out.println("WiFi enabled: " + r.isWifiEnabled());
                System.out.println("Smoking allowance: " + r.isSmoking());
                break;
            }
        }
    }

    public static void displayAllVacantRoom(){
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getStatus()==Room.RoomStatus.VACANT) {
                System.out.println("Room Type: " + r.getRoomType());
                System.out.println("Bed Type: " + r.getBedType());
                System.out.println("Room Status: " + r.getStatus());
                System.out.println("Facing View: " + r.getFacing());
                System.out.println("Room Rate: " + r.getRoomRate());
                System.out.println("Room Weekend Rate: " + r.getRoomWeekendRate());
                System.out.println("Room Number: " + r.getRoomNumber());
                System.out.println("WiFi enabled: " + r.isWifiEnabled());
                System.out.println("Smoking allowance: " + r.isSmoking());
            }
        }
    }

    public static ArrayList<Room> returnAllVacantRooms(){
        List list = readSerializedObject("Hotel.dat");
        ArrayList<Room> vacantRooms = new ArrayList<Room>();
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getStatus()==Room.RoomStatus.VACANT) {
                vacantRooms.add(r);
            }
        }
        return vacantRooms;
    }



    public static void displayAllVacantRoomNumbers(){
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getStatus()==Room.RoomStatus.VACANT) {
                System.out.println("Room Number: " + r.getRoomNumber());
            }
        }
    }

    public static void updateRoomDetails(String rNum){
        Scanner sc = new Scanner(System.in);
        int found=0;
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getRoomNumber().equals(rNum)) {
                found = 1;
                System.out.println("Which detail of the room would you like to update:\n" +
                        "1. Room Status\n" +
                        "2. Room Rate\n" +
                        "3. Room Weekend rate\n" +
                        "4. Exit\n");
                int choice = sc.nextInt();
                while (choice != 4) {
                    switch (choice) {
                        case 1:
                            System.out.println("The old room status was: " + r.getStatus());
                            System.out.println("What do you want to change the status to\n" +
                                    "1. Vacant\n" +
                                    "2. Occupied\n" +
                                    "3. Reserved\n" +
                                    "4. Under Maintenance");
                            int c = sc.nextInt();
                            if (c == 1) {
                                r.setStatus(Room.RoomStatus.VACANT);
                                List reservationList = FileIO.readSerializedObject("Reservation.dat");
                                for(int l=0;l<reservationList.size();l++){
                                    Reservation reservation = (Reservation)reservationList.get(l);
                                    for(int m=0;m<reservation.getRooms().size();m++){
                                        Room room = (Room)reservation.getRooms().get(m);
                                        if(room.getRoomNumber().equals(rNum)){
                                            room.setStatus(Room.RoomStatus.VACANT);
                                        }
                                    }
                                }
                            } else if (c == 2) {
                                r.setStatus(Room.RoomStatus.OCCUPIED);
                                List reservationList = FileIO.readSerializedObject("Reservation.dat");
                                for(int l=0;l<reservationList.size();l++){
                                    Reservation reservation = (Reservation)reservationList.get(l);
                                    for(int m=0;m<reservation.getRooms().size();m++){
                                        Room room = (Room)reservation.getRooms().get(m);
                                        if(room.getRoomNumber().equals(rNum)){
                                            room.setStatus(Room.RoomStatus.OCCUPIED);
                                        }
                                    }
                                }
                            } else if (c == 3) {
                                r.setStatus(Room.RoomStatus.RESERVED);
                                List reservationList = FileIO.readSerializedObject("Reservation.dat");
                                for(int l=0;l<reservationList.size();l++){
                                    Reservation reservation = (Reservation)reservationList.get(l);
                                    for(int m=0;m<reservation.getRooms().size();m++){
                                        Room room = (Room)reservation.getRooms().get(m);
                                        if(room.getRoomNumber().equals(rNum)){
                                            room.setStatus(Room.RoomStatus.RESERVED);
                                        }
                                    }
                                }
                            } else {
                                r.setStatus(Room.RoomStatus.UNDER_MAINTENANCE);
                                List reservationList = FileIO.readSerializedObject("Reservation.dat");
                                for(int l=0;l<reservationList.size();l++){
                                    Reservation reservation = (Reservation)reservationList.get(l);
                                    for(int m=0;m<reservation.getRooms().size();m++){
                                        Room room = (Room)reservation.getRooms().get(m);
                                        if(room.getRoomNumber().equals(rNum)){
                                            room.setStatus(Room.RoomStatus.UNDER_MAINTENANCE);
                                        }
                                    }
                                }
                            }
                            writeSerializedObject("Hotel.dat", list);

                            break;
                        case 2:
                            System.out.println("The old room rate was: " + r.getRoomRate());
                            System.out.println("Enter the new room rate: ");
                            double rRate = sc.nextDouble();
                            r.setRoomRate(rRate);
                            writeSerializedObject("Hotel.dat", list);
                            List reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                for(int m=0;m<reservation.getRooms().size();m++){
                                    Room room = (Room)reservation.getRooms().get(m);
                                    if(room.getRoomNumber().equals(rNum)){
                                        room.setRoomRate(rRate);
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("The old room weekend rate was: " + r.getRoomWeekendRate());
                            System.out.println("Enter the new room weekend rate: ");
                            double rwRate = sc.nextDouble();
                            r.setRoomWeekendRate(rwRate);
                            writeSerializedObject("Hotel.dat", list);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                for(int m=0;m<reservation.getRooms().size();m++){
                                    Room room = (Room)reservation.getRooms().get(m);
                                    if(room.getRoomNumber().equals(rNum)){
                                        room.setRoomWeekendRate(rwRate);
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter a valid number");
                    }
                    System.out.println("Which detail of the room would you like to update:\n" +
                            "1. Room Status\n" +
                            "2. Room Rate\n" +
                            "3. Room Weekend rate\n" +
                            "4. Exit\n");
                    choice = sc.nextInt();
                }
            }
        }
        if(found==0){
            System.out.println("Room not found!");
        }
    }

    public static void removeRooms(String rNum){
        List list = readSerializedObject("Hotel.dat");
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getRoomNumber().equals(rNum)){
                list.remove(r);
                writeSerializedObject("Hotel.dat",list);
            }
        }
    }

    public static ArrayList<Room> findRoomsForCheckInGuests(Room.RoomType roomType, Room.BedType bedType, Room.FacingView facingView, boolean wifi, boolean smoking){
        List list = readSerializedObject("Hotel.dat");
        ArrayList<Room> suitableRooms = new ArrayList<Room>();
        int found=0;
        for(int i=0;i<list.size();i++){
            Room r = (Room) list.get(i);
            if(r.getRoomType()==roomType && r.getBedType()==bedType && r.getFacing()==facingView && r.isWifiEnabled()==wifi && r.isSmoking()==smoking && r.getStatus()== Room.RoomStatus.VACANT)  {
                found=1;
                suitableRooms.add(r);
            }
        }
        if(found==1){
            return suitableRooms;
        }
        else{
            System.out.println("Rooms of the specified types aren't available at the moment");
            return null;
        }
    }

//    public static void changeRoomStatusToReserved(Room r){
//        List list = readSerializedObject("Hotel.dat");
//        for(int i=0;i<list.size();i++){
//            Room room = (Room) list.get(i);
//            if(r.getRoomNumber().equals(room.getRoomNumber()))  {
//                room.setStatus(Room.RoomStatus.RESERVED);
//                writeSerializedObject("Hotel.dat",list);
//            }
//        }
//    }
//
//    public static void changeRoomStatusToVacant(Room r){
//        List list = readSerializedObject("Hotel.dat");
//        for(int i=0;i<list.size();i++){
//            Room room = (Room) list.get(i);
//            if(r.getRoomNumber().equals(room.getRoomNumber()))  {
//                room.setStatus(Room.RoomStatus.VACANT);
//                writeSerializedObject("Hotel.dat",list);
//            }
//        }
//    }
//
//    public static void changeRoomStatusToUnderMaintenance(Room r){
//        List list = readSerializedObject("Hotel.dat");
//        for(int i=0;i<list.size();i++){
//            Room room = (Room) list.get(i);
//            if(r.getRoomNumber().equals(room.getRoomNumber()))  {
//                room.setStatus(Room.RoomStatus.UNDER_MAINTENANCE);
//                writeSerializedObject("Hotel.dat",list);
//            }
//        }
//    }

    public static ArrayList<String> returnRoomNumbersByRoomType(Room.RoomType roomType){
        ArrayList<String> roomNums = new ArrayList<String>();
        List roomList = readSerializedObject("Hotel.dat");
        for(int i=0;i<roomList.size();i++){
            Room room = (Room) roomList.get(i);
            if(room.getRoomType()==roomType)  {
                roomNums.add(room.getRoomNumber());
            }
        }
        return roomNums;
    }

    public static ArrayList<String> returnRoomNumbersByRoomStatus(Room.RoomStatus roomStatus){
        ArrayList<String> roomNums = new ArrayList<String>();
        List roomList = readSerializedObject("Hotel.dat");
        for(int i=0;i<roomList.size();i++){
            Room room = (Room) roomList.get(i);
            if(room.getStatus()==roomStatus)  {
                roomNums.add(room.getRoomNumber());
            }
        }
        return roomNums;
    }




    public static void printRoomStatisticsReport(){
        System.out.println("Room Statistics report:  \n");
        List roomList = readSerializedObject("Hotel.dat");
        ArrayList<String> singleRoomNums = new ArrayList<String>();
        singleRoomNums = HotelController.returnRoomNumbersByRoomType(Room.RoomType.SINGLE);
        ArrayList<String> doubleRoomNums = new ArrayList<String>();
        doubleRoomNums = HotelController.returnRoomNumbersByRoomType(Room.RoomType.DOUBLE);
        ArrayList<String> deluxeRoomNums = new ArrayList<String>();
        deluxeRoomNums = HotelController.returnRoomNumbersByRoomType(Room.RoomType.DELUXE);
        ArrayList<String> vipRoomNums = new ArrayList<String>();
        vipRoomNums = HotelController.returnRoomNumbersByRoomType(Room.RoomType.VIP);
        ArrayList<String> vacantRoomNums = new ArrayList<String>();
        vacantRoomNums = HotelController.returnRoomNumbersByRoomStatus(Room.RoomStatus.VACANT);
        ArrayList<String> occupiedRoomNums = new ArrayList<String>();
        occupiedRoomNums = HotelController.returnRoomNumbersByRoomStatus(Room.RoomStatus.OCCUPIED);
        ArrayList<String> reservedRoomNums = new ArrayList<String>();
        reservedRoomNums = HotelController.returnRoomNumbersByRoomStatus(Room.RoomStatus.RESERVED);
        ArrayList<String> underMaintenanceRoomNums = new ArrayList<String>();
        underMaintenanceRoomNums = HotelController.returnRoomNumbersByRoomStatus(Room.RoomStatus.UNDER_MAINTENANCE);
        int single_room=0,double_room=0,deluxe_room=0,vip_room=0,vacant_room=0,occupied_room=0,reserved_room=0,under_maintenance_room=0;
        for(int i=0;i<roomList.size();i++){
            Room room = (Room)roomList.get(i);
            if(room.getRoomType()== Room.RoomType.SINGLE){
                single_room++;
            }
            else if(room.getRoomType()== Room.RoomType.DOUBLE){
                double_room++;
            }
            else if(room.getRoomType()== Room.RoomType.DELUXE){
                deluxe_room++;
            }
            else if(room.getRoomType()== Room.RoomType.VIP){
                vip_room++;
            }
        }
        for(int i=0;i<roomList.size();i++){
            Room room = (Room)roomList.get(i);
            if(room.getStatus()== Room.RoomStatus.VACANT){
                vacant_room++;
            }
            else if(room.getStatus()== Room.RoomStatus.OCCUPIED){
                occupied_room++;
            }
            else if(room.getStatus()== Room.RoomStatus.RESERVED){
                reserved_room++;
            }
            else if(room.getStatus()== Room.RoomStatus.UNDER_MAINTENANCE){
                under_maintenance_room++;
            }
        }
        System.out.println("Room type occupancy report: \n\n");
        System.out.println("Single:   Number: "+ single_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<single_room;i++){
              String s = (String)singleRoomNums.get(i);
              System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("Double:   Number: "+ double_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<double_room;i++){
            String s = (String)doubleRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("Deluxe:   Number: "+ deluxe_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<deluxe_room;i++){
            String s = (String)deluxeRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("VIP:   Number: "+ vip_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<vip_room;i++){
            String s = (String)vipRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n\n\n");



        System.out.println("Room status occupancy report: \n\n");
        System.out.println("Vacant:   Number: "+ vacant_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<vacant_room;i++){
            String s = (String)vacantRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("Occupied:   Number: "+ occupied_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<occupied_room;i++){
            String s = (String)occupiedRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("Reserved:   Number: "+ reserved_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<reserved_room;i++){
            String s = (String)reservedRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n");
        System.out.println("Under Maintenance:   Number: "+ under_maintenance_room +" out of 48");
        System.out.print("          Rooms: ");
        for(int i=0;i<under_maintenance_room;i++){
            String s = (String)underMaintenanceRoomNums.get(i);
            System.out.print(s+", ");
        }
        System.out.println("\n\n\n");
    }

    public static void createHotel(){
        Room room = new Room(Room.RoomType.SINGLE, Room.BedType.DOUBLE_BED, Room.RoomStatus.UNDER_MAINTENANCE, Room.FacingView.NO_VIEW,173,178,"06-08",false,true);
         HotelController.createRoom(room);
    }

    public static void main(String[] args) throws ParseException,WriteAbortedException {
       RoomServiceBoundary.enterRoomService();
    }




}
