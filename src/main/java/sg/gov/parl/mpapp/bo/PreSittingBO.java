package sg.gov.parl.mpapp.bo;

import java.util.List;

public class PreSittingBO {
	
	private String title;
	private List<SubtitlesBO> subtitles;
	
	private String docType;
	
	private String url;
	
	
	private String  key;
	
	private String icon ;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<SubtitlesBO> getSubtitles() {
		return subtitles;
	}
	public void setSubtitles(List<SubtitlesBO> subtitles) {
		this.subtitles = subtitles;
	}
	public void setUrl(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getUrl() {
		return url;
	}
	
	

}
