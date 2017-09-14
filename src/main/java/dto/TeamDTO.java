package dto;

public class TeamDTO {
	private Integer teamId;
	private String teamName;
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public TeamDTO(Integer teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}
	 

}
