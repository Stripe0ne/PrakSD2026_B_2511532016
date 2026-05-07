package pekan5_2511532016;
import java.util.Scanner;


public class RumahSakit_2511532016 {
	static Scanner sc = new Scanner(System.in);
	static int nomorAntrian=0;
	
	static void tampilkanMenu_2016() {
		System.out.println("\nMenu:");	
		System.out.println("1. Daftarkan Pasien");
		System.out.println("2. Tampilkan Antrian");
		System.out.println("3. Cari Pasien Dalam Antrian");
		System.out.println("4. Cek Status Antrian Saat Ini");
		System.out.println("5. Panggil Pasien");
		System.out.println("6. Keluar Dari Menu");
	}
	
	static Pasien_2511532016 DaftarkanPasien_2016(Pasien_2511532016 head_2016) {
	    Pasien_2511532016 pasienBaru_2016 = new Pasien_2511532016();
	    System.out.print("Masukkan Nama Pasien: ");
	    String namaPasien = sc.nextLine();
	    pasienBaru_2016.setNamaPasien(namaPasien);
	    System.out.print("Masukkan Penyakit Pasien: ");
	    String penyakit_2016 = sc.nextLine();
	    pasienBaru_2016.setPenyakit(penyakit_2016);
	    pasienBaru_2016.setNomorAntrian(++nomorAntrian);
	    if (head_2016 == null) {	    	 
	    	System.out.println("Pasien Berhasil Didaftarkan! Nomor antrian: " + pasienBaru_2016.getNomorAntrian());
	        return pasienBaru_2016;
	    }
	    Pasien_2511532016 temp_2016 = head_2016;
	    while (temp_2016.getNext() != null) {
	        temp_2016 = temp_2016.getNext();
	    }
	    temp_2016.setNext(pasienBaru_2016);
		System.out.println("Pasien Berhasil Didaftarkan! Nomor antrian: " + pasienBaru_2016.getNomorAntrian());
	    return head_2016;
	}
	
	 static void TampilkanAntrian(Pasien_2511532016 head_2016) {
		 if(head_2016 == null) {
				System.out.println("Antrian Kosong!");
				return;
			}
		Pasien_2511532016 temp_2016 = head_2016;
		while(temp_2016 != null) {
		System.out.println("\nNama Pasien 	: " + temp_2016.getNamaPasien());
		System.out.println("Penyakit Pasien	: " + temp_2016.getPenyakit());
		System.out.println("Nomor Antrian	: " + temp_2016.getNomorAntrian());
		System.out.println();
		temp_2016 = temp_2016.getNext();
		}
	 }
	 
	 static void CariPasien(Pasien_2511532016 head_2016) {
		    if (head_2016 == null) {
		        System.out.println("Antrian Kosong!");
		        return;
		    }
		    System.out.print("Masukkan nama pasien yang dicari: ");
		    String nama_2016 = sc.nextLine().toLowerCase();
		    
		    Pasien_2511532016 temp_2016 = head_2016;
		    while (temp_2016 != null) {
		        if (temp_2016.getNamaPasien().toLowerCase().equals(nama_2016)) {
		            System.out.println("Pasien Ada!");
		            return;
		        }
		        temp_2016 = temp_2016.getNext();
		    }

		    System.out.println("Pasien Tidak Ada!");
		}
	 
	static void CekStatusAntrian(Pasien_2511532016 head_2016) {
		if(head_2016== null) {
			System.out.println("Antrian Kosong!");
			return;
		}
		Pasien_2511532016 temp_2016 = head_2016;
		int i_2016 =0;
		while(temp_2016 != null) {
				i_2016++;
				temp_2016 = temp_2016.getNext();
			}
		System.out.println("\nSaat ini, terdapat " + i_2016 + " pasien.");

		System.out.println("Status Pasien Selanjutnya: ");
		System.out.println("Nama Pasien 	: " + head_2016.getNamaPasien());
		System.out.println("Penyakit Pasien	: " + head_2016.getPenyakit());
		System.out.println("Nomor Antrian	: " + head_2016.getNomorAntrian());
		}
	
	
	
	static Pasien_2511532016 PanggilPasien_2016(Pasien_2511532016 head_2016) {
		if(head_2016 == null) {
			System.out.println("Antrian Kosong!");
			return null;
		}
		
		Pasien_2511532016 pasien_2016 = head_2016;
		System.out.println(
				"\nPasien dengan nomor urut " + pasien_2016.getNomorAntrian() + 
				" atas nama " + pasien_2016.getNamaPasien() +
				" dan memiliki penyakit " + pasien_2016.getPenyakit() +
				" telah dilayani!"
				);
		head_2016 = head_2016.getNext();
		return head_2016;
	}
	
	public static void main(String[] args) {
		Pasien_2511532016 head_2016 = null;
		int choice;
		do {
			tampilkanMenu_2016();
			System.out.print("Pilih menu: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
				case 1:
					head_2016 =  DaftarkanPasien_2016(head_2016);
					break;
				case 2:
					TampilkanAntrian(head_2016);
					break;
				case 3:
					CariPasien(head_2016);
					break;
				case 4:
					CekStatusAntrian(head_2016);
					break;
				case 5:
					head_2016 = PanggilPasien_2016(head_2016);
					break;
				case 6:
					System.out.println("Program Selesai.");
					break;
				default:
					System.out.println("Pilihan tidak valid!");
			} 
		} while (choice != 6);
		sc.close();
	}
}
