package sg.gov.parl.mpapp.bo;

import java.util.List;

public class NotificationInfoBO {
	
	private List<NotificationBo> leaves;
	private List<NotificationBo> parlBusiness;
	private List<NotificationBo> others;
	
	public List<NotificationBo> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<NotificationBo> leaves) {
		this.leaves = leaves;
	}
	
	public List<NotificationBo> getParlBusiness() {
		return parlBusiness;
	}
	public void setParlBusiness(List<NotificationBo> parlBusiness) {
		this.parlBusiness = parlBusiness;
	}
	public List<NotificationBo> getOthers() {
		return others;
	}
	public void setOthers(List<NotificationBo> others) {
		this.others = others;
	}

	/*public List<NotificationBo> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationBo> notifications) {
		this.notifications = notifications;
	}*/
	
	
	
}
