package com.mdw31g5.loginandregistersqlite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText textPersonLogin,textPassword;
    DatabaseHelper db;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db= new DatabaseHelper(this);
        textPersonLogin =  findViewById(R.id.textPersonLogin);
        textPassword = findViewById(R.id.textPassword);
        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            String email= textPersonLogin.getText().toString();
            String password=textPassword .getText().toString();
            Boolean Chkemailpass = db.emailpassword(email,password);
            if(Chkemailpass)
                Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_LONG).show();

        });
    }
}


