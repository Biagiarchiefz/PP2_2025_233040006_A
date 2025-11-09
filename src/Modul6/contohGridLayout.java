package Modul6;

import javax.swing.*;
import java.awt.*;

public class contohGridLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("Grid Layout");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 400);


                // atur layout frame menjadi grid layout 3 baris, 2 colom, 5px h-ga, 5px v-gap
                frame.setLayout(new GridLayout(3, 2, 5, 5));

                frame.add(new JLabel("Label 1:"));
                frame.add(new JTextField());
                frame.add(new JLabel("Label 2:"));
                frame.add(new JPasswordField());
                frame.add(new JButton("Login"));
                frame.add(new JButton("Batal"));


                frame.setVisible(true);
            }
        });
    }
}
