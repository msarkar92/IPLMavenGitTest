package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MemberDTO;
import dto.ResponseDTO;
import util.DBUtil;

public class LoginDAO {
	public ResponseDTO isPresent(MemberDTO memberDTO) throws Exception{
		
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("Invalid userID or Password !!!");
		
		//To get the connection object
		Connection con=DBUtil.getConnectin();
		
		PreparedStatement pstmt=con.prepareStatement("select admin_email from admin_details where admin_email= '"+memberDTO.getUserId()+"' "
				+ " and admin_password= '"+memberDTO.getPassword()+"' ");
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			responseDTO.setStatus(true);
			responseDTO.setMessage(memberDTO.getUserId());
			return responseDTO;
		}
		return responseDTO;
	}
}
