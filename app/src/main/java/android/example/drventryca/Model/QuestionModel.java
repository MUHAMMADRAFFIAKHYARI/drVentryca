package android.example.drventryca.Model;

public class QuestionModel {

    public long id;
    public int checkedId = -1;
    public boolean answer;
    private String Question;

    public QuestionModel(String question) {
        Question = question;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question){
        Question = question;
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
