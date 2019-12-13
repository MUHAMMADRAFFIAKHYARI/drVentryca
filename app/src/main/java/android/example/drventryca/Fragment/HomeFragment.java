package android.example.drventryca.Fragment;

import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.example.drventryca.Activity.BMICalc;
import android.example.drventryca.Activity.DataDisease;
import android.example.drventryca.Activity.FaktaTips;
import android.example.drventryca.Activity.HealthNews;
import android.example.drventryca.R;
import android.example.drventryca.Activity.ReadyDiag;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private CardView klikDiag, klikData, klikFakta;
    private ImageView berita1, berita2, berita3;
    private ImageView news, goImt;
    private PropertyValuesHolder scaleX, scaleY, aplha;
    TextView appTitle, halo, etNama, kabar, bawah1, bawah2;

    DatabaseReference reference;
    FirebaseUser user;
    FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);


         appTitle = view.findViewById(R.id.app_title);
         klikDiag = view.findViewById(R.id.goDiag);
         klikData = view.findViewById(R.id.goData);
         klikFakta = view.findViewById(R.id.goFakta);
         news = view.findViewById(R.id.news);
         TextView lihat_ = view.findViewById(R.id.lihat_tips_lain);
         halo = view.findViewById(R.id.halo);
        etNama = view.findViewById(R.id.nama);
         kabar = view.findViewById(R.id.kabar);
         bawah1 = view.findViewById(R.id.text_bawah1);
         /*bawah2 = view.findViewById(R.id.text_bawah2);*/
         berita1 = view.findViewById(R.id.berita1);
         berita2 = view.findViewById(R.id.berita2);
         berita3 = view.findViewById(R.id.berita3);

        goImt = view.findViewById(R.id.goIMT);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference().child("User:").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaDepan = dataSnapshot.child("namaDepan").getValue().toString();
                String namaBelakang = dataSnapshot.child("namaBelakang").getValue().toString();
                etNama.setText(namaDepan.toUpperCase() +"!");
                Toast.makeText(getContext(), "Selamat datang "+ namaDepan +" "+namaBelakang+"!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


         /*kabar.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in2));*/
         halo.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth));
        etNama.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.left_slide_in_smooth));
         /*appTitle.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.showed_up));*/
         /*news.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in));*/
         klikDiag.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show3));
         klikData.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show3));
         klikFakta.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.translate_y_show3));
         /*bawah1.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in2));*/
        /* bawah2.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in));*/
         berita1.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_slide_in_smooth));
         berita2.setAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_slide_in_smooth));


         news.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(), HealthNews.class));
             }
         });

         klikDiag.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (v.getId() == R.id.goDiag){
                     startActivity(new Intent(getActivity(), ReadyDiag.class));
                 }
             }
         }) ;

         klikData.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (v.getId() == R.id.goData){
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
                 startActivity(new Intent(getActivity(), HealthNews.class));
             }
         });

         goImt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(), BMICalc.class));
             }
         });

        berita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.kompas.com/tren/read/2019/11/10/130000865/meski-kekinian-ada-bahaya-mengintai-dari-minuman-boba-bagi-tubuh-kita";

                // Parse the URI and create the intent.
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                // Find an activity to hand the intent and start that activity.
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        berita2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lifestyle.kompas.com/read/2019/07/01/193007520/konsumsi-7-makanan-ini-demi-usus-sehat?_ga=2.142810289.587969730.1576057969-445157469.1560355677";

                // Parse the URI and create the intent.
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                // Find an activity to hand the intent and start that activity.
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });


        berita3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lifestyle.kompas.com/read/2019/10/22/161654120/langsung-tidur-setelah-makan-pencernaan-bisa-bermasalah-lho";

                // Parse the URI and create the intent.
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                // Find an activity to hand the intent and start that activity.
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

         return view;
    }


    /*float x1,x2,y1,y2;


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
    }*/

}
