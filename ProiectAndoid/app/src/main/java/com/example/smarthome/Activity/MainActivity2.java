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

public class MainActivity2 extends AppCompatActivity {

    private EditText  Name, Password, UserName;
    private Button butonRegister;
    private Button butonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name=findViewById(R.id.idNume);
        Password=findViewById(R.id.IdParola);
        UserName=findViewById(R.id.idUsername);
        butonRegister=findViewById(R.id.idbuttonRegister);
        butonLogin=findViewById(R.id.idbuttonLogin);

        butonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity userEntity=new UserEntity();
                userEntity.setUserId(UserName.getText().toString());
                userEntity.setName(Name.getText().toString());
                userEntity.setPassword(Password.getText().toString());
                if(validateInput(userEntity)){
                    //inserare
                    UserDatabase userdatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userdatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity existingUser = userDao.getUserById(userEntity.getUserId());
                            if(existingUser != null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "User already exists!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                userDao.registerUser(userEntity);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    }).start();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        butonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validateInput(UserEntity userentity){
        if(userentity.getName() == null || userentity.getName().isEmpty() || userentity.getUserId() == null || userentity.getUserId().isEmpty() ||
                userentity.getPassword() == null || userentity.getPassword().isEmpty() ){
            Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        } else if(userentity.getPassword().length() < 5){
            Toast.makeText(getApplicationContext(), "Password must be at least 5 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }






}