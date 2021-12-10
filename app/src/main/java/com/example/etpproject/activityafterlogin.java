package com.example.etpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class activityafterlogin extends AppCompatActivity {
    ImageButton ibut,ibut1;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityafterlogin);
        getSupportActionBar().hide();
        ibut=findViewById(R.id.imgbut1);
        ibut1=findViewById(R.id.imgbut2);
        tv1=findViewById(R.id.genqr);
        tv2=findViewById(R.id.scantv);
        ibut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activityafterlogin.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activityafterlogin.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        ibut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activityafterlogin.this, scanqr.class);
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activityafterlogin.this, scanqr.class);
                startActivity(intent);
            }
        });
    }
}
