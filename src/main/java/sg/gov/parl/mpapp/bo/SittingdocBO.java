package sg.gov.parl.mpapp.bo;

import java.util.List;

public class SittingdocBO {
	
	String title;
	List<DocsBO> docs;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<DocsBO> getDocs() {
		return docs;
	}
	public void setDocs(List<DocsBO> docs) {
		this.docs = docs;
	}
	
}
