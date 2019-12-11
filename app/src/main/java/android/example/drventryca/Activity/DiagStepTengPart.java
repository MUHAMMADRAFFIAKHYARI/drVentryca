package android.example.drventryca.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.example.drventryca.Adapter.DiagTengAdapter;
import android.example.drventryca.Model.DiagTengModel;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class DiagStepTengPart extends AppCompatActivity {

    private RecyclerView questTeng;
    private DiagTengAdapter diagTengAdapter;
    private ArrayList<DiagTengModel> diagTengModels;
    private TextView questionTengCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_step_teng_part);

        //Intent
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String data = bundle.getString("data");
        }

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        questTeng = findViewById(R.id.quest_teng_recycler);
        questTeng.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper helper = new PagerSnapHelper() ;
        helper.attachToRecyclerView(questTeng);
        diagTengModels = new ArrayList<>();

        diagTengAdapter = new DiagTengAdapter(this, diagTengModels);
        questTeng.setAdapter(diagTengAdapter);
        initializeDiagTengPart();
        questCounter();
    }

    private void questCounter(){
        questionTengCounter = findViewById(R.id.questionTengCounter);

        diagTengAdapter.setOnItemClickListener(new DiagTengAdapter.OnItemClickListener() {
            @Override
            public void onChoiceClick(int position) {
                DiagTengModel a = diagTengModels.get(position);
                questionTengCounter.setText("PERTANYAAN "+a);
            }
        });


    }

    public void initializeDiagTengPart(){
        String[] question = getResources().getStringArray(R.array.question_tenggorokan);
        diagTengModels.clear();

        for (int i =0; i <question.length;i++){
            diagTengModels.add(new DiagTengModel(question[i]));
        }
        diagTengAdapter.notifyDataSetChanged();

    }
}
