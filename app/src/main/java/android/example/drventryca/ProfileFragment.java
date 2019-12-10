package android.example.drventryca;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private ImageView image_user;
    TextView massa, tinggi, gender, goldar, age, namdep, nambel;
    private Button cek_imt;
    DatabaseReference reference;
    FirebaseUser user;
    FirebaseAuth auth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        image_user = view.findViewById(R.id.user_image);
        massa = view.findViewById(R.id.mb);
        tinggi = view.findViewById(R.id.tb);
        gender = view.findViewById(R.id.gender);
        goldar = view.findViewById(R.id.goldar);
        age = view.findViewById(R.id.age);
        namdep = view.findViewById(R.id.nama_depan);
        nambel = view.findViewById(R.id.nama_belakang);

        /*imt = view.findViewById(R.id.imt);*/
        cek_imt = view.findViewById(R.id.goIMT);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference().child("User:").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaDepan = dataSnapshot.child("namaDepan").getValue().toString();
                namdep.setText(namaDepan);
                String namaBelakang = dataSnapshot.child("namaBelakang").getValue().toString();
                nambel.setText(namaBelakang);
                String beratBadan = dataSnapshot.child("massaBadan").getValue().toString();
                massa.setText(beratBadan);
                String tinggiBadan = dataSnapshot.child("tinggiBadan").getValue().toString();
                tinggi.setText(tinggiBadan);

                Log.d("Check", beratBadan);
                Log.d("Check", tinggiBadan);

                beratBadan = massa.getText().toString();
                final double massa_ = Double.parseDouble(beratBadan);
                int massa_count = Integer.valueOf(beratBadan);

                tinggiBadan = tinggi.getText().toString();
                final double tinggi_ = Double.parseDouble(tinggiBadan);
                int tinggi_count = Integer.valueOf(tinggiBadan);

                ValueAnimator animate_massa, animate_tinggi;

                animate_massa = ValueAnimator.ofInt(0, massa_count);
                animate_massa.setDuration(2000);
                animate_massa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        massa.setText(animation.getAnimatedValue().toString());
                    }
                });

                animate_tinggi = ValueAnimator.ofInt(0, tinggi_count);
                animate_tinggi.setDuration(3000);
                animate_tinggi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        tinggi.setText(animation.getAnimatedValue().toString());
                    }
                });


                animate_massa.start();
                animate_tinggi.start();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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

        cek_imt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BMICalc.class));
            }
        });

        /*image_user.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show2));*/
        gender.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        goldar.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        age.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in));
        namdep.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth));
        nambel.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in_smooth));



        return view;
    }



}
