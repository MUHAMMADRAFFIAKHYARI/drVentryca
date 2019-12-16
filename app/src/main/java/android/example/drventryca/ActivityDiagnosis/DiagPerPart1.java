package android.example.drventryca.ActivityDiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

public class DiagPerPart1 extends AppCompatActivity {

    RadioGroup radioGroup_per1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_per_part1);
        radioGroup_per1 = (RadioGroup) findViewById(R.id.radiogroup_per1);

        radioGroup_per1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton1_per1){
                    Intent intent = new Intent(DiagPerPart1.this, DiagPerPart1_1.class);
                    startActivity(intent);
                    finish();
                }
                if (checkedId==R.id.radioButton2_per1){
                    Intent intent = new Intent(DiagPerPart1.this, DiagPerPart1_2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}
