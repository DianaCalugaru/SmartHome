package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.smarthome.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {


    private EditText inputEditText;

    private EditText inputEditText1;

    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        inputEditText = findViewById(R.id.inputEditText);
        inputEditText1 = findViewById(R.id.inputEditText1);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = inputEditText.getText().toString().trim();
                String[] strings = inputText.split(" ");

                List<String> stringList = new ArrayList<>(Arrays.asList(strings));

                String inputText1 = inputEditText1.getText().toString().trim();
                String[] strings1 = inputText1.split(" ");

                List<String> stringList1 = new ArrayList<>(Arrays.asList(strings1));

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("wordList", (ArrayList<String>) stringList);
                bundle.putStringArrayList("numbers", (ArrayList<String>) stringList1);


                Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}