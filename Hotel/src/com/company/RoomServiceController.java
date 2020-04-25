package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.WriteAbortedException;
//
//public class RoomServiceController {
//
//    public static void roomServiceModifier(RoomService roomService, double price, int floor, int room_num){
//        Scanner sc = new Scanner(System.in);
//        roomService.setCost(price);
//        LocalDateTime now = LocalDateTime.now();
//        roomService.setDate(now);
//
//        Hotel.getRoom(floor*Hotel.ROOMS_ON_EACH_FLOOR + room_num).addRoomService(roomService);
//        System.out.println("Your ordered has been placed");
//
//        System.out.println("Your order is: ");
//        Hotel.getRoom(floor*Hotel.ROOMS_ON_EACH_FLOOR + room_num).printRoomServices();
//    }
//
//
//}

public class RoomServiceController extends FileIO {
    public static void newRoomServiceOrder() throws WriteAbortedException {
        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        System.out.println("Please enter the reservation Id: ");
        int reservationId = sc.nextInt();
        ArrayList<String> roomNums = new ArrayList<String>();
        List reservationList = readSerializedObject("Reservation.dat");
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = (Reservation) reservationList.get(i);
            if (reservation.getReservationNumber() == reservationId) {
                System.out.println("Rooms under this reservation are: ");
                for (int j = 0; j < reservation.getRooms().size(); j++) {
                    Room room = (Room) reservation.getRooms().get(j);
                    System.out.println("Room number: " + room.getRoomNumber());
                }
            }
        }
        System.out.println("Please enter your room number for which you want ot :\n");
        String rNum = sc.next();
        //Room room = HotelController.returnRoomOnPassingRoomId(rNum);
        System.out.println("Please enter the room service id:\n");
        int rsId = sc.nextInt();
        MenuController.displayMenuItems();
        System.out.println("Please enter the ID of the menu item you would like to order: (Enter -1 to exit)");
        int id = sc.nextInt();
        double cost = 0;
        while (id != -1) {
            List menuList = readSerializedObject("Menu.dat");
            for (int i = 0; i < menuList.size(); i++) {
                MenuItem m = (MenuItem) menuList.get(i);
                if (m.getId() == id) {
                    menuItems.add(m);
                    cost += m.getPrice();
                }
            }
            System.out.println("Please enter the ID of the menu item you would like to order: (Enter -1 to exit)");
            id = sc.nextInt();
        }
        Date date = new Date();
        sc.nextLine();
        System.out.println("Please enter some remarks:\n");
        String remarks = sc.nextLine();
        RoomService roomService = new RoomService(rsId, date, cost, menuItems, remarks, RoomService.RoomServiceStatus.CONFIRMED);

        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = (Reservation) reservationList.get(i);
            if (reservation.getReservationNumber() == reservationId) {
                for (int j = 0; j < reservation.getRooms().size(); j++) {
                    Room r = (Room) reservation.getRooms().get(j);
                    if (r.getRoomNumber().equals(rNum)) {
                        r.addRoomService(roomService);
                    }
                }
                writeSerializedObject("Reservation.dat", reservationList);
            }
        }
