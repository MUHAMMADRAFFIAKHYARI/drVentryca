package android.example.drventryca.ActivityDiagnosis;

import android.content.Intent;
import android.example.drventryca.Adapter.DiagAnAdapter;
import android.example.drventryca.Interpretasi.InterpretasiDiagAn;
import android.example.drventryca.Model.QuestionModel;
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

public class DiagAn extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DiagAnAdapter mDiagAnAdapter;
    private ArrayList<QuestionModel> questionModels;
    private ArrayList<Integer> mJumlah;
    private ProgressBar mProgressBar;
    private TextView questionAnCounter;
    private int progres;
    private Button submit;
    private String diagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_an);

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

        mRecyclerView = findViewById(R.id.quest_an_recycler);
        mProgressBar = findViewById(R.id.progressBar);
        questionAnCounter = findViewById(R.id.questionAnCounter);
        submit = findViewById(R.id.submit);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper helper = new PagerSnapHelper() ;
        helper.attachToRecyclerView(mRecyclerView);

        questionModels = new ArrayList<>();
        mDiagAnAdapter = new DiagAnAdapter(questionModels, this);
        mRecyclerView.setAdapter(mDiagAnAdapter);

        mDiagAnAdapter.setOnItemClickListener(new DiagAnAdapter.OnItemClickListener() {
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
                        questionAnCounter.setText("Terisi " + progres + " dari " + questionModels.size());

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



        initializeDiagAn();
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (progres == questionModels.size()){


                    InterpretasiDiagAn interpretasiDiagAn = new InterpretasiDiagAn(questionModels);
                    interpretasiDiagAn.spk();
                    Intent intent = new Intent(DiagAn.this, ResultDiag.class);
                    intent.putExtra("key", interpretasiDiagAn.getDiagnosis());


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

    public void initializeDiagAn(){
        String[] question = getResources().getStringArray(R.array.question_an);

        questionModels.clear();
        for (int i =0; i <question.length;i++){
            questionModels.add(new QuestionModel(question[i]));
        }
        mProgressBar.setMax(questionModels.size());
        questionAnCounter.setText("Terisi " + 0 + " dari " + questionModels.size());

        mJumlah = new ArrayList<>(Collections.nCopies(questionModels.size(), 0));
        mDiagAnAdapter.notifyDataSetChanged();

    }
}
