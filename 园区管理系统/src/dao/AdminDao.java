package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao extends BaseDao{
	//登录系统
	public Admin selectAdmin(String username,String password) {
		String sqlStr = "select * from s_admin where username = ? and password = ? ";
		Admin admin = null;
		try {
			
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, username);
			this.pStatement.setString(2, password);
			ResultSet executeQuery = this.pStatement.executeQuery();
			
			if(executeQuery.next()) {
				admin = new Admin(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return admin;
	}
	//修改密码
	public String revisePassword(Admin admin,String newpassword) {
		String resultStr = "操作失败！";
		String sqlStr = "update s_admin set password = ? where username = ? and password = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, newpassword);
			this.pStatement.setString(2, admin.getName());
			this.pStatement.setString(3, admin.getPassword());
			System.out.println(newpassword);
			System.out.println(admin.getName());
			System.out.println(admin.getPassword());
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
