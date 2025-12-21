package Modul10.controller;

import Modul10.model.MahasiswaModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class MahasiswaController {

    private MahasiswaModel model;

    public MahasiswaController() {
        model = new MahasiswaModel();
    }

    public void loadData(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        try {
            ResultSet res = model.getAll();
            int no = 1;
            while (res.next()) {
                tableModel.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Data: " + e.getMessage());
        }
    }

    public void cariData(String keyword, DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        try {
            ResultSet res = model.cariNama(keyword);
            int no = 1;
            while (res.next()) {
                tableModel.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Cari Data: " + e.getMessage());
        }
    }

    public void simpan(String nama, String nim, String jurusan) {
        try {
            if (model.cekNIM(nim)) {
                JOptionPane.showMessageDialog(null, "NIM sudah terdaftar!");
                return;
            }
            model.insert(nama, nim, jurusan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
        }
    }

    public void edit(String nama, String jurusan, String nim) {
        try {
            model.update(nama, jurusan, nim);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Edit: " + e.getMessage());
        }
    }

    public void hapus(String nim) {
        try {
            model.delete(nim);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
        }
    }
}

