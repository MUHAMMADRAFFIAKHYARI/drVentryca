package android.example.drventryca.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.example.drventryca.Adapter.SliderAdapter;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IntroduceSlide extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button skipButton;
    private Button nextButton;
    private int mCurrentPage;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_slide);

        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        skipButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);
        relativeLayout = findViewById(R.id.bg_relative);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        relativeLayout.setBackgroundColor(getColor(R.color.rajah));

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }


    public  void  addDotsIndicator(int position){
        int count = sliderAdapter.getCount();
        mDots = new TextView[count];
        mDotLayout.removeAllViews();

        for (int i =0; i< mDots.length;i++){
            mDots[i]= new  TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWhite));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.dark_cerulian));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage =i;

            if (i == 0){
                nextButton.setEnabled(true);
                skipButton.setEnabled(true);

                nextButton.setText("Next");
                relativeLayout.setBackgroundColor(getColor(R.color.rajah));

            } else if(i == mDots.length-1){
                nextButton.setEnabled(true);
                skipButton.setEnabled(true);

                nextButton.setText("Got It");
                skipButton.setText("");

                relativeLayout.setBackgroundColor(getColor(R.color.coral_reef));
            }else{
                nextButton.setEnabled(true);
                skipButton.setEnabled(true);
                skipButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                skipButton.setText("Skip");

                relativeLayout.setBackgroundColor(getColor(R.color.bleu_de_france));
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skipPage(View view) {
        startActivity(new Intent(this, Register.class));
        /*mSlideViewPager.setCurrentItem(mCurrentPage -1);*/
    }

    public void nextPage(View view) {
        if (nextButton.getText() == "Got It"){
            startActivity(new Intent(this, Register.class));
        }else{
            mSlideViewPager.setCurrentItem(mCurrentPage +1);
        }
    }
}
