package com.company;

import java.util.ArrayList;
import java.io.Serializable;

public class Room implements Serializable{

	public enum RoomType {
        SINGLE, DOUBLE, DELUXE, VIP
    }
	
    public enum BedType {
        SINGLE_BED, DOUBLE_BED, MASTER_BED
    }

	public enum RoomStatus {
        VACANT, OCCUPIED, RESERVED, UNDER_MAINTENANCE
    }

    public enum FacingView {
        CITY_VIEW, SEA_VIEW, PARK_VIEW, POOL_VIEW, MOUNTAIN_VIEW, NO_VIEW
    }
    
    private static final long serialVersionUID = 6438902214071397951L;
    private double roomRate;
    private double  roomWeekendRate;
    private String roomNumber;
    private boolean wifiEnabled;
    private boolean smoking;
    private RoomType roomType;
    private BedType bedType;
    private RoomStatus roomStatus;
    private FacingView facingView;
	private ArrayList<RoomService> roomServices = new ArrayList<RoomService>();
//    private ArrayList<Guest> guests;

//    private Reservation reservation;

	public Room(RoomType roomType,BedType bedType,RoomStatus roomStatus, FacingView facingView, double roomRate,double  roomWeekendRate,String roomNumber, boolean wifiEnabled,boolean smoking){
		this.roomType=roomType;
		this.bedType=bedType;
		this.roomStatus=roomStatus;
		this.facingView=facingView;
		this.roomRate=roomRate;
		this.roomWeekendRate=roomWeekendRate;
		this.roomNumber=roomNumber;
		this.wifiEnabled=wifiEnabled;
		this.smoking=smoking;
//		roomServices = new ArrayList<RoomService>();
//		guests = new ArrayList<Guest>();
	}


//	public void getGuests() {
//		for(Guest guest: guests){
//			System.out.println("Names " + guest.getName() + "\n");
//		}
//	}

	public double getRoomRate() {
		return roomRate;
	}
	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}
	public double getRoomWeekendRate() {
		return roomWeekendRate;
	}
	public void setRoomWeekendRate(double roomWeekendRate) {
		this.roomWeekendRate = roomWeekendRate;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public boolean isWifiEnabled() {
		return wifiEnabled;
	}
	public void setWifiEnabled(boolean wifiEnabled) {
		this.wifiEnabled = wifiEnabled;
	}
	public boolean isSmoking() {
		return smoking;
	}
	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public RoomStatus getStatus() {
		return roomStatus;
	}
	public void setStatus(RoomStatus status) {
		this.roomStatus = status;
	}
	public FacingView getFacing() {
		return facingView;
	}
	public void setFacing(FacingView facing) {
		this.facingView = facing;
	}

	public ArrayList<RoomService> getRoomServices(){
		return roomServices;
	}

	public void setRoomServices(ArrayList<RoomService> roomServices){
		this.roomServices=roomServices;
	}

	public void addRoomService(RoomService roomService){

			roomServices.add(roomService);
	}

	public void removeRoomService(RoomService roomService){
		roomServices.remove(roomService);
	}

	public RoomService getRoomServiceByRoomServiceId(int rsId){
		for(RoomService roomService: roomServices){
			if(roomService.getRoomServiceId()==rsId){
				return roomService;
			}

		}
		return null;
	}






//	public String getCompleteRoomNumber() {
//		return completeRoomNumber;
//	}
//
//	public void setCompleteRoomNumber(){
//		this.completeRoomNumber = String.format("0%d-0%d", this.roomFloor, this.roomNumber);
//	}

//	public Reservation getReservation() {
//		return reservation;
//	}

//	public void setReservation(Reservation reservation) {
//		this.reservation = reservation;
//	}

//	public ArrayList<RoomService> getRoomServices() {
//		return this.roomServices;
//	}

//	public void addRoomService(RoomService roomService) {
//		this.roomServices.add(roomService);
//	}

//	private double totalCostRoomServices(){
//		double price = 0.0;
//		for(RoomService roomService: this.roomServices){
//			price = price + roomService.getCost();
//		}
//		return price;
//	}

//	public void printRoomServices(){
//		for(RoomService roomService: this.roomServices){
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//			String time = dtf.format(roomService.getDate());
//			System.out.printf("the time is %s\n", time);
//			for(MenuItem menuItem: roomService.getItemsSelected()){
//				System.out.printf("The item description is %s and name is %s\n", menuItem.getDescription(),
//						menuItem.getName());
//			}
//		}
//	}

//	public static void printingRoomTypes(){
//		for(int i = 0; i<RoomType.values().length;i++){
//			System.out.printf("%d for %s\n", i, RoomType.values()[i]);
//		}
//	}
//	public static void printingBedType(){
//		for(int i = 0; i<BedType.values().length;i++){
//			System.out.printf("%d for %s\n", i, BedType.values()[i]);
//		}
//	}
//	public static void printingFacingView(){
//		for(int i = 0; i<FacingView.values().length;i++){
//			System.out.printf("%d for %s\n", i, FacingView.values()[i]);
//		}
//	}

//	public double roomCost(){
//		double price = this.getRoomRate() + this.totalCostRoomServices();
//		return price;
//	}

}
