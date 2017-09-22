package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.ResetBO;
import dao.ResetDAO;
import dto.MemberDTO;
import dto.ResponseDTO;

/**
 * Servlet implementation class ResetController
 */

public class ResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final org.slf4j.Logger log=LoggerFactory.getLogger(ResetController.class);
	
	//final Logger LOG = (Logger) LoggerFactory.getLogger(ResetController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String oldpassword = request.getParameter("oldpass");//==null?"":request.getParameter("oldpass").toString();
		String  newpassword = request.getParameter("newpass");//==null?"": request.getParameter("newpass").toString();
		String confirmpassword = request.getParameter("confirmpass");//==null?"":request.getParameter("confirmpass").toString();
		
		//PrintWriter out=response.getWriter();
		Cookie[] cookie=request.getCookies();
		
		String uname = null;
		if (cookie != null) {
	        	for(Cookie c:cookie){
	            	if (c.getName().equals("userId")) {
	                  uname = c.getValue();
	                  break;
	            }
	        }
	    }		
	
		log.debug(uname);
		log.debug(newpassword);
		
		ResetBO resetBO=new ResetBO();
		MemberDTO memberDTO=new MemberDTO(uname,oldpassword);
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO=resetBO.reset(memberDTO,newpassword,confirmpassword);
		
		RequestDispatcher rd=null;
		
		if(!responseDTO.getStatus()){
			request.setAttribute("resetStatus",responseDTO.getMessage());
			rd=request.getRequestDispatcher("adminReset.jsp");
		}else{
			Cookie loginCookie=null;
			if(cookie != null)
			{
				for(Cookie ck : cookie)
				{
					if(ck.getName().equals("userId"))
					{
						loginCookie = ck;
						break;
					}
				}
			}
			if(loginCookie != null)
			{
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
			}
			rd=request.getRequestDispatcher("adminLogin.jsp");			
		}
		rd.forward(request, response);
	}
}
