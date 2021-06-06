package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao extends BaseDao{
	public Admin selectAdmin(String name,String password) {
		String sqlStr = "select * from s_admin where username = ? and password = ? ";
		Admin admin = null;
		try {
			
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, name);
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

}
