package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

import util.DBUtil;

public class DbServiceDAO {
	//To get the connection object
	static Connection con=DBUtil.getConnectin();
	
	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(DbServiceDAO.class);
	
	//This will insert teams in team_table
	public void insertTeam(Set<String> teamName){
		PreparedStatement pstmt=null;
		log.info("insertTeam()");
		for(String team:teamName){
			try{
				log.info(team);
				pstmt=con.prepareStatement("insert into team(team_name) values(?)");
				pstmt.setString(1,team);
				pstmt.executeUpdate();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
	}
	
	public void insertVenue(Map<String,String> venueMap){
		PreparedStatement pstmt=null;
		log.info("insertVenue()");
		for(Map.Entry<String, String> entry : venueMap.entrySet())
		{
			try{
				log.info(entry.getKey()+" "+entry.getValue());
				pstmt=con.prepareStatement("insert into venue(city,venue_name) values(?,?)");
				pstmt.setString(1, entry.getKey());
				pstmt.setString(2, entry.getValue());
				pstmt.executeUpdate();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
	}	
}
