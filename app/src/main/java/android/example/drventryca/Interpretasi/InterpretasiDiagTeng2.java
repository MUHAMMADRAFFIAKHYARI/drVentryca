package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagTeng2 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;

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


        for (int i = 0; i < position; i++) {

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
                setDiagnosis("Gastroesofageal Refluks Disorder");
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
        }
    };
}
