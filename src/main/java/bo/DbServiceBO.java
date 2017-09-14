package bo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

import dto.CsvFileDTO;
import dto.ResponseDTO;

public class DbServiceBO {
	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(DbServiceBO.class);
	
	public boolean insertOutcome(List<CsvFileDTO> csvFileDTOs){
		
		return false;
	}
	
	public boolean insertUmpire(List<CsvFileDTO> csvFileDTOs){
		Set<String> umpireName=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			umpireName.add(dto.getUmpire1().trim());
			umpireName.add(dto.getUmpire2().trim());
			umpireName.add(dto.getUmpire3().trim());
		}
		return false;
	}
	public boolean insertToss(List<CsvFileDTO> csvFileDTOs){
		Set<String> tossSet=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			tossSet.add(dto.getTossDecision().trim());}
		return false;
	}
	
	public boolean insertVenue(List<CsvFileDTO> csvFileDTOs){
		Map<String,String> venueMap=new HashMap<String,String>(); 
		for(CsvFileDTO dto:csvFileDTOs){
			venueMap.put(dto.getCity().trim(), dto.getVenue().trim());
		}
		return false;
	}
	
	public boolean insertTeam(List<CsvFileDTO> csvFileDTOs){
		Set<String> teamName=new HashSet<String>();
		for(CsvFileDTO dto:csvFileDTOs){
			teamName.add(dto.getTeam1().trim());
			teamName.add(dto.getTeam2().trim());
		}
		
		return false;
	}
	
	public ResponseDTO insert(List<CsvFileDTO> csvFileDTOs){
		
		return null;
	}
	
}
