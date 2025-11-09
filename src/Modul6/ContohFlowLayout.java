package Modul6;

import javax.swing.*;

//Tanpa JPanel: Semua komponen langsung ditambahkan ke JFrame, sehingga tata letak terbatas pada layout manager JFrame.
//Dengan JPanel: Komponen dikelompokkan dalam JPanel, memungkinkan penggunaan layout manager tambahan dan struktur yang lebih modular.

public class ContohFlowLayout {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // 2. Membuat panel ( Container )
        // Jpanel secara default sudah menggunakan FlowLayout
        JPanel panel = new JPanel();

        // 3. Buat dan tambahkan komponen
        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol empat panjang"));
        panel.add(new JButton("Tombol 5"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
