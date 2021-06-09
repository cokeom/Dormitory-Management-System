package model;
//园区
public class DorPark {
	private String Pname;
	private String Paddress;
	
	public DorPark(String pname, String paddress) {
		super();
		Pname = pname;
		Paddress = paddress;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getPaddress() {
		return Paddress;
	}

	public void setPaddress(String paddress) {
		Paddress = paddress;
	}
	@Override
	public String toString() {
		return "DorPark [Pname=" + Pname + ", Paddress=" + Paddress + ", getPname()=" + getPname() + ", getPaddress()="
				+ getPaddress() + "]";
	}

}
