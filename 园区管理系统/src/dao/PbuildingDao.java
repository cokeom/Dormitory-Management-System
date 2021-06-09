package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pbuilding;

public class PbuildingDao extends BaseDao{

	public String updateName(String oldname , String newname) {
		String resultStr = "修改楼栋名字失败！";
		String sqlStr1 = "set foreign_key_checks = 0;";
		String sqlStr2 = "set foreign_key_checks = 1;";
		String sqlStr = "update pbuilding set Bname = ? where Bname = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			ResultSet executeQuery1 = this.pStatement.executeQuery();
			
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1,newname);
			this.pStatement.setString(2,oldname);

			if(this.pStatement.executeUpdate()>0) {
				resultStr = "修改楼栋名字成功！";
			}
			
			this.pStatement = this.con.prepareStatement(sqlStr2);
			ResultSet executeQuery2 = this.pStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}
	
	public ArrayList <Pbuilding> queryAllPbd() {
		ArrayList <Pbuilding> array = new ArrayList<Pbuilding>();
		String sqlStr = "select * from pbuilding";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Pbuilding tempPbd = new Pbuilding();
				tempPbd.setBname(executeQuery.getString(1));
				tempPbd.setPname(executeQuery.getString(2));
				tempPbd.setBnumber(executeQuery.getInt(3));
				array.add(tempPbd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return array;
	}
}