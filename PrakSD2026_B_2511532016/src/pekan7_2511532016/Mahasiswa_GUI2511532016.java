package pekan7_2511532016;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


//ADT Mahasiswa - menyimpan data seorang mahasiswa
 class Mahasiswa_2511532016 {
 // Atribut
 private String nama_2016;
 private String nim_2016;
 private String prodi_2016;

 // Constructor
 public Mahasiswa_2511532016(String nama_2016, String nim_2016, String prodi_2016) {
     this.nama_2016 = nama_2016;
     this.nim_2016 = nim_2016;
     this.prodi_2016 = prodi_2016;
 }

 // Getter
 public String getNama_2016() { return nama_2016; }
 public String getNim_2016()  { return nim_2016; }
 public String getProdi_2016(){ return prodi_2016; }

 // Setter
 public void setNama_2016(String nama_2016)   { this.nama_2016 = nama_2016; }
 public void setNim_2016(String nim_2016)     { this.nim_2016 = nim_2016; }
 public void setProdi_2016(String prodi_2016) { this.prodi_2016 = prodi_2016; }

 @Override
 public String toString() {
     return nama_2016 + " | " + nim_2016 + " | " + prodi_2016;
 }
}

public class Mahasiswa_GUI2511532016 extends JFrame {

    private static final long serialVersionUID = 1L;

    // Data
    private ArrayList<Mahasiswa_2511532016> dataMahasiswa_2016 = new ArrayList<>();

    // Komponen input
    private JTextField fieldNama_2016, fieldNim_2016, fieldProdi_2016;
    private JButton btnTambah_2016, btnHapus_2016, btnSorting_2016, btnReset_2016;
    private JComboBox<String> comboAlgoritma_2016;

    // Area tampilan
    private JTextArea areaTabelData_2016;
    private JTextArea areaHasil_2016;

    public Mahasiswa_GUI2511532016() {
    	
    	//Properti Program
        setTitle("Pengurutan Nama Mahasiswa - Sorting Algoritma");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== PANEL INPUT (NORTH) =====
        JPanel panelInput_2016 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_2016.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        fieldNama_2016  = new JTextField();
        fieldNim_2016   = new JTextField();
        fieldProdi_2016 = new JTextField();

        panelInput_2016.add(new JLabel("Nama Mahasiswa :"));
        panelInput_2016.add(fieldNama_2016);
        panelInput_2016.add(new JLabel("NIM :"));
        panelInput_2016.add(fieldNim_2016);
        panelInput_2016.add(new JLabel("Program Studi :"));
        panelInput_2016.add(fieldProdi_2016);

        // Tombol tambah & hapus
        JPanel panelTombolInput_2016 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnTambah_2016 = new JButton("Tambah Data");
        btnHapus_2016  = new JButton("Hapus Data Terakhir");
        panelTombolInput_2016.add(btnTambah_2016);
        panelTombolInput_2016.add(btnHapus_2016);
        panelInput_2016.add(panelTombolInput_2016);

        // ===== PANEL TENGAH (CENTER) =====
        JPanel panelTengah_2016 = new JPanel(new GridLayout(1, 2, 10, 0));

        // Tabel data mahasiswa
        areaTabelData_2016 = new JTextArea();
        areaTabelData_2016.setEditable(false);
        areaTabelData_2016.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollTabel_2016 = new JScrollPane(areaTabelData_2016);
        scrollTabel_2016.setBorder(BorderFactory.createTitledBorder("Data Mahasiswa"));

        // Area hasil sorting
        areaHasil_2016 = new JTextArea();
        areaHasil_2016.setEditable(false);
        areaHasil_2016.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollHasil_2016 = new JScrollPane(areaHasil_2016);
        scrollHasil_2016.setBorder(BorderFactory.createTitledBorder("Visualisasi & Hasil Sorting"));

        panelTengah_2016.add(scrollTabel_2016);
        panelTengah_2016.add(scrollHasil_2016);

        // ===== PANEL KONTROL (SOUTH) =====
        JPanel panelKontrol_2016 = new JPanel(new FlowLayout());
        panelKontrol_2016.setBorder(BorderFactory.createTitledBorder("Pilih & Jalankan Sorting"));

        String[] algoritma_2016 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        comboAlgoritma_2016 = new JComboBox<>(algoritma_2016);
        btnSorting_2016 = new JButton("Mulai Sorting");
        btnReset_2016   = new JButton("Reset");

        panelKontrol_2016.add(new JLabel("Algoritma : "));
        panelKontrol_2016.add(comboAlgoritma_2016);
        panelKontrol_2016.add(btnSorting_2016);
        panelKontrol_2016.add(btnReset_2016);

        // ===== TAMBAHKAN KE FRAME =====
        add(panelInput_2016, BorderLayout.NORTH);
        add(panelTengah_2016, BorderLayout.CENTER);
        add(panelKontrol_2016, BorderLayout.SOUTH);

        // ===== EVENT LISTENER =====
        btnTambah_2016.addActionListener(e -> tambahData_2016());
        btnHapus_2016.addActionListener(e -> hapusData_2016());
        btnSorting_2016.addActionListener(e -> jalankanSorting_2016());
        btnReset_2016.addActionListener(e -> reset_2016());
    }

