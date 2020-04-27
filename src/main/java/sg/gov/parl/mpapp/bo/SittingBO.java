package sg.gov.parl.mpapp.bo;

import java.util.List;

public class SittingBO {
	
	private long id;
	private String sittingDate;
	private int sittingNo;
	private List<SittingdocBO> sittingdocs;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSittingDate() {
		return sittingDate;
	}
	public void setSittingDate(String sittingDate) {
		this.sittingDate = sittingDate;
	}
	public int getSittingNo() {
		return sittingNo;
	}
	public void setSittingNo(int sittingNo) {
		this.sittingNo = sittingNo;
	}
	public List<SittingdocBO> getSittingdocs() {
		return sittingdocs;
	}
	public void setSittingdocs(List<SittingdocBO> sittingdocs) {
		this.sittingdocs = sittingdocs;
	}
}
