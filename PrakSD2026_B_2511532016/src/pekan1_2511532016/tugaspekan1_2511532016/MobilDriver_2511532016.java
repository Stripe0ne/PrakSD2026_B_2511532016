package tugaspekan1_2511532016;

public class MobilDriver_2511532016 {

    public static void main(String[] args) {

        Mobil_2511532016 M1 = new Mobil_2511532016("Xpander", 2021, 1500, 270000000, "Mitsubishi");
        Mobil_2511532016 M2 = new Mobil_2511532016("Civic", 2020, 1800, 500000000, "Honda");
        Mobil_2511532016 M3 = new Mobil_2511532016("Avanza", 2018, 1500, 200000000, "Toyota");
        Mobil_2511532016 M4 = new Mobil_2511532016("MobilOwi", 2019, 0, 19000000, "AsliSolo");
  
        
        Mobil_2511532016.tambahMobil(M1);
        Mobil_2511532016.tambahMobil(M2);
        Mobil_2511532016.tambahMobil(M3);
        Mobil_2511532016.tambahMobil(M4);

        System.out.println("=== Daftar Mobil ===");
        Mobil_2511532016.tampilkanMobilMobilan();

        System.out.println("\n=== Hapus Mobil Index 1 ===");
        Mobil_2511532016.hapusMobil(3);

        System.out.println("\n=== Daftar Mobil Setelah Dihapus ===");
        Mobil_2511532016.tampilkanMobilMobilan();
    }
}

