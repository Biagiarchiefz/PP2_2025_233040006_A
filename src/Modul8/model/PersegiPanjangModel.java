package Modul8.model;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;



    // Menghitung Luas ( logika bisnis )
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }


    // Getter dan setterr
    public void setPanjang(double panjang){
        this.panjang = panjang;
    }

    public void setLebar(double lebar){
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }


}
