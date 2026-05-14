package pekan6_2511532016;

public class Lagu_2511532016 {
	String judul_2016;
	String penyanyi_2016;
	Lagu_2511532016 next_2016;
	Lagu_2511532016 prev_2016;
	
	public Lagu_2511532016() {
		this.judul_2016 = null;
		this.penyanyi_2016 = null;
		this.next_2016 = null;
		this.prev_2016 = null;
	}
	
	
	public void setJudul_2016(String judul_2016) {
		this.judul_2016 = judul_2016;
	}
	public void setPenyanyi_2016(String penyanyi_2016) {
		this.penyanyi_2016 = penyanyi_2016;
	}
	public void setNext_2016(Lagu_2511532016 next_2016) {
		this.next_2016 = next_2016;
	}
	public void setPrev_2016(Lagu_2511532016 prev_2016) {
		this.prev_2016 = prev_2016;
	}
	
	public String getJudul_2016() {
		return judul_2016;
	}
	public String getPenyanyi_2016() {
		return penyanyi_2016;
	}
	public Lagu_2511532016 getNext_2016() {
		return next_2016;
	}
	public Lagu_2511532016 getPrev_2016() {
		return prev_2016;
	}
}
