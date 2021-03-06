package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.LoginBO;

import com.google.gson.Gson;

import dto.MemberDTO;
import dto.ResponseDTO;

/**
 * Servlet implementation class loginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(LoginController.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		log.info(request.getParameter("data"));
		
		Gson gson = new Gson();
		MemberDTO memberDTO=gson.fromJson(request.getParameter("data"),MemberDTO.class);
		
		LoginBO loginBO=new LoginBO();
		
		log.info("userId= "+memberDTO.getUserId());
		
		ResponseDTO responseDTO=new ResponseDTO();
		
		try{
			responseDTO=loginBO.login(memberDTO);
		}
		catch(Exception e){
			responseDTO.setMessage(e.getMessage());
		}
		
		PrintWriter pw=response.getWriter();
		
		//if validation gets failed in the any of the underlying layers status is set to false 
		//based on the status controller decides with page to be redirected 
		if(responseDTO.getStatus()){			
			//Cookie is created when login is successful			
			Cookie ck=new Cookie("userId", memberDTO.getUserId());
			ck.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(ck);		
			
			responseDTO.setMessage("adminLogin.jsp");
		}
		else{
			log.info(responseDTO.getMessage());
		}		
		pw.print(gson.toJson(responseDTO));		
	}
}
