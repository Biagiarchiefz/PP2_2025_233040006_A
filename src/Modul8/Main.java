package Modul8;

import Modul8.controller.PersegiPanjangController;
import Modul8.model.PersegiPanjangModel;
import Modul8.view.PersegiPanjangView;

public class Main {
    public static void main(String[] args) {
        // 1. Instansiasi model
        PersegiPanjangModel model = new PersegiPanjangModel();

        // 2. Instansiasi View
        PersegiPanjangView view = new PersegiPanjangView();

        // 3. Instansiasi Controller ( Hubungkan Model & view )
        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        // 4. Tampilkan View
        view.setVisible(true);
    }
}
