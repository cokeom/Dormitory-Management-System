package model;

public class StudentInfo {
	private String username;
	private String name;
	private String grade;
	private String academy;
	private String major;
	private String sex;
	private Integer age;
	private String telephone;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public StudentInfo(String username, String name, String grade, String academy, String major, String sex, Integer age,
			String telephone) {
//		super();
		this.username = username;
		this.name = name;
		this.grade = grade;
		this.academy = academy;
		this.major = major;
		this.sex = sex;
		this.age = age;
		this.telephone = telephone;
	}
	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}

	
}
