package model;
//楼栋
public class Pbuilding {
	private String Bname;
	private String Pname;
	public Pbuilding(String bname, String pname, Integer bnumber) {
		super();
		Bname = bname;
		Pname = pname;
		Bnumber = bnumber;
	}
	public Pbuilding() {
		// TODO Auto-generated constructor stub
	}
	private Integer Bnumber;
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public Integer getBnumber() {
		return Bnumber;
	}
	public void setBnumber(Integer bnumber) {
		Bnumber = bnumber;
	}
}
