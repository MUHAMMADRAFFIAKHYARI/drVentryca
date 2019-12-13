package android.example.drventryca.Model;

import android.util.Log;

import java.util.ArrayList;

public class InterpretasiDiagTeng {
    private ArrayList<DiagTengModel>diagTengModels;
    private String diagnosis;


    private int position;



    public InterpretasiDiagTeng(ArrayList<DiagTengModel>diagTengModels){
        this.diagTengModels = diagTengModels;
    }


    public ArrayList<DiagTengModel>getDiagTengModels(){
        return diagTengModels;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void spk()
    {
        position = diagTengModels.size();

        for (int i = 0; i < position; i++) {
            if (diagTengModels.get(0).isAnswer() == true &&
                    diagTengModels.get(1).isAnswer() == true &&
                    diagTengModels.get(2).isAnswer() == true &&
                    diagTengModels.get(3).isAnswer() == false &&
                    diagTengModels.get(4).isAnswer() == false &&
                    diagTengModels.get(5).isAnswer() == false)
            {
                Log.d("diagnosis", "Penyakit Esofagitis");
                setDiagnosis("Penyakit Esofagitis");
            }

            else if (diagTengModels.get(0).isAnswer() == false &&
                    diagTengModels.get(1).isAnswer() == false &&
                    diagTengModels.get(2).isAnswer() == false &&
                    diagTengModels.get(3).isAnswer() == true &&
                    diagTengModels.get(4).isAnswer() == true &&
                    diagTengModels.get(5).isAnswer() == true)
            {
                Log.d("diagnosis", "Strikus Esofagus");
                setDiagnosis("Strikus Esofagus");
            }

            else{
                setDiagnosis("Belum Terdiagnosis");
            }
        }
    };
}
