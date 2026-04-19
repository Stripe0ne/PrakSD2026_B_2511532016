package pekan2_2511532016;

public class Musik_2511532016 {
	private String JudulLagu_2016;
	private String Penyanyi_2016;
	private int Durasi_2511532016;
	
	//Construct
	public Musik_2511532016(String JudulLagu_2016, String Penyanyi_2016, int Durasi_2511532016) {
		this.JudulLagu_2016 = JudulLagu_2016;
		this.Penyanyi_2016 = Penyanyi_2016;
		this.Durasi_2511532016 = Durasi_2511532016;
	}
	//Get
	public String getJudulLagu_2016() { return JudulLagu_2016;}
	public String getPenyanyi_2016() { return Penyanyi_2016;}
	public int getDurasi_2511532016() { return Durasi_2511532016;}

	//Set
	public void setJudulLagu_2016(String JudulLagu_2016) { this.JudulLagu_2016 = JudulLagu_2016;}
	public void setPenyanyi_2016(String Penyanyi_2016) { this.Penyanyi_2016 = Penyanyi_2016;}
	public void setDurasi_2511532016(int Durasi_2511532016) { this.Durasi_2511532016 = Durasi_2511532016;}
	
	@Override
	public String toString() {
		 return JudulLagu_2016 + " - " + Penyanyi_2016 + " (" + Durasi_2511532016 + " detik)";
	}
}



