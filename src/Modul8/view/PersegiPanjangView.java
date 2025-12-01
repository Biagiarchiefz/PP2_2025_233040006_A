package Modul8.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung Luas");

    // konstruktor
    public PersegiPanjangView() {
        // inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(4,2 ,10,10)); // Grid 4 baris
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas"));
        this.add(lblHasil);
        this.add(new JLabel("")); // Spacer kosong
        this.add(btnHitung);
    }


    // Mengambil nilai panjang dari TextFiled
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }


    // Mengambil nilai dari TextField
    public double  getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil ke label
    public void setHasil(double hasil){
        lblHasil.setText(String.valueOf(hasil));
    }


    // Menampilkan pesan error ( jika input bulan angka )
    public void tampilkanPesanError(String pesan){
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Mendaftarkan Listener untuk tombol ( Control yang akan memberikan aksinya )
    public void  addHitungListener(ActionListener listener){
        btnHitung.addActionListener(listener);
    }


}
