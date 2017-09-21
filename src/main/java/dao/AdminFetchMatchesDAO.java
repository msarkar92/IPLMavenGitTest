package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import util.DBUtil;
import dto.ViewDTO;

public class AdminFetchMatchesDAO {
	final static org.slf4j.Logger log=LoggerFactory.getLogger(AdminFetchMatchesDAO.class);
	
	public static List<ViewDTO> getMatches(){
		Connection con=null;
	    Statement stm=null;
	    ResultSet rst=null;
	    List<ViewDTO> matchList=new ArrayList<ViewDTO>();
	    try{
	    	con=DBUtil.getConnectin();
	    	stm = con.createStatement();
	    	String sql = "select m.season,m.date,v.venue_name,v.city,t1.team_name,t2.team_name from "
	    			+ " match_details m join venue v on m.venue_id=v.venue_id "
	    			+ " join team t1 on t1.team_id=m.team1_id "
	    			+ " join team t2 on t2.team_id=m.team2_id ";
	    	
	    	rst = stm.executeQuery(sql);

	    	while (rst.next()) {
	    		ViewDTO view= new ViewDTO(Integer.parseInt(rst.getString(1)),rst.getDate(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
	    		matchList.add(view);
	    	}  
	    }catch(Exception e){
	    	log.error(e.getMessage());
	    }
	    finally{
	    	try{
	    		stm.close();
	    		rst.close();
	    		con.close();
	    	}catch(Exception e){
	    		log.error(e.getMessage());
	    	}
	    }
		return matchList;	    
	}
}
