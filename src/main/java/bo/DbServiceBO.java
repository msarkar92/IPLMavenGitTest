package bo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

import dao.DbServiceDAO;
import dto.CsvFileDTO;
import dto.ResponseDTO;

public class DbServiceBO {
	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(DbServiceBO.class);
	DbServiceDAO dbServiceDAO=new DbServiceDAO(); 
	
	
	public boolean insertOutcome(List<CsvFileDTO> csvFileDTOs){
		
		return true;
	}
	
	public void insertUmpire(List<CsvFileDTO> csvFileDTOs){
		Set<String> umpireNameSet=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			if( (!dto.getUmpire1().trim().equals("")) && (!dto.getUmpire2().trim().equals("")) ){
				umpireNameSet.add(dto.getUmpire1().trim());
				umpireNameSet.add(dto.getUmpire2().trim());
			}
		}
		dbServiceDAO.insertUmpire(umpireNameSet);
	}
	
	public void insertToss(List<CsvFileDTO> csvFileDTOs){
		Set<String> tossSet=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			if(!dto.getTossDecision().trim().equals(""))
				tossSet.add(dto.getTossDecision().trim());
		}
		dbServiceDAO.insertToss(tossSet);
	}
	
	public void insertVenue(List<CsvFileDTO> csvFileDTOs){
		Map<String,String> venueMap=new HashMap<String,String>(); 
		for(CsvFileDTO dto:csvFileDTOs){
			if(!dto.getCity().trim().equals(""))
				venueMap.put(dto.getCity().trim(), dto.getVenue().trim());
		}
		dbServiceDAO.insertVenue(venueMap);	
	}
	
	public void insertTeam(List<CsvFileDTO> csvFileDTOs){
		Set<String> teamName=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			if( (!dto.getTeam1().trim().equals("")) && (!dto.getTeam2().trim().equals("")) ){
				teamName.add(dto.getTeam1().trim());
				teamName.add(dto.getTeam2().trim());
			}
		}
		dbServiceDAO.insertTeam(teamName);
	}
	
	public ResponseDTO insertMatchDetails(List<CsvFileDTO> csvFileDTOs){		
		log.info("insertMatchDetails()");
		log.info("Size= "+csvFileDTOs.size());
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(true);
		responseDTO.setMessage("done!");
		//First we have o insert team details
		insertTeam(csvFileDTOs);  
		//Second Venue details
		insertVenue(csvFileDTOs);
		//Third Toss Decisions
		insertToss(csvFileDTOs);
		//Fourth Umpires
		insertUmpire(csvFileDTOs);
		//Match details and Outcome
		responseDTO=dbServiceDAO.insertMatchDetails(csvFileDTOs);
		return responseDTO;
	}
	
}
