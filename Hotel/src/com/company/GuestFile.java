package com.company;

import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GuestFile extends FileIO{
    public static void displayGuestDetails() {
        List list ; //= new ArrayList<Guest>();
        try	{

            // read from serialized file the list of professors
            list = (ArrayList) readSerializedObject("Guest.dat");
            for (int i = 0 ; i < list.size() ; i++) {
                Guest g = (Guest)list.get(i);
                System.out.println("Name: " + g.getName() );
                System.out.println("Address: " + g.getAddress());
                System.out.println("Country: " + g.getCountry());
                System.out.println("Gender: " + g.getGender());
                System.out.println("Nationality: " + g.getNationality());
                System.out.println("Phone Number: " + g.getPhoneNumber());
                System.out.println("Passport Number: " + g.getPassportNumber());
                System.out.println("Card holder name: " + g.getCreditCard().getCardHolderName());
                System.out.println("Credit Card Number: " + g.getCreditCard().getCreditCardnumber());
                DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy ");
                String strDate = dateFormat.format(g.getCreditCard().getExpiryDate());
                System.out.println("Expiry date of credit card: " + strDate);
                System.out.println("Cash:  " + g.getCash());
            }
        }catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );

        }
    }

    public static void addGuestDetails(Guest g) {
        List list = readSerializedObject("Guest.dat");
        list.add(g);
        writeSerializedObject("Guest.dat", list);
    }

    public static void removeGuestDetails(String pNum) {
        List list = readSerializedObject("Guest.dat");
        for (int i = 0; i < list.size(); i++) {
            Guest g = (Guest) list.get(i);
            if (g.getPassportNumber().equals(pNum)) {
                list.remove(g);
                writeSerializedObject("Guest.dat", list);
            }
        }
    }

    public static List getGuestList(){
        List list = readSerializedObject("Guest.dat");
        return list;
    }

    public static void searchGuestDetails(String pNum){
        List list = readSerializedObject("Guest.dat");
        int found=0;
        for (int i = 0; i < list.size(); i++) {
            Guest g = (Guest) list.get(i);
            if (g.getPassportNumber().equals(pNum)) {
                found=1;
                System.out.println("Guest is found!");
                System.out.println("The details are: ");
                System.out.println("Name: "+g.getName());
                System.out.println("Address: "+g.getAddress());
                System.out.println("Country: "+g.getCountry());
                System.out.println("Gender: "+g.getGender());
                System.out.println("Nationality: "+g.getNationality());
                System.out.println("Phone Number: "+g.getPhoneNumber());
                System.out.println("Passport Number: "+g.getPassportNumber());
                System.out.println("Card Holder Name: "+g.getCreditCard().getCardHolderName());
                System.out.println("Credit Card Number: "+g.getCreditCard().getCreditCardnumber());
                DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy ");
                String strDate = dateFormat.format(g.getCreditCard().getExpiryDate());
                System.out.println("Expiry date of credit card: "+strDate);
                System.out.println("Cash in hand: "+g.getCash());
                writeSerializedObject("Guest.dat", list);
                break;
            }
        }
        if(found==0){
            System.out.println("Guest not found! ");
        }

    }
//        for(Object g: list){
//            if(g instanceof Guest){
//               if(((Guest) g).getPassportNumber().equals(pNum))
//                   list.remove(g);
//               }
//            }
//        }
        //list.remove(g);
       // GuestFile.writeSerializedObject("Guest.dat", list);
    }

//	public static void main(String[] args) {
    //List list ;//= new ArrayList<Guest>();
//		try	{
//
//				// read from serialized file the list of professors
//				list = (ArrayList)GuestBinaryDB.readSerializedObject("Guest.dat");
//				for (int i = 0 ; i < list.size() ; i++) {
//					Guest g = (Guest)list.get(i);
//					System.out.println("Name is " + g.getName() );
//					System.out.println("Credit Card Number is " + g.getCreditCardNum());
//					System.out.println("Address is " + g.getAddress());
//					System.out.println("Country is " + g.getCountry());
//					System.out.println("Gender is " + g.getGender());
//					System.out.println("Nationality is " + g.getNationality());
//					System.out.println("Phone Number is " + g.getPhoneNumber());
//					System.out.println("Passport Number is " + g.getPassportNumber());
//				}

    // write to serialized file - update/insert/delete
    // example - add one more professor
    //Guest g = new Guest("Stavya","1234567890","Jaypee Greens","India","Male","Indian", "9812345678","G1674974");
    // add to list
    //list.add(g);
    //list.remove(g);  // remove if p equals object in the list

    //GuestBinaryDB.writeSerializedObject("Guest.dat", list);

//		}  catch ( Exception e ) {
//					System.out.println( "Exception >> " + e.getMessage() );
//		}
//	}


