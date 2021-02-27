package valueObject;

public class VData {
	
	private String id;
	private String text;
	private String fileName;
	
	private String proName;
	private String credit;
	private String time;
	

	public VData() {
		
	}

	// gettes & setters 
	public String getId() { return id; }
	public void setId(String id) {	this.id = id;}
	
	public String getText() { return text;}
	public void setText(String text) {this.text = text;}
	
	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	
	public String getProName() {	return proName;	}
	public void setProName(String proName) {	this.proName = proName;	}
	
	public String getCredit() {		return credit;	}
	public void setCredit(String credit) {		this.credit = credit;}
	
	public String getTime() {	return time;}
	public void setTime(String time) {	this.time = time;}

}
