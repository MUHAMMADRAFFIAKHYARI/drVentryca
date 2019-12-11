package android.example.drventryca.Model;

public class DiseaseModel {

    String title_, explan_;

    public DiseaseModel(String title, String explan) {
        this.title_ = title;
        this.explan_= explan;
    }

    public String getTitle() {
        return title_;
    }

    public String getExplan(){
        return explan_;
    }



}
