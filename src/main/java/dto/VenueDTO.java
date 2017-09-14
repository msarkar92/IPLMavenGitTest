package dto;

public class VenueDTO {
private Integer venueId;
private String city;
private String venueName;

public Integer getVenueId() {
	return venueId;
}
public void setVenueId(Integer venueId) {
	this.venueId = venueId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getVenueName() {
	return venueName;
}
public void setVenueName(String venueName) {
	this.venueName = venueName;
}
public VenueDTO(Integer venueId, String city, String venueName) {
	super();
	this.venueId = venueId;
	this.city = city;
	this.venueName = venueName;
}


}
