package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.Model.DiseaseModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagPer3_1 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;
    private DiseaseModel diseaseModel;

    private int hitungP1 = 3;
    private int hitungP2 = 3;
    private int hitungP3 = 3;
    private int hitungP4 = 3;
    private int hitungP5 = 3;


    public InterpretasiDiagPer3_1(ArrayList<QuestionModel> questionModels){
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
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == true &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Penyakit Whipple");
                setDiagnosis("Whipple");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == true &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Traveller's Diarrhea");
                setDiagnosis("Traveller's Diarrhea");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Diarre Akut");
                setDiagnosis("Diarre Akut");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
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
                Log.d("diagnosis", "Diare Kronik");
                setDiagnosis("Diare Kronik");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false &&
                    questionModels.get(11).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Divertikulosis");
                setDiagnosis("Kemungkinan anda terkena penyakit Divertikulosis," +
                        "segera periksakan diri anda ke dokter");
            }

            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }
        }*/

        if (questionModels.get(0).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(2).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(6).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(7).isAnswer() == true) {
            hitungP1 += 1;
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(8).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(9).isAnswer() == true) {
            hitungP2 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(10).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(11).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        else {
            setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
        }

        Log.d("hitung p1 akhir", String.valueOf(hitungP1));
        Log.d("hitung p2 akhir", String.valueOf(hitungP2));
        Log.d("hitung p3 akhir", String.valueOf(hitungP3));
        Log.d("hitung p4 akhir", String.valueOf(hitungP4));
        Log.d("hitung p5 akhir", String.valueOf(hitungP5));

        if (hitungP1 > hitungP2 && hitungP1 > hitungP3 && hitungP1 > hitungP4 && hitungP1 > hitungP5) {
            setDiagnosis("Whipple\n\n Anda memenuhi " + hitungP1 + " dari 8 gejala yang ada");
        } else if (hitungP2 > hitungP1 && hitungP2 > hitungP3 && hitungP2 > hitungP4 && hitungP2 > hitungP5) {
            setDiagnosis("Traveller's Diarrhea\n\n Anda memenuhi " + hitungP2 + " dari 9 gejala yang ada");
        } else if (hitungP3 > hitungP1 && hitungP3 > hitungP2 && hitungP3 > hitungP4 && hitungP3 > hitungP5) {
            setDiagnosis("Diarre Akut\n\n Anda memenuhi " + hitungP3 + " dari 7 gejala yang ada");
        } else if (hitungP4 > hitungP1 && hitungP4 > hitungP2 && hitungP4 > hitungP3 && hitungP4 > hitungP5) {
            setDiagnosis("Diare Kronik\n\n Anda memenuhi " + hitungP4 + " dari 8 gejala yang ada");
        } else if (hitungP5 > hitungP1 && hitungP5 > hitungP2 && hitungP5 > hitungP5 && hitungP5 > hitungP1) {
            setDiagnosis("Divertikulosis\n\n Anda memenuhi " + hitungP5 + " dari 5 gejala yang ada");
        }

        else if (hitungP1 == hitungP2 && hitungP1!=3) {
            setDiagnosis("Whipple, anda memenuhi " + hitungP1 + " dari 8 gejala yang ada \n" +
                    "Traveller's Diarrhea, anda memenuhi " + hitungP2 + " dari 9 gejala yang ada");
        }
        else if (hitungP1 == hitungP3 && hitungP1!=3) {
            setDiagnosis("Whipple, anda memenuhi " + hitungP1 + " dari 8 gejala yang ada \n" +
                    "Diarre Akut, anda memenuhi " + hitungP3 + " dari 7 gejala yang ada");
        }

        else if (hitungP1 == hitungP4 && hitungP1!=3) {
            setDiagnosis("Whipple, anda memenuhi " + hitungP1 + " dari 8 gejala yang ada \n" +
                    "Diarre Kronik, anda memenuhi " + hitungP4 + " dari 8 gejala yang ada");
        }

        else if (hitungP1 == hitungP5 && hitungP1!=3) {
            setDiagnosis("Whipple, anda memenuhi " + hitungP1 + " dari 8 gejala yang ada \n" +
                    "Divertikulosis, anda memenuhi " + hitungP5 + " dari 5 gejala yang ada");
        }

        else if (hitungP2 == hitungP3 && hitungP2!=3) {
            setDiagnosis("Traveller's Diarrhea, anda memenuhi " + hitungP2 + " dari 9 gejala yang ada \n" +
                    "Diarre Akut, anda memenuhi " + hitungP3 + " dari 7 gejala yang ada");
        }

        else if (hitungP2 == hitungP4 && hitungP2!=3) {
            setDiagnosis("Traveller's Diarrhea, anda memenuhi " + hitungP2 + " dari 9 gejala yang ada \n" +
                    "Diarre Kronik, anda memenuhi " + hitungP4 + " dari 8 gejala yang ada");
        }

        else if (hitungP2 == hitungP5 && hitungP2!=3) {
            setDiagnosis("Traveller's Diarrhea, anda memenuhi " + hitungP2 + " dari 9 gejala yang ada \n" +
                    "Divertikulosis, anda memenuhi " + hitungP5 + " dari 5 gejala yang ada");
        }

        else if (hitungP3 == hitungP4 && hitungP3!=3) {
            setDiagnosis("Diarre Akut, anda memenuhi " + hitungP3 + " dari 7 gejala yang ada \n" +
                    "Diarre Kronik, anda memenuhi " + hitungP4 + " dari 8 gejala yang ada");
        }

        else if (hitungP4 == hitungP5 && hitungP4!=3) {
            setDiagnosis("Diarre Kronik, anda memenuhi " + hitungP4 + " dari 8 gejala yang ada \n" +
                    "Divertikulosis, anda memenuhi " + hitungP5 + " dari 5 gejala yang ada");
        }

        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }
    };
}
