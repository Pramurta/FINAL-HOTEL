package com.company;
import java.util.Date;

import java.util.ArrayList;
import java.io.Serializable;
public class RoomService implements Serializable{

    public enum RoomServiceStatus{
        CONFIRMED,PREPARING,DELIVERED
    }
    private int roomServiceId;
	private Date date;
	private double cost;
	private ArrayList<MenuItem> itemsSelected;
    private String remarks;
    private RoomServiceStatus roomServiceStatus;
    private static final long serialVersionUID=8960344642728822683L;

	public RoomService(int roomServiceId,Date date, double cost, ArrayList<MenuItem> itemsSelected,String remarks,RoomServiceStatus roomServiceStatus){
        this.roomServiceId=roomServiceId;
		this.date=date;
		this.cost=cost;
		this.itemsSelected=itemsSelected;
		this.remarks=remarks;
		this.roomServiceStatus=roomServiceStatus;
	}

	public int getRoomServiceId(){
	    return roomServiceId;
    }

    public void setRoomServiceId(int rid){
	    this.roomServiceId=rid;
    }




	public Date getDate() {
		return this.date;
	}

    public void setDate(Date date) {
        this.date=date;
    }

	public double getCost() {
		return this.cost;
	}




	public void setCost(double cost) {
		this.cost=cost;
	}

	public ArrayList<MenuItem> getItemsSelected() {
		return itemsSelected;
	}

	public void setItemsSelected(ArrayList<MenuItem> itemsSelected){
        this.itemsSelected=itemsSelected;
    }


	public void addNewMenuItem(MenuItem menuItem){
	    itemsSelected.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem){
		for(int i=0;i<itemsSelected.size();i++){
			MenuItem m = (MenuItem)itemsSelected.get(i);
			if(m.getId()==menuItem.getId()){
				itemsSelected.remove(m);
				break;
			}
		}
    }

    public String getRemarks(){
	    return remarks;
    }

    public void setRemarks(String remarks){
	    this.remarks=remarks;
    }

    public RoomServiceStatus getRoomServiceStatus(){
	    return roomServiceStatus;
    }

    public void setRoomServiceStatus(RoomServiceStatus roomServiceStatus){
	    this.roomServiceStatus=roomServiceStatus;
    }


}
