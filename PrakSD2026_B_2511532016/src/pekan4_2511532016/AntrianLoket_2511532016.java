package pekan4_2511532016;
import java.util.Scanner;
public class AntrianLoket_2511532016 {
	public static void tampilkanMenu_2511532016() {
		System.out.println("\nMenu:");	
		System.out.println("1. Tambah Antrian");
		System.out.println("2. Hapus Antrian"); 
		System.out.println("3. Tampilkan Antrian");
		System.out.println("4. Reverse Antrian");
		System.out.println("5. Keluar");
		}
	public static void main(String[] args) {
		Queue_2511532016 Antrian = new Queue_2511532016(100);
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			tampilkanMenu_2511532016();
			System.out.print("Pilih menu: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					System.out.print("Masukkan nama pelanggan: ");
					String nama= scanner.nextLine();
					Antrian.enqueue_2016(nama);
					break;
				case 2:
					Antrian.dequeue_2016();
					break;
				case 3:
					Antrian.display_2016();
					break;
				case 4:
					Antrian.Reverse_2016();
					break;
				case 5:
					System.out.println("Keluar dari program.");
					break;
				default:
					System.out.println("Pilihan tidak valid!");
					break;
			} 
		} while (choice != 5);
		scanner.close();
		}	
}



