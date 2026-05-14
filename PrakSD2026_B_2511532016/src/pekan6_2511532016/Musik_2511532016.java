package pekan6_2511532016;
import java.util.*;

public class Musik_2511532016 {
	
	static Scanner sc_2016 = new Scanner(System.in);
	
	//Method alias untuk System.out.println() agar terlihat lebih rapi 
	static void Jump_2016() {
		System.out.println();
	}
	//Method untuk menampilkan menu yang akan dipanggil pada method main
	static void tampilkanMenu_2016() {
		System.out.println("=== Playlist Musik NIM: 2511532016 ===");	
		System.out.println("1. Tambah Lagu");
		System.out.println("2. Hapus Lagu Pertama");
		System.out.println("3. Lihat Playlist (Maju)");
		System.out.println("4. Lihat Playlist (Mundur)");
		System.out.println("5. Cari Lagu");
		System.out.println("6. Keluar Dari Menu");
	}
	
	//Fungsi untuk menambahkan lagu ke dalam DLL
	static Lagu_2511532016 TambahLagu_2016(Lagu_2511532016 head_2016) {
		Lagu_2511532016 newSong_2016 = new Lagu_2511532016();
		
		System.out.print("Masukkan Judul Lagu: ");
		String judul_2016 = sc_2016.nextLine();
		newSong_2016.setJudul_2016(judul_2016);
		
		System.out.print("Masukkan Penyanyi Lagu: ");
		String penyanyi_2016 = sc_2016.nextLine();
		newSong_2016.setPenyanyi_2016(penyanyi_2016);
		
		if(head_2016 == null) head_2016 = newSong_2016;
		else {
			Lagu_2511532016 curr_2016 = head_2016;
			
			while(curr_2016.getNext_2016() != null) {
				curr_2016 = curr_2016.getNext_2016();
			}
			
			curr_2016.setNext_2016(newSong_2016);
			newSong_2016.setPrev_2016(curr_2016);
		}
		System.out.println("Lagu " + newSong_2016.getJudul_2016() + 
		" oleh " + newSong_2016.getPenyanyi_2016()+ 
		" Berhasil Ditambahkan ke dalam Playlist!\n");
		
		return head_2016;
	}
	
	//Fungsi untuk menghapus lagu pertama (head) pada DLL
	static Lagu_2511532016 HapusLaguPertama_2016(Lagu_2511532016 head_2016) {
		if(head_2016 == null) {
			System.out.println("Playlist Kosong!\n");
			return null;
		}
		System.out.println("Lagu " + head_2016.getJudul_2016() + 
		" oleh " + head_2016.getPenyanyi_2016()+ 
		" Berhasil Dihapus!\n");
		head_2016 = head_2016.getNext_2016();
		if(head_2016 != null) {
			head_2016.setPrev_2016(null);
		}
		return head_2016;
	}
	
	//Method untuk menampilkan daftar lagu dari kiri ke kanan (berdasarkan waktu dimasukkan)
	static void ShowListFromLeft_2016(Lagu_2511532016 head_2016) {
		Lagu_2511532016 curr_2016 = head_2016;
		if(curr_2016 == null) {
			System.out.println("Playlist Kosong!\n");
			return;
		}
		while(curr_2016 != null) {
			System.out.println(curr_2016.getJudul_2016() + " - " + curr_2016.getPenyanyi_2016());
			curr_2016 = curr_2016.getNext_2016();
		}
		Jump_2016();
	}
	
	//Method untuk menampilkan daftar lagu dari kanan ke kiri (berdasarkan waktu dimasukkan)
	static void ShowListFromRight(Lagu_2511532016 tail_2016) {
		Lagu_2511532016 curr_2016 = tail_2016;
		if(curr_2016 == null) {
			System.out.println("Playlist Kosong!\n");
			return;
		}
		//Pergi ke bagian ujung dulu
		while(curr_2016.getNext_2016() != null) {
			curr_2016 = curr_2016.getNext_2016();
		}
		while(curr_2016 != null) {
			System.out.println(curr_2016.getJudul_2016() + " - " + curr_2016.getPenyanyi_2016());
			curr_2016 = curr_2016.getPrev_2016();
		}
		Jump_2016();
	}
	
	//Method untuk mencari judul lagu
	static void CariJudul_2016(Lagu_2511532016 head_2016) {
		if(head_2016 == null) {
			System.out.println("Playlist Kosong!\n");
			return;
		}
		Lagu_2511532016 curr_2016 = head_2016;
		System.out.print("Masukkan Judul Lagu yang Ingin Dicari: "); 
		String judul_2016 = sc_2016.nextLine();
		while(curr_2016 != null) {
			if(curr_2016.judul_2016.toLowerCase().equals(judul_2016.toLowerCase())) {
				System.out.println("Lagu " + curr_2016.getJudul_2016() + " Terdapat dalam Playlist!\n");
				return;}
			curr_2016 = curr_2016.getNext_2016();}
		System.out.println("Lagu " + judul_2016 + " Tidak Terdapat dalam Playlist!\n");
		return;
		}
	
	public static void main(String[] args) {
		Lagu_2511532016 head_2016 = null;
		int choice_2016;
		do {
			tampilkanMenu_2016();
			System.out.print("Pilih menu: ");
			choice_2016 = sc_2016.nextInt();
			sc_2016.nextLine();
			switch(choice_2016){
				case 1:
					head_2016 = TambahLagu_2016(head_2016);
					break;
				case 2:
					head_2016 = HapusLaguPertama_2016(head_2016);
					break;
				case 3:
					ShowListFromLeft_2016(head_2016);
					break;
				case 4:
					ShowListFromRight(head_2016);
					break;
				case 5:
					CariJudul_2016(head_2016);
					break;
				case 6:
					System.out.println("Program Selesai.");
					break;
				default:
					System.out.println("Pilihan tidak valid!");
			} 
		} while (choice_2016 != 6);
		sc_2016.close();
	}

}
