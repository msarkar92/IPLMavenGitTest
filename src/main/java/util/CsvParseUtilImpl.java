package util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import dto.CsvFileDTO;

public class CsvParseUtilImpl implements ParseUtilInterface{

	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(CsvParseUtilImpl.class);
		
	@Override
	public List<String> parseToFileFormat(List<CsvFileDTO> fileDtoData) {
		
		return null;
	}

	@Override
	public List<CsvFileDTO> parseToDto(List<String> stringFileData) {
		//TO get file related details and attribute name,position
		//ResourceBundle rb= ResourceBundle.getBundle("csvStructure");
		//Integer totalColumnsInFile=Integer.parseInt(rb.getString("com.csv.totalColumn"));
		
		//To hold DTO objects
		List<CsvFileDTO> csvFileDTOs=new ArrayList<>();		
		
		for(String line:stringFileData){
			String dataArr[]=line.split(",");
			try{
				log.info(line);
				CsvFileDTO tempCsvFileDTO=new CsvFileDTO();
				tempCsvFileDTO.setSeason(Integer.parseInt(dataArr[0]));
				tempCsvFileDTO.setCity(dataArr[1]);
				tempCsvFileDTO.setDate(dataArr[2]);
				tempCsvFileDTO.setTeam1(dataArr[3]);
				tempCsvFileDTO.setTeam2(dataArr[4]);
				tempCsvFileDTO.setTossWinner(dataArr[5]);
				tempCsvFileDTO.setTossDecision(dataArr[6]);
				tempCsvFileDTO.setWinner(dataArr[7]);
				tempCsvFileDTO.setWinByRuns(Integer.parseInt(dataArr[8]));
				tempCsvFileDTO.setWinByWickets(Integer.parseInt(dataArr[9]));
				tempCsvFileDTO.setPlayerOfMatch(dataArr[10]);
				if(dataArr[11].startsWith("\"") && dataArr[12].endsWith("\"")){
					
					tempCsvFileDTO.setVenue(dataArr[11].substring(1,dataArr[11].length())+dataArr[12].substring(0,dataArr[12].length()-1));
					
					tempCsvFileDTO.setUmpire1(dataArr[13]);
					tempCsvFileDTO.setUmpire2(dataArr[14]);					
				}else{
					tempCsvFileDTO.setVenue(dataArr[11]);
					tempCsvFileDTO.setUmpire1(dataArr[12]);
					tempCsvFileDTO.setUmpire2(dataArr[13]);
				}				
				tempCsvFileDTO.setUmpire3("");
				
				log.info("Venue "+tempCsvFileDTO.getVenue());
				log.info("Umpire 1"+tempCsvFileDTO.getUmpire1());
				log.info("Umpire 2"+tempCsvFileDTO.getUmpire2());
				
				csvFileDTOs.add(tempCsvFileDTO);
			}
			catch(Exception e){
				log.error(e.getMessage());
			}				
		}
		return csvFileDTOs;
	}
}
