package pekan5_2511532016;
public class Pasien_2511532016 {
	String namaPasien_2016;
	String penyakit_2016;
	int nomorAntrian_2016;
	
	Pasien_2511532016 next_2016;
	public Pasien_2511532016() {
		this.namaPasien_2016 = null;
		this.penyakit_2016 = null;
		this.next_2016 = null;
	
	}
	public String getNamaPasien() {
		return namaPasien_2016;
	}
	public String getPenyakit() {
		return penyakit_2016;
	}
	public int getNomorAntrian() {
		return nomorAntrian_2016;
	}
	public Pasien_2511532016 getNext() {
		return next_2016;
	}
	
	public void setNamaPasien(String namaPasien_2016) {
		this.namaPasien_2016 = namaPasien_2016;
	}
	public void setPenyakit(String penyakit_2016) {
		this.penyakit_2016 = penyakit_2016;
	}
	public void setNomorAntrian(int nomorAntrian_2016) {
		this.nomorAntrian_2016 = nomorAntrian_2016;
	}
	public void setNext(Pasien_2511532016 next_2016) {
		this.next_2016 = next_2016;
	}
	
}



