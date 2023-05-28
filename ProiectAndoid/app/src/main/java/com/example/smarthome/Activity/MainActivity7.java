package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.smarthome.Adapter.Adapter;
import com.example.smarthome.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {

    private ListView listView;
    private Adapter adapter;

    private EditText inputEditText2;
    private ArrayList<String> wordList;
    private ArrayList<String> numberList;
    private Button butonnext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        inputEditText2=findViewById(R.id.numbers_field);
        butonnext=findViewById(R.id.send_button);
        butonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] numbersStringArray = inputEditText2.getText().toString().split(" ");
                ArrayList<Integer> numbers = new ArrayList<>();

                for (String numberString : numbersStringArray) {
                    try {
                        numbers.add(Integer.parseInt(numberString));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
                intent.putStringArrayListExtra("numbers", numberList);
                intent.putStringArrayListExtra("wordList", wordList);
                startActivity(intent);
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

        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null) {
            numberList = bundle1.getStringArrayList("numbers");

        }


//        numberList = Arrays.asList("1", "2", "3");
//
        listView = findViewById(R.id.listView);

        adapter = new Adapter(this, wordList, numberList);
        listView.setAdapter(adapter);
    }
}
