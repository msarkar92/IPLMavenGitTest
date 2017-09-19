package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import controller.InsertToDatabaseController;

public class CsvFileUtilImpl implements FileUtilInterface {
	
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(InsertToDatabaseController.class);

	@Override
	//Read the file and return a list of string
	public List<String> readFile(String filePath) {		
		
		List<String> result = new ArrayList<String> ();
		try{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line=br.readLine();
			while((line = br.readLine()) != null) 
			{
				//log.info(line);
				result.add(line);				
			}
			br.close();
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean writeFile(List<String> data, String filePath) {
		
		return false;
	}

}
