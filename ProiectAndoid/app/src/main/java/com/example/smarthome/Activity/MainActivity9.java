package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.smarthome.R;

import java.util.ArrayList;

public class MainActivity9 extends AppCompatActivity {

    private ArrayList<String> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);

        // Obține lista de elemente
        ArrayList<String> wordList = getIntent().getStringArrayListExtra("wordList");

        // Parcurge lista și adaugă un buton pentru fiecare element
        for (String word : wordList) {
            Button button = new Button(this);
            button.setText(word);
            buttonContainer.addView(button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Creează un Intent cu acțiunea dorită
                    Intent intent = new Intent(MainActivity9.this, MainActivity10.class);
                    // Adaugă orice date suplimentare către Intent, dacă este necesar
                    intent.putExtra("word", word);
                    // Lansează Intent-ul
                    startActivity(intent);
                }
            });
        }
    }
}
