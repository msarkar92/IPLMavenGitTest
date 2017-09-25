package bo;

import org.slf4j.LoggerFactory;

import dao.UpdateVenueDAO;

public class UpdateVenueBO {
	final static org.slf4j.Logger log=LoggerFactory.getLogger(UpdateVenueBO.class);

	public static boolean validate(String id,String name, String city)
	{
		boolean status=false;
		try{
			if(UpdateVenueDAO.updateVenue(id,name,city) >0)
			{
				status=true;
				log.info("true");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
