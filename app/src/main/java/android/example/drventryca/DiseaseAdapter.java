package android.example.drventryca;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DiseaseModel> diseaseModel;

    DiseaseAdapter(Context context, ArrayList<DiseaseModel> disease_list){
        this.mContext = context;
        this.diseaseModel = disease_list;
    }

    @Override
    public DiseaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.disease_items,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull DiseaseAdapter.ViewHolder holder, int position) {
        DiseaseModel currentDisease = diseaseModel.get(position);
        holder.bindTo(currentDisease);
    }

    @Override
    public int getItemCount() {
        return diseaseModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView disease_text, disease_expl;
        RelativeLayout  disease_card;

        public ViewHolder(View itemView) {
            super(itemView);

            disease_expl =itemView.findViewById(R.id.disease_expl);
            disease_text = itemView.findViewById(R.id.disease_title);
            disease_card = itemView.findViewById(R.id.disease_container);

            itemView.setOnClickListener(this);
        }
        void bindTo(DiseaseModel currentDisease){
            disease_text.setText(currentDisease.getTitle_());
            disease_expl.setText(currentDisease.getExplan_());

            disease_text.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_right_show));
            disease_card.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.translate_y_show2));
        }
        @Override
        public void onClick(View view){
            DiseaseModel currentExpl = diseaseModel.get(getAdapterPosition());

            Intent explDisease = new Intent(mContext, DetailDisease.class);
            explDisease.putExtra("penjelasan", currentExpl.getExplan_());
            explDisease.putExtra("judul_",currentExpl.getTitle_());

            mContext.startActivity(explDisease);
        }
    }
}
