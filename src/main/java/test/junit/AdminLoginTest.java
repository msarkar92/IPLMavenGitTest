/**
 * 
 */
package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import bo.LoginBO;
import dto.MemberDTO;
import dto.ResponseDTO;

/**
 * @author 616486
 *
 */
public class AdminLoginTest {

	@Test
	public void checkNullLogin() {
		
		MemberDTO memberDTO=new MemberDTO("","");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("UserId or Password cannot be empty !!!");
		LoginBO loginBO=new LoginBO();
		
		//This is for null values passing while Login : getStatus() should be false 
		try {
			assertEquals(responseDTO, loginBO.login(memberDTO));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void checkInvalidLogin() {
		
		MemberDTO memberDTO=new MemberDTO("123456","Qq1!");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(false);
		responseDTO.setMessage("Invalid userID or Password !!!");
		LoginBO loginBO=new LoginBO();
		
		//This is for Invalid Login : getStatus() should be false 
		try {
			assertEquals(responseDTO.getStatus(), loginBO.login(memberDTO).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void checkValidLogin() {
		
		MemberDTO memberDTO=new MemberDTO("m@yahoo.com","Qq1!");
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(true);
		responseDTO.setMessage("m@yahoo.com");
		LoginBO loginBO=new LoginBO();
		
		//This is for Valid Login : getStatus() should be true 
		try {
			assertEquals(responseDTO.getStatus(), loginBO.login(memberDTO).getStatus());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
