package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.UploadFileListBO;
import dto.UploadFileLogDTO;

/**
 * Servlet implementation class UploadFileListController
 */
public class UploadFileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//To maintain log
	final org.slf4j.Logger log=LoggerFactory.getLogger(UploadFileListController.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileListController() {
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
		
		RequestDispatcher rd=request.getRequestDispatcher("/adminUpload.jsp");
		//ResponseDTO responseDTO=new ResponseDTO();
		
		UploadFileListBO uploadFileListBO=new UploadFileListBO();
		List<UploadFileLogDTO> uploadFileLogDTOs=uploadFileListBO.getUploadFileList();
		
		request.setAttribute("uploadList",uploadFileLogDTOs);
		rd.forward(request, response);
	}

}
