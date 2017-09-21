package dto;

import java.util.Date;

public class ViewDTO {
	private Integer season;
	private Date date;
	private String venue;
	private String city;
	private String team1;
	private String team2;
	
	public Integer getSeason() {
		return season;
	}
	public void setSeason(Integer season) {
		this.season = season;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public ViewDTO(){
		super();
	}
	public ViewDTO(Integer season, Date date, String venue, String city,
			String team1, String team2) {
		super();
		this.season = season;
		this.date = date;
		this.venue = venue;
		this.city = city;
		this.team1 = team1;
		this.team2 = team2;
	}
}
