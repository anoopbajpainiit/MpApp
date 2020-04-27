package sg.gov.parl.mpapp.bo;

import java.util.List;

public class PollBO {
	
	private String title;
	private String description;
	private String startdate;
	private String enddate;
	private String key;
	
    private List<OptionBO> options;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<OptionBO> getOptions() {
		return options;
	}
	public void setOptions(List<OptionBO> options) {
		this.options = options;
	}

}
