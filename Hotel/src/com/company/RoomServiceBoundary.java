package com.company;

import java.util.Scanner;
import java.io.WriteAbortedException;
//
//public class RoomServiceBoundary {
//    public static void initiateRoomService(){
//        System.out.println("Order from the menu below");
//        Menu.displayMenuItems();
//
//        Scanner sc = new Scanner(System.in);
//        int id = -2;
//        double price = 0.0;
//        RoomService roomService = new RoomService();
//        do{
//            System.out.println("Select the ids of the items or select -1 to finalize  ");
//            id = Integer.parseInt(sc.nextLine());
//            if(id == -1){
//                break;
//            }
//            if(id < -1 || id >= Menu.getMenuItems().size()){
//                System.out.println("Please choose an appropriate number");
//                continue;
//            }
//            // adding the selected menu item into the array list of the room service object
//            roomService.getItemsSelected().add(Menu.getMenuItems().get(id));
//            price = price + Menu.getMenuItems().get(id).getPrice();
//            System.out.printf("The price of the items selected is %.2f\n", price);
//
//        } while(id!=-1);
//
//        // setting up the room service object instance
//        System.out.println("Your complete Room number Please");
//        System.out.print("Floor: ");
//        int floor = Integer.parseInt(sc.nextLine());
//        System.out.print("Room number: ");
//        int room_num = Integer.parseInt(sc.nextLine());
//
//
//        RoomServiceController.roomServiceModifier(roomService, price, floor, room_num);
//    }
//}

public class RoomServiceBoundary {
    public static void enterRoomService() throws WriteAbortedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:\n" +
                "1. Place a new order for room service\n" +
                "2. Update a room service order\n" +
                "3. Remove a room service order\n" +
                "4. View room service orders of a room\n" +
                "5. Exit");
        int choice=sc.nextInt();
        while(choice!=5){
            switch(choice){
                case 1:
                    RoomServiceController.newRoomServiceOrder();
                    break;
                case 2:
                    System.out.println("Please enter the reservation ID: ");
                    int reservationId=sc.nextInt();
                    System.out.println("Please enter the room number: ");
                    String roomId=sc.next();
                    System.out.println("Please enter the room Service Id: ");
                    int rsId=sc.nextInt();
                    RoomServiceController.updateRoomServiceOrder(reservationId,roomId,rsId);
                    break;
                case 3:
                    System.out.println("Please enter the reservation ID: ");
                    reservationId=sc.nextInt();
                    System.out.println("Please enter the room number: ");
                    roomId=sc.next();
                    System.out.println("Please enter the room Service Id: ");
                    rsId=sc.nextInt();
                    RoomServiceController.removeRoomServiceOrder(reservationId,roomId,rsId);
                    break;
                case 4:
                    System.out.println("Please enter the reservation ID: ");
                    reservationId=sc.nextInt();
                    System.out.println("Please enter the room number: ");
                    roomId=sc.next();
                    System.out.println("Please enter the room Service Id: ");
                    rsId=sc.nextInt();
                    RoomServiceController.displayRoomServiceOrderOfARoom(reservationId,roomId,rsId);
                    break;
                default:
                    System.out.println("Enter a valid number: ");
            }
            System.out.println("Enter your choice:\n" +
                    "1. Place a new order for room service\n" +
                    "2. Update a room service order\n" +
                    "3. Remove a room service order\n" +
                    "4. View room service orders of a room\n" +
                    "5. Exit");
            choice=sc.nextInt();
        }
    }


}


