package com.company;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;


public class GuestController {


    public static Guest createGuest() throws ParseException {

        String name;
        String address;
        String country;
        String gender;
        String nationality;
        long phoneNumber;
        String passportNumber ;
        String creditCardNum;
        String d;
        double cash;


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter guest name:");
        name = sc.nextLine();

        System.out.println("Enter guest address:");
        address = sc.nextLine();

        System.out.println("Enter guest country:");
        country = sc.nextLine();

        System.out.println("Enter guest gender:");
        gender = sc.nextLine();

        System.out.println("Enter guest nationality:");
        nationality = sc.nextLine();

        System.out.println("Enter guest phone number:");
        phoneNumber = sc.nextLong();


        sc.nextLine();
        System.out.println("Enter guest passport number:");
        passportNumber = sc.nextLine();


        System.out.println("Please enter credit card details: ");
        System.out.println("Please enter card holder name: ");
        String cardHolderName = sc.nextLine();
        System.out.println("Please enter credit card number: ");
        creditCardNum = sc.nextLine();
        System.out.println("Please enter the expiry date of the credit card:(DD-MM-YYYY) ");
        d = sc.next();
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date date = format.parse(d);
        CreditCard creditCard = new CreditCard(cardHolderName, creditCardNum, date);

        System.out.println("Please enter the amount of cash the guest is/will be carrying:(enter 0 if the guest doesn't/will not have any cash) ");
        cash = sc.nextDouble();
        //sc.nextLine();


        Guest g = new Guest(name, address, country, gender, nationality, phoneNumber, passportNumber, creditCard, cash);

        GuestFile.addGuestDetails(g);
        return g;




//        System.out.println("GuestIdNumber "+GuestIdNum+ ": Name "+ g.getName()+ " details.");
//        System.out.println("Passport Number: " + g.getpassportNumber()+ "\n Driving License: " +
//                g.getdrivingLicense() + "\n Phone Number: " + g.getphoneNumber() + "\n Gender: " +g.getGender()
//                + "\n Nationality: "+g.getNationality()+ "\n Country: "+g.getCountry()+ "\n Address: "+
//                g.getAddress());
//        guestIdNumber++;
//        return g;
    }


