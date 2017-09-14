package util;

import java.util.List;

public interface FileUtilInterface {
	
	public List<String> readFile(String filePath);
	
	public boolean writeFile(List<String> data,String filePath);
}
