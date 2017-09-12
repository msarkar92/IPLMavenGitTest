package bo;

import java.io.File;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.LoggerFactory;

import dao.UploadFileDAO;
import dto.ResponseDTO;

public class UploadFileBO {
	
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(UploadFileBO.class);
	
	//To get max File Id from file_upload_log
	public Integer getMaxFileId(){
		Integer maxId=null;
		maxId=new UploadFileDAO().getMaxFileId();
		return maxId;
	}
	
	//To  create a directory under project root
	public boolean createDirectory(String rootPath,String localFolder){
		boolean status=false;		
		File dir = new File(rootPath+localFolder);
	    // attempt to create the directory here
	    boolean successful = dir.mkdir();
	    if (successful)
	    {
	      // creating the directory succeeded
	      log.debug("directory was created successfully");
	      status=true;
	    }
	    else
	    {
	      // creating the directory failed
	    	log.debug("failed trying to create the directory");
	    }
		return status;
	}
	
	//TO check whether a file exist or not
	public boolean checkFile(String path){
		boolean status=false;
		File f = new File(path);
		if (f.exists()) {
			status=true;
		}
		return status;
	}
	
	//To check whether a directory is exist or not
	public boolean checkDirectory(String rootPath,String localFolder){
		boolean status=false;
		File f = new File(rootPath+localFolder);
		if (f.exists() && f.isDirectory()) {
			status=true;
		}
		return status;
	}
	
	//Upload file to server
	public ResponseDTO uploadFile(List<FileItem> fileItems,String rootPath,String localFolder){
		
		//Response Object
		ResponseDTO responseDTO=null;
		Integer maxId=getMaxFileId();
		if(maxId==null)
			maxId=1;
		else{
			maxId++;
		}
		
		Boolean isDirectoryExist=checkDirectory(rootPath, localFolder);
		if(!isDirectoryExist)
			createDirectory(rootPath, localFolder);
		
		try{
			for(FileItem fi:fileItems){
				if(fi==null){
					responseDTO.setStatus(false);
					responseDTO.setMessage("Select a file first");
					return responseDTO;
				}			
				String fileName=FilenameUtils.getBaseName(fi.getName());
				String fileExtension=FilenameUtils.getExtension(fi.getName());
				String newFileName=maxId+"_file";
				String filePath=rootPath+localFolder+"/";
				
				//To get the file name with full path and extension
				log.info(new File(fi.getName()).getName()); 
				log.info("Original file name: "+fileName);
				log.info("File ext: "+fileExtension);
				log.debug("New File name: "+newFileName);
				
				//It will create a file in server
				File newFile=new File(filePath+newFileName+"."+fileExtension);
				fi.write(newFile);
				log.debug(newFile.getAbsolutePath());
				if(checkFile(newFile.getAbsolutePath())){
					//log.debug("insert to db");
					responseDTO=new UploadFileDAO().insertFileDetails(newFileName,fileExtension,filePath,"file_upload_log");
				}					
			}
		}
		catch(Exception e){
			log.error(e.getMessage());
		}
		return responseDTO;
	}
}
