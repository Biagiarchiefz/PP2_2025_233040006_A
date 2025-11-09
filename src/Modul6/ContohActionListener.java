package Modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContohActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // 1. Buat komponen ( EVENT source dan komponen lain )
        JLabel label = new JLabel("Halo, Klik tombol di bawah");
        JButton button = new JButton("Klik saya");

        // 2. Buat event listener menggunakan anonymous inner class disini
        // Ini cara lama (sebelum Java 8) untuk membuat objek dari interface (ActionListener).
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 3. logika yang dieksekusi saat event terjadi
                label.setText("Tombol telah diklik");
            }
        };

        // 4. Daftarkan listener ke source
        button.addActionListener(listener);

        // Tambahkan komponen ke frame
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);


    }


}
