package Modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // 1. Buat Komponen ( Event Source )
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));

        // 2. Buat event Listener ( Menggunakan MouseAdapter )
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // saat mouse masuk, ubah warna jadi biru
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // saat mouse keluar, kembalikan warna
                panel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // saat diklik, tampilkan koordinat klik
                System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
            }
        };


        // 3.Daftarkan listener ke source
        panel.addMouseListener(adapter);
        frame.add(panel);
        frame.setVisible(true);

    }


}
