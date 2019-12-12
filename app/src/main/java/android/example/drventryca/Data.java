package android.example.drventryca;

import java.io.Serializable;

public class Data implements Serializable {
    String namaDepan;
    String namaBelakang;
    String golonganDarah;
    String massaBadan;
    String tinggiBadan;
    String gender;
    String usia;

    public Data(String namaDepan, String namaBelakang, String massaBadan, String tinggiBadan, String usia) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.massaBadan = massaBadan;
        this.tinggiBadan = tinggiBadan;
        this.usia = usia;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getMassaBadan() {
        return massaBadan;
    }

    public void setMassaBadan(String massaBadan) {
        this.massaBadan = massaBadan;
    }

    public String getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(String tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }
}
