package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagPer2_1 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;

    private int hitungP1 = 3;
    private int hitungP2 = 3;
    private int hitungP3 = 3;

    public InterpretasiDiagPer2_1(ArrayList<QuestionModel> questionModels){
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
                    questionModels.get(7).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == true &&
                    questionModels.get(7).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Penyakit Duodenitis");
                setDiagnosis("Duodenitis");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == false &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Karsinonia Lambung");
                setDiagnosis("Karsinonia Lambung");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == true &&
                    questionModels.get(6).isAnswer() == false &&
                    questionModels.get(7).isAnswer() == false
            )
            {
                Log.d("diagnosis", "Strikus Kolitis Crohn");
                setDiagnosis("Kolitis Crohn");
            }

            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }
        }*/

        if (questionModels.get(0).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));
        }

        if (questionModels.get(1).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));
        }

        if (questionModels.get(2).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        if (questionModels.get(3).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        if (questionModels.get(4).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        if (questionModels.get(5).isAnswer() == true) {
            hitungP3 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        if (questionModels.get(6).isAnswer() == true) {
            hitungP1 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        if (questionModels.get(7).isAnswer() == true) {
            hitungP2 += 1;
            Log.d("hitung p1", String.valueOf(hitungP1));
            Log.d("hitung p2", String.valueOf(hitungP2));
            Log.d("hitung p2", String.valueOf(hitungP3));

        }

        else {
            setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
        }


        Log.d("hitung p1 akhir", String.valueOf(hitungP1));
        Log.d("hitung p2 akhir", String.valueOf(hitungP2));
        Log.d("hitung p3 akhir", String.valueOf(hitungP3));

        if (hitungP1 > hitungP2 && hitungP1 > hitungP3) {
            setDiagnosis("Duodenitis\n\n Anda memenuhi " + hitungP1 + " dari 6 gejala yang ada");
        }
        else if (hitungP2 > hitungP1 && hitungP2 > hitungP3) {
            setDiagnosis("Karsinonia Lambung\n\n Anda memenuhi " + hitungP2 + " dari 5 gejala yang ada");
        }
        else if (hitungP3 > hitungP1 && hitungP3 > hitungP2) {
            setDiagnosis("Kolitis Crohn\n\n Anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        }
        else if (hitungP1 == hitungP2 && hitungP1!=3) {
            setDiagnosis("Duodenitis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Karsinonia Lambung, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada");
        }

        else if (hitungP1 == hitungP3 && hitungP1!=3) {
            setDiagnosis("Duodenitis, anda memenuhi " + hitungP1 + " dari 6 gejala yang ada \n" +
                    "Kolitis Crohn, anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        }

        else if (hitungP2 == hitungP3 && hitungP1!=3) {
            setDiagnosis("Karsinonia Lambung, anda memenuhi " + hitungP2 + " dari 5 gejala yang ada \n" +
                    "Kolitis Crohn, anda memenuhi " + hitungP3 + " dari 6 gejala yang ada");
        }
        else {
            setDiagnosis("Kami kekurangan data untuk mendiognosa keluhan anda, silahkan masukkan gejala dengan benar ^-^");
        }
    };
}
