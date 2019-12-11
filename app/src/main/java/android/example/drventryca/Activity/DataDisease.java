package android.example.drventryca.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.drventryca.Adapter.DiseaseAdapter;
import android.example.drventryca.Model.DiseaseModel;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class DataDisease extends AppCompatActivity {

    private RecyclerView diseaseRecycler_;
    private ArrayList<DiseaseModel> diseaseList;
    private DiseaseAdapter diseaseAdapter;
    private TextView title_fitur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_disease);

        title_fitur =findViewById(R.id.title_fitur);
        title_fitur.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate_y_show));

        diseaseRecycler_ = findViewById(R.id.diseaseRecycler);
        diseaseRecycler_.setLayoutManager(new LinearLayoutManager(this));
        diseaseList = new ArrayList<>();

        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        diseaseAdapter = new DiseaseAdapter(this, diseaseList);
        diseaseRecycler_.setAdapter(diseaseAdapter);
        initializeDiseaseList();

    }

    public void initializeDiseaseList(){
        String[] title_disease = getResources().getStringArray(R.array.disease_list);
        String[] expl_disease = getResources().getStringArray(R.array.penjelasan);

        diseaseList.clear();

        for (int i=0; i<title_disease.length;i++){
            diseaseList.add(new DiseaseModel(title_disease[i],expl_disease[i]));
        }
        diseaseAdapter.notifyDataSetChanged();
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

                }
                break;
        }

        return false;
    }



}
