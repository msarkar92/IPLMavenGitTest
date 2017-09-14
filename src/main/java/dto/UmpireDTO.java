package dto;

public class UmpireDTO {
	private Integer umpireId;
	private String umpireName;
	
	public Integer getUmpireId() {
		return umpireId;
	}
	public void setUmpireId(Integer umpireId) {
		this.umpireId = umpireId;
	}
	public String getUmpireName() {
		return umpireName;
	}
	public void setUmpireName(String umpireName) {
		this.umpireName = umpireName;
	}
	public UmpireDTO(Integer umpireId, String umpireName) {
		super();
		this.umpireId = umpireId;
		this.umpireName = umpireName;
	}
	

}
