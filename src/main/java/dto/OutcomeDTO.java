package dto;

public class OutcomeDTO {
	private Integer matchId;
	private String playerOfMatch;
	private Integer winByRuns;
	private Integer winByWickets;
	private Integer winTeamId;
	
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public String getPlayerOfMatch() {
		return playerOfMatch;
	}
	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}
	public Integer getWinByRuns() {
		return winByRuns;
	}
	public void setWinByRuns(Integer winByRuns) {
		this.winByRuns = winByRuns;
	}
	public Integer getWinByWickets() {
		return winByWickets;
	}
	public void setWinByWickets(Integer winByWickets) {
		this.winByWickets = winByWickets;
	}
	public Integer getWinTeamId() {
		return winTeamId;
	}
	public void setWinTeamId(Integer winTeamId) {
		this.winTeamId = winTeamId;
	}
}
