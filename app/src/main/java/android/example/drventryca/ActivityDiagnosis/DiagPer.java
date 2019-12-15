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

public class DiagPer extends AppCompatActivity {

    RadioGroup radioGroup_per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_per);
        radioGroup_per = (RadioGroup) findViewById(R.id.radiogroup_per);

        radioGroup_per.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton_per1){
                    Intent intent = new Intent(DiagPer.this, DiagPerPart1.class);
                    startActivity(intent);
                }
                if (checkedId==R.id.radioButton_per2){
                    Intent intent = new Intent(DiagPer.this, DiagPerPart2.class);
                    startActivity(intent);
                }
                if (checkedId==R.id.radioButton_per3){
                    Intent intent = new Intent(DiagPer.this, DiagPerPart3.class);
                    startActivity(intent);
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
