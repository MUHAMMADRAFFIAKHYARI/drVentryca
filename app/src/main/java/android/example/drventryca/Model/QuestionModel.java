package android.example.drventryca.Model;

public class QuestionModel {

    public long id;
    public int checkedId = -1;
    public boolean answer;
    private String Question_teng;

    public QuestionModel(String question_teng) {
        Question_teng = question_teng;
    }

    public String getQuestion_teng() {
        return Question_teng;
    }

    public void setQuestion_teng(String question_teng){
        Question_teng = question_teng;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public int getCheckId(){
        return checkedId;
    }

    public void setCheckedId(int checkedId){
        this.checkedId = checkedId;
    }

    public boolean isAnswer(){
        return answer;
    }

    public void setAnswer(boolean answer){
        this.answer = answer;
    }


}
