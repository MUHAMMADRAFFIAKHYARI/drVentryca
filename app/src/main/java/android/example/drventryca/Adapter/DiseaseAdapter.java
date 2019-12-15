package android.example.drventryca.Adapter;

import android.content.Context;
import android.content.Intent;
import android.example.drventryca.Activity.DetailDisease;
import android.example.drventryca.Model.DiseaseModel;
import android.example.drventryca.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.ViewHolder> implements Filterable {

    private Context mContext;
    private List<DiseaseModel> diseaseModel;
    private List<DiseaseModel> diseaseModelsFilt;


    public DiseaseAdapter(Context context, List<DiseaseModel> disease_list){
        this.mContext = context;
        this.diseaseModel = disease_list;
        this.diseaseModelsFilt = diseaseModel;
    }

    @Override
    public DiseaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.disease_items,parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull DiseaseAdapter.ViewHolder holder, int position) {
        DiseaseModel currentDisease = diseaseModelsFilt.get(position);
        holder.bindTo(currentDisease);
    }

    @Override
    public int getItemCount() {
        return diseaseModelsFilt.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();
                if (key.isEmpty()) {
                    diseaseModelsFilt = diseaseModel;
                }else{
                    List<DiseaseModel> filteredDisease = new ArrayList<>();
                    for (DiseaseModel row : diseaseModel){
                        if (row.getTitle().toLowerCase().contains(key.toLowerCase())){
                            filteredDisease.add(row);
                        }
                    }
                    diseaseModelsFilt = filteredDisease;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = diseaseModelsFilt;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                diseaseModelsFilt = (ArrayList<DiseaseModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView disease_name, disease_expl;

        public ViewHolder(View itemView) {
            super(itemView);

            /*disease_expl =itemView.findViewById(R.id.disease_expl);*/
            disease_name = itemView.findViewById(R.id.disease_name);

            itemView.setOnClickListener(this);
        }
        void bindTo(DiseaseModel currentDisease){
            /*disease_expl.setText(currentDisease.getExplan());*/
            disease_name.setText(getAdapterPosition()+1 +". "+currentDisease.getTitle());

            disease_name.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_right_show));
        }
        @Override
        public void onClick(View view){
            DiseaseModel currentExpl = diseaseModel.get(getAdapterPosition());

            Intent explDisease = new Intent(mContext, DetailDisease.class);
            explDisease.putExtra("penjelasan", currentExpl.getExplan());
            explDisease.putExtra("judul_",currentExpl.getTitle());

            mContext.startActivity(explDisease);
        }
    }
}
