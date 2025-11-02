package Modul05;

import javax.swing.*;

public class Latihan2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("jendela dengan label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // membuat components JLabel
                JLabel label = new JLabel("ini adalah JLabel");

                // menambahkan JLabel ke JFrame
                // Secara default, JFrame menggunakna borderlayout dan .add() akan menambahkan ke bagian tengah (CENTER) secara vertikal
                frame.add(label);

                frame.setVisible(true);


            }
        });
    }
}
