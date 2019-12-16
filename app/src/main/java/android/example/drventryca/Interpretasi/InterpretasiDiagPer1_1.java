package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.Model.DiseaseModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagPer1_1 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;
    private DiseaseModel diseaseModel;

    private int hitungP1 = 3;
    private int hitungP2 = 3;
    private int hitungP3 = 3;
    private int hitungP4 = 3;
    private int hitungP5 = 3;
    private int hitungP6 = 3;


    public InterpretasiDiagPer1_1(ArrayList<QuestionModel> questionModels){
        this.questionModels = questionModels;
    }

    public ArrayList<QuestionModel> getQuestionModels(){
        return questionModels;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void spk()
    {
        position = questionModels.size();


        /*for (int i = 0; i < position; i++) {

            if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == true &&
                    questionModels.get(9).isAnswer() == true &&
                    questionModels.get(10).isAnswer() == true &&
                    questionModels.get(11).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == true &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Penyakit Kolesitesis");
                setDiagnosis("Kolesitesis");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == true &&
                    questionModels.get(10).isAnswer() == true &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Gastritis Kronik");
                setDiagnosis("Gastritis Kronik");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == true &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Gastritis Akut Erosif");
                setDiagnosis("Gastritis Akut Erosif");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Leiomiosarkoma Gaster");
                setDiagnosis("Leiomiosarkoma Gaster");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Refluk Empedu");
                setDiagnosis("Jika anda seorang perokok aktif ataupun pecandu alkohol," +
                        "kemungkinan besar anda terkena Refluk Empedu");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Ulkus Gastikum");
                setDiagnosis("Ulkus Gastikum");
            }

            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }*/
        if (questionModels.get(0).isAnswer() == true) {
            hitungP1 += 1;
            hitungP2 += 1;
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(2).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP6 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(6).isAnswer() == true) {
            hitungP6 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(7).isAnswer() == true) {
            hitungP6 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(8).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(9).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(10).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        if (questionModels.get(11).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
            Log.d("hitung p6", String.valueOf(hitungP6));
        }

        else {
            setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
        }

        Log.d("hitung p1 akhir", String.valueOf(hitungP1));
        Log.d("hitung p2 akhir", String.valueOf(hitungP2));
        Log.d("hitung p3 akhir", String.valueOf(hitungP3));
        Log.d("hitung p4 akhir", String.valueOf(hitungP4));
        Log.d("hitung p5 akhir", String.valueOf(hitungP5));
        Log.d("hitung p6 akhir", String.valueOf(hitungP6));

        if (hitungP1 > hitungP2 && hitungP1 > hitungP3 && hitungP1 > hitungP4 && hitungP1 > hitungP5 && hitungP1 > hitungP6) {
            setDiagnosis("Kolesitesis\n\n Anda memenuhi " + hitungP1 + " dari 6 gejala yang ada");
        } else if (hitungP2 > hitungP1 && hitungP2 > hitungP3 && hitungP2 > hitungP4 && hitungP2 > hitungP5 && hitungP2 > hitungP6) {
            setDiagnosis("Gastritis Kronik\n\n Anda memenuhi " + hitungP2 + " dari 6 gejala yang ada");
        } else if (hitungP3 > hitungP1 && hitungP3 > hitungP2 && hitungP3 > hitungP4 && hitungP3 > hitungP5 && hitungP3 > hitungP6) {
            setDiagnosis("Gastritis Akut Erosif\n\n Anda memenuhi " + hitungP3 + " dari 5 gejala yang ada " +
                    "(Pecandu Alkohol kemnugkinan terjangkit penyakit ini lebih besar");
        } else if (hitungP4 > hitungP1 && hitungP4 > hitungP2 && hitungP4 > hitungP3 && hitungP4 > hitungP5 && hitungP4 > hitungP6) {
            setDiagnosis("Leiomiosarkoma Gaster\n\n Anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        } else if (hitungP5 > hitungP1 && hitungP5 > hitungP2 && hitungP5 > hitungP3 && hitungP5 > hitungP4 && hitungP5 > hitungP6) {
            setDiagnosis("Refluk Empedu\n\n Anda memenuhi " + hitungP5 + " dari 4 gejala yang ada " +
                    "(Perokok Aktif ataupun Pecandu Alkohol kemungkinan terjangkit lebih besar)");
        } else if (hitungP6 > hitungP1 && hitungP6 > hitungP2 && hitungP6 > hitungP3 && hitungP6 > hitungP4 && hitungP6 > hitungP5) {
            setDiagnosis("Ulkus Gastikum\n\n Anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else if (hitungP1 == hitungP2 && hitungP1!=3) {
            setDiagnosis("Kolesitesis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Gastritis Kronik, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada");
        }
        else if (hitungP1 == hitungP3 && hitungP1!=3) {
            setDiagnosis("Kolesitesis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Gastritis Akut Erosif, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada");
        }

        else if (hitungP1 == hitungP4 && hitungP1!=3) {
            setDiagnosis("Kolesitesis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Leiomiosarkoma Gaster, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else if (hitungP1 == hitungP5 && hitungP1!=3) {
            setDiagnosis("Kolesitesis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Refluk Empedu, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP1 == hitungP6 && hitungP1!=3) {
            setDiagnosis("Kolesitesis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Ulkus Gastikum, anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else if (hitungP2 == hitungP3 && hitungP2!=3) {
            setDiagnosis("Gastritis Kronik, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "Gastritis Akut Erosif, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada");
        }

        else if (hitungP2 == hitungP4 && hitungP2!=3) {
            setDiagnosis("Gastritis Kronik, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "Leiomiosarkoma Gaster, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else if (hitungP2 == hitungP5 && hitungP2!=3) {
            setDiagnosis("Gastritis Kronik, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "Refluk Empedu, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP2 == hitungP6 && hitungP2!=3) {
            setDiagnosis("Gastritis Kronik, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "Ulkus Gastikum, anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else if (hitungP3 == hitungP4 && hitungP3!=3) {
            setDiagnosis("Gastritis Akut Erosif, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada \n" +
                    "Leiomiosarkoma Gaster, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else if (hitungP3 == hitungP5 && hitungP3!=3) {
            setDiagnosis("Gastritis Akut Erosif, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada \n" +
                    "Refluk Empedu, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP3 == hitungP6 && hitungP3!=3) {
            setDiagnosis("Gastritis Akut Erosif, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada \n" +
                    "Ulkus Gastikum, anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else if (hitungP4 == hitungP5 && hitungP4!=3) {
            setDiagnosis("Leiomiosarkoma Gaster, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada \n" +
                    "Refluk Empedu, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP4 == hitungP6 && hitungP4!=3) {
            setDiagnosis("Leiomiosarkoma Gaster, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada \n" +
                    "Ulkus Gastikum, anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else if (hitungP5 == hitungP6 && hitungP4!=3) {
            setDiagnosis("Refluk Empedu, anda memenuhi " + hitungP5 + " dari 6 gejala yang ada \n" +
                    "Ulkus Gastikum, anda memenuhi " + hitungP6 + " dari 6 gejala yang ada");
        }

        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }

        }
    }
