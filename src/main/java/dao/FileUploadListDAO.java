package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import util.DBUtil;
import dto.UploadFileLogDTO;

public class FileUploadListDAO {
	//To maintain log
	final static org.slf4j.Logger log=LoggerFactory.getLogger(FileUploadListDAO.class);
	
	public static List<UploadFileLogDTO> getUploadFileList(){
		List<UploadFileLogDTO> uploadFileLogDTOs=new ArrayList<>();
		Connection con=DBUtil.getConnectin();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=con.prepareStatement("select file_id,file_name,file_extension,file_path,file_upload_date,file_creator,file_process_status from file_upload_log");
			rs=pstmt.executeQuery();
			while(rs.next()){
				UploadFileLogDTO dto=new UploadFileLogDTO();
				dto.setFileId(rs.getInt("file_id"));
				dto.setFileName(rs.getString("file_name"));
				dto.setFileExtension(rs.getString("file_extension"));
				dto.setFilePath(rs.getString("file_path"));
				dto.setFileProcessStatus(rs.getString("file_process_status"));
				uploadFileLogDTOs.add(dto);
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return uploadFileLogDTOs;
	}
}
