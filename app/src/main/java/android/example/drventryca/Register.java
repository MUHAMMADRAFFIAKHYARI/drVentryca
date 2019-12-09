package android.example.drventryca;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Variable yang akan merefers Firebase Realtime Database.
    DatabaseReference database;

    private TextView toHome, goLogin;

    // Variable fields EditText dan Button
    private Button btSubmitDB;
    EditText etNamaDepan, etNamaBelakang, etBeratBadan, etTinggiBadan, etUsia;
    Spinner goldar;
    RadioGroup gender;
    RadioButton jenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // inisialisasi
        etNamaDepan = findViewById(R.id.userName);
        etNamaBelakang = findViewById(R.id.password);
        etBeratBadan = findViewById(R.id.et_massaBadan);
        etTinggiBadan = findViewById(R.id.et_tinggiBadan);
        etUsia = findViewById(R.id.et_usia);
        btSubmitDB = findViewById(R.id.bt_submit);

//        goldar = (Spinner)findViewById(R.id.spin_goldar);
//        gender = (RadioGroup)findViewById(R.id.rg_kelamin);

        //get reference Firebase Database

        toHome = findViewById(R.id.toHome);
        database = FirebaseDatabase.getInstance().getReference();

        // setOnclick pada button submit
        btSubmitDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(etNamaDepan.getText().toString()) &&
                        !isEmpty(etNamaBelakang.getText().toString()) &&
                        !isEmpty(etBeratBadan.getText().toString()) &&
                        !isEmpty(etTinggiBadan.getText().toString()) &&
                        !isEmpty(etUsia.getText().toString()))

                    submitData(new Data(
                            etNamaDepan.getText().toString(),
                            etNamaBelakang.getText().toString(),
                            etBeratBadan.getText().toString(),
                            etTinggiBadan.getText().toString(),
                            etUsia.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.bt_submit), "Data Tidak Boleh Kosong !",
                            Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNamaDepan.getWindowToken(), 0);

            }
        });

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        Spinner spinner = findViewById(R.id.spin_goldar);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.goldar, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }


    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);

    }



    private void submitData(Data data) {
        database.child("Data User : ").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNamaDepan.setText("");
                etNamaBelakang.setText("");
                etBeratBadan.setText("");
                etTinggiBadan.setText("");
                etUsia.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data Berhasil Ditambahkan", Snackbar.LENGTH_LONG).show();
                startActivity(Register.getActIntent(Register.this));
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, Landing.class);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void toLogin(View view){
        startActivity(new Intent(this, Login.class));
    }

    public void skipHome(View view) {
        startActivity(new Intent(this,Landing.class));
    }
}
