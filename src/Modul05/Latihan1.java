package Modul05;

import javax.swing.*;

public class Latihan1 {
    public static void main(String[] args) {

        // SwingUtilities.invokeLater() dijalankan di thread Event Dispatch Thread itu pekerja khusus bagian UI.
        // GUI bisa Freeze atau event delay langsung menulis kode program GUI dimain
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // membuat object Hframe
                // default dari layout JFrame adalah BorderLayout
                JFrame frame = new JFrame("Jendela pertamaku");

                // atur ukuran jendela ( lebar 400, tinggi 300 )
                frame.setSize(400, 300);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // membuat jendelanya terlihat
                frame.setVisible(true);
            }
        });
    }
}
