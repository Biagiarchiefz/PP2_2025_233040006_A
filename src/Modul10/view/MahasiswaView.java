package Modul10.view;

import Modul10.controller.MahasiswaController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MahasiswaView extends JFrame {

    JTextField txtNama, txtNIM, txtJurusan, txtCari;
    JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    JTable tableMahasiswa;
    DefaultTableModel model;

    MahasiswaController controller;

    public MahasiswaView() {
        controller = new MahasiswaController();

        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        JPanel panelTombol = new JPanel();
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);

        JPanel panelCari = new JPanel();
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        panelCari.add(new JLabel("Cari Nama:"));
        panelCari.add(txtCari);
        panelCari.add(btnCari);
        add(panelCari, BorderLayout.SOUTH);

        controller.loadData(model);

        btnSimpan.addActionListener(e -> {
            controller.simpan(
                    txtNama.getText(),
                    txtNIM.getText(),
                    txtJurusan.getText()
            );
            controller.loadData(model);
            clearForm();
        });

        btnEdit.addActionListener(e -> {
            controller.edit(
                    txtNama.getText(),
                    txtJurusan.getText(),
                    txtNIM.getText()
            );
            controller.loadData(model);
            clearForm();
        });

        btnHapus.addActionListener(e -> {
            controller.hapus(txtNIM.getText());
            controller.loadData(model);
            clearForm();
        });

        btnCari.addActionListener(e ->
                controller.cariData(txtCari.getText(), model)
        );

        btnClear.addActionListener(e -> clearForm());

        tableMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNIM.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtJurusan.setText("");
    }


}
