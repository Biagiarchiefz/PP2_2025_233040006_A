package Modul05;

import javax.swing.*;
import java.awt.*;

public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);

                // atur layout manager ke borderLayout
                // sebenarnya ini tidak perlu karena BorderLayout merupakann Layout manager default
                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("label ada di atas NORTH");
                JButton button = new JButton("button ada di bawah SOUTH");

                button.addActionListener( e -> {
                    label.setText("Tombol di SOUTH diklik");
                });


                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                frame.add(new JButton("WEST"), BorderLayout.WEST);
                frame.add(new JButton("EAST"), BorderLayout.EAST);
                frame.add(new JButton("CENTER"), BorderLayout.CENTER);

                frame.setVisible(true);

            }
        });
    }
}
