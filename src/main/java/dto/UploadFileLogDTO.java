package dto;

public class UploadFileLogDTO {
	private Integer fileId;
	private String fileName; 
	private String fileExtension;
	private String filePath; 
	private String fileUpload_date; 
	private String fileCreator;
	private String fileProcessStatus;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileUpload_date() {
		return fileUpload_date;
	}
	public void setFileUpload_date(String fileUpload_date) {
		this.fileUpload_date = fileUpload_date;
	}
	public String getFileCreator() {
		return fileCreator;
	}
	public void setFileCreator(String fileCreator) {
		this.fileCreator = fileCreator;
	}
	public String getFileProcessStatus() {
		return fileProcessStatus;
	}
	public void setFileProcessStatus(String fileProcessStatus) {
		this.fileProcessStatus = fileProcessStatus;
	}
}
