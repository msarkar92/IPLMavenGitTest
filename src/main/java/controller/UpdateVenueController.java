package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import bo.UpdateVenueBO;

/**
 * Servlet implementation class UpdateVenueController
 */
public class UpdateVenueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final org.slf4j.Logger log=LoggerFactory.getLogger(UpdateVenueController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVenueController() {
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
		String venueId=request.getParameter("venueid");
		String venue=request.getParameter("venue");
		String city=request.getParameter("city");
		log.debug(venueId);
		if(UpdateVenueBO.validate(venueId,venue,city)){
			request.setAttribute("msg", "Update Success");
			RequestDispatcher rd=request.getRequestDispatcher("adminUpdate.jsp");
			rd.forward(request, response);
		}

		else
		{
			request.setAttribute("msg", "Not Updated");
			RequestDispatcher rd=request.getRequestDispatcher("adminUpdate.jsp");
			rd.include(request, response);

		}

	}

}
