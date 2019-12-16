package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagTeng2 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;

    private int hitungP1 = 2, hitungP2 = 2, hitungP3 = 2, hitungP4 = 2;

    public InterpretasiDiagTeng2(ArrayList<QuestionModel> questionModels){
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
                    questionModels.get(9).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Penyakit Karsinoma Esofagus");
                setDiagnosis("Karsinoma Esofagus");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == false &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Strikus Hernia Hiatus Esofagus");
                setDiagnosis("Hernia Hiatus Esofagus");
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
                    questionModels.get(9).isAnswer() == false
            )
            {
                Log.d("diagnosis", "GERD (Gastroesofageal\nRefluks\nDisorder)");
                setDiagnosis("Gastroesofageal\nRefluks Disorder");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true &&
                    questionModels.get(8).isAnswer() == false &&
                    questionModels.get(9).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Akalasia");
                setDiagnosis("Akalasia");
            }

            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }
        }*/

        if (questionModels.get(0).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(2).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP1 += 1;
            hitungP2 += 1;
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(6).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(7).isAnswer() == true) {
            hitungP3 += 1;
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(8).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        if (questionModels.get(9).isAnswer() == true) {
            hitungP4 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p3", String.valueOf(hitungP3));
            Log.d("hitung p4", String.valueOf(hitungP4));
        }

        else {
            setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
        }


        Log.d("hitung p1 akhir", String.valueOf(hitungP1));
        Log.d("hitung p2 akhir", String.valueOf(hitungP2));
        Log.d("hitung p3 akhir", String.valueOf(hitungP3));
        Log.d("hitung p4 akhir", String.valueOf(hitungP4));

        if (hitungP1 > hitungP2 && hitungP1 > hitungP3 && hitungP1 > hitungP4) {
            setDiagnosis("Karsinoma Esofagus\n\n Anda memenuhi " + hitungP1 + " dari 6 gejala yang ada");
        } else if (hitungP2 > hitungP1 && hitungP2 > hitungP3 && hitungP2 > hitungP4) {
            setDiagnosis("Hernia Hiatus Esofagus\n\n Anda memenuhi " + hitungP2 + " dari 6 gejala yang ada");
        } else if (hitungP3 > hitungP1 && hitungP3 > hitungP2 && hitungP3 > hitungP4) {
            setDiagnosis("GERD (Gastroesofageal Refluks Disorder)\n\n Anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        } else if (hitungP4 > hitungP1 && hitungP4 > hitungP2 && hitungP4 > hitungP3) {
            setDiagnosis("Akalasia\n\n Anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }
        else if (hitungP1 == hitungP2 && hitungP1!=2) {
            setDiagnosis("Karsinoma Esofagus, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Hernia Hiatus Esofagus, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada");
        }
        else if (hitungP1 == hitungP3 && hitungP1!=2) {
            setDiagnosis("Karsinoma Esofagus " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "GERD (Gastroesofageal Refluks Disorder), anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        }

        else if (hitungP1 == hitungP4 && hitungP1!=2) {
            setDiagnosis("Karsinoma Esofagus, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Akalasia, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else if (hitungP2 == hitungP3 && hitungP2!=2) {
            setDiagnosis("Hernia Hiatus Esofagus, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "GERD (Gastroesofageal Refluks Disorder), anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        }

        else if (hitungP2 == hitungP4 && hitungP2!=2) {
            setDiagnosis("Hernia Hiatus Esofagus, anda memenuhi " + hitungP2 + " dari 6 gejala yang ada \n" +
                    "Akalasia, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else if (hitungP3 == hitungP4 && hitungP3!=2) {
            setDiagnosis("GERD (Gastroesofageal Refluks Disorder), anda memenuhi " + hitungP3 + " dari 6 gejala yang ada \n" +
                    "Akalasia, anda memenuhi " + hitungP4 + " dari 6 gejala yang ada");
        }

        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }
    }
}
