package android.example.drventryca.Adapter;

import android.content.Context;
import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiagPerAdapter extends RecyclerView.Adapter<DiagPerAdapter.ViewHolder>{
    private Context context;
    private ArrayList<QuestionModel> questionModels;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onChoiceClick(int position, boolean answer);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public DiagPerAdapter(ArrayList<QuestionModel> questionModels, Context context) {
        this.context = context;
        this.questionModels = questionModels;
    }

    @NonNull
    @Override
    public DiagPerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnosis_per_item,parent,false);
        DiagPerAdapter.ViewHolder v = new DiagPerAdapter.ViewHolder(view, mListener);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull DiagPerAdapter.ViewHolder holder, int position) {
        QuestionModel currentDiagPer = questionModels.get(position);
        holder.bindTo(currentDiagPer);
    }

    @Override
    public int getItemCount() {
        return questionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView question_Per;
        private RadioGroup mRadioGroup;
        RadioButton radioYa, radioTidak;


        public ViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            question_Per = itemView.findViewById(R.id.questionPer);
            mRadioGroup = itemView.findViewById(R.id.radioPilihan);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                }
            });

            mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int id) {
                    radioYa = itemView.findViewById(R.id.radioYa);
                    radioTidak = itemView.findViewById(R.id.radioTidak);
                    if ((id == R.id.radioYa)) {

                        Log.d("__DebugRadio", "Ya Checked");
                        if (listener != null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onChoiceClick(position, true);
                                radioYa.setBackgroundResource(R.drawable.button1_2_style);
                                radioTidak.setBackgroundResource(R.drawable.round_style8);
                            }
                        }
                    }else if (id == R.id.radioTidak){
                        Log.d("__DebugRadio", "Tidak Checked");
                        if (listener != null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION){
                                listener.onChoiceClick(position, false);
                                radioTidak.setBackgroundResource(R.drawable.round_style8_2);
                                radioYa.setBackgroundResource(R.drawable.button1_style);
                            }
                        }
                    }
                }
            });
        }

        void bindTo(QuestionModel currentDiagPer){
            question_Per.setText(currentDiagPer.getQuestion());
        }

    }
}
