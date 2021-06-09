package model;
//宿舍
public class Room {
	private String buildingname;
	private Integer housenumber;
	private Integer electricity;
	private Integer population;
	public Room(String buildingname, Integer housenumber, Integer electricity, Integer water, Integer population) {
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
	public Integer getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(Integer housenumber) {
		this.housenumber = housenumber;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}

	
}
