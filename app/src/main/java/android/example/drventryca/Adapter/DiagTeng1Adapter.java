package android.example.drventryca.Adapter;

import android.content.Context;
import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiagTeng1Adapter extends RecyclerView.Adapter<DiagTeng1Adapter.ViewHolder>{
    private Context context;
    private ArrayList<QuestionModel> questionModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onChoiceClick(int position, boolean answer);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public DiagTeng1Adapter(ArrayList<QuestionModel> questionModels, Context context) {
        this.context = context;
        this.questionModels = questionModels;
    }

    @NonNull
    @Override
    public DiagTeng1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnosis_teng_item,parent,false);
        DiagTeng1Adapter.ViewHolder v = new DiagTeng1Adapter.ViewHolder(view, mListener);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull DiagTeng1Adapter.ViewHolder holder, int position) {
        QuestionModel currentDiagTeng = questionModels.get(position);
        holder.bindTo(currentDiagTeng);
    }

    @Override
    public int getItemCount() {
        return questionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView question_Teng;
        private RadioGroup mRadioGroup;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            question_Teng = itemView.findViewById(R.id.questionTeng);
            mRadioGroup = itemView.findViewById(R.id.radioPilihan);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                }
            });

            mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int id) {
                    if ((id == R.id.radioYa)) {

                        Log.d("__DebugRadio", "Ya Checked");
                        if (listener != null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onChoiceClick(position, true);
                            }
                        }
                    }else if (id == R.id.radioTidak){
                        Log.d("__DebugRadio", "Tidak Checked");
                        if (listener != null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION){
                                listener.onChoiceClick(position, false);
                            }
                        }
                    }
                }
            });
        }

        void bindTo(QuestionModel currentDiagTeng){
            question_Teng.setText(currentDiagTeng.getQuestion_teng());
        }

    }
}
