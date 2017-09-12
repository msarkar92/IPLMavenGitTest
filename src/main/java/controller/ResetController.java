package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;


import bo.LoginBO;
import dao.ResetDAO;

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
		
		
		
		String oldpassword = request.getParameter("oldpass")==null?"":request.getParameter("oldpass").toString();
		String  newpassword = request.getParameter("newpass")==null?"": request.getParameter("newpass").toString();
		String confirmpassword = request.getParameter("confirmpass")==null?"":request.getParameter("confirmpass");
		
		PrintWriter out=response.getWriter();
		Cookie[] cookie=request.getCookies();
		
		String uname = null;
		if (cookie != null) {
			 
	        for (int i = 0; i < cookie.length; i++) {
	 
	            if (cookie[i].getName().equals("emailaddress")) {
	 
	                  uname = cookie[i].getValue();
	            }
	        }
	    }		
	
		log.debug(uname);
		log.debug(newpassword);
		try
		{
			if(oldpassword.equals(null) || oldpassword==""|| newpassword.equals(null) || newpassword==""||confirmpassword.equals(null) || confirmpassword==""){
				request.setAttribute("msg", "All fields are mandatory");
				RequestDispatcher rd=request.getRequestDispatcher("reset.jsp");
				rd.include(request, response);
			}
			else if(!newpassword.equals(confirmpassword))
			{
				request.setAttribute("msg", "Password does not match");
				RequestDispatcher rd=request.getRequestDispatcher("reset.jsp");
				rd.include(request, response);
			}		
			else			
			{
				//LoginBO l=new LoginBO();
				//l.setEmail(uname);
				//l.setPassword(newpassword);
				try {
					int status=ResetDAO.updatedata(newpassword, uname);
					if(status!=0)
					{

						Cookie loginCookie=null;
						if(cookie != null)
						{
							for(Cookie ck : cookie)
							{
								if(ck.getName().equals("emailaddress"))
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
						out.print("<script>");
						out.print("alert('password updated');");
						out.print("</script>");


						log.info("Password Updated");
						response.sendRedirect("login.jsp");
						//request.setAttribute("msg", "Password Updated");
						//RequestDispatcher rd=request.getRequestDispatcher("LogoutController");  


						//rd.include(request, response);
						//response.sendRedirect("login.jsp");
					}
					else
					{
						request.setAttribute("msg", "Password not updated");
						RequestDispatcher rd=request.getRequestDispatcher("reset.jsp");  


						rd.include(request, response);
					}
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}