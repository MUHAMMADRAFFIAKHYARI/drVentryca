package android.example.drventryca.Activity;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.example.drventryca.R;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


public class BMICalc extends AppCompatActivity {

    TextView result, status, showtable;
    private EditText massa, tinggi;
    private Button calculate;
    private View circleResult;
    Button okimt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        hideNotif();

        result = findViewById(R.id.imtResult);
        status = findViewById(R.id.status);
        massa = findViewById(R.id.massaInput);
        tinggi = findViewById(R.id.tinggiInput);
        calculate = findViewById(R.id.calculate);
        circleResult = findViewById(R.id.circleResult);
        showtable = findViewById(R.id.showImt);


        showtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTable();
            }
        });
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



    public void imtCalculate(View view){

        String massa_ = massa.getText().toString();
        String tinggi_ = tinggi.getText().toString();

        if(massa.getText().toString().isEmpty() || tinggi.getText().toString().isEmpty() ||
                (massa.getText().toString().isEmpty() & tinggi.getText().toString().isEmpty() )){
            /*Toast.makeText(this,"Kedua isisan tidak boleh kososng", Toast.LENGTH_LONG).show();*/
            Snackbar.make(findViewById(R.id.calculate), "Kedua isian tidak boleh kosong", Snackbar.LENGTH_LONG).show();

        } else{
            final float mass, height, result_;

            mass = Float.valueOf(massa_);
            height = Float.valueOf(tinggi_);

            result_ = mass / (height*height);
            String yHasil = String.format("%.2f",result_);
            final float xHasil = Float.parseFloat(yHasil);

            final String status_;

            if(result_ < 18.5){
                status_ = "Wah sepertinya kamu kekurangan massa tubuh";
            } else if(result_>= 18.5 && result_ <= 24.9){
                status_ = "Selamat massa tubuhmu sudah ideal :D";
            } else if(result_ > 24.9 && result_ <= 29.9){
                status_ = "Waduh kamu kelebihan berat badan, harus diet nih";
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
            animate_result.setDuration(2000);
            animate_result.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    result.setText(animation.getAnimatedValue().toString());
                }
            });animate_result.start();

            int delay_result = Integer.valueOf((int) result_);
            Log.d("delay_result","delay result0");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(result_ < 18.5){
                        circleResult.setBackgroundResource(R.drawable.circle_yellow);
                        circleResult.setTransitionAlpha(xHasil);
                    } else if(result_>= 18.5 && result_ <= 24.9){
                        circleResult.setBackgroundResource(R.drawable.circle_green);
                        circleResult.setTransitionAlpha(xHasil);
                    } else if(result_ > 24.9 && result_ <= 29.9){
                        circleResult.setBackgroundResource(R.drawable.circle_red);
                        circleResult.setTransitionAlpha(xHasil);
                    } else if (result_ > 29.9){
                        circleResult.setBackgroundResource(R.drawable.circle_red);
                        circleResult.setTransitionAlpha(xHasil);
                    } else{
                        circleResult.setBackgroundResource(R.drawable.circle_red);
                        circleResult.setTransitionAlpha(xHasil);
                    }
                }
            }, delay_result*50);
        }

    }

    void hideNotif(){
        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    public void toTable() {
        final Dialog dialog = new Dialog(BMICalc.this);
        dialog.setContentView(R.layout.imt_table);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        okimt = findViewById(R.id.okimt);
        okimt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}