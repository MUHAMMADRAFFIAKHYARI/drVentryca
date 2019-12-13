package android.example.drventryca.Adapter;

import android.content.Context;
import android.content.Intent;
import android.example.drventryca.Activity.DetailDisease;
import android.example.drventryca.Model.DiseaseModel;
import android.example.drventryca.Model.HealthNewsModel;
import android.example.drventryca.Model.MySingleton;
import android.example.drventryca.R;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

public class HealthNewsAdapter extends RecyclerView.Adapter<HealthNewsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HealthNewsModel> newsList;
    private MySingleton mySingleton;
    private ImageLoader imageLoader;


    public HealthNewsAdapter(Context context, ArrayList<HealthNewsModel> newsList) {
        this.context = context;
        this.newsList = newsList;
        mySingleton = MySingleton.getInstance(context);
        imageLoader = mySingleton.getImageLoader();
    }

    @Override
    public HealthNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.health_news_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HealthNewsAdapter.ViewHolder holder, int position) {
        HealthNewsModel currentHealthNews = newsList.get(position);

        holder.title.setText(currentHealthNews.getTitle());
        holder.desc.setText(currentHealthNews.getDesc());
        holder.date.setText(currentHealthNews.getPubD());

        String imgUrl = currentHealthNews.getImgUrl();
        if (imgUrl != null){
            imageLoader.get(imgUrl, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.img.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView img;
        TextView title,desc, date;
        private View ilangLu;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleNews);
            desc = itemView.findViewById(R.id.detailsText);
            date = itemView.findViewById(R.id.dataText);
            img = itemView.findViewById(R.id.imgNews);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){

            String url = String.valueOf(desc);

            // Parse the URI and create the intent.
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

            // Find an activity to hand the intent and start that activity.
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!");
            }

        }
        void bindTo(HealthNewsModel currentHealthNews){
            title.setText(currentHealthNews.getTitle());
            desc.setText(currentHealthNews.getDesc());
            date.setText(currentHealthNews.getPubD());
        }
    }
}
