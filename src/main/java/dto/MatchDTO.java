package dto;

import java.util.Date;

public class MatchDTO {
	private Integer matchId;
	private Date date;
	private Integer venueId;
	private Integer season;
	private Integer team1Id;
	private Integer team2Id;
	private Integer tosswinnerId;
	private Integer umpire1Id;
	private Integer umpire2Id;
	private Integer umpire3Id;
	
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public Integer getSeason() {
		return season;
	}
	public void setSeason(Integer season) {
		this.season = season;
	}
	public Integer getTeam1Id() {
		return team1Id;
	}
	public void setTeam1Id(Integer team1Id) {
		this.team1Id = team1Id;
	}
	public Integer getTeam2Id() {
		return team2Id;
	}
	public void setTeam2Id(Integer team2Id) {
		this.team2Id = team2Id;
	}
	public Integer getTosswinnerId() {
		return tosswinnerId;
	}
	public void setTosswinnerId(Integer tosswinnerId) {
		this.tosswinnerId = tosswinnerId;
	}
	public Integer getUmpire1Id() {
		return umpire1Id;
	}
	public void setUmpire1Id(Integer umpire1Id) {
		this.umpire1Id = umpire1Id;
	}
	public Integer getUmpire2Id() {
		return umpire2Id;
	}
	public void setUmpire2Id(Integer umpire2Id) {
		this.umpire2Id = umpire2Id;
	}
	public Integer getUmpire3Id() {
		return umpire3Id;
	}
	public void setUmpire3Id(Integer umpire3Id) {
		this.umpire3Id = umpire3Id;
	}
	
}
