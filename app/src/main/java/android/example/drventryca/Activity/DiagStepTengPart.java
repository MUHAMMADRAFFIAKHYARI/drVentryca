package android.example.drventryca.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.drventryca.Adapter.DiagTengAdapter;
import android.example.drventryca.Model.DiagTengModel;
import android.example.drventryca.Model.InterpretasiDiagTeng;

import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class DiagStepTengPart extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DiagTengAdapter mDiagTengAdapter;
    private ArrayList<DiagTengModel> diagTengModels;
    private ArrayList<Integer> mJumlah;
    private ProgressBar mProgressBar;
    private TextView questionTengCounter;
    private int progres;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_step_teng_part);

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
        mDiagTengAdapter = new DiagTengAdapter(diagTengModels, this);
        mRecyclerView.setAdapter(mDiagTengAdapter);

        mDiagTengAdapter.setOnItemClickListener(new DiagTengAdapter.OnItemClickListener() {
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
                        progres = Collections.frequency(mJumlah, 1);
                        mProgressBar.setProgress(progres);
                        questionTengCounter.setText("Terjawab " + progres + "dari " + diagTengModels.size());

                        if (position < mJumlah.size() - 1 ){
                            if (mJumlah.get(position + 1) == 0 ){
                                mRecyclerView.smoothScrollToPosition(position + 1);
                            }
                        }

                        if (progres == mJumlah.size()){
                            submit.setText("Selesai");
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

                    Intent intent = new Intent(DiagStepTengPart.this, ResultDiag.class);
                    String indikasi = interpretasiDiagTeng.getHasil();
                    startActivity(intent);
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
        diagTengModels.clear();

        for (int i =0; i <question.length;i++){
            diagTengModels.add(new DiagTengModel(question[i]));
        }
        mProgressBar.setMax(diagTengModels.size());
        questionTengCounter.setText("Terjawab " + 0 + " dari " + diagTengModels.size());

        mJumlah = new ArrayList<>(Collections.nCopies(diagTengModels.size(), 0));
        mDiagTengAdapter.notifyDataSetChanged();

    }
}
