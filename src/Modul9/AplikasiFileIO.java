package Modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {


    // komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;


    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();


        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka text");
        btnSaveText = new JButton("Simpan Text");
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");


        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);


        // Layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // ---- EVENT HANDLING ---------

        // 1. Membaca file teks (TEXT STREAM)
        btnOpenText.addActionListener(e -> bukaFileTeks());

        // 2. Menulis file teks (text stream)
        btnSaveBinary.addActionListener(e -> simpanFileTeks());

        // 3. Menulis file binary ( Byte Stream )
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());

        // 4. Membaca file binary ( Byte Stream )
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
    }


    // Contoh: Membaca file text dengan Try-Catch-Finaly konvensional
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null; // Deklarasi diluar try agar bisa diakses di finally

            try {
                // Membuka stream
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");  // Kosong area

                String line;
                // Baca baris demi baris
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file" + ex.getMessage());
            } finally {
                // Blok Finally: Selalu dijalankan untuk menutup resource
                try {
                    if (reader != null) {
                        reader.close();  // PENTING: untuk menuttup stream
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }


    // Contoh: menmulis file teks menggunakan TRY-With-Resource (Lebih modern)
    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Try-With-Resource otomatis menutup stream tanpa blok finally manual
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }

        }

    }


    // Contoh: Menulis Binary ( Menyimpan ukuran font saat ini ke file .bin )
    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            // Kita simpan ukuran font saat ini ( Integer )
            int fontSize = textArea.getFont().getSize();
            dos.write(fontSize);

            JOptionPane.showMessageDialog(this, "Ukuran font (" + fontSize + ") disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan binary: " + ex.getMessage());
        }

    }


    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            // Membaca data integer mentah
            int fontSize = dis.readInt();


            // Terapkan ke aplikasi
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font diubah menjadi ukuran: " + fontSize);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File config.bin belum dibuat!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca binary: " + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }


}