    // ===== TAMBAH DATA =====
    private void tambahData_2016() {
        String nama_2016  = fieldNama_2016.getText().trim();
        String nim_2016   = fieldNim_2016.getText().trim();
        String prodi_2016 = fieldProdi_2016.getText().trim();

        if (nama_2016.isEmpty() || nim_2016.isEmpty() || prodi_2016.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dataMahasiswa_2016.add(new Mahasiswa_2511532016(nama_2016, nim_2016, prodi_2016));
        fieldNama_2016.setText("");
        fieldNim_2016.setText("");
        fieldProdi_2016.setText("");
        tampilkanTabel_2016();
    }

    // ===== HAPUS DATA TERAKHIR =====
    private void hapusData_2016() {
        if (dataMahasiswa_2016.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data kosong!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dataMahasiswa_2016.remove(dataMahasiswa_2016.size() - 1);
        tampilkanTabel_2016();
    }

    // ===== TAMPILKAN TABEL DATA =====
    private void tampilkanTabel_2016() {
        StringBuilder sb_2016 = new StringBuilder();
        sb_2016.append(String.format("%-5s %-20s %-15s %-20s%n", "No", "Nama", "NIM", "Prodi"));
        sb_2016.append("-".repeat(62)).append("\n");
        for (int i_2016 = 0; i_2016 < dataMahasiswa_2016.size(); i_2016++) {
            Mahasiswa_2511532016 mhs = dataMahasiswa_2016.get(i_2016);
            sb_2016.append(String.format("%-5d %-20s %-15s %-20s%n",
                i_2016 + 1,
                mhs.getNama_2016(),
                mhs.getNim_2016(),
                mhs.getProdi_2016()));
        }
        areaTabelData_2016.setText(sb_2016.toString());
    }

    // ===== JALANKAN SORTING =====
    private void jalankanSorting_2016() {
        if (dataMahasiswa_2016.size() < 2) {
            JOptionPane.showMessageDialog(this, "Minimal 2 data mahasiswa!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Salin data agar data asli tidak berubah
        ArrayList<Mahasiswa_2511532016> dataSorting_2016 = new ArrayList<>();
        for (Mahasiswa_2511532016 mhs : dataMahasiswa_2016) {
            dataSorting_2016.add(new Mahasiswa_2511532016(mhs.getNama_2016(), mhs.getNim_2016(), mhs.getProdi_2016()));
        }

        String pilihan_2016 = (String) comboAlgoritma_2016.getSelectedItem();
        StringBuilder log_2016 = new StringBuilder();

        // Jalankan algoritma sesuai pilihan
        if (pilihan_2016.equals("Insertion Sort")) {
            insertionSort_2016(dataSorting_2016, log_2016);
        } else if (pilihan_2016.equals("Selection Sort")) {
            selectionSort_2016(dataSorting_2016, log_2016);
        } else {
            bubbleSort_2016(dataSorting_2016, log_2016);
        }

        // Tampilkan hasil akhir
        log_2016.append("\n=== HASIL AKHIR (A-Z) ===\n");
        for (int i_2016 = 0; i_2016 < dataSorting_2016.size(); i_2016++) {
            log_2016.append((i_2016 + 1) + ". " + dataSorting_2016.get(i_2016).getNama_2016() + "\n");
        }

        areaHasil_2016.setText(log_2016.toString());
    }

    // ===== INSERTION SORT =====
    private void insertionSort_2016(ArrayList<Mahasiswa_2511532016> data_2016, StringBuilder log_2016) {
        log_2016.append("=== INSERTION SORT ===\n\n");
        int n_2016 = data_2016.size();

        for (int i_2016 = 1; i_2016 < n_2016; i_2016++) {
            // Simpan elemen yang akan disisipkan
            Mahasiswa_2511532016 key_2016 = data_2016.get(i_2016);
            int j_2016 = i_2016 - 1;

            // Geser elemen yang lebih besar ke kanan
            while (j_2016 >= 0 && data_2016.get(j_2016).getNama_2016().compareToIgnoreCase(key_2016.getNama_2016()) > 0) {
                data_2016.set(j_2016 + 1, data_2016.get(j_2016));
                j_2016--;
            }
            // Sisipkan key ke posisi yang tepat
            data_2016.set(j_2016 + 1, key_2016);

            // Log langkah
            log_2016.append("Langkah " + i_2016 + " : " + getNamaList_2016(data_2016) + "\n");
        }
    }

    // ===== SELECTION SORT =====
    private void selectionSort_2016(ArrayList<Mahasiswa_2511532016> data_2016, StringBuilder log_2016) {
        log_2016.append("=== SELECTION SORT ===\n\n");
        int n_2016 = data_2016.size();

        for (int i_2016 = 0; i_2016 < n_2016; i_2016++) {
            // Cari indeks elemen terkecil dari bagian yang belum terurut
            int minIndex_2016 = i_2016;
            for (int j_2016 = i_2016 + 1; j_2016 < n_2016; j_2016++) {
                if (data_2016.get(j_2016).getNama_2016().compareToIgnoreCase(data_2016.get(minIndex_2016).getNama_2016()) < 0) {
                    minIndex_2016 = j_2016;
                }
            }
            // Tukar elemen terkecil ke posisi i
            Mahasiswa_2511532016 temp_2016 = data_2016.get(i_2016);
            data_2016.set(i_2016, data_2016.get(minIndex_2016));
            data_2016.set(minIndex_2016, temp_2016);

            // Log pass
            log_2016.append("Pass " + (i_2016 + 1) + " : " + getNamaList_2016(data_2016) + "\n");
        }
    }

    // ===== BUBBLE SORT =====
    private void bubbleSort_2016(ArrayList<Mahasiswa_2511532016> data_2016, StringBuilder log_2016) {
        log_2016.append("=== BUBBLE SORT ===\n\n");
        int n_2016 = data_2016.size();

        for (int i_2016 = 0; i_2016 < n_2016; i_2016++) {
            for (int j_2016 = 0; j_2016 < n_2016 - i_2016 - 1; j_2016++) {
                // Bandingkan dua elemen berdekatan
                if (data_2016.get(j_2016).getNama_2016().compareToIgnoreCase(data_2016.get(j_2016 + 1).getNama_2016()) > 0) {
                    // Tukar jika urutan salah
                    Mahasiswa_2511532016 temp_2016 = data_2016.get(j_2016);
                    data_2016.set(j_2016, data_2016.get(j_2016 + 1));
                    data_2016.set(j_2016 + 1, temp_2016);
                }
            }
            // Log pass
            log_2016.append("Pass " + (i_2016 + 1) + " : " + getNamaList_2016(data_2016) + "\n");
        }
    }

    // ===== HELPER: ambil list nama dari ArrayList =====
    private String getNamaList_2016(ArrayList<Mahasiswa_2511532016> data_2016) {
        StringBuilder sb_2016 = new StringBuilder("[");
        for (int i_2016 = 0; i_2016 < data_2016.size(); i_2016++) {
            sb_2016.append(data_2016.get(i_2016).getNama_2016());
            if (i_2016 < data_2016.size() - 1) sb_2016.append(", ");
        }
        sb_2016.append("]");
        return sb_2016.toString();
    }

    // ===== RESET =====
    private void reset_2016() {
        dataMahasiswa_2016.clear();
        areaTabelData_2016.setText("");
        areaHasil_2016.setText("");
        fieldNama_2016.setText("");
        fieldNim_2016.setText("");
        fieldProdi_2016.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mahasiswa_GUI2511532016 gui_2016 = new Mahasiswa_GUI2511532016();
            gui_2016.setVisible(true);
        });
    }
}