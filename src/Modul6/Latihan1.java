package Modul6;

import javax.swing.*;
import java.awt.*;

public class Latihan1 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Kalkulator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // digunakan untuk mengatur apa yang terjadi ketika user menekan tombol close (x) pada window
                frame.setSize(300, 400);
                frame.setLayout(new BorderLayout(10, 10));

                // menambahkan layar
                JTextField layar = new JTextField();
                frame.add(layar, BorderLayout.NORTH);

                // layarnya menggunakan layout manager BorderLayout
                // sedangkan buttonPanelnua menggunakan layout manager GridLayout


                // buat gridlayout dengan 4
                JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5,5));
                // ini membuat array of string dengan nama variable buttonLabels
                String[] buttonLabels = {
                        "7", "8", "9", "/",
                        "4", "5", "6", "*",
                        "1", "2", "3", "-",
                        "0", ".", "=", "+"
                };

                // kita looping si buttonLabelsnya lalu masing value si arraynya kita simpan ke dalam variabel label
                for (String label : buttonLabels) {
                    JButton button = new JButton(label);
                    buttonPanel.add(button);  // kita masukkan button" yang kita kasi label sesuai dengan buttonLables tadi ke dalam buttonPanel
                }

                frame.add(buttonPanel, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
    }
}
