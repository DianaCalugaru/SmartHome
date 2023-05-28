package com.example.smarthome.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smarthome.R;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    TextView Name;
    private Button buton1;
    private Button buton2;
    private Button buton3;
    private  ArrayList<String> wordList;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Name=findViewById(R.id.idnumetext);
        String name= getIntent().getStringExtra("nume");
        Name.setText(name);
        buton1=findViewById(R.id.button);
        buton2=findViewById(R.id.button2);
        buton3=findViewById(R.id.button3);


        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent0=new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(intent0);
            }
        });


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            wordList = bundle.getStringArrayList("wordList");
            if (wordList != null) {
                for (String word : wordList) {
                    System.out.println(word);
                }
            }
        }

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity4.this, MainActivity9.class);
                intent1.putStringArrayListExtra("wordList", wordList);
                startActivity(intent1);
            }
        });

        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity4.this, Informatii.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater meniu = getMenuInflater();
        meniu.inflate(R.menu.meniu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Intent intent1 = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent1);
                return true;
            case R.id.item_2:
//                finish();
                finishAffinity(); // Închide toate activitățile din aplicație
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}