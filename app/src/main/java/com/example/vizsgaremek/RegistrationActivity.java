package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText usernameTxt, emailTxt, passwordTxt, passwordagainTxt;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameTxt = findViewById(R.id.felhszanaloNev);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.jelszo);
        passwordagainTxt = findViewById(R.id.jelszoUjra);
        registrationButton = findViewById(R.id.regisztralas);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String passwordAgain = passwordagainTxt.getText().toString();
                Intent loginpage = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(loginpage);
            }
        });
    }
}