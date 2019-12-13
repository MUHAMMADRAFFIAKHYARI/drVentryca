package android.example.drventryca.Model;

import java.io.Serializable;

public class Data implements Serializable {
    String namaDepan;
    String namaBelakang;
    String golonganDarah;
    String massaBadan;
    String tinggiBadan;
    String gender;
    String usia;

    public Data(String namaDepan, String namaBelakang, String massaBadan, String tinggiBadan, String usia, String gender, String golonganDarah) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.massaBadan = massaBadan;
        this.tinggiBadan = tinggiBadan;
        this.gender = gender;
        this.usia = usia;
        this.golonganDarah = golonganDarah;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
