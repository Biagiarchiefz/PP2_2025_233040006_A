import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Latihan1 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Jendela Pertamaku");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 400);

                JLabel label = new JLabel("label ada di atas/north");
                JButton button = new JButton("tombol ada di bawah/south");
                frame.setLayout(new BorderLayout());

                button.addActionListener(e -> {
                    label.setText("Tombol sudah di klik");
                });

                frame.add(button, BorderLayout.SOUTH);
                frame.add(label, BorderLayout.NORTH);
                frame.setVisible(true);

            }
        });
    }
}
