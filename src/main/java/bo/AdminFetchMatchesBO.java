package bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import dao.AdminFetchMatchesDAO;
import dto.ViewDTO;

public class AdminFetchMatchesBO {
	
	final static org.slf4j.Logger log=LoggerFactory.getLogger(AdminFetchMatchesBO.class);
	
	public List<ViewDTO> getMatches(){
		List<ViewDTO> matchList=new ArrayList<ViewDTO>();
		matchList=AdminFetchMatchesDAO.getMatches();
		return matchList;
	}
	
}
