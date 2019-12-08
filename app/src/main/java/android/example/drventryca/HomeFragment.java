package android.example.drventryca;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class HomeFragment extends Fragment {

    private CardView klikDiag;
    private CardView klikData;
    private CardView klikFakta;
    private CardView klikLemak;
    private ImageView news;
    private PropertyValuesHolder scaleX, scaleY, aplha;
    private TextView appTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_home, container, false);


         appTitle = view.findViewById(R.id.app_title);
         klikDiag = view.findViewById(R.id.goDiag);
         klikData = view.findViewById(R.id.goData);
         klikFakta = view.findViewById(R.id.goFakta);
         klikLemak = view.findViewById(R.id.card_lemak);
         news = view.findViewById(R.id.news);
         TextView lihat_ = view.findViewById(R.id.lihat_tips_lain);


         appTitle.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.showed_up));

         news.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(), HealthNews.class));
             }
         });

         klikDiag.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (v.getId() == R.id.goDiag || v.getId() == R.id.goDiag1 || v.getId() == R.id.goDiag2){
                     startActivity(new Intent(getActivity(), ReadyDiag.class));
                 }
             }
         }) ;

         klikData.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (v.getId() == R.id.goData || v.getId() == R.id.goData1 || v.getId() == R.id.goData2){
                     startActivity(new Intent(getActivity(), DataDisease.class));
                 }
             }
         });

         klikFakta.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (v.getId() == R.id.goFakta || v.getId() == R.id.goFakta1 || v.getId() == R.id.goFakta2){
                     startActivity(new Intent(getActivity(), FaktaTips.class));
                 }
             }
         });

         lihat_.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(), FaktaTips.class));
             }
         });

         klikLemak.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(), FaktaTips.class));
             }
         });

         return view;
    }

    float x1,x2,y1,y2;

    void onSwipe(){

    }
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
                    startActivity(new Intent(getContext(), HealthNews.class));
                } else if (x2<x1){

                }
                break;
        }

        return false;
    }

}
