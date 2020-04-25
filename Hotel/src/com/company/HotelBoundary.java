package com.company;

import java.util.Scanner;

public class HotelBoundary {
//    public static void enterHotel(){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("What room number do you want\nFloor:  ");
//        int floorNum = Integer.parseInt(sc.nextLine());
//        while(floorNum < 0 || floorNum >= Hotel.FLOORS){
//            System.out.println("Choose again\nFloor: ");
//            floorNum = Integer.parseInt(sc.nextLine());
//        }
//        System.out.print("\nroom number: ");
//        int roomNum = Integer.parseInt(sc.nextLine());
//        while(roomNum < 0 || roomNum >= Hotel.ROOMS_ON_EACH_FLOOR){
//            System.out.println("Choose again\nroom number: ");
//            roomNum = Integer.parseInt(sc.nextLine());
//        }
//
//
//        System.out.println("What do you want from this room number\n 1 for changing status of the room number" +
//                "\n 2 changing the weekday cost of the room number\n 3 changing the weekend cost\n 4 for rooms");
//
//        int decision = Integer.parseInt(sc.nextLine());
//
//        switch (decision){
//            case 1:
//               HotelController.changeStatus(floorNum*Hotel.ROOMS_ON_EACH_FLOOR + roomNum);
//               break;
//            case 2:
//                System.out.print("What cost do u want: ");
//                double price = Double.parseDouble(sc.nextLine());
//                HotelController.changing_room_cost(price, roomNum);
//            case 4:
//                HotelController.printRooms();
//                break;
//
//        }
//    }
//
//    public static void choosingRoom(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What type of bed do u want");
//    }

     public static void enterHotel(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter your choice:\n " +
                 "1. Create a room\n" +
                 "2. Update the details of a room\n" +
                 "3. Display all the rooms\n" +
                 "4. Remove a room\n" +
                 "5. Exit");
         int decision = sc.nextInt();
         while(decision!=5){
             switch(decision){
                 case 1:
                     System.out.println("Enter the room type:(Press 1->Single,2->Double....)  \n" +
                             "1. Single\n" +
                             "2. Double\n" +
                             "3. Deluxe\n" +
                             "4. VIP\n");
                     int choice=sc.nextInt();
                     Room.RoomType rType;
                     if(choice==1){
                         rType= Room.RoomType.SINGLE;
                     }
                     else if(choice==2){
                         rType= Room.RoomType.DOUBLE;
                     }
                     else if(choice==3){
                         rType= Room.RoomType.DELUXE;
                     }
                     else{
                         rType= Room.RoomType.VIP;
                     }
                     System.out.println("Enter the bed type:(Press 1->Single,2->Double....)  \n" +
                             "1. Single_bed\n" +
                             "2. Double_bed\n" +
                             "3. Master_bed\n" );
                     choice=sc.nextInt();
                     Room.BedType bType;
                     if(choice==1){
                         bType= Room.BedType.SINGLE_BED;
                     }
                     else if(choice==2){
                         bType= Room.BedType.DOUBLE_BED;
                     }
                     else{
                         bType= Room.BedType.MASTER_BED;
                     }
                     System.out.println("Enter the room status:(Press 1->Vacant,2->Occupied....)  \n" +
                             "1. Vacant\n" +
                             "2. Occupied\n" +
                             "3. Reserved\n" +
                             "4. Under_Maintenance\n");
                     choice=sc.nextInt();
                     Room.RoomStatus rstatus;
                     if(choice==1){
                         rstatus= Room.RoomStatus.VACANT;
                     }
                     else if(choice==2){
                         rstatus= Room.RoomStatus.OCCUPIED;
                     }
                     else if(choice==3){
                         rstatus= Room.RoomStatus.RESERVED;
                     }
                     else{
                         rstatus= Room.RoomStatus.UNDER_MAINTENANCE;
                     }
                     System.out.println("Enter the room facing view:(Press 1->Vacant,2->Occupied....)  \n" +
                             "1. City View\n" +
                             "2. Sea View\n" +
                             "3. Park View\n" +
                             "4. Pool View\n" +
                             "5. Mountain View\n" +
                             "6. No View");
                     choice=sc.nextInt();
                     Room.FacingView fView;
                     if(choice==1){
                         fView= Room.FacingView.CITY_VIEW;
                     }
                     else if(choice==2){
                         fView= Room.FacingView.SEA_VIEW;
                     }
                     else if(choice==3){
                         fView= Room.FacingView.PARK_VIEW;
                     }
                     else if(choice==4){
                         fView= Room.FacingView.POOL_VIEW;
                     }
                     else if(choice==5){
                         fView= Room.FacingView.MOUNTAIN_VIEW;
                     }
                     else{
                         fView= Room.FacingView.NO_VIEW;
                     }
                     System.out.println("Enter room rate: ");
                     double rRate = sc.nextDouble();
                     System.out.println("Enter room weekend rate: ");
                     double rwRate = sc.nextDouble();
                     System.out.println("Enter room number: ");
                     String rNumber=sc.next();
                     System.out.println("Is the room wifi enabled:(y/n)");
                     boolean wifi;
                     char w = sc.next().charAt(0);
                     if(w=='y'){
                         wifi=true;
                     }
                     else{
                         wifi=false;
                     }
                     System.out.println("Is smoking allowed in the room:(y/n)");
                     boolean smoking;
                     char s = sc.next().charAt(0);
                     if(s=='y'){
                         smoking=true;
                     }
                     else{
                         smoking=false;
                     }
                     Room room = new Room(rType,bType,rstatus,fView,rRate,rwRate,rNumber,wifi,smoking);
                     HotelController.createRoom(room);
                     System.out.println("A new room was created successfully");
                     break;
                 case 2:
                     System.out.println("Enter the room number of the room whose details you would like to modify: ");
                     String rNum=sc.next();
                     HotelController.updateRoomDetails(rNum);
                     System.out.println("The room detail(s) was/were edited successfully!");
                     break;
                 case 3:
                     HotelController.displayAllRooms();
                     break;
                 case 4:
                     System.out.println("Enter the room number of the room whose details you would like to remove: ");
                     rNum=sc.next();
                     HotelController.removeRooms(rNum);
                     System.out.println("Room has been removed successfully");
                     break;
                 default:
                     System.out.println("Enter the correct value: ");

             }
             System.out.println("Enter your choice:\n " +
                     "1. Create a room\n" +
                     "2. Update the details of a room\n" +
                     "3. Display all the rooms\n" +
                     "4. Remove a room\n" +
                     "5. Exit");
             decision = sc.nextInt();
         }
     }


}
