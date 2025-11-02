package Modul05;

import javax.swing.*;
import java.awt.*;

public class Tugas {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Tugas Modul 5");
                frame.setSize(400, 300);
                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("label di atas NORTH");
                JButton button = new JButton("button di bawah SOUTH ");
                JButton button2 = new JButton("button di bawah WEST");
                JButton button3 = new JButton("button di bawah EASH");
                JButton button4 = new JButton("button di bawah CENTER");



                button.addActionListener( e -> {
                    label.setText("tombol south di klik");
                });

                button2.addActionListener( e -> {
                    label.setText("tombol west di klik");
                });

                button3.addActionListener( e -> {
                    label.setText("tombol eash di klik");
                });

                button4.addActionListener( e -> {
                    label.setText("tombol center di klik");
                });


                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                frame.add(button2, BorderLayout.WEST);
                frame.add(button3, BorderLayout.EAST);
                frame.add(button4, BorderLayout.CENTER);
                frame.setVisible(true);

            }
        });
    }
}
