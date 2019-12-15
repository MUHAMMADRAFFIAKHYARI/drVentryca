package android.example.drventryca.ActivityDiagnosis;

import android.content.Intent;
import android.example.drventryca.Adapter.DiagTeng1Adapter;
import android.example.drventryca.Model.QuestionModel;
import android.example.drventryca.Interpretasi.InterpretasiDiagTeng2;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class DiagTengPart2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DiagTeng1Adapter mDiagTeng1Adapter;
    private ArrayList<QuestionModel> questionModels;
    private ArrayList<Integer> mJumlah;
    private ProgressBar mProgressBar;
    private TextView questionTengCounter;
    private int progres;
    private Button submit;
    private String diagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_teng_part1);

        /*//Intent
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String data = bundle.getString("data");
        }*/

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        mRecyclerView = findViewById(R.id.quest_teng_recycler);
        mProgressBar = findViewById(R.id.progressBar);
        questionTengCounter = findViewById(R.id.questionTengCounter);
        submit = findViewById(R.id.submit);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper helper = new PagerSnapHelper() ;
        helper.attachToRecyclerView(mRecyclerView);

        questionModels = new ArrayList<>();
        mDiagTeng1Adapter = new DiagTeng1Adapter(questionModels, this);
        mRecyclerView.setAdapter(mDiagTeng1Adapter);

        mDiagTeng1Adapter.setOnItemClickListener(new DiagTeng1Adapter.OnItemClickListener() {
            @Override
            public void onChoiceClick(final int position, final boolean answer) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mJumlah.get(position) == 0){
                            mJumlah.set(position, 1);
                        }

                        questionModels.get(position).setAnswer(answer);
                        Log.d("answer", position + String.valueOf(answer));


                        progres = Collections.frequency(mJumlah, 1);
                        mProgressBar.setProgress(progres);
                        questionTengCounter.setText("Terisi " + progres + " dari " + questionModels.size());

                        if (position < mJumlah.size() - 1 ){
                            if (mJumlah.get(position + 1) == 0 ){
                                mRecyclerView.smoothScrollToPosition(position + 1);
                            }
                        }

                        if (progres == mJumlah.size()){
                            submit.setText("Done");
                        }

                    }
                }, 300);
            }
        });



        initializeDiagTengPart();
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (progres == questionModels.size()){


                    InterpretasiDiagTeng2 interpretasiDiagTeng2 = new InterpretasiDiagTeng2(questionModels);
                    interpretasiDiagTeng2.spk();
                    Intent intent = new Intent(DiagTengPart2.this, ResultDiag.class);
                    intent.putExtra("key", interpretasiDiagTeng2.getDiagnosis());
                    startActivity(intent);

                    int postion = questionModels.size();

                    for (int i = 0; i < postion; i++){

                        Log.d("answer 1", i + String.valueOf(questionModels.get(i).isAnswer()));
                    }


                    finish();
                }else {
                    for (int i = 0; i< mJumlah.size(); i++){
                        if (mJumlah.get(i) ==0){
                            mRecyclerView.smoothScrollToPosition(i);
                            break;
                        }
                    }
                }
            }
        });

        mRecyclerView.setItemViewCacheSize(questionModels.size());
    }

    public void initializeDiagTengPart(){
        String[] question = getResources().getStringArray(R.array.question_tenggorokan_part2);

        questionModels.clear();
        for (int i =0; i <question.length;i++){
            questionModels.add(new QuestionModel(question[i]));
        }
        mProgressBar.setMax(questionModels.size());
        questionTengCounter.setText("Terisi " + 0 + " dari " + questionModels.size());

        mJumlah = new ArrayList<>(Collections.nCopies(questionModels.size(), 0));
        mDiagTeng1Adapter.notifyDataSetChanged();

    }
}
