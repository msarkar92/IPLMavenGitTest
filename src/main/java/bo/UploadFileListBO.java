package bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import dao.FileUploadListDAO;
import dto.UploadFileLogDTO;

public class UploadFileListBO {
	final org.slf4j.Logger log=LoggerFactory.getLogger(UploadFileListBO.class); 
	
	public List<UploadFileLogDTO> getUploadFileList(){
		log.info("BO");
		List<UploadFileLogDTO> uploadFileLogDTOs=new ArrayList<>();
		uploadFileLogDTOs=FileUploadListDAO.getUploadFileList();
		return uploadFileLogDTOs;
	}
}
