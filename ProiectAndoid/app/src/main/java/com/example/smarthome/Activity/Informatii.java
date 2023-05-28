package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smarthome.R;

public class Informatii extends AppCompatActivity {

    private Button btnform;
    private Button btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatii);
        btnform=findViewById(R.id.button9);
        btnhome=findViewById(R.id.button10);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Informatii.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        btnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Informatii.this, SharedPref.class);
                startActivity(intent);
            }
        });


    }
}