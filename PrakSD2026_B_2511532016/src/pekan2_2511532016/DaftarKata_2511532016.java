package pekan2_2511532016;
import java.util.ArrayList;


public class DaftarKata_2511532016 {
	private final ArrayList<String> data;
	
	// Konstruktor: inisialisasi list kosong
	public DaftarKata_2511532016() {
		this.data = new ArrayList<>();
	}
	//Menambahkan elemen di akhir list
	public void tambah_2511532016(String elemen) {
		data.add(elemen);
	}
	//Menambahkan elemen pada indeks tertentu
	public void tambahPada_2511532016(int index, String elemen) {
		data.add(index, elemen);
	}
	/*
	 * Mengubah elemen pada posisi 'index' menjadi 'nilaiBaru'
	 * Bertindak sebagai "setter" untuk elemen tertentu
	 */
	public void ubahElemen_2511532016(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	public String hapusElemen2511532016(int index) {
		return data.remove(index);
	}
	
	public void iterasiCetak_2511532016() {
		for (int i=0; i< data.size(); i++) {
			System.out.print(data.get(i)+ " ");
		}
	}
	public String get(int index) {
		return data.get(index);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
