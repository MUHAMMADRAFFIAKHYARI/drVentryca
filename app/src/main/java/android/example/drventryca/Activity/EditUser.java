package android.example.drventryca.Activity;

import android.content.Intent;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditUser extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference root;

    EditText edtNamaDepan, edtNamaBelakang, edtBeratBadan, edtTinggiBadan, edtUsia;

    Button updateProfil, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        hideNotif();

        edtNamaDepan = findViewById(R.id.namdep_edit);
        edtNamaBelakang = findViewById(R.id.nambel_edit);
        edtBeratBadan = findViewById(R.id.edit_mass);
        edtTinggiBadan = findViewById(R.id.edit_ting);
        edtUsia = findViewById(R.id.edit_usia);
        updateProfil = findViewById(R.id.bt_update);
        btn_cancel = findViewById(R.id.btn_cancel);

        //auth = FirebaseAuth.getInstance();



        root = FirebaseDatabase.getInstance().getReference().child("User:").child(user.getUid());
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nama_depan = dataSnapshot.child("namaDepan").getValue(String.class);
                String nama_belakang = dataSnapshot.child("namaBelakang").getValue().toString();
                String berat_badan = dataSnapshot.child("massaBadan").getValue().toString();
                String tinggi_badan = dataSnapshot.child("tinggiBadan").getValue().toString();
                String usia = dataSnapshot.child("usia").getValue().toString();

                edtNamaDepan.setText(nama_depan);
                edtNamaBelakang.setText(nama_belakang);
                edtBeratBadan.setText(berat_badan);
                edtTinggiBadan.setText(tinggi_badan);
                edtUsia.setText(usia);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Landing.class));
                finish();
            }
        });

        updateProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama_depan, nama_belakang, berat_badan, tinggi_badan, usia;

                nama_depan = edtNamaDepan.getText().toString().trim();
                nama_belakang = edtNamaBelakang.getText().toString().trim();
                berat_badan = edtBeratBadan.getText().toString().trim();
                tinggi_badan = edtTinggiBadan.getText().toString().trim();
                usia = edtUsia.getText().toString().trim();

                if(!TextUtils.isEmpty(nama_depan)){
                    root.child("namaDepan").setValue(nama_depan);
                }
                if(!TextUtils.isEmpty(nama_belakang)){
                    root.child("namaBelakang").setValue(nama_belakang);
                }
                if(!TextUtils.isEmpty(berat_badan)){
                    root.child("massaBadan").setValue(berat_badan);
                }
                if(!TextUtils.isEmpty(tinggi_badan)){
                    root.child("tinggiBadan").setValue(tinggi_badan);
                }
                if(!TextUtils.isEmpty(usia)){
                    root.child("usia").setValue(usia);
                }

                startActivity(new Intent(getApplicationContext(), Landing.class));
                finish();
                finish();
            }
        });
    }


    private void hideNotif(){
        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}
