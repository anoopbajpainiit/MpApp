package sg.gov.parl.mpapp.bo;

import java.util.List;

public class PreSittingInfo {
	
	List<PreSittingBO> presit;
	List<PreSittingBO> postsit;
	List<PreSittingBO> sittings;

	public List<PreSittingBO> getPresit() {
		return presit;
	}
	public void setPresit(List<PreSittingBO> presit) {
		this.presit = presit;
	}
	public List<PreSittingBO> getPostsit() {
		return postsit;
	}
	public void setPostsit(List<PreSittingBO> postsit) {
		this.postsit = postsit;
	}
	public List<PreSittingBO> getSittings() {
		return sittings;
	}
	public void setSittings(List<PreSittingBO> sittings) {
		this.sittings = sittings;
	}
	
	
	
}
