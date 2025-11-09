package Modul6;

import javax.swing.*;
import java.awt.*;

public class ContohBorderLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // JFrame sudah menggunakan BorderLayout secara default

        // 2. Buat dan tambahkan komponen ke 5 wilayah
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
