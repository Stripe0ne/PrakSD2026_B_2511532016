package pekan8_2511532016;

public class Sorting_2511532016 {

    private Lagu_2511532016[] dataLagu_2016 = new Lagu_2511532016[100];
    private int jumlahLagu_2016 = 0;
    public void inputData_2016() {
    	dataLagu_2016[0]  = new Lagu_2511532016("Wind's Anthem",    "Eve",       			223);
    	dataLagu_2016[1]  = new Lagu_2511532016("spiral",			"LONGMAN",    			232);
    	dataLagu_2016[2]  = new Lagu_2511532016("Souvenir",         "Bump of Chicken",  	265);
    	dataLagu_2016[3]  = new Lagu_2511532016("Same Blue",  		"OFFICIAL HIGE DANDISM",238);
        dataLagu_2016[4]  = new Lagu_2511532016("Kaiju",          	"sakanaction",     		253);
        dataLagu_2016[5]  = new Lagu_2511532016("Hello, World!",	"Bump of Chicken", 		249);
        dataLagu_2016[6]  = new Lagu_2511532016("Beneath the Mask", "Lyn",      			278);
        dataLagu_2016[7]  = new Lagu_2511532016("Absolute Zero",    "natori",         		199);
        dataLagu_2016[8]  = new Lagu_2511532016("Memories of You",  "Azumi Takahashi", 		400);
        dataLagu_2016[9]  = new Lagu_2511532016("SPECIALZ", 		"King Gnu", 			240);
        jumlahLagu_2016 = 10;
    }

   
    public void shellSort_2016() {
        int n_2016 = jumlahLagu_2016;
        int gap_2016 = n_2016 / 2;
        while (gap_2016 > 0) {
            for (int i_2016 = gap_2016; i_2016 < n_2016; i_2016++) {
                Lagu_2511532016 temp_2016 = dataLagu_2016[i_2016];
                int j_2016 = i_2016;
                while (j_2016 >= gap_2016 &&
                        dataLagu_2016[j_2016 - gap_2016].getJudul_2016().
                        compareToIgnoreCase(temp_2016.getJudul_2016()) > 0) {
                    dataLagu_2016[j_2016] = dataLagu_2016[j_2016 - gap_2016];
                    j_2016 -= gap_2016;
                }
                dataLagu_2016[j_2016] = temp_2016;
            }
            gap_2016 /= 2;
        }
    }

    
    public void tampilData_2016(String judul_2016) {
        System.out.println(judul_2016);
        for (int i_2016 = 0; i_2016 < jumlahLagu_2016; i_2016++) {
            System.out.println((i_2016 + 1) + ". " + dataLagu_2016[i_2016]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorting_2511532016 playlist_2016 = new Sorting_2511532016();

        System.out.println("=== Sorting Playlist NIM: 2511532016 ===");
        System.out.println("Algoritma: Shell Sort (Judul A-Z)\n");

        playlist_2016.inputData_2016();
        playlist_2016.tampilData_2016("Data Sebelum Sorting:");

        playlist_2016.shellSort_2016();

        playlist_2016.tampilData_2016("Data Setelah Shell Sort (Judul A-Z):");
    }
}