//        List roomList = FileIO.readSerializedObject("Hotel.dat");
//        for(int i=0;i<roomList.size();i++){
//            Room r = (Room) roomList.get(i);
//            if(r.getRoomNumber().equals(rNum)){
//                r.addRoomService(roomService);
//                FileIO.writeSerializedObject("Room.dat", roomList);
//            }
//        }


    }

    public static void updateRoomServiceOrder(int reservationId, String roomId, int roomServiceId) throws WriteAbortedException {
        List reservationList = readSerializedObject("Reservation.dat");
        Scanner sc = new Scanner(System.in);
        System.out.println("Your room service order till now: \n");
        RoomServiceController.displayRoomServiceOrderOfARoom(reservationId, roomId, roomServiceId);
        System.out.println("The menu items available are: \n");
        MenuController.displayMenuItems();
        for(int k=0;k<reservationList.size();k++){
            Reservation reservation = (Reservation)reservationList.get(k);
            if(reservationId==reservation.getReservationNumber()){
                for (int i = 0; i < reservation.getRooms().size(); i++) {
                    Room r = (Room) reservation.getRooms().get(i);
                    if (r.getRoomNumber().equals(roomId)) {
                        RoomService rs = r.getRoomServiceByRoomServiceId(roomServiceId);
                        System.out.println("Please enter what you would like to modify:\n" +
                                "1. Add a new menu item\n" +
                                "2. Remove a menu item\n" +
                                "3. Edit remarks\n" +
                                "4. Exit");
                        int choice = sc.nextInt();
                        while (choice != 4) {
                            switch (choice) {
                                case 1:
                                    System.out.println("Please enter the id of the menu item you would like to add: ");
                                    int menuItemId = sc.nextInt();
                                    List menuList = readSerializedObject("Menu.dat");
                                    for (int j = 0; j < menuList.size(); j++) {
                                        MenuItem m = (MenuItem) menuList.get(j);
                                        if (m.getId() == menuItemId) {
                                            rs.addNewMenuItem(m);
                                        }
                                    }
//                                    FileIO.writeSerializedObject("Room.dat", list);
                                    break;
                                case 2:
                                    System.out.println("Please enter the id of the menu item you would like to remove: ");
                                    menuItemId = sc.nextInt();
                                    List menuList1 = readSerializedObject("Menu.dat");
                                    for (int j = 0; j < menuList1.size(); j++) {
                                        MenuItem m = (MenuItem) menuList1.get(j);
                                        if (m.getId() == menuItemId) {
                                            rs.removeMenuItem(m);
                                            break;
                                        }
                                    }
//                                    FileIO.writeSerializedObject("Room.dat", list);
                                    break;
                                case 3:
                                    System.out.println("Your old remarks: " + rs.getRemarks());
                                    sc.nextLine();
                                    System.out.println("Please enter your new remarks: ");
                                    String newRemarks = sc.nextLine();
                                    rs.setRemarks(newRemarks);
//                                    FileIO.writeSerializedObject("Room.dat", list);
                                    break;
                                default:
                                    break;
                            }
                            System.out.println("Please enter what you would like to modify:\n" +
                                    "1. Add a new menu item\n" +
                                    "2. Remove a menu item\n" +
                                    "3. Edit remarks\n" +
                                    "4. Exit");
                            choice = sc.nextInt();
                        }
                        break;
                    }
                }
                writeSerializedObject("Reservation.dat",reservationList);
            }
        }

    }

    public static void displayRoomServiceOrderOfARoom(int reservationId, String rId, int rsId) throws WriteAbortedException {
        List reservationList = readSerializedObject("Reservation.dat");
//        List list = FileIO.readSerializedObject("Room.dat");
        for (int k = 0; k < reservationList.size(); k++) {
            Reservation reservation = (Reservation) reservationList.get(k);
            if (reservationId == reservation.getReservationNumber()) {
                for (int i = 0; i < reservation.getRooms().size(); i++) {
                    Room r = (Room) reservation.getRooms().get(i);
                    if (r.getRoomNumber().equals(rId)) {
                        RoomService rs = r.getRoomServiceByRoomServiceId(rsId);
                        if (rs == null) {
                            System.out.println("The order has been cancelled or no such order exists.");
                        } else {
                            System.out.println("Reservation id: " + reservation.getReservationNumber());
                            System.out.println("Room service id: " + rs.getRoomServiceId());
                            System.out.println("Room number: " + r.getRoomNumber());
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            System.out.println("Date and time when the room service was ordered: " + formatter.format(rs.getDate()));
                            System.out.println("Your remarks: " + rs.getRemarks());
                            System.out.println("The order status: " + rs.getRoomServiceStatus());
                            System.out.println("Menu Items selected: \n");
                            for (int j = 0; j < rs.getItemsSelected().size(); j++) {
                                MenuItem m = (MenuItem) rs.getItemsSelected().get(j);
                                System.out.println("Name: " + m.getName());
                                System.out.println("Description: " + m.getDescription());
                                System.out.println("Price: " + m.getPrice());
                                System.out.println("\n");
                            }
                        }
                    }
                }
            }
        }

    }

    public static void removeRoomServiceOrder(int reservationId, String roomId, int roomServiceId) throws WriteAbortedException {
        List reservationList = readSerializedObject("Reservation.dat");
        for (int k = 0; k < reservationList.size(); k++) {
            Reservation reservation = (Reservation) reservationList.get(k);
            if (reservationId == reservation.getReservationNumber()) {
                for (int i = 0; i < reservation.getRooms().size(); i++) {
                    Room r = (Room) reservation.getRooms().get(i);
                    if (r.getRoomNumber().equals(roomServiceId)) {
                        RoomService rs = r.getRoomServiceByRoomServiceId(roomServiceId);
                        r.removeRoomService(rs);
                    }
                }
                writeSerializedObject("Reservation.dat", reservationList);
            }
        }
    }

}
//        for(int i=0;i<list.size();i++){
//            Room r = (Room) list.get(i);
//            if(r.getRoomNumber().equals(roomId)){
//                RoomService rs = r.getRoomServiceByRoomServiceId(roomServiceId);
//                r.removeRoomService(rs);
//                FileIO.writeSerializedObject("Room.dat", list);
//                }
//            }
//        }


