package android.example.drventryca;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static android.example.drventryca.R.drawable.circle_yellow;

public class BMICalc extends AppCompatActivity {

    private TextView result, status;
    private EditText massa, tinggi;
    private Button calculate;
    private View circleResult;

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
        circleResult = findViewById(R.id.circleResult);

    }

    float x1,x2,y1,y2;
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                y1 = motionEvent.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();
                y2 = motionEvent.getY();

                if (x1<x2){
                    finish();
                } else if (x2<x1){
                    finish();
                }
                break;
        }

        return false;
    }

    @SuppressLint("ResourceAsColor")
    public void imtCalculate(View view){

        String massa_ = massa.getText().toString();
        String tinggi_ = tinggi.getText().toString();

        if(massa.getText().toString().isEmpty() || tinggi.getText().toString().isEmpty() ||
                (massa.getText().toString().isEmpty() & tinggi.getText().toString().isEmpty() )){
            /*Toast.makeText(this,"Kedua isisan tidak boleh kososng", Toast.LENGTH_LONG).show();*/
            Snackbar.make(findViewById(R.id.calculate), "Kedua isian tidak boleh kosong", Snackbar.LENGTH_LONG).show();

        } else{
            float mass, height, result_;

            mass = Float.valueOf(massa_);
            height = Float.valueOf(tinggi_);

            result_ = mass / (height*height);
            String yHasil = String.format("%.2f",result_);
            final float xHasil = Float.parseFloat(yHasil);

            String status_;

            if(result_ < 18.5){
                status_ = "Wah sepertinya kamu kekurangan massa tubuh";
                circleResult.setBackgroundResource(circle_yellow);
                circleResult.setTransitionAlpha(xHasil);
            } else if(result_>= 18.5 && result_ <= 24.9){
                status_ = "Selamat massa tubuhmu sudah ideal :D";
                circleResult.setBackgroundResource(R.drawable.circle_green);
                circleResult.setTransitionAlpha(xHasil);
            } else if(result_ > 24.9 && result_ <= 29.9){
                status_ = "Waduh kamu kelebihan berat badan, harus \n diet nih";
                circleResult.setBackgroundResource(R.drawable.circle_red);
                circleResult.setTransitionAlpha(xHasil);
            } else if (result_ > 29.9){
                status_ = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
                circleResult.setBackgroundResource(R.drawable.circle_red);
                circleResult.setTransitionAlpha(xHasil);
            } else{
                status_ = "Oh tidak!! kamu terkena obesitas, diperbaiki pola makannya ya";
                circleResult.setBackgroundResource(R.drawable.circle_red);
                circleResult.setTransitionAlpha(xHasil);
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
}