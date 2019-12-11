package android.example.drventryca.Adapter;

import android.content.Context;
import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiagnosisAdapter extends RecyclerView.Adapter<DiagnosisAdapter.ViewHolder> {

    public Context context;
    public ArrayList<QuestionModel> mQuestion;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onChoiceClick(int position);
    }

    public DiagnosisAdapter(Context context, ArrayList<QuestionModel> mQuestion){
        this.context = context;
        this.mQuestion = mQuestion;
    }

    @NonNull
    @Override
    public DiagnosisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnosis_item,parent,false);
        DiagnosisAdapter.ViewHolder v = new DiagnosisAdapter.ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull DiagnosisAdapter.ViewHolder holder, int position) {
            QuestionModel currenctQuestion = mQuestion.get(position);
            holder.bindTo(currenctQuestion);
    }

    @Override
    public int getItemCount() {
        return mQuestion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView question;

        public ViewHolder(View itemView) {
            super(itemView);

                question = itemView.findViewById(R.id.question);
                itemView.setOnClickListener(this);
        }

        void bindTo(QuestionModel currentQuestion){
                question.setText(currentQuestion.getQuestion());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
