package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Canteen;

public class CanteenDao extends BaseDao{

	public String updateName(String oldname , String newname) {
		String resultStr = "修改食堂名字失败！";
		String sqlStr = "update canteen set Cname = ? where Cname = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1,newname);
			this.pStatement.setString(2,oldname);

			if(this.pStatement.executeUpdate()>0) {
				resultStr = "修改食堂名字成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}

	public String updateFeaturedDish(String name , String dishName) {
		String resultStr = "修改食堂特色菜失败！";
		String sqlStr = "update canteen set Featured_dishes = ? where Cname = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1,dishName);
			this.pStatement.setString(2,name);

			if(this.pStatement.executeUpdate()>0) {
				resultStr = "修改食堂特色菜成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}
	
	public String updateSeatNum(String name , String seatNum) {
		String resultStr = "修改食堂座位数失败！";
		String sqlStr = "update canteen set Seat_num = ? where Cname = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1,seatNum);
			this.pStatement.setString(2,name);

			if(this.pStatement.executeUpdate()>0) {
				resultStr = "修改食堂座位数成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}	
	
	public ArrayList <Canteen> queryAllCan() {
		ArrayList <Canteen> array = new ArrayList<Canteen>();
		String sqlStr = "select * from canteen";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Canteen tempCan = new Canteen();
				tempCan.setCname(executeQuery.getString(1));
				tempCan.setDorName(executeQuery.getString(2));
				tempCan.setDishes(executeQuery.getString(3));
				tempCan.setSeat(executeQuery.getInt(4));
				array.add(tempCan);
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