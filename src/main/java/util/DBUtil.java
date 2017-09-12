package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBUtil {
	//Create DB Connection
	
	public Connection getConnectin(){
		Connection con=null;
		try{  
			ResourceBundle rb= ResourceBundle.getBundle("mysql");
			String url=rb.getString("db.url");
			String username=rb.getString("db.username");
			String pass=rb.getString("db.password");
			
			
			//step1 load the driver class
			Class.forName("com.mysql.jdbc.Driver");  

			//step2 create  the connection object
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl","root","root");
			con = DriverManager.getConnection(url,username,pass);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
}
