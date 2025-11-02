package Modul05;

import javax.swing.*;
import java.awt.*;

public class Latihan3 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Label dan tombol");

                frame.setSize(400, 300);

                // mengatur layour manager
                // FlowLayout akan menyusun componen dari kiri ke kanan
                frame.setLayout(new FlowLayout());

                // membuat component GUI
                JLabel label = new JLabel("text awal");
                JButton button = new JButton("klik saya");

                // menambahkan aksi ( ActionListener ) ke tombol,
                // penambahan ini menggunakna lambda untuk mempersingkat penggunaan anonymous inner class

                button.addActionListener( e -> {
                    label.setText("tombol berhasil ditekan");
                });

                // menambahkan label dan button ke frame
                // karena menggunakan flowlayout keduanya akan tampil berdampingan seperti flex kalau di css
                frame.add(label);
                frame.add(button);

                frame.setVisible(true);
            }
        });
    }
}