    public static void UpdateGuest() throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passport number of the guest to update the details:");
        String pNum = sc.next();
        sc.nextLine();
        List guestList=GuestFile.getGuestList();
        for(int i = 0; i < guestList.size(); i++){
            Guest g = (Guest) guestList.get(i);
            if(g.getPassportNumber().equals(pNum)){
                System.out.println("Guest found!");
                System.out.println("The old details are: ");
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
                System.out.println("\n Enter which guest details you wish to update: \n 1 Name"
                        + "\n 2 Address \n 3 Country \n 4 Gender"
                        + "\n 5 Nationality \n 6 Phone Number \n 7 Passport Number \n 8 Credit Card details \n 9 Cash in hand"
                        + "\n 0 Exit");

                int decision = Integer.parseInt(sc.nextLine());
                while(decision!=0) {
                    switch (decision) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("The old name was " + g.getName());
                            System.out.print("\nNew name: ");
                            String newName = sc.nextLine();
                            g.setName(newName);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            List reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setName(newName);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;

                        case 2:
                            System.out.println("The old address was: " + g.getAddress());
                            System.out.print("\nNew address: ");
                            String address = sc.nextLine();
                            g.setAddress(address);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setAddress(address);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;

                        case 3:
                            System.out.println("The old country was: " + g.getCountry());
                            System.out.print("\nNew country: ");
                            String country = sc.nextLine();
                            g.setCountry(country);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setCountry(country);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;


                        case 4:
                            System.out.println("The old gender was: " + g.getGender());
                            System.out.print("\nNew gender: ");
                            String gender = sc.nextLine();
                            g.setGender(gender);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setGender(gender);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;


                        case 5:
                            System.out.println("The old nationality was: " + g.getNationality());
                            System.out.print("\nNew nationality: ");
                            String nationality = sc.nextLine();
                            g.setNationality(nationality);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setNationality(nationality);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;


                        case 6:
                            System.out.println("The old phone number was: " + g.getPhoneNumber());
                            System.out.print("\nNew phone number: ");
                            long phoneNumber = sc.nextInt();
                            g.setPhoneNumber(phoneNumber);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setPhoneNumber(phoneNumber);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;


                        case 7:
                            System.out.println("The old passport number was:" + g.getPassportNumber());
                            System.out.print("\nNew passport number: ");
                            String passportNumber = sc.nextLine();
                            g.setPassportNumber(passportNumber);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setPassportNumber(passportNumber);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;

                        case 8:
                            System.out.println("The old credit card details were: \n");
                            g.getCreditCard().displayCreditCardDetails();
                            System.out.print("\nWhich detail do you want to modify: \n" +
                                    "1 Credit Card holder name\n" +
                                    "2 Credit Card number\n" +
                                    "3 Expiry date of credit card\n" +
                                    "4 Exit");
                            int d = sc.nextInt();
                            while(d!=4){
                                switch(d){
                                    case 1:
                                        System.out.println("The old credit card holder name was: "+ g.getCreditCard().getCardHolderName());
                                        System.out.println("\nNew card holder name: ");
                                        String cname=sc.nextLine();
                                        g.getCreditCard().setCardHolderName(cname);
                                        GuestFile.writeSerializedObject("Guest.dat", guestList);
                                        reservationList = FileIO.readSerializedObject("Reservation.dat");
                                        for(int l=0;l<reservationList.size();l++){
                                            Reservation reservation = (Reservation)reservationList.get(l);
                                            if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                                reservation.getGuest().getCreditCard().setCardHolderName(cname);
                                                break;
                                            }
                                        }
                                        FileIO.writeSerializedObject("Reservation.dat",reservationList);
                                        break;
                                    case 2:
                                        System.out.println("The old credit card number was: "+ g.getCreditCard().getCreditCardnumber());
                                        System.out.println("\nNew credit card number: ");
                                        String cnumber=sc.nextLine();
                                        g.getCreditCard().setCreditCardNumber(cnumber);
                                        GuestFile.writeSerializedObject("Guest.dat", guestList);
                                        reservationList = FileIO.readSerializedObject("Reservation.dat");
                                        for(int l=0;l<reservationList.size();l++){
                                            Reservation reservation = (Reservation)reservationList.get(l);
                                            if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                                reservation.getGuest().getCreditCard().setCreditCardNumber(cnumber);
                                                break;
                                            }
                                        }
                                        FileIO.writeSerializedObject("Reservation.dat",reservationList);
                                        break;
                                    case 3:
                                        strDate = dateFormat.format(g.getCreditCard().getExpiryDate());
                                        System.out.println("The old expiry of the credt card was: "+ strDate);
                                        System.out.println("\nNew expiry date: ");
                                        String dt = sc.next();
                                        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
                                        Date date = format.parse(dt);
                                        g.getCreditCard().setExpiryDate(date);
                                        GuestFile.writeSerializedObject("Guest.dat", guestList);
                                        reservationList = FileIO.readSerializedObject("Reservation.dat");
                                        for(int l=0;l<reservationList.size();l++){
                                            Reservation reservation = (Reservation)reservationList.get(l);
                                            if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                                reservation.getGuest().getCreditCard().setExpiryDate(date);
                                                break;
                                            }
                                        }
                                        FileIO.writeSerializedObject("Reservation.dat",reservationList);
                                        break;
                                    default:
                                        System.out.println("Please enter valid number:\n");
                                }
                                sc.nextLine();
                                System.out.print("\nWhich detail do you want to modify: \n" +
                                        "1 Credit Card holder name\n" +
                                        "2 Credit Card number\n" +
                                        "3 Expiry date of credit card\n" +
                                        "4 Exit");
                                d = sc.nextInt();
                            }
                            break;

