package android.example.drventryca.ActivityDiagnosis;

import android.content.Intent;
import android.example.drventryca.Activity.DataDisease;
import android.example.drventryca.Activity.Landing;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultDiag extends AppCompatActivity {

    private TextView hasil, goDisease, endDiag, reDiag;
    public ReadyDiag readyDiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        hasil = findViewById(R.id.textView6);
        goDisease = findViewById(R.id.goDisease);
        endDiag = findViewById(R.id.endDiag);
        /*docDiag = findViewById(R.id.docDiag);*/
        reDiag = findViewById(R.id.reDiag);

        hasil.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_scale));

        endDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Landing.class));
                finish();
            }
        });

        reDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReadyDiag.class));
                finish();
            }
        });

        goDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataDisease.class));
                finish();
            }
        });

        Intent i = getIntent();
        String a = i.getStringExtra("key");
        Log.d("tes", " "+a);

        hasil.setText(a);

        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}
