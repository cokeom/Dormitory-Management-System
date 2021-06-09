package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Canteen;
import model.DorPark;
import model.Pbuilding;
import model.Room;
import model.Student;

public class StudentDao extends BaseDao{
	//登录系统
	public Student selectStudent(String username,String password) {
		String sqlStr = "select * from s_student where username = ? and password = ? ";
		Student student = null;
		try {
			
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, username);
			this.pStatement.setString(2, password);
			ResultSet executeQuery = this.pStatement.executeQuery();
			
			if(executeQuery.next()) {
				student = new Student(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return student;
	}
	//修改密码
	public String revisePassword(Student student,String newpassword) {
		String resultStr = "操作失败！";
		String sqlStr = "update s_student set password = ? where username = ? and password = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, newpassword);
			this.pStatement.setString(2, student.getName());
			this.pStatement.setString(3, student.getPassword());
			System.out.println(newpassword);
			System.out.println(student.getName());
			System.out.println(student.getPassword());
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
}
