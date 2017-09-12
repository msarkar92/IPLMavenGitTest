package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.slf4j.LoggerFactory;

import util.DBUtil;
import dto.ResponseDTO;

public class UploadFileDAO {
	
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(UploadFileDAO.class);
	Connection con=new DBUtil().getConnectin();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public Integer getMaxFileId(){
		Integer maxFileId=0;		
		try{
			pstmt=con.prepareStatement("select max(file_id) as maxId from file_upload_log");
			rs=pstmt.executeQuery();
			if(rs.next()){
				maxFileId=rs.getInt("maxId");
			}
			pstmt.close();
		}
		catch(Exception e){
			log.error(e.getMessage());
		}		
		log.info("max file id: "+maxFileId.toString());
		return maxFileId;
	}
	
	public ResponseDTO insertFileDetails(String newFileName,String fileExtension,String filePath,String tableName){
		ResponseDTO responseDTO=new ResponseDTO();
		
		Date date=new Date();
		java.sql.Timestamp sqlDate=new java.sql.Timestamp(date.getTime());
		try{
			pstmt=con.prepareStatement("insert into file_upload_log(file_name,file_extension,file_path,file_upload_date) values(?,?,?,?)");
			//pstmt.setString(1,tableName);
			pstmt.setString(1,newFileName);
			pstmt.setString(2,fileExtension);
			pstmt.setString(3,filePath.replaceAll("/", "//"));			
			pstmt.setTimestamp(4,sqlDate);
			/*
			pstmt.setString(6,"");
			pstmt.setString(7,"");
			*/
			if(pstmt.executeUpdate()>0){
				responseDTO.setStatus(true);
				responseDTO.setMessage("File uploaded successfully");
			}else{
				responseDTO.setStatus(false);
				responseDTO.setMessage("Sorry file upload status not inserted in db");
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return responseDTO;
	}

}
