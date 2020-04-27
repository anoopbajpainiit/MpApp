package sg.gov.parl.mpapp.bo;

import java.util.List;

public class AllSittings {
	
	private int volume;
    private int parliament;
    private int session;
    private List<SittingBO> sittings;
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getParliament() {
		return parliament;
	}
	public void setParliament(int parliament) {
		this.parliament = parliament;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public List<SittingBO> getSittings() {
		return sittings;
	}
	public void setSittings(List<SittingBO> sittings) {
		this.sittings = sittings;
	}

}
