package Modul6;

import javax.swing.*;
import java.awt.*;

public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. buat frame
            JFrame frame = new JFrame("Konversi Suhu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            // 2. buat panel menggunaka grid colm 2, baris 3
            JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // menambahkan padding sekitar panelnya

            // 3. buat component"nya
            JLabel celciusLabel = new JLabel("Celcius:");
            JTextField celciusInput = new JTextField();
            JButton konversiButton = new JButton("Konversi");
            JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
            JLabel hasilLabel = new JLabel("");

            // 4. Tambahkan komponen"nya ke dalam panel
            // nantinya di tampilan GUInya berurutan berdasarkan komponent pertama yang dimasukkan ke panel. 2 colm, 3 baris
            panel.add(celciusLabel);
            panel.add(celciusInput);
            panel.add(new JLabel());  // label kosong biar nanti ada spasi dan tampilanya bagus
            panel.add(konversiButton);
            panel.add(fahrenheitLabel);
            panel.add(hasilLabel);

            // 5. tambah action listener ke si buttonya konvertnya dan handle ketika si user memasukan text
            konversiButton.addActionListener(e -> {
                try {
                    double celcius = Double.parseDouble(celciusInput.getText());  // mengambil text yang dimasukan user ke dalam komponen JTextFiled, lalu ubah tipe datanya yang awalnya string ke double
                    double fahrenheit = (celcius * 9/5) + 32;
                    hasilLabel.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {   // handle~tangkap error NumberFormatException jika user memasukan string "abc", karna string "abc" tidak bisa diubah ke integer
                    JOptionPane.showMessageDialog(frame,   // menampilkan alert
                            "Masukkan angka yang valid!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    celciusInput.setText("");
                    hasilLabel.setText("");
                }
            });

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
