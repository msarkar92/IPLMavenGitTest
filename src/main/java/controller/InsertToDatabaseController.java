package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.InsertToDatabaseBO;
import dto.ResponseDTO;

/**
 * Servlet implementation class InsertToDatabase
 */
public class InsertToDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(InsertToDatabaseController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertToDatabaseController() {
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
		
		String filePath=request.getParameter("txt-selected-file");
		log.info("File= "+filePath);
		
		//To send the result
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO=InsertToDatabaseBO.insertByFile(filePath);
		
		log.info("Response= "+responseDTO.getMessage());
		
		request.setAttribute("insertStatus",responseDTO.getMessage());
		RequestDispatcher rd=request.getRequestDispatcher("adminUpload.jsp");
		rd.forward(request, response);
	}

}
