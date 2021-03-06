package bo;

import dao.LoginDAO;
import dto.MemberDTO;
import dto.ResponseDTO;

public class LoginBO {
	public ResponseDTO login(MemberDTO memberDTO) throws Exception{
		
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		
		if(memberDTO.getUserId().equals("") || memberDTO.getPassword().equals("")){
			responseDTO.setStatus(false);
			responseDTO.setMessage("UserId or Password cannot be empty !!!");
			return responseDTO;
		}		
		
		LoginDAO loginDAO=new LoginDAO();
		responseDTO=loginDAO.isPresent(memberDTO);
		
		return responseDTO;
	}
}