package android.example.drventryca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailDisease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_disease);

        TextView mExplan = findViewById(R.id.disease_expl);

        Intent intent = getIntent();
        mExplan.setText(intent.getStringExtra("penjelasan"));
    }
}
