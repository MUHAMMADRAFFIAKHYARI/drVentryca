package android.example.drventryca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

public class ReadyDiag extends AppCompatActivity {
    private TextView readyDiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_diag);

        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        readyDiag = findViewById(R.id.diag_text);

        readyDiag.animate().scaleX(1f).scaleY(1f).alpha(1f).setInterpolator(new OvershootInterpolator()).start();

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
                    startActivity(new Intent(this, Landing.class));
                } else if (x2<x1){

                }
                break;
        }

        return false;
    }
}
