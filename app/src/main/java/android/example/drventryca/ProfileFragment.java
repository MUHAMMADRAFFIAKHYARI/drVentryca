package android.example.drventryca;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.*;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;
import static java.lang.String.valueOf;

public class ProfileFragment extends Fragment {

    private ImageView image_user;
    private TextView massa, tinggi, gender, goldar, age,namdep, nambel;
    private Button cek_imt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        image_user = view.findViewById(R.id.user_image);
        massa = view.findViewById(R.id.mb);
        tinggi = view.findViewById(R.id.tb);
        tinggi = view.findViewById(R.id.tb);
        gender = view.findViewById(R.id.gender);
        goldar = view.findViewById(R.id.goldar);
        age = view.findViewById(R.id.age);
        namdep = view.findViewById(R.id.nama_depan);
        nambel = view.findViewById(R.id.nama_belakang);

        /*imt = view.findViewById(R.id.imt);
        cek_imt = view.findViewById(R.id.cek_mt);*/

        String massa__, tinggi__;

        massa__ = massa.getText().toString();
        final double massa_ = Double.parseDouble(massa__);
        int massa_count = Integer.valueOf(massa__);

        tinggi__=tinggi.getText().toString();
        final double tinggi_= Double.parseDouble(tinggi__);
        int tinggi_count = Integer.valueOf(tinggi__);


        /*cek_imt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException {
                double tinggiper = 170.0/100.0;

                double hasil =  70.0 / (1.7*1.7);
                System.out.println(hasil);
                imt.setText(String.valueOf(hasil));

                *//*String hasil_ = String.format("%.2f",hasil);
                String apa = valueOf(100.0);
                imt.setText(apa);
                int hasil__ = Integer.valueOf(hasil_);
                imt.setText(hasil_);*//*

            }
        });*/

        /*image_user.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show2));*/
        gender.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        goldar.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        age.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in));
        namdep.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth));
        nambel.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in_smooth));

        ValueAnimator animate_massa, animate_tinggi;

        animate_massa = ValueAnimator.ofInt(0, massa_count);
        animate_massa.setDuration(2000);
        animate_massa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                massa.setText(animation.getAnimatedValue().toString());
            }
        });

        animate_tinggi= ValueAnimator.ofInt(0, tinggi_count);
        animate_tinggi.setDuration(3000);
        animate_tinggi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                tinggi.setText(animation.getAnimatedValue().toString());
            }
        });


        animate_massa.start();
        animate_tinggi.start();

        return view;
    }



}
