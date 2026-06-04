package pekan8_2511532016;

public class Lagu_2511532016 {
    private String judul_2016;
    private String penyanyi_2016;
    private int durasi_2016;

    public Lagu_2511532016(String judul_2016, String penyanyi_2016, int durasi_2016) {
        this.judul_2016 = judul_2016;
        this.penyanyi_2016 = penyanyi_2016;
        this.durasi_2016 = durasi_2016;
    }

    public String getJudul_2016()    { return judul_2016; }
    public String getPenyanyi_2016() { return penyanyi_2016; }
    public int getDurasi_2016()      { return durasi_2016; }

    public void setJudul_2016(String judul_2016)       { this.judul_2016 = judul_2016; }
    public void setPenyanyi_2016(String penyanyi_2016) { this.penyanyi_2016 = penyanyi_2016; }
    public void setDurasi_2016(int durasi_2016)        { this.durasi_2016 = durasi_2016; }

    @Override
    public String toString() {
        return judul_2016 + " - " + penyanyi_2016 + " (" + durasi_2016 + " detik)";
    }
}



