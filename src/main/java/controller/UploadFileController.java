package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.LoggerFactory;

import bo.UploadFileBO;
import dto.ResponseDTO;


/**
 * Servlet implementation class UploadFileController
 */
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileController() {
        super();
        // TODO Auto-generated constructor stub
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
		RequestDispatcher rd=request.getRequestDispatcher("adminUpload.jsp");
		ResponseDTO responseDTO=new ResponseDTO();
		//To maintain log
		final org.slf4j.Logger log=LoggerFactory.getLogger(UploadFileController.class); 			
		ServletFileUpload sfu=new ServletFileUpload(new DiskFileItemFactory());
		
		List<FileItem> fileItems=null;
		try{
			//To get the list of file items sent form client machine
			//log.debug(sfu.parseRequest(request).toString());
			fileItems=sfu.parseRequest(request);
		}
		catch(Exception e){
			log.error(e.getMessage());
		}
		
		if(fileItems.size()>0){
			String rootPath=getServletConfig().getInitParameter("rootPath");
			UploadFileBO uploadFileBO =new UploadFileBO();
			responseDTO=uploadFileBO.uploadFile(fileItems, rootPath,"uploads");
		}else{
			responseDTO.setStatus(false);
			responseDTO.setMessage("Select a file first");
		}
		log.info(responseDTO.getMessage());
		request.setAttribute("uploadStatus",responseDTO.getMessage());
		rd.forward(request, response);
	}
}
