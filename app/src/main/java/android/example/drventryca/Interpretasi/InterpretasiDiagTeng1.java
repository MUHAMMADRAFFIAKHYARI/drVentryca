package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.Model.DiseaseModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagTeng1 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;
    private DiseaseModel diseaseModel;


    public InterpretasiDiagTeng1(ArrayList<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }

    public ArrayList<QuestionModel> getQuestionModels() {
        return questionModels;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }


    private int hitungP1 = 2;
    private int hitungP2 = 2;


    public void spk() {
        position = questionModels.size();



            /*if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true)
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }*/

            /*else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false)
            {
                Log.d("diagnosis", "Penyakit Esofagitis");
                setDiagnosis("Esofagitis");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true)
            {
                Log.d("diagnosis", "Strikus Esofagus");
                setDiagnosis("Strikus Esofagus");
            }*/

        if (questionModels.get(0).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
        }

        if (questionModels.get(2).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));

        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));

        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));

        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));

        } else {
            setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
        }


        Log.d("hitung p1 akhir", String.valueOf(hitungP1));
        Log.d("hitung p2 akhir", String.valueOf(hitungP2));

        if (hitungP1 > hitungP2) {
            setDiagnosis("Esofagitis\n\n Anda memenuhi " + hitungP1 + " dari 5 gejala yang ada");
        } else if (hitungP2 > hitungP1) {
            setDiagnosis("Strikus Esofagus\n\n Anda memenuhi " + hitungP2 + " dari 5 gejala yang ada");
        } else if (hitungP2 == hitungP1 && hitungP2!=2) {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }
        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }

    }
}
