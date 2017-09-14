package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			Scanner scan = new Scanner(new File(filePath));
			scan.next();
			while (scan.hasNextLine()) 
			{
				String line = scan.nextLine();
				result.add(line);
			}
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
