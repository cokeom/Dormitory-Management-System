package util;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private static ReadProperties rp;
	
	public String Url;
	public String UserName;
	public String Password;
	
	private ReadProperties() {
		loadProperties();
	}
	public static ReadProperties initial() {
		if(rp==null)
			rp = new ReadProperties();
		return rp;
	}

	private void loadProperties() {
		InputStream ips = getClass().getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(ips);
			this.Url = properties.getProperty("url");
			System.out.println(Url+"123");
			this.UserName = properties.getProperty("username");
			this.Password = properties.getProperty("password");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
