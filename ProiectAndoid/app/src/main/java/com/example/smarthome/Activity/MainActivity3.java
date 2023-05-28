package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smarthome.Database.UserDao;
import com.example.smarthome.Database.UserDatabase;
import com.example.smarthome.Database.UserEntity;
import com.example.smarthome.R;

public class MainActivity3 extends AppCompatActivity {

    private EditText userId;
    private EditText password;
    private Button butonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        userId=findViewById(R.id.idUsername2);
        password=findViewById(R.id.IdParola2);
        butonlogin=findViewById(R.id.idbuttonLogin2);

        butonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userIdText=userId.getText().toString();
                String passwordText=password.getText().toString();
                if(userIdText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userentity=userDao.login(userIdText, passwordText);

                            if(userentity==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{

                                String name=userentity.getName();
                                Intent intent=new Intent(MainActivity3.this, MainActivity4.class).putExtra("nume",name);
                                startActivity(intent);

                            }
                        }
                    }).start();
                }

            }
        });


    }
}