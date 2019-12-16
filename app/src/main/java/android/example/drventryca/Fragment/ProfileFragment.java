package android.example.drventryca.Fragment;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.drventryca.Activity.EditUser;
import android.example.drventryca.Activity.Login;
import android.example.drventryca.R;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

    private ImageView image_user, imgLogout, round1, round2, round3, round4, goSett;
    TextView massa, tinggi, gender, goldar, age, namdep, nambel, keluar, editAkun, deleteAkun;
    Button btn_yes, btn_no;

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
        keluar =view.findViewById(R.id.keluar);
        round1 = view.findViewById(R.id.round1);
        round2 = view.findViewById(R.id.round2);
        round3 = view.findViewById(R.id.round3);
        round4 = view.findViewById(R.id.round4);
        goSett = view.findViewById(R.id.goSett);
        editAkun = view.findViewById(R.id.editAkun);
        deleteAkun = view.findViewById(R.id.hapusAkun);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference().child("User:").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaDepan = dataSnapshot.child("namaDepan").getValue().toString();
                namdep.setText(namaDepan.toUpperCase());
                String namaBelakang = dataSnapshot.child("namaBelakang").getValue().toString();
                nambel.setText(namaBelakang.toUpperCase());
                String beratBadan = dataSnapshot.child("massaBadan").getValue().toString();
                massa.setText(beratBadan);
                String tinggiBadan = dataSnapshot.child("tinggiBadan").getValue().toString();
                tinggi.setText(tinggiBadan);
                String umur = dataSnapshot.child("usia").getValue().toString();
                age.setText(umur + " Tahun");
                String golonganDarah = dataSnapshot.child("golonganDarah").getValue().toString();
                goldar.setText(golonganDarah);
                String jenisKelamin = dataSnapshot.child("gender").getValue().toString();
                gender.setText(jenisKelamin);


                if (gender.getText().toString().equals("Laki-Laki")){
                    image_user.setImageResource(R.drawable.casual_boy);
                }else if (gender.getText().toString().equals("Perempuan")){
                    image_user.setImageResource(R.drawable.casual_girl);
                }

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

        goSett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.akun_opsi);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                editAkun = dialog.findViewById(R.id.editAkun);
                deleteAkun = dialog.findViewById(R.id.hapusAkun);
                keluar = dialog.findViewById(R.id.keluar);

                editAkun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getContext(), EditUser.class));
                    }
                });

                deleteAkun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getContext(), EditUser.class));

                    }
                });
                keluar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.logout_dialog);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                        btn_no = dialog.findViewById(R.id.bt_no);
                        btn_yes = dialog.findViewById(R.id.bt_yes);

                        btn_yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                auth.signOut();
                                Intent i = new Intent(getActivity().getApplicationContext(), Login.class);
                                SharedPreferences pref = getActivity().getApplication().getSharedPreferences("myyPrefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putBoolean("isIntro0pened", false);
                                editor.commit();
                                getActivity().onBackPressed();
                                startActivity(i);
                            }
                        });

                        btn_no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                    }
                });
            }
        });



        /*image_user.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show2));*/
        gender.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        goldar.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.fade_right_show));
        age.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in));
        namdep.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth));
        nambel.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in_smooth));
        round1.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth_round));
        round2.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth_round));
        round3.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth_round));
        round4.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth_round));

        return view;
    }



}
