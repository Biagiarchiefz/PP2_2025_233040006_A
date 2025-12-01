package Modul8.controller;

import Modul8.model.PersegiPanjangModel;
import Modul8.view.PersegiPanjangView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    // Model dan view sebagai atribute kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view){
        this.model = model;
        this.view = view;


        // Menghubungkan tombol di view dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
    }


    class HitungListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil dara dari view
                double p = view.getPanjang();
                double l = view.getLebar();


                // 2. Kirim data ke model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Jalankan logika bisnis di model
                model.hitungLuas();

                // 4. Ambil hasil dari model dan tampilkan
                double hasil = model.getLuas();
                view.setHasil(hasil);

            } catch (NumberFormatException ex){
                // Handle jika use memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid");
            }
        }
    }


}
