package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private ReadProperties rp = ReadProperties.initial();
	
	public Connection getConnection() {
		try {
			Class.forName(jdbcDriver);
			System.out.println(rp.Url);
			Connection connection = DriverManager.getConnection(this.rp.Url,this.rp.UserName,this.rp.Password);
			return connection;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
