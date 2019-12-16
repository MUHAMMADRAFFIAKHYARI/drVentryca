package android.example.drventryca.Activity;

import android.example.drventryca.Adapter.HealthNewsAdapter;
import android.example.drventryca.Model.HealthNewsModel;
import android.example.drventryca.Model.MySingleton;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class HealthNews extends AppCompatActivity {

    RequestQueue mQueue;
    private RecyclerView healthNewsRecycler;
    private ArrayList<HealthNewsModel> healthNewsList = new ArrayList<>();
    private HealthNewsAdapter healthNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_news);
        fullScreenHN();

        healthNewsRecycler = findViewById(R.id.healthNewsRecycler);
        healthNewsRecycler.setLayoutManager(new LinearLayoutManager(this));
        healthNewsRecycler.setHasFixedSize(true);

        healthNewsAdapter = new HealthNewsAdapter(this, healthNewsList);
        healthNewsRecycler.setAdapter(healthNewsAdapter);

        initialHealthNews();
    }

    void initialHealthNews(){
        mQueue = MySingleton.getInstance(this).getRequestQueue();

        String url ="https://www.mysitemapgenerator.com/shareapi/rss/1712171820";
        StringRequest mRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                Elements itemElements = document.select("item");

                for (int i=0;i<itemElements.size(); i++){
                    Element item = itemElements.get(i);
                    String title = item.child(1).text();
                    String desc = item.child(2).text();
                    String imgLink = item.child(7).attr("url");
                    String pubD = item.child(6).text();

                    /*HealthNewsModel healthNewsModel = new HealthNewsModel(title,desc,imgLink,pubD);*/
                    HealthNewsModel healthNewsModel = new HealthNewsModel(title,desc,imgLink,pubD);
                    healthNewsList.add(healthNewsModel);
                }
                healthNewsAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(mRequest);
    }



    void fullScreenHN(){
        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    float x1,x2,y1,y2;
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                y1 = motionEvent.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();
                y2 = motionEvent.getY();

                if (x1<x2){
                    finish();
                } else if (x2<x1){
                    finish();
                }
                break;
        }

        return false;
    }

}
