package Modul10.model;

import Modul10.config.KoneksiDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MahasiswaModel {

    public ResultSet getAll() throws Exception {
        Connection conn = KoneksiDB.configDB();
        Statement stm = conn.createStatement();
        return stm.executeQuery("SELECT * FROM mahasiswa");
    }

    public ResultSet cariNama(String keyword) throws Exception {
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        return pst.executeQuery();
    }

    public boolean cekNIM(String nim) throws Exception {
        String sql = "SELECT nim FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

    public void insert(String nama, String nim, String jurusan) throws Exception {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nim);
        pst.setString(3, jurusan);
        pst.execute();
    }

    public void update(String nama, String jurusan, String nim) throws Exception {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jurusan);
        pst.setString(3, nim);
        pst.executeUpdate();
    }

    public void delete(String nim) throws Exception {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.execute();
    }
}