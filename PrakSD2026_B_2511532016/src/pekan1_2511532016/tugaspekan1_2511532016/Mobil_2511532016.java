package tugaspekan1_2511532016;

public class Mobil_2511532016 {
	//Atribut
	private String nama;
	private int tahun;
	private int cc;
	private int harga;
	private String merk;
	
	//Validator
	private static boolean isValid(String n, int t, int cc, int h, String m) {
		return !(n.isBlank()) && !(t < 0) && !(cc < 0) && !(h <0) && !(m.isBlank());
	}
	//Konstruktor
	public Mobil_2511532016(String nama, int tahun, int cc, int harga, String merk) {
		if(isValid(nama, tahun, cc, harga, merk)) {
		this.nama = nama;
		this.tahun = tahun;
		this.cc = cc;
		this.harga = harga;
		this.merk = merk;
		}
	}
	
	//Selektor
	public String getNama(){return nama;}
	public int getTahun(){return tahun;}
	public int getCC(){return cc;}
	public int getHarga(){return harga;}
	public String getMerk(){return merk;}
	
	//Mutator
	public void setNama(String n) {this.nama = n;}
	public void setTahun(int t) {this.tahun = t;}
	public void setCC(int cc) {this.cc = cc;}
	public void setHarga(int cc) {this.cc = cc;}
	public void setMerk(String m) {this.merk = m;}
	
	
	
	
	//Method-Method Tambahan
	private static Mobil_2511532016[] mobilMobilan = new Mobil_2511532016[100];
	private static int n = 0;
	
	//Menambahkan Mobil
	public static void tambahMobil(Mobil_2511532016 M) {
		if(n < mobilMobilan.length)
		mobilMobilan[n] = M;
		n++;
	}
	//Menghapus Mobil Berdasarkan Index
	public static void hapusMobil(int idx){
	    if(idx >= 0 && idx < n){
	        for(int i = idx; i < n-1; i++){
	        	mobilMobilan[i] = mobilMobilan[i+1];
	        }
	        mobilMobilan[n-1] = null;
	        n--;
	    }
	}
	//Menampilkan Mobil-Mobil
	public static void tampilkanMobilMobilan(){
	    for(int i = 0; i < n; i++){
	        Mobil_2511532016 m = mobilMobilan[i];
	        System.out.println(
	            m.getNama()+" "+
	            m.getMerk()+" "+
	            m.getTahun()+" "+
	            m.getCC()+"cc "+
	            m.getHarga()
	        );
	    }
	}
	
}