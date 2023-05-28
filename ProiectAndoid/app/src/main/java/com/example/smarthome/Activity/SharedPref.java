package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.smarthome.R;

public class SharedPref extends AppCompatActivity {

    private EditText age;

    private EditText studii;

    private EditText city;

    private EditText opcupation;
    private Switch switch1;
    private Button save;
    private Button show;
    private TextView text;
    private Button butonback;

    SharedPreferences sharedpref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        age=findViewById(R.id.idage);
        switch1=findViewById(R.id.idswitch);
        save=findViewById(R.id.btnsave);
        show=findViewById(R.id.btninfo);
        text=findViewById(R.id.idinfo);
        studii=findViewById(R.id.idstud);
        city=findViewById(R.id.idcity);
        opcupation=findViewById(R.id.idopc);
        butonback=findViewById(R.id.button11);

        sharedpref=getSharedPreferences("SP_NAME", MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String mage=age.getText().toString();
               String mcity=city.getText().toString();
               String mocupation=opcupation.getText().toString();
               String mstudii=studii.getText().toString();
               boolean infroswitxh=switch1.isChecked();

               SharedPreferences.Editor editor= sharedpref.edit();
               editor.putString("AGE", mage);
               editor.putString("CITY", mcity);
               editor.putString("STUDII", mstudii);
                editor.putString("OPCUP", mocupation);
               editor.putBoolean("PREF", infroswitxh);

               editor.apply();





            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String age=sharedpref.getString("AGE", "");
                String studii=sharedpref.getString("STUDII", "");
                String opcup=sharedpref.getString("OPCUP", "");
                String city=sharedpref.getString("CITY", "");
                boolean pref=sharedpref.getBoolean("PREF", false);

                text.setText("Age "+ age + " city "+ city+ " opcupation " + opcup + " studies "+ studii +" and  information useful: "+ pref );



            }
        });

        butonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SharedPref.this, MainActivity4.class);
                startActivity(intent);
            }
        });


    }
}