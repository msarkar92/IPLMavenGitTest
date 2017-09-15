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
	
	public boolean insertUmpire(List<CsvFileDTO> csvFileDTOs){
		Set<String> umpireName=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			umpireName.add(dto.getUmpire1().trim());
			umpireName.add(dto.getUmpire2().trim());
			umpireName.add(dto.getUmpire3().trim());
		}
		return true;
	}
	public boolean insertToss(List<CsvFileDTO> csvFileDTOs){
		Set<String> tossSet=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			tossSet.add(dto.getTossDecision().trim());}
		return true;
	}
	
	public void insertVenue(List<CsvFileDTO> csvFileDTOs){
		Map<String,String> venueMap=new HashMap<String,String>(); 
		for(CsvFileDTO dto:csvFileDTOs){
			venueMap.put(dto.getCity().trim(), dto.getVenue().trim());
		}
		dbServiceDAO.insertVenue(venueMap);	
	}
	
	public void insertTeam(List<CsvFileDTO> csvFileDTOs){
		Set<String> teamName=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			log.info(dto.getTeam1());
			teamName.add(dto.getTeam1().trim());
			teamName.add(dto.getTeam2().trim());
		}
		dbServiceDAO.insertTeam(teamName);
	}
	
	public ResponseDTO insertMatchDetails(List<CsvFileDTO> csvFileDTOs){		
		log.info("insertMatchDetails()");
		log.info("Size= "+csvFileDTOs.size());
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(true);
		responseDTO.setMessage("done!");
		insertTeam(csvFileDTOs);
		insertVenue(csvFileDTOs);
		return responseDTO;
	}
	
}
