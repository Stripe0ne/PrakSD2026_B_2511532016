package pekan3_2511532016;
import java.util.Stack;
import java.util.Scanner;
public class Browser_2511532016 {
	//1. Menampilkan Menu
	public static void tampilkanMenu_2016() {
		System.out.println("\nMenu:");	
		System.out.println("1. Kunjungi Halaman");
		System.out.println("2. Kembali ke Halaman Sebelumnya");
		System.out.println("3. Melihat Halaman Saat Ini");
		System.out.println("4. Tampilkan Banyak Halaman di History");
		System.out.println("5. Keluar");
		}
	//2. Mengunji Website
	public static void kunjungiWebsite_2016(Stack<Website_2511532016> history, Scanner sc) {
		System.out.print("Masukkan Judul Website: ");
		String judul = sc.nextLine();
		System.out.print("Masukkan URL: ");
		String URL = sc.nextLine();
		history.push(new Website_2511532016(judul, URL));
		System.out.println("Berhasil Mengunjungi Halaman!");
	}
	//3. Menekan tombol back
	public static void tekanBack_2016(Stack<Website_2511532016> history) {
		if(history.isEmpty()) {
			System.out.println("Tidak ada halaman sebelumnya");
		}
		else {
			Website_2511532016 halaman = history.pop();
			System.out.println("Kembali dari: " + halaman.getJudulWebsite());}
}
	//4. Melihat halaman yang sedang aktif
	public static void lihatHalamanAktif_2016(Stack<Website_2511532016> history) {
	if(history.isEmpty()) {
		System.out.println("Tidak ada halaman yang sedang dibuka!");
	} else {
		Website_2511532016 aktif = history.peek();
		System.out.println("Halaman saat ini: " + aktif.getJudulWebsite());
	}
	}
	//5. Mengecek status history
	public static void cekStatusHistory_2016(Stack<Website_2511532016>history) {
		if(history.isEmpty()) {
			System.out.println("History kosong.");
		}
		else {
			System.out.println("Banyak halaman di history: " + history.size());
		}
	}
	
	public static void main(String[] args) {
		Stack<Website_2511532016> history= new Stack<>();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			tampilkanMenu_2016();
			System.out.println("Pilih Menu: ");
			choice = sc.nextInt();
			sc.nextLine();
		
			switch(choice) {
			case 1:
				kunjungiWebsite_2016(history, sc);
				break;
			case 2:
				tekanBack_2016(history);
				break;
			case 3:
				lihatHalamanAktif_2016(history);
				break;
			case 4:
				cekStatusHistory_2016(history);
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