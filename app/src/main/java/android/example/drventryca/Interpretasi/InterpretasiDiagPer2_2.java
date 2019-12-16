package android.example.drventryca.Interpretasi;

import android.example.drventryca.Model.QuestionModel;
import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagPer2_2 {
    private ArrayList<QuestionModel> questionModels;
    private String diagnosis;
    private int position;

    public InterpretasiDiagPer2_2(ArrayList<QuestionModel> questionModels){
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
                    questionModels.get(5).isAnswer() == true

            )
            {
                Log.d("diagnosis", "Segera periksakan diri anda ke dokter");
                setDiagnosis("Segera periksakan diri anda ke dokter");
            }

            else if (questionModels.get(0).isAnswer() == false &&
                    questionModels.get(1).isAnswer() == true &&
                    questionModels.get(2).isAnswer() == true &&
                    questionModels.get(3).isAnswer() == true &&
                    questionModels.get(4).isAnswer() == true &&
                    questionModels.get(5).isAnswer() == false

            )
            {
                Log.d("diagnosis", "Pencernaan Lemah");
                setDiagnosis("Pencernaan Lemah");
            }

            else if (questionModels.get(0).isAnswer() == true &&
                    questionModels.get(1).isAnswer() == false &&
                    questionModels.get(2).isAnswer() == false &&
                    questionModels.get(3).isAnswer() == false &&
                    questionModels.get(4).isAnswer() == false &&
                    questionModels.get(5).isAnswer() == true
            )
            {
                Log.d("diagnosis", "Kolitis Hemoragika");
                setDiagnosis("Kolitis Hemoragika");
            }


            else{
                setDiagnosis("Belum Dapat di Diagnosa, silahkan periksakan diri anda ke dokter");
            }
        }
    }
}
