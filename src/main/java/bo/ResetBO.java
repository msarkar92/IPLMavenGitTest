package bo;

import org.slf4j.LoggerFactory;

import dao.LoginDAO;
import dao.ResetDAO;
import dto.MemberDTO;
import dto.ResponseDTO;

public class ResetBO {
	final static org.slf4j.Logger log=LoggerFactory.getLogger(ResetBO.class);
	
	public ResponseDTO reset(MemberDTO memberDTO,String newPassword,String confirmPassword){
		
		ResponseDTO responseDTO=new ResponseDTO();
		
		if(memberDTO.getPassword().equals("") || newPassword.equals("") || confirmPassword.equals("")){
			responseDTO.setStatus(false);
			responseDTO.setMessage("All the fields are mandatory...!");		
		}else if(!newPassword.equals(confirmPassword)){
			responseDTO.setStatus(false);
			responseDTO.setMessage("New password don't match confirm password...!");
		}
		else if(memberDTO.getPassword().equals(confirmPassword)){
			responseDTO.setStatus(false);
			responseDTO.setMessage("New password should not match old password...!");
		}else{			
			LoginDAO loginDAO=new LoginDAO();
			try {
				responseDTO=loginDAO.isPresent(memberDTO);
			} catch (Exception e1) {
				log.error(e1.getMessage());
			}
			responseDTO.setMessage("Old password is wrong...!");			
			if(responseDTO.getStatus()){
				ResetDAO resetDAO=new ResetDAO();
				try {
					responseDTO=resetDAO.resetPassword(memberDTO,newPassword);
				} catch (Exception e) {
					log.error(e.getMessage());
				}	
			}
		}
		log.info(responseDTO.getMessage());
		return responseDTO;
	}
}
