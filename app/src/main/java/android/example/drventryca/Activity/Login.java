package android.example.drventryca.Activity;

import android.content.Intent;
import android.example.drventryca.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private TextView goDaftar;
    Button btLogin;
    EditText etEmail, etPassword;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = findViewById(R.id.bt_update);
        auth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.namdep_edit);
        etPassword = findViewById(R.id.nambel_edit);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = etEmail.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login Sukses !", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), Landing.class));
                                } else
                                    Toast.makeText(getApplicationContext(), "Login Gagal !", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        goDaftar = findViewById(R.id.goDaftar);
        forClick();
    }

    void forClick(){
        goDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Register.class));
                finish();
            }
        });
    }
}
