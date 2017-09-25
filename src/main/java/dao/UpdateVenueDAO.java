package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

import util.DBUtil;

public class UpdateVenueDAO {

	public static int updateVenue(String id, String name, String city) throws SQLException {
		// TODO Auto-generated method stub
		final org.slf4j.Logger log=LoggerFactory.getLogger(UpdateVenueDAO.class); 			

		Connection con=DBUtil.getConnectin();
     	log.info("updatevenuedao");
		PreparedStatement ps=con.prepareStatement("update venue set city=? and venue_name=? where venue_id=?");
		log.debug("ps");
		ps.setString(1,city.trim());
		log.debug("city");
		ps.setString(2,name.trim());
		log.debug("name");
		ps.setInt(3,Integer.parseInt(id));
		log.debug("id");
		
		Integer i=ps.executeUpdate(); 
		log.debug(i.toString());
		return i;
	}
	

}