                        case 9:
                            System.out.println("The amount of cash in hand previously was: " + g.getCash());
                            System.out.println("\nNew cash in hand: ");
                            double cash = sc.nextDouble();
                            g.setCash(cash);
                            GuestFile.writeSerializedObject("Guest.dat", guestList);
                            reservationList = FileIO.readSerializedObject("Reservation.dat");
                            for(int l=0;l<reservationList.size();l++){
                                Reservation reservation = (Reservation)reservationList.get(l);
                                if(reservation.getGuest().getPassportNumber().equals(pNum)){
                                    reservation.getGuest().setCash(cash);
                                    break;
                                }
                            }
                            FileIO.writeSerializedObject("Reservation.dat",reservationList);
                            break;

                        default:
                            System.out.println("Please enter a valid number.");

                    }
                    sc.nextLine();
                    System.out.println("\n Enter which guest details you wish to update: \n 1 Name"
                            + "\n 2 Address \n 3 Country \n 4 Gender"
                            + "\n 5 Nationality \n 6 Phone Number \n 7 Passport Number \n 8 Credit Card details \n 9 Cash in hand"
                            + "\n 0 Exit");

                    decision = Integer.parseInt(sc.nextLine());
                }
                System.out.println("Updated guest details:\n ");
                System.out.println("Name: "+g.getName());
                System.out.println("Address: "+g.getAddress());
                System.out.println("Country: "+g.getCountry());
                System.out.println("Gender: "+g.getGender());
                System.out.println("Nationality: "+g.getNationality());
                System.out.println("Phone Number: "+g.getPhoneNumber());
                System.out.println("Passport Number: "+g.getPassportNumber());
                System.out.println("Card Holder Name: "+g.getCreditCard().getCardHolderName());
                System.out.println("Credit Card Number: "+g.getCreditCard().getCreditCardnumber());
                strDate = dateFormat.format(g.getCreditCard().getExpiryDate());
                System.out.println("Expiry date of credit card: "+strDate);
                System.out.println("Cash in hand: "+g.getCash());
                break;
            }
        }
    }

    public static void removeGuest(){
        System.out.println("To remove guest please enter his/her passport number:");
        Scanner sc = new Scanner(System.in);
        String pNum = sc.nextLine();
        GuestFile.removeGuestDetails(pNum);
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getGuest().getPassportNumber().equals(pNum)){
                ReservationController.removeAReservation(reservation.getReservationNumber());
            }
        }
    }

    public static void removeGuestByObject(Guest guest){
        List list = FileIO.readSerializedObject("Guest.dat");
        for (int i = 0; i < list.size(); i++) {
            Guest g = (Guest) list.get(i);
            if (g.getPassportNumber().equals(guest.getPassportNumber())) {
                list.remove(g);
                GuestFile.writeSerializedObject("Guest.dat", list);
            }
        }
        List reservationList = FileIO.readSerializedObject("Reservation.dat");
        for(int i=0;i<reservationList.size();i++){
            Reservation reservation = (Reservation)reservationList.get(i);
            if(reservation.getGuest().getPassportNumber().equals(guest.getPassportNumber())){
                ReservationController.removeAReservation(reservation.getReservationNumber());
            }
        }
    }

    public static void displayGuest(){
        GuestFile.displayGuestDetails();
    }

    public static void searchGuest(){
        System.out.println("To search for a guest please enter his/her passport number:");
        Scanner sc = new Scanner(System.in);
        String pNum = sc.nextLine();
       GuestFile.searchGuestDetails(pNum);
    }

    public static void displayASingleGuestDetails(Guest guest) {
        List list;
        try	{

            // read from serialized file the list of professors
            list = (ArrayList)GuestFile.readSerializedObject("Guest.dat");
            for (int i = 0 ; i < list.size() ; i++) {
                Guest g = (Guest)list.get(i);
                if(guest.getPassportNumber().equals(g.getPassportNumber())) {
                    System.out.println("Name: " + g.getName());
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
            }
        }catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );

        }
    }


}
