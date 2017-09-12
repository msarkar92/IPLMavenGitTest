package controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import bo.LoginBO;
import dto.MemberDTO;
import dto.ResponseDTO;

/**
 * Servlet implementation class loginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//To maintain log
		final org.slf4j.Logger log=LoggerFactory.getLogger(LoginController.class);	
		log.info(request.getParameter("data"));
		
		Gson gson = new Gson();
		MemberDTO memberDTO=gson.fromJson(request.getParameter("data"),MemberDTO.class);
		
		LoginBO loginBO=new LoginBO();
		
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
			//RequestDispatcher rd=request.getRequestDispatcher("/adminHome.jsp");
			//rd.forward(request, response);						
			//response.sendRedirect("/adminHome.jsp");
			
			//session is created when login is successful
			HttpSession session=request.getSession();
			session.setAttribute("userId",memberDTO.getUserId());
			
			responseDTO.setMessage("adminLogin.jsp");
		}
		else{
			log.info(responseDTO.getMessage());
			//System.out.println(responseDTO.getMessage());		
			/*
			request.setAttribute("response",responseDTO.getMessage());
			request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
			*/
			//pw.print(responseDTO.getMessage());			
		}		
		pw.print(gson.toJson(responseDTO));				
	}
}
