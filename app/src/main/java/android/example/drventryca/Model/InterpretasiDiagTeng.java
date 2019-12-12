package android.example.drventryca.Model;

import java.util.ArrayList;

public class InterpretasiDiagTeng {
    private ArrayList<DiagTengModel>diagTengModels;
    private String hasil;

    public InterpretasiDiagTeng(ArrayList<DiagTengModel>diagTengModels){
        this.diagTengModels = diagTengModels;
    }

    public String getHasil(){
        return hasil;
    }

    public ArrayList<DiagTengModel>getDiagTengModels(){
        return diagTengModels;
    }
}
