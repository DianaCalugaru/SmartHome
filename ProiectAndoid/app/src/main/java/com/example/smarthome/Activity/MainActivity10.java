package com.example.smarthome.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarthome.R;

import java.util.Random;

public class MainActivity10 extends AppCompatActivity {

    private TextView temperaturaTextView;
    private TextView umiditateaTextView;
    private TextView ledTextView;
    private TextView usaTextView;
    private TextView vibratieTextView;
    private TextView sunetTextView;
    private Button butonnext;
    private Button butonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        temperaturaTextView = findViewById(R.id.temperaturaTextView);
        umiditateaTextView = findViewById(R.id.umiditateaTextView);
        ledTextView = findViewById(R.id.ledTextView);
        usaTextView = findViewById(R.id.usaTextView);
        vibratieTextView=findViewById(R.id.vibratieTextView);
        sunetTextView=findViewById(R.id.sunetTextView);
        butonnext=findViewById(R.id.button6);
        butonback=findViewById(R.id.button8);

        // Generare valori random pentru Temperatură și Umiditate
        Random random = new Random();
        int temperatura = random.nextInt(35);
        int umiditate = random.nextInt(60);

        // Generare valoare random pentru starea Led-ului
        boolean ledAprins = random.nextBoolean();
        String ledStare = ledAprins ? "Aprins" : "Stins";

        // Generare valoare random pentru starea Ușii
        boolean usaDeschisa = random.nextBoolean();
        String usaStare = usaDeschisa ? "Deschisa" : "Inchisa";

        boolean sunetDetectat = random.nextBoolean();
        String sunetStare = sunetDetectat ? "Detectat" : "Nedetectat";

        boolean vibratieDetectata = random.nextBoolean();
        String vibratieStare = vibratieDetectata ? "Detectat" : "Nedetectat";


        // Setare valorile generate în TextView-urile corespunzătoare
        temperaturaTextView.setText("Temperatura: " + temperatura);
        umiditateaTextView.setText("Umiditatea: " + umiditate);
        ledTextView.setText("Led: " + ledStare);
        usaTextView.setText("Usa: " + usaStare);
        sunetTextView.setText("Sunet: "+sunetStare);
        vibratieTextView.setText("Vibratie: "+ vibratieStare);

        butonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity10.this, Maps.class);
                startActivity(intent);
            }
        });
        butonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity10.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
