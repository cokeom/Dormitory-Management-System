package model;

public class Canteen {
	private String Cname;
	private String DorName;
	private String dishes;
	private Integer seat;
	public Canteen(String cname, String dorName, String dishes, Integer seat) {
		super();
		Cname = cname;
		DorName = dorName;
		this.dishes = dishes;
		this.seat = seat;
	}
	public Canteen() {
		super();
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getDorName() {
		return DorName;
	}
	public void setDorName(String dorName) {
		DorName = dorName;
	}
	public String getDishes() {
		return dishes;
	}
	public void setDishes(String dishes) {
		this.dishes = dishes;
	}
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(Integer seat) {
		this.seat = seat;
	}
}
