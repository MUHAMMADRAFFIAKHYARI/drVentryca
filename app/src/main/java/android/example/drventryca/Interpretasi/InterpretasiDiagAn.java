package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.Model.DiseaseModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagAn {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;
    private DiseaseModel diseaseModel;

    public int hitungP1 = 1;
    public int hitungP2 = 1;
    public int hitungP3 = 1;
    public int hitungP4 = 1;
    public int hitungP5 = 1;



    public InterpretasiDiagAn(ArrayList<QuestionModel> questionModels){
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
                    questionModels.get(10).isAnswer() == true
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
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Penyakit Gatal Anus");
                setDiagnosis("Gatal Anus");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == true &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Strikus Fissura Anus");
                setDiagnosis("Fissura Anus");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == true &&
                    questionModels.get(9).isAnswer() == true &&
                    questionModels.get(10).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Hemoroid");
                setDiagnosis("Hemoroid");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Pilonidal");
                setDiagnosis("Pilonidal");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false &&
                    questionModels.get(10).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Abses Anorektal");
                setDiagnosis("Abses Anorektal");
            }

            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }
        }*/

        if (questionModels.get(0).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP1 += 1;
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
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP4 += 1;
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(6).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(7).isAnswer() == true) {
            hitungP5 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(8).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(9).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
            Log.d("hitung p5", String.valueOf(hitungP5));
        }

        if (questionModels.get(10).isAnswer() == true) {
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
            setDiagnosis("Gatal Anus\n\n Anda memenuhi " + hitungP1 + " dari 3 gejala yang ada");
        } else if (hitungP2 > hitungP1 && hitungP2 > hitungP3 && hitungP2 > hitungP4 && hitungP2 > hitungP5) {
            setDiagnosis("Fissura Anus\n\n Anda memenuhi " + hitungP2 + " dari 5 gejala yang ada");
        } else if (hitungP3 > hitungP1 && hitungP3 > hitungP2 && hitungP3 > hitungP4 && hitungP3 > hitungP5) {
            setDiagnosis("Hemoroid\n\n Anda memenuhi " + hitungP3 + " dari 5 gejala yang ada");
        } else if (hitungP4 > hitungP1 && hitungP4 > hitungP2 && hitungP4 > hitungP3 && hitungP4 > hitungP5) {
            setDiagnosis("Pilonidal\n\n Anda memenuhi " + hitungP4 + " dari 4 gejala yang ada");
        } else if (hitungP5 > hitungP1 && hitungP5 > hitungP2 && hitungP5 > hitungP5 && hitungP5 > hitungP1) {
            setDiagnosis("Abses Anorektal\n\n Anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP1 == hitungP2 && hitungP1!=1) {
            setDiagnosis("Gatal Anus, anda memenuhi " + hitungP1 + " dari 3 gejala yang ada \n" +
                    "Fissura Anus, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada");
        }
        else if (hitungP1 == hitungP3 && hitungP1!=1) {
            setDiagnosis("Gatal Anus " + hitungP1 + " dari 3 gejala yang ada \n" +
                    "Hemoroid, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada");
        }

        else if (hitungP1 == hitungP4 && hitungP1!=1) {
            setDiagnosis("Gatal Anus, anda memenuhi " + hitungP1 + " dari 3 gejala yang ada \n" +
                    "Pilonidal, anda memenuhi " + hitungP4 + " dari 4 gejala yang ada");
        }

        else if (hitungP1 == hitungP5 && hitungP1!=1) {
            setDiagnosis("Gatal Anus, anda memenuhi " + hitungP1 + " dari 3 gejala yang ada \n" +
                    "Abses Anorektal, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP2 == hitungP3 && hitungP2!=1) {
            setDiagnosis("Fissura Anus, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada \n" +
                    "Hemoroid, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada");
        }

        else if (hitungP2 == hitungP4 && hitungP2!=1) {
            setDiagnosis("Fissura Anus, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada \n" +
                    "Pilonidal, anda memenuhi " + hitungP4 + " dari 4 gejala yang ada");
        }

        else if (hitungP2 == hitungP5 && hitungP2!=1) {
            setDiagnosis("Fissura Anus, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada \n" +
                    "Abses Anorektal, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else if (hitungP3 == hitungP4 && hitungP3!=1) {
            setDiagnosis("Hemoroid, anda memenuhi " + hitungP3 + " dari 5 gejala yang ada \n" +
                    "Pilonidal, anda memenuhi " + hitungP4 + " dari 4 gejala yang ada");
        }

        else if (hitungP4 == hitungP5 && hitungP4!=1) {
            setDiagnosis("Pilonidal, anda memenuhi " + hitungP4 + " dari 4 gejala yang ada \n" +
                    "Abses Anorektal, anda memenuhi " + hitungP5 + " dari 4 gejala yang ada");
        }

        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }

    };
}
