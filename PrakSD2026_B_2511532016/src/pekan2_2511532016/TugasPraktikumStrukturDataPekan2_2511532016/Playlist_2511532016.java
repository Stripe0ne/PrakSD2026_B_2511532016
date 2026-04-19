package pekan2_2511532016;
import java.util.ArrayList;
import java.util.Scanner;
public class Playlist_2511532016 {
	// 1. Menampilkan Menu
	public static void tampilkanMenu_2016() {
		System.out.println("\nMenu:");	
		System.out.println("1. Tambah Lagu");
		System.out.println("2. Tampilkan Playlist Lagu");
		System.out.println("3. Hapus Lagu Berdasarkan Index");
		System.out.println("4. Tampilkan Kapasistas Playlist");
		System.out.println("5. Keluar");
		}
	//2. Menambahkan Lagu
	public static void tambahLagu_2016(ArrayList<Musik_2511532016> list, Scanner sc) {
		System.out.print("Masukkan Judul Lagu: ");
		String JudulLagu_2016 = sc.nextLine();
		System.out.print("Masukkan Nama Penyanyi: ");
		String Penyanyi_2016 = sc.nextLine();
		System.out.print("Masukkan Durasi Lagu: ");
		int Durasi_2016= sc.nextInt();
		list.add(new Musik_2511532016(JudulLagu_2016, Penyanyi_2016, Durasi_2016));
		System.out.println("Lagu berhasil ditambahkan!");
	}
	//3. Menampilkan Playlist Lagu
	public static void tampilkanPlaylistLagu_2016(ArrayList<Musik_2511532016> list) {
		if(list.isEmpty()) System.out.println("PLaylist lagu kosong");
		else {
			System.out.println("Playlist Lagu");
			for(Musik_2511532016 lagu: list) {
				System.out.println(lagu);
			}
		}
	}
	//4. Menghapus Lagu Berdasarkan Index
	public static void hapusLagu_2016(ArrayList<Musik_2511532016> list, Scanner sc) {
		if (list.isEmpty()) {
            System.out.println("Playlist masih kosong.");
        } else {
            System.out.print("Masukkan Indeks Lagu yang Ingin Dihapus: ");
            int idx = sc.nextInt();
            
            if(idx <1 || idx >list.size()) {
            	System.out.println("Index Tidak Valid!");
            }
            else {
            	String hapusJudul = list.get(idx - 1).getJudulLagu_2016();
            	list.remove(idx-1);
            	System.out.println("Lagu " + hapusJudul + " Berhasil Dihapus!");
            }
        }
     }
	//5. Menampilkan Banyak Lagu
	public static void banyakLagu_2016(ArrayList<Musik_2511532016> list) {
		System.out.println("Banyak Lagu dalam Playlist: " + list.size());
	}

	public static void main(String[] args) {
		ArrayList<Musik_2511532016> Playlist= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			tampilkanMenu_2016();
			System.out.println("Pilih Menu: ");
			choice = sc.nextInt();
			sc.nextLine();
		
			switch(choice) {
			case 1:
				tambahLagu_2016(Playlist, sc);
				break;
			case 2:
				tampilkanPlaylistLagu_2016(Playlist);
				break;
			case 3:
				hapusLagu_2016(Playlist, sc);
				break;
			case 4:
				banyakLagu_2016(Playlist);
				break;
			case 5:
				System.out.println("Keluar dari program.");
				break;
			default:
				System.out.println("Pilihan Tidak Valid.");
				}
			
			} while (choice != 5);
			sc.close();
		}
	}

