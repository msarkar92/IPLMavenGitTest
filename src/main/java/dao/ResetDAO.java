package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.LoggerFactory;



import util.DBUtil;
import bo.LoginBO;

public class ResetDAO {
	public static int updatedata(String newpassword, String email) throws Exception 
	{
		final org.slf4j.Logger log=LoggerFactory.getLogger(ResetDAO.class);
//		String connectionUrl = "jdbc:mysql://localhost:3306/ip";
//		String dbUser = "root";
//		String dbPwd = "root";
//         Class.forName("com.mysql.jdbc.Driver");  
         Connection con=new DBUtil().getConnection();
		log.debug("resetdao");
		PreparedStatement ps=con.prepareStatement("update login set password=? where email=?");
		ps.setString(1,newpassword);
		ps.setString(2,email);
		
		int i=ps.executeUpdate(); 
		
		
		return i;
	}		
}
