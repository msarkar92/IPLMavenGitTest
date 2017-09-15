package bo;

import java.util.List;

import org.slf4j.LoggerFactory;

import util.CsvFileUtilImpl;
import util.CsvParseUtilImpl;
import util.FileUtilInterface;
import util.ParseUtilInterface;
import dto.CsvFileDTO;
import dto.ResponseDTO;

public class InsertToDatabaseBO {
	
	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(InsertToDatabaseBO.class);
	
	public static ResponseDTO insertByFile(String filePath){
		
		//To send the result of underlying operations
		ResponseDTO responseDTO=new ResponseDTO();
		
		if(!filePath.equals("")){
			//To read csv file
			FileUtilInterface csvFileUtil=new CsvFileUtilImpl();
			List<String> stringFileData=csvFileUtil.readFile(filePath);
			
			//To parse the file content into dto
			ParseUtilInterface csvParseUtil=new CsvParseUtilImpl();
			List<CsvFileDTO> csvFileDTOs=csvParseUtil.parseToDto(stringFileData);
			
			//TO insert into database
			DbServiceBO dbServiceBO=new DbServiceBO();			
			responseDTO=dbServiceBO.insertMatchDetails(csvFileDTOs);
		}else{
			responseDTO.setStatus(false);
			responseDTO.setMessage("Select a file first !!!");
		}
		
		log.info(responseDTO.getMessage());
		
		return responseDTO;
	}
}
