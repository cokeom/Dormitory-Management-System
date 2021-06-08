package model;

public class StudentRoom {
	private int roomnumber;	
	private String buildingname;
	private String username;
	public int getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getBuildingname() {
		return buildingname;
	}
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StudentRoom(int roomnumber, String buildingname, String username) {
		this.roomnumber = roomnumber;
		this.buildingname = buildingname;
		this.username = username;
	}
	public StudentRoom() {
	}

	
	
}
