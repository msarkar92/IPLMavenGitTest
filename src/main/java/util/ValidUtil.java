package util;

import dto.MemberDTO;

public class ValidUtil {
	public Boolean isEmpty(MemberDTO memberDTO){
		if(memberDTO.getUserId().equals(""))
			return false;
		if(memberDTO.getPassword().equals(""))
			return false;
		return true;
	}
	
	public Boolean isValid(MemberDTO memberDTO){
		
		return true;
	}
}
