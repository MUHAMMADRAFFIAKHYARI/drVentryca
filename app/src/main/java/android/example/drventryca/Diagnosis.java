package android.example.drventryca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class Diagnosis extends AppCompatActivity {

    private RecyclerView questionRecycler;
    private DiagnosisAdapter diagnosisAdapter;
    private ArrayList<QuestionModel> questionAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);


        questionRecycler = findViewById(R.id.quest_recycler);
        questionRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper helper = new PagerSnapHelper() ;
        helper.attachToRecyclerView(questionRecycler);
        questionAll = new ArrayList<>();

        diagnosisAdapter = new DiagnosisAdapter(this,questionAll);
        questionRecycler.setAdapter(diagnosisAdapter);
        initializeQuestion();
        changeStatusBarColor();

    }

    void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void initializeQuestion(){
        String[] question = getResources().getStringArray(R.array.question);
        questionAll.clear();

        for (int i =0; i <question.length;i++){
            questionAll.add(new QuestionModel(question[i]));
        }
        diagnosisAdapter.notifyDataSetChanged();

    }
}
