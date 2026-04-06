package pekan2_2511532016;

public class DaftarKataDriver_2511553206 {

	public static void main(String[] args) {
		DaftarKata_2511532016 al = new DaftarKata_2511532016();
		
		//	Menambah elemen (akhir)
		al.tambah_2511532016("Kami ");
		al.tambah_2511532016("Informatika");
		
		//	Menyisipkan elemen pada indeks 1
		al.tambahPada_2511532016(1, "Mahasiswa");
		
		//	Cetak isi awal
		System.out.println("Awal     :" + al);
		
		//	Mengubah elemen (index 1)
		al.ubahElemen_2511532016(1, "Departemen");
		System.out.println("Setelah Ubah: "+ al);
		
		//	Menghapus elemen (hapus index 0)
		String terhapus = al.hapusElemen2511532016(0);
		System.out.println("Terhapus   : " + terhapus);
		System.out.println("Setelah Hapus: " + al);
		
		//Iterasi pada ArrayList
		System.out.print("Iterasi:");
		al.iterasiCetak_2511532016();
		System.out.println();
		
		
	}

}
