package com.example.etpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class scanresults extends AppCompatActivity {
    TextView scanrestv;
    String scanres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanresults);
        scanrestv=findViewById(R.id.scanrestv);
        getSupportActionBar().hide();
        Intent intent = getIntent();


        scanres = intent.getStringExtra(scanqr.qrres);

        // Setting up received email to TextView.
        scanrestv.setText(scanrestv.getText().toString()+ scanres);

    }
}