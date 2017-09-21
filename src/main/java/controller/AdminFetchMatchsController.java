package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.AdminFetchMatchesBO;
import dto.ViewDTO;
/**
 * Servlet implementation class AdminFetchMatchsController
 */
public class AdminFetchMatchsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static org.slf4j.Logger log=LoggerFactory.getLogger(AdminFetchMatchsController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFetchMatchsController() {
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
		/*
		String data="{\"data\": [[\"Tiger Nixon\",\"System Architect\",\"Edinburgh\",\"5421\",\"2011/04/25\",\"$320,800\"],[\"Mrinal\",\"Junior Architect\",\"Chennai\",\"5421\",\"2011/04/25\",\"$320,000\"]]}";
		response.getWriter().print(data);
		*/
		
		//To get all the match details 
		AdminFetchMatchesBO adminFetchMatchesBO=new AdminFetchMatchesBO();
		List<ViewDTO> matchList=adminFetchMatchesBO.getMatches();
		Integer length=matchList.size();
		String data="{\"data\": [";
		for(ViewDTO viewDTO:matchList){
			data+="[\""+viewDTO.getSeason()+"\",\""+viewDTO.getDate()+"\",\""+viewDTO.getVenue()+"\",\""+viewDTO.getCity()+"\",\""+viewDTO.getTeam1()+"\",\""+viewDTO.getTeam2()+"\"]";
			if(length>1){
				length--;
				data+=",";
			}
		}
		data+="]}";
		response.getWriter().print(data);
	}

}
