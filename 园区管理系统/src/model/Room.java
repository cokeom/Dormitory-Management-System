package model;

public class Room {
	private String buildingname;
	private int housenumber;
	private Integer electricity;
//	private Integer water;
	private Integer population;
	public Room(String buildingname, int housenumber, Integer electricity, Integer population) {
		this.buildingname = buildingname;
		this.housenumber = housenumber;
		this.electricity = electricity;
		this.population = population;
	}
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public String getBuildingname() {
		return buildingname;
	}
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	public int getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
//	public Integer getWater() {
//		return water;
//	}
//	public void setWater(Integer water) {
//		this.water = water;
//	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}

	
}
