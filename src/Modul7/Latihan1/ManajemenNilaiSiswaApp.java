package Modul7.Latihan1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private JTabbedPane tabbedPane;
    private DefaultTableModel tableModel;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });



    }


    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));


        // komponen nama
        panel.add(new JLabel("Nama Siswa"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // komponen Mata Pelajaran ( Combo Boxs)
        panel.add(new JLabel("Mata Pelajaran : "));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia", "ALgoritma dan Pemrograman 1", "Praktikum Pemrograman 2"};
        cmbMatkul= new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // komponen Nilai
        panel.add(new JLabel("Nilai (0 - 100 ) : "));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tugas 4 Menambahkan Tombol Reset
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);

        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
//        panel.add(new JLabel(""));
        panel.add(btnSimpan);

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel;
    }


    // Method untuk membuat desain tab Tabel
    private JPanel createTablePanel () {
        JPanel panel = new JPanel(new BorderLayout());
        // Panel tombol hapus
        JButton btnHapus = new JButton("Hapus Data");

        // setup Model tabel (Kolom)
       String[] kolom = {"Nama Siswa", "mata pelajaran", "nilai", "grade"};
       tableModel = new DefaultTableModel(kolom, 0);
       tableData = new JTable(tableModel);

        // Tugas 2 menambahkan button hapus
        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Panel khusus tombol
        JPanel panelButton = new JPanel();
       // memngbungkus tabel dengan ScrollPane (agar bisa discroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        panelButton.add(btnHapus);
        panel.add(panelButton, BorderLayout.SOUTH);

        return panel;
    }


    // Logika Validasi dan Penyimpanan data
    private void prosesSimpan(){
        // 1. ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2, VALIDASI INPUT
        // Validasi 1: Cek apakah nama kosong
        if(nama.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;  // hentikan proses
        }

        // Tugas 3 Validasi nama minimal 3 karakter
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // validasi 2: cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100){
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!", "Error validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // 3. Logika Bisnis (Menentukan Grade)
//        String grade;
//        if(nilai >= 80) grade = "A";
//        else if (nilai >= 70) grade = "AB";
//        else if (nilai >= 60) grade = "B";
//        else if (nilai >= 50) grade = "BC";
//        else if (nilai >= 40) grade = "C";
//        else if (nilai >= 30) grade = "D";
//        else grade = "E";


        // Tugas Soal 1
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }



        // 4. Masukkan ke Table ( Update Model )
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan Pindah Tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1);  // Otomatis pidan ke tab tabel

    }



    // kontruktur
    public ManajemenNilaiSiswaApp() {
        // 1. Konfigurasi Frame Utama
        setTitle("Aplikasi Namanjeme Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Posisi di tengah Layar

        // 2. Inisialisasi Tabbed Pane
        tabbedPane = new JTabbedPane();

        // 3. Membuat panel untuk tab 1 (FORM Input)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput );

        // 4. Membuat Panel untuk Tab 2 (Tabel Data)
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        // Menambahkan TabbedPane ke Frame
        add(tabbedPane);

    }

}
