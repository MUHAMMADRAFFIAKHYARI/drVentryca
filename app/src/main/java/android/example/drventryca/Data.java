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

    //    public Data(String toString1, String s1, String string, String toString, String s) {
//    }
    public Data(String namaD, String namaB, String mB, String tB, String umur) {
        namaDepan = namaD;
        namaBelakang = namaB;
        massaBadan = mB;
        tinggiBadan = tB;
        usia = umur;
    }

    public Data(String namaDepan, String namaBelakang, String golonganDarah, String massaBadan, String tinggiBadan, String gender, String usia) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.golonganDarah = golonganDarah;
        this.massaBadan = massaBadan;
        this.tinggiBadan = tinggiBadan;
        this.gender = gender;
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

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    @Override
    public String toString() {
        return "Data{" +
                ",1. Nama Depan='" + namaDepan + '\'' +
                ",2. Nama Belakang='" + namaBelakang + '\'' +
                ",3. Golongan Darah='" + golonganDarah + '\'' +
                ",4. Massa Badan='" + massaBadan + '\'' +
                ",5. Tinggi Badan='" + tinggiBadan + '\'' +
                ",6. gender='" + gender + '\'' +
                ",7. usia='" + usia + '\'' +
                '}';
    }
}
