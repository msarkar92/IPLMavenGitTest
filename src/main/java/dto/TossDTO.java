package dto;

public class TossDTO {
 private Integer tossId;
 private String tossDecision;
 
public Integer getTossId() {
	return tossId;
}
public void setTossId(Integer tossId) {
	this.tossId = tossId;
}
public String getTossDecision() {
	return tossDecision;
}
public void setTossDecision(String tossDecision) {
	this.tossDecision = tossDecision;
}
public TossDTO(Integer tossId, String tossDecision) {
	super();
	this.tossId = tossId;
	this.tossDecision = tossDecision;
}
 
}
