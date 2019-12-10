package android.example.drventryca;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalc extends AppCompatActivity {

    private TextView result, status;
    private EditText massa, tinggi;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);


        result = findViewById(R.id.imtResult);
        status = findViewById(R.id.status);
        massa = findViewById(R.id.massaInput);
        tinggi = findViewById(R.id.tinggiInput);
        calculate = findViewById(R.id.calculate);

    }

    public void imtCalculate(View view){

        String massa_ = massa.getText().toString();
        String tinggi_ = tinggi.getText().toString();

        float mass, height, result_;

        mass = Float.valueOf(massa_);
        height = Float.valueOf(tinggi_);

        result_ = mass / (height*height);
        String yHasil = String.format("%.2f",result_);
        float xHasil = Float.parseFloat(yHasil);

        String status_;

        if(result_ < 18.5){
            status_ = "Wah sepertinya kamu kekurangan massa tubuh";
        } else if(result_>= 18.5 && result_ <= 24.9){
            status_ = "Selamat massa tubuhmu sudah ideal :D";
        } else if(result_ > 24.9 && result_ <= 29.9){
            status_ = "Waduh kamu kelebihan berat badan, harus \n diet nih";
        } else if (result_ > 29.9){
            status_ = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
        } else{
            status_ = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
        }status.setText(status_);


        AlphaAnimation animation1 = new AlphaAnimation(0f, 1.0f);
        animation1.setDuration((long) (result_*100));
        animation1.setStartOffset(1000);
        animation1.setFillAfter(true);
        status.startAnimation(animation1);


        ValueAnimator animate_result;
        animate_result = ValueAnimator.ofFloat(0, xHasil);
        animate_result.setDuration(2500);
        animate_result.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                result.setText(animation.getAnimatedValue().toString());
            }
        });animate_result.start();

    }
}