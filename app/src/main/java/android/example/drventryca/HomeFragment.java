package android.example.drventryca;

import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

    private CardView klikDiag, klikData, klikFakta, berita1, berita2, berita3;
    private ImageView news;
    private PropertyValuesHolder scaleX, scaleY, aplha;
    TextView appTitle, halo, etNama, kabar, bawah1, bawah2;

    DatabaseReference reference;
    FirebaseUser user;
    FirebaseAuth auth;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);


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
         /*berita3 = view.findViewById(R.id.ber)*/


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference().child("User:").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namaDepan = dataSnapshot.child("namaDepan").getValue().toString();
                etNama.setText(namaDepan);
                Toast.makeText(getContext(), namaDepan, Toast.LENGTH_LONG).show();
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
                 startActivity(new Intent(getActivity(), HealthNews.class));
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
