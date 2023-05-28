package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smarthome.Intro.SliderAdapter;
import com.example.smarthome.R;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView tv_page_counter, tv_next;
    Button butonskip;

    int total = 3 , count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by ids
        viewPager = findViewById(R.id.viewpager);
        tv_page_counter = findViewById(R.id.tv_page_counter);
        butonskip=findViewById(R.id.buttonskip);


        tv_page_counter.setText( count + " / " + total);

        //hide title
        getSupportActionBar().hide();

        //set adapter
        viewPager.setAdapter(new SliderAdapter(getSupportFragmentManager()));

        //change counter on scroll
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = 0;
                count = position + 1;
                tv_page_counter.setText( count + " / " + total);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        butonskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        //on last screen change next button to finish / continue
    }
}