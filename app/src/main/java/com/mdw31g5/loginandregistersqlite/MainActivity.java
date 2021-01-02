package com.mdw31g5.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password,confirm;
    DatabaseHelper db;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
      email=findViewById(R.id.PersonName);
       password=findViewById(R.id.Password);
       confirm=findViewById(R.id.TextPassword);
          login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
        Intent i= new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);});
       register = findViewById(R.id.register);
        register.setOnClickListener(v -> {
       String s_email = email.getText().toString();
       String s_password = password.getText().toString();

       String s_confirm = confirm.getText().toString();

      if(s_email.equals("") || s_password.equals("") || s_confirm.equals("")) {
          Toast.makeText(getApplicationContext(), "the fields are empty",Toast.LENGTH_LONG).show();
      }
     else{
          if(s_password.equals(s_confirm)) {
              boolean chkemail = db.chkemail(s_email);
              if(chkemail) {
                  boolean insert = db.insert(s_email,s_password);
                  if(insert) {
                      Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();

                  }
      }
              else {
                  Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_LONG).show();

              }
          Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_LONG).show();

      }
   }
   });

}}



