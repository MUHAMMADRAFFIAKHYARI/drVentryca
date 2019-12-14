package android.example.drventryca.Activity;

import android.content.Intent;
import android.example.drventryca.Adapter.DiagTeng1Adapter;
import android.example.drventryca.Model.DiagTengModel;
import android.example.drventryca.Model.InterpretasiDiagTeng;
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

public class DiagTengPart1 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DiagTeng1Adapter mDiagTeng1Adapter;
    private ArrayList<DiagTengModel> diagTengModels;
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

        diagTengModels = new ArrayList<>();
        mDiagTeng1Adapter = new DiagTeng1Adapter(diagTengModels, this);
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

                        diagTengModels.get(position).setAnswer(answer);
                        Log.d("answer", position + String.valueOf(answer));


                        progres = Collections.frequency(mJumlah, 1);
                        mProgressBar.setProgress(progres);
                        questionTengCounter.setText("Terisi " + progres + " dari " + diagTengModels.size());

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
                if (progres == diagTengModels.size()){


                    InterpretasiDiagTeng interpretasiDiagTeng = new InterpretasiDiagTeng(diagTengModels);
                    interpretasiDiagTeng.spk();
                    Intent intent = new Intent(DiagTengPart1.this, ResultDiag.class);
                    intent.putExtra("key", interpretasiDiagTeng.getDiagnosis());


                    startActivity(intent);

                    int postion = diagTengModels.size();

                    for (int i = 0; i < postion; i++){

                        Log.d("answer 1", i + String.valueOf(diagTengModels.get(i).isAnswer()));
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

        mRecyclerView.setItemViewCacheSize(diagTengModels.size());
    }

    public void initializeDiagTengPart(){
        String[] question = getResources().getStringArray(R.array.question_tenggorokan);
        String[] jawaban = {};

        diagTengModels.clear();
        for (int i =0; i <question.length;i++){
            diagTengModels.add(new DiagTengModel(question[i]));
        }
        mProgressBar.setMax(diagTengModels.size());
        questionTengCounter.setText("Terisi " + 0 + " dari " + diagTengModels.size());

        mJumlah = new ArrayList<>(Collections.nCopies(diagTengModels.size(), 0));
        mDiagTeng1Adapter.notifyDataSetChanged();

    }
}
