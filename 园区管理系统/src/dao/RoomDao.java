package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.Room;
import model.StudentInfo;

public class RoomDao extends BaseDao{
	//交水费
	public String payWater(String Bname,String Dnumber,String WaterFee) throws SQLException {
		String resultStr = "添加失败";
		String sqlStr = "update room set electric_fee=electric_fee+? where Bname= ? and room_number= ?";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(2, Bname);
			this.pStatement.setString(3, Dnumber);
			this.pStatement.setString(1, WaterFee);
			if(this.pStatement.executeUpdate()>0) {
				resultStr = "操作成功!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
		
		
	}
	
	//查询
	public ArrayList queryRoom() {
		ArrayList array = new ArrayList();
		String sqlStr = "select * from student";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				StudentInfo tempStudent = new StudentInfo();
				tempStudent.setUsername(executeQuery.getString(1));
				tempStudent.setName(executeQuery.getString(2));
				tempStudent.setGrade(executeQuery.getString(3));
				tempStudent.setMajor(executeQuery.getString(5));
				tempStudent.setAcademy(executeQuery.getString(4));
				tempStudent.setSex(executeQuery.getString(6));
				tempStudent.setAge(Integer.parseInt(executeQuery.getString(7)));
				tempStudent.setTelephone(executeQuery.getString(8));
				array.add(tempStudent);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return array;
	}
	
	//条件查询
	public ArrayList <StudentInfo> ConQueryRoom(String Bname,String Rnumber){
		ArrayList<StudentInfo> arrays = new ArrayList<StudentInfo>();
		String sqlStr = "select student.* from student,student_room where student_room.Bname like '"+Bname+"%' and room_number like '"+Rnumber+"' and student.student_number=student_room.student_number";
		System.out.println(sqlStr);
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				StudentInfo tempStudent = new StudentInfo();
				tempStudent.setUsername(executeQuery.getString(1));
				tempStudent.setName(executeQuery.getString(2));
				System.out.println(tempStudent.getUsername());
				tempStudent.setGrade(executeQuery.getString(3));
				tempStudent.setMajor(executeQuery.getString(5));
				tempStudent.setAcademy(executeQuery.getString(4));
				tempStudent.setSex(executeQuery.getString(6));
				tempStudent.setAge(Integer.parseInt(executeQuery.getString(7)));
				tempStudent.setTelephone(executeQuery.getString(8));
				arrays.add(tempStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return arrays;
	}

	public ArrayList<Room> QueryRoom(String bname, String rnumber) {
		// TODO Auto-generated method stub
		
		ArrayList<Room> result = new ArrayList<Room>();
		String sqlStr = "select * from room where Bname like '%"+bname+"%' and room_number like '%"+rnumber+"%';";
		System.out.println(sqlStr);
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Room tempRoom = new Room();
				tempRoom.setHousenumber(Integer.parseInt(executeQuery.getString(1)));
				tempRoom.setBuildingname(executeQuery.getString(2));
				tempRoom.setElectricity(Integer.parseInt(executeQuery.getString(3)));
				tempRoom.setPopulation(Integer.parseInt(executeQuery.getString(4)));
				result.add(tempRoom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return result;
	}
		
	
	
}
