package android.example.drventryca.Adapter;

import android.content.Context;
import android.example.drventryca.Model.DiagTengModel;
import android.example.drventryca.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiagTengAdapter extends RecyclerView.Adapter<DiagTengAdapter.ViewHolder>{
    private Context context;
    public ArrayList<DiagTengModel> diagTengModels;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onChoiceClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public DiagTengAdapter(Context context, ArrayList<DiagTengModel> diagTengModels) {
        this.context = context;
        this.diagTengModels = diagTengModels;
    }

    @NonNull
    @Override
    public DiagTengAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnosis_teng_item,parent,false);
        DiagTengAdapter.ViewHolder v = new DiagTengAdapter.ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(DiagTengAdapter.ViewHolder holder, int position) {
        DiagTengModel currenctDiagTeng = diagTengModels.get(position);
        holder.bindTo(currenctDiagTeng);
    }

    @Override
    public int getItemCount() {
        return diagTengModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question_Teng;

        public ViewHolder(View itemView) {
            super(itemView);
            question_Teng = itemView.findViewById(R.id.questionTeng);

        }

        void bindTo(DiagTengModel currentDiagTeng){
            question_Teng.setText(currentDiagTeng.getQuestion_teng());

        }

    }
}
