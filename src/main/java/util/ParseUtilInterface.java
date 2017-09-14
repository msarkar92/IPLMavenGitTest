package util;

import java.util.List;

import dto.CsvFileDTO;

public interface ParseUtilInterface {
	
	public List<String> parseToFileFormat(List<CsvFileDTO> fileDtoData);
	
	public List<CsvFileDTO> parseToDto(List<String> stringFileData);
}
