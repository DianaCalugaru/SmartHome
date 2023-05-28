package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.smarthome.PieChartView.PieChartView;
import com.example.smarthome.R;

import java.util.ArrayList;

public class MainActivity8 extends AppCompatActivity {

    private Button butonback;
    private Button butonhome;
    private  ArrayList<String> wordList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        butonhome=findViewById(R.id.button5);
        butonback=findViewById(R.id.button4);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
           wordList = bundle.getStringArrayList("wordList");
            if (wordList != null) {
                for (String word : wordList) {
                    System.out.println(word);
                }
            }
        }
        int[] numbers = getIntent().getIntArrayExtra("numbers");

        if (numbers != null) {
            float[] values = new float[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                values[i] = (float) numbers[i];
            }

            PieChartView pieChartView = new PieChartView(this, values);
            addContentView(pieChartView, new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT));
        }
        butonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity8.this, MainActivity7.class);
                startActivity(intent1);
            }
        });
        butonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(MainActivity8.this, MainActivity4.class);
                intent2.putStringArrayListExtra("wordList", wordList);
                startActivity(intent2);
            }
        });
    }
}