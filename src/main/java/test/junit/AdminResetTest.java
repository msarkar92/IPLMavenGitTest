package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import bo.ResetBO;
import dto.MemberDTO;
import dto.ResponseDTO;

public class AdminResetTest {

	@Test
	public void checkNullReset() {
		MemberDTO memberDTO=new MemberDTO("","");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("All the fields are mandatory...!");	
		String newPassword="";
		String confirmPassword="";
		ResetBO resetBO=new ResetBO();
		try {
			assertEquals(responseDTO.getStatus(),resetBO.reset(memberDTO, newPassword, confirmPassword).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void checkIncorrectPasswordReset() {
		MemberDTO memberDTO=new MemberDTO("m@yahoo.com","123456");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("Old password is wrong...!");
		String newPassword="ms12";
		String confirmPassword="ms12";
		ResetBO resetBO=new ResetBO();
		try {
			assertEquals(responseDTO.getStatus(),resetBO.reset(memberDTO, newPassword, confirmPassword).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void checkIncorrectConfirmPasswordReset() {
		MemberDTO memberDTO=new MemberDTO("m@yahoo.com","123456");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("New password don't match confirm password...!");
		String newPassword="ms12";
		String confirmPassword="ms1234";
		ResetBO resetBO=new ResetBO();
		try {
			assertEquals(responseDTO.getStatus(),resetBO.reset(memberDTO, newPassword, confirmPassword).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	@Test
	public void checkCorrectReset() {
		MemberDTO memberDTO=new MemberDTO("m@yahoo.com","1234");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(true);
		responseDTO.setMessage("Password updated successfully");
		String newPassword="ms12";
		String confirmPassword="ms12";
		ResetBO resetBO=new ResetBO();
		try {
			assertEquals(responseDTO.getStatus(),resetBO.reset(memberDTO, newPassword, confirmPassword).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	*/
}
