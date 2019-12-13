package android.example.drventryca.Adapter;

import android.content.Context;
import android.example.drventryca.Model.DiagTengModel;
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
import android.example.drventryca.Model.DiagTengModel;

public class DiagTengAdapter extends RecyclerView.Adapter<DiagTengAdapter.ViewHolder>{
    private Context context;
    private ArrayList<DiagTengModel> diagTengModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onChoiceClick(int position, boolean answer);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public DiagTengAdapter(ArrayList<DiagTengModel> diagTengModels, Context context) {
        this.context = context;
        this.diagTengModels = diagTengModels;
    }

    @NonNull
    @Override
    public DiagTengAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnosis_teng_item,parent,false);
        DiagTengAdapter.ViewHolder v = new DiagTengAdapter.ViewHolder(view, mListener);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull DiagTengAdapter.ViewHolder holder, int position) {
        DiagTengModel currentDiagTeng = diagTengModels.get(position);
        holder.bindTo(currentDiagTeng);
    }

    @Override
    public int getItemCount() {
        return diagTengModels.size();
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

        void bindTo(DiagTengModel currentDiagTeng){
            question_Teng.setText(currentDiagTeng.getQuestion_teng());
        }

    }
}
