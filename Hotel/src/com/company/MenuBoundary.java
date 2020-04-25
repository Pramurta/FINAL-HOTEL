package com.company;

import java.util.Scanner;

public class MenuBoundary {
    public static void enterMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What do u want from menu\n 1  Add a new menu item \n 2 Update a menu item\n 3 Remove a menu item" +
                "\n 4 Display all menu items"+"\n 5 Exit");

        int decision = Integer.parseInt(sc.nextLine());
        while (decision!=5){
         switch (decision){
             case 1:
                 System.out.println("The old menu is:");
                 MenuController.displayMenuItems();
                 System.out.println("Enter a unique menu id number: ");
                 int id = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Entry of new menu item name: ");
                 String menuItemName = sc.nextLine();
                 System.out.println("Entry for new menu item description: ");
                 String menuItemDescription = sc.nextLine();
                 System.out.print("Entry for menu item price: ");
                 double menuItemPrice = Double.parseDouble(sc.nextLine());
                 // creating menu item in arraylist
                 MenuController.addMenuItem(id,menuItemName,menuItemDescription,menuItemPrice);
                 System.out.println("Menu item is added");
                 break;

             case 2:
                 System.out.println("The menu is:");
                 MenuController.displayMenuItems();
                 System.out.println("Enter the id of the menu item you want to update: ");
                 int mid = sc.nextInt();
                 MenuController.updateMenuItem(mid);
                 sc.nextLine();
                 System.out.println("The updated menu is: ");
                 MenuController.displayMenuItems();
           //      MenuController.updateMenuItem();
                 break;

             case 3:
                 MenuController.displayMenuItems();
                 System.out.println("Enter the ID of the menu item you want to remove: ");
                 int idOfRemovalItem = Integer.parseInt(sc.nextLine());
                 MenuController.removeMenuItem(idOfRemovalItem);
                 System.out.println("The updated menu is: ");
                 MenuController.displayMenuItems();
                 break;
             case 4:
                 System.out.println("The menu is: ");
                 MenuController.displayMenuItems();
                 break;
             default:
                 System.out.println("Enter valid number: ");
         }

            System.out.println("Enter your choice\n 1  Add a new menu item \n 2 Update a menu item\n 3 Remove a menu item" +
                    "\n 4 Display all menu items"+"\n 5 Exit");

            decision = Integer.parseInt(sc.nextLine());

        }


    }


}
