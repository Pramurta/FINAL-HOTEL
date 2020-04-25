package com.company;

import java.util.List;
import java.util.Scanner;

public class MenuController extends FileIO{
    public static void addMenuItem(int id,String menuItemName,String menuItemDescription, double menuItemPrice){
        List list = readSerializedObject("Menu.dat");
        MenuItem menuItem = new MenuItem(id,menuItemName,menuItemDescription,menuItemPrice);
        list.add(menuItem);
        writeSerializedObject("Menu.dat", list);
    }

    public static void displayMenuItems(){
        List list = readSerializedObject("Menu.dat");
        for(int i=0;i<list.size();i++){
            MenuItem m = (MenuItem) list.get(i);
            System.out.println("Menu item ID: "+m.getId());
            System.out.println("Menu item name: "+m.getName());
            System.out.println("Menu item description: "+m.getDescription());
            System.out.println("Menu item price: "+m.getPrice()+"\n\n");
        }
    }

    public static void removeMenuItem(int idOfRemovalItem){
        List list = readSerializedObject("Menu.dat");
        for(int i=0;i<list.size();i++){
            MenuItem m = (MenuItem) list.get(i);
            if(m.getId()==idOfRemovalItem){
                list.remove(m);
                writeSerializedObject("Menu.dat", list);
            }
        }
    }

    public static void updateMenuItem(int mid){
        Scanner sc = new Scanner(System.in);
        int found=0;
        List list = readSerializedObject("Menu.dat");
        for(int i = 0; i < list.size(); i++){
            MenuItem m = (MenuItem) list.get(i);
            if(mid == m.getId()){
                found=1;
                System.out.println("The item is found, what do u want to change about the item\n 1 Name\n " +
                        "2 Description \n 3 Price \n 4 Exit");
                int decision = Integer.parseInt(sc.nextLine());
                while(decision!=4){
                switch (decision){
                    case 1:
                        System.out.println("The old name was " + m.getName());
                        System.out.print("\nNew name: ");
                        String newName = sc.nextLine();
                        m.setName(newName);
                        writeSerializedObject("Menu.dat", list);
                        break;

                    case 2:
                        System.out.println("This is the old description " + m.getDescription());
                        System.out.print("\nNew description: ");
                        String newDescription = sc.nextLine();
                        m.setDescription(newDescription);
                        writeSerializedObject("Menu.dat", list);
                        break;

                    case 3:
                        System.out.println("This is the old price " + m.getPrice());
                        System.out.print("\nNew Price: ");
                        double newPrice = sc.nextDouble();
                        m.setPrice(newPrice);
                        writeSerializedObject("Menu.dat", list);
                        break;

                    default:
                        System.out.println("Please put valid number ");

                    }
                    System.out.println("What do you want to change about the item: \n 1 Name\n " +
                            "2 Description \n 3 Price \n 4 Exit");
                    sc.nextLine();
                    decision = Integer.parseInt(sc.nextLine());

                }
                //sc.close();


            }

        }
        if(found==0){
            System.out.println("Item not found");
        }
    }

    public static void createMenu(){
        MenuController.addMenuItem(1,"Fried Chicken Waffle","Half a fried chciken and a Belgian waffle topped with sweet strawberry butter",15);
        MenuController.addMenuItem(2,"Roast beef bleu","Slow cooked roast beef with melted bleu cheese crumbles on grilled rye",20);
        MenuController.addMenuItem(3,"Mahi mahi","6 oz Mahi filet grilled, blackened and fried with shredded lettuce and tomato",17);
        MenuController.addMenuItem(4,"Steak Frites","10oz NY Strip steak served with Parmesan cheese fries and garlic aioli sauce",12);
        MenuController.addMenuItem(5,"Funnel Cake","Fried spiral cake topped with confectioners' sugar & vanilla bean whipped cream",8);
    }
}
