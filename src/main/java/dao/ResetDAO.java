package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.LoggerFactory;

import util.DBUtil;

public class ResetDAO {
	final static org.slf4j.Logger log=LoggerFactory.getLogger(ResetDAO.class);
	
	public static Integer updatedata(String newpassword, String email) throws Exception 
	{		
		Connection con=null;
		Integer i=null;
		try{
			con=DBUtil.getConnectin();
			log.debug("resetdao");
			PreparedStatement ps=con.prepareStatement("update admin_details set admin_password=? where admin_email=?");
			ps.setString(1,newpassword);
			ps.setString(2,email);

			i=ps.executeUpdate(); 
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return i;
	}		
}
