package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

import dto.CsvFileDTO;
import dto.MatchDTO;
import dto.OutcomeDTO;
import dto.ResponseDTO;
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
	
	public void insertToss(Set<String> tossSet){
		log.info("insertToss()");
		PreparedStatement pstmt=null;
		for(String toss:tossSet){
			try{
				log.info(toss);
				pstmt=con.prepareStatement("insert into toss(toss_decision) values(?)");
				pstmt.setString(1,toss);
				pstmt.executeUpdate();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
	}
	
	public void insertUmpire(Set<String> umpireNameSet){
		log.info("insertUmpire()");
		PreparedStatement pstmt=null;
		for(String umpireName:umpireNameSet){
			try{
				log.info(umpireName);
				pstmt=con.prepareStatement("insert into umpire(umpire_name) values(?)");
				pstmt.setString(1,umpireName);
				pstmt.executeUpdate();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
	}
	
	public ResponseDTO insertMatchDetails(List<CsvFileDTO> csvFileDTOs){
		ResponseDTO responseDTO=new ResponseDTO();
		//log.info("insertMatchDetails()");
		PreparedStatement pstmt=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		for(CsvFileDTO csvFileDTO:csvFileDTOs){
			//log.info(csvFileDTO.toString());
			
			MatchDTO matchDTO=new MatchDTO();
			OutcomeDTO outcomeDTO=new OutcomeDTO();
			try{
				matchDTO.setDate(sdf.parse(csvFileDTO.getDate()));
			}catch(Exception e){
				log.error("Date parse error"+e.getMessage());
			}
			//To set match details
			matchDTO.setVenueId(getVenueId(csvFileDTO.getVenue()));
			matchDTO.setSeason(csvFileDTO.getSeason());
			matchDTO.setTeam1Id(getTeamId(csvFileDTO.getTeam1()));
			matchDTO.setTeam2Id(getTeamId(csvFileDTO.getTeam2()));			
			matchDTO.setTossId(getTossId(csvFileDTO.getTossDecision()));
			matchDTO.setTosswinnerId(getTeamId(csvFileDTO.getWinner()));
			matchDTO.setUmpire1Id(getUmpireId(csvFileDTO.getUmpire1()));
			matchDTO.setUmpire2Id(getUmpireId(csvFileDTO.getUmpire2()));
			
			//To set outcome details for the current match details
			outcomeDTO.setPlayerOfMatch(csvFileDTO.getPlayerOfMatch());
			outcomeDTO.setWinByRuns(csvFileDTO.getWinByRuns());
			outcomeDTO.setWinByWickets(csvFileDTO.getWinByWickets());
			outcomeDTO.setWinTeamId(getTeamId(csvFileDTO.getWinner()));
			try{
				pstmt=con.prepareStatement("insert into match_details(date,venue_id,season,team1_id,team2_id,"
						+ "toss_id,tosswinner_id,umpire1_id,umpire2_id) values(?,?,?,?,?,?,?,?,?)");
				pstmt.setDate(1, new java.sql.Date(matchDTO.getDate().getTime()));
				pstmt.setInt(2, matchDTO.getVenueId());
				pstmt.setInt(3,matchDTO.getSeason());
				pstmt.setInt(4, matchDTO.getTeam1Id());
				pstmt.setInt(5, matchDTO.getTeam2Id());
				pstmt.setInt(6, matchDTO.getTossId());
				pstmt.setInt(7, matchDTO.getTosswinnerId());
				pstmt.setInt(8, matchDTO.getUmpire1Id());
				pstmt.setInt(9, matchDTO.getUmpire2Id());
				Integer result=pstmt.executeUpdate();
				if(result>0){
					responseDTO.setStatus(true);
					responseDTO.setMessage("Match Inserted Successfully");
					//Last inserted match will have max match_id because match_id is auto increment
					outcomeDTO.setMatchId(getMaxMatchId());
					try{
						pstmt=con.prepareStatement("insert into outcome values(?,?,?,?,?)");
						pstmt.setInt(1, outcomeDTO.getMatchId());
						pstmt.setString(2, outcomeDTO.getPlayerOfMatch());
						pstmt.setInt(3, outcomeDTO.getWinByRuns());
						pstmt.setInt(4, outcomeDTO.getWinByWickets());
						pstmt.setInt(5, outcomeDTO.getWinTeamId());
						result=pstmt.executeUpdate();
						if(result>0){
							responseDTO.setStatus(true);
							responseDTO.setMessage("Outcome Inserted Successfully");
						}
					}catch(Exception e){
						log.error("Outcome "+e.getMessage());
					}
				}
			}catch(Exception e){
				log.error("Match Insertion "+e.getMessage());
			}
		}
		log.info(responseDTO.getMessage());
		return responseDTO;
	}
	
	public Integer getMaxMatchId(){
		Integer id=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select max(match_id) from match_details");
			rs=pstmt.executeQuery();
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			log.error(e.getMessage());
		}finally{
			try{
				pstmt.close();
				rs.close();
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
		return id;
	}
	
	public Integer getTeamId(String teamName){
		Integer id=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select team_id from team where team_name=?");
			pstmt.setString(1,teamName);
			rs=pstmt.executeQuery();
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return id;
	}
	
	public Integer getVenueId(String venueName){
		Integer id=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select venue_id from venue where venue_name=?");
			pstmt.setString(1,venueName);
			rs=pstmt.executeQuery();
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return id;
	}
	
	public Integer getTossId(String tossDecision){
		Integer id=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select toss_id from toss where toss_decision=?");
			pstmt.setString(1,tossDecision);
			rs=pstmt.executeQuery();
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return id;
	}
	
	public Integer getUmpireId(String umpireName){
		Integer id=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select umpire_id from umpire where umpire_name=?");
			pstmt.setString(1,umpireName);
			rs=pstmt.executeQuery();
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return id;
	}	
}
