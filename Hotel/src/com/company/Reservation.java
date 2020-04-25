package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Reservation implements Serializable{
    private int reservationNumber;
    private Guest guest;
    private  ArrayList<Room> rooms;
   // private enum reservationStatus;
    private int numberOfAdults;
    private int numberOfChildren;
    private Date fromDate;
    private Date toDate;


    public enum ReservationStatus {
        CONFIRMED,
        WAITLIST,
        CHECKEDIN,
        EXPIRED
    }

    private ReservationStatus reservationStatus;


    public Reservation(int reservationNumber, Guest guest, ArrayList<Room> rooms,int numberOfAdults, int numberOfChildren,Date fromDate,Date toDate, ReservationStatus reservationStatus){
        this.reservationNumber=reservationNumber;
        this.guest=guest;
        this.rooms=rooms;
        this.numberOfAdults=numberOfAdults;
        this.numberOfChildren=numberOfChildren;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.reservationStatus=reservationStatus;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }



    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms){
        this.rooms=rooms;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

//    public double totalReservationCost() {
//        // finding the total room cost of the guest
//        double price = 0;
//        for(Room room: rooms){
//            price = price + room.roomCost();
//        }
//        return price;
//    }

    public int getNumberOfAdultsStaying() {
        return numberOfAdults;
    }

    public void setNumberOfAdultsStaying(int numberOfGuestStaying) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildrenStaying() {
        return numberOfChildren;
    }

    public void setNumberOfChildrenStaying(int numberOfGuestStaying) {
        this.numberOfChildren = numberOfChildren;
    }


    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void removeRoom(Room room){
        for(Room r: rooms){
            if(r.getRoomNumber().equals(room.getRoomNumber())){
                rooms.remove(r);
                break;
            }
        }
    }




}

