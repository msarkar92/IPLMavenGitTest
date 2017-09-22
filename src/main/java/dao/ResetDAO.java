package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.LoggerFactory;

import dto.MemberDTO;
import dto.ResponseDTO;
import util.DBUtil;

public class ResetDAO {
	final static org.slf4j.Logger log=LoggerFactory.getLogger(ResetDAO.class);
	
	public ResponseDTO resetPassword(MemberDTO memberDTO,String newPassword) throws Exception 
	{		
		Connection con=null;
		Integer updateResult=null;
		ResponseDTO responseDTO=new ResponseDTO();
		try{
			con=DBUtil.getConnectin();
			log.debug("resetdao");
			PreparedStatement ps=con.prepareStatement("update admin_details set admin_password=? where admin_email=?");
			ps.setString(1,newPassword);
			ps.setString(2,memberDTO.getUserId());
			updateResult=ps.executeUpdate();
			if(updateResult>0){
				responseDTO.setStatus(true);
				responseDTO.setMessage("Password updated successfully");
			}else{
				responseDTO.setStatus(false);
				responseDTO.setMessage("Password not updated successfully...!");
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return responseDTO;
	}		
}
