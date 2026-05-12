package pekan1_2511532016;

public final class Jam_2511532016 {
	private int hh_2016; //0...23
	private int mm_2016; //0...59
	private int ss_2016; //0...59

	//---Validator---
	public static boolean isValid(int h_2016, int m_2016, int s_2016){
		return (h_2016>=0 && h_2016<=23) && (m_2016>=0 && m_2016<=59) && (s_2016>=0 && s_2016<=59);
	}

	//---Konstruktor---
	public Jam_2511532016(int h_2016, int m_2016, int s_2016){
		this.hh_2016 = h_2016; this.mm_2016=m_2016; this.ss_2016=s_2016;
	}

	//---Selektor---
	public int getHour(){return hh_2016;}
	public int getMinute(){return mm_2016;}
	public int getSecond(){return ss_2016;}

	//---Mutator---
	public void setHour(int h_2016){this.hh_2016 = h_2016;}
	public void setMinute(int m_2016){this.mm_2016 = m_2016;}
	public void setSecond(int s_2016){this.ss_2016 = s_2016;}

	//Konversi
	public int toSeconds(){return hh_2016*3600 + mm_2016*60 + ss_2016;}
	
	public static Jam_2511532016 fromSeconds(int total_2016){
		if(total_2016 <0 ) throw new IllegalArgumentException("Detik Negatif!");
		total_2016 %= 24*3600; 
		int h = total_2016/3600; total_2016 %=3600; 
		int m = total_2016/60; int s = total_2016%60;
		return new Jam_2511532016(h,m,s);
	}
	//---Relasional---
	public int compareTo(Jam_2511532016 other_2016){ 
		return Integer.compare(this.toSeconds(),other_2016.toSeconds());}
	
	public boolean equals(Object o_2016){
		if(!(o_2016 instanceof Jam_2511532016 j_2016)) return false;		
		return hh_2016 == j_2016.hh_2016 && mm_2016 == j_2016.mm_2016 && ss_2016 == j_2016.ss_2016;
	}
	public int hashCode() {
		return java.util.Objects.hash(hh_2016,mm_2016,ss_2016);}

	//---Aritmatika---
	public Jam_2511532016 plus(Jam_2511532016 other_2016){return fromSeconds(this.toSeconds() + other_2016.toSeconds());}
	public Jam_2511532016 minus(Jam_2511532016 other_2016){return fromSeconds(this.toSeconds() - other_2016.toSeconds());}
	public Jam_2511532016 nextSecond(){return fromSeconds(this.toSeconds() + 1);}
	public Jam_2511532016 nextNSecond(int n_2016){ return fromSeconds(this.toSeconds() + Math.max(0,n_2016));}
	public Jam_2511532016 prevSecond() {return fromSeconds(Math.floorMod(this.toSeconds() -1, 24*3600));}
	public Jam_2511532016 prevNSecond(int n_2016){ return fromSeconds(Math.floorMod(this.toSeconds() - Math.max(0,n_2016), 24*3600));}

	//--- Durasi (detik) -- bisa negatif jika this > other? sesuai spesifikasi durasi (JAw, JAkh)
	public static int durasiDetik(Jam_2511532016 JAw_2016, Jam_2511532016 JAkh_2016){	
	return JAkh_2016.toSeconds() - JAw_2016.toSeconds();}

	//Overriding ke string
	public String toString(){ 
	return String.format("%02d:%02d:%02d", hh_2016,mm_2016,ss_2016);}}
