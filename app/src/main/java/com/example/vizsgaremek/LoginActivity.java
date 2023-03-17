package com.example.vizsgaremek;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private EditText emailTxt, passwordTxt;
    private Button registrationButton, loginButton;
    private String BASE_URL = "http://10.0.2.2:3000/auth/login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrationpage = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registrationpage);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailTxt.getText().toString().trim();
                String password = passwordTxt.getText().toString().trim();
                Gson json = new Gson();

                LoginGetSet logindata = new LoginGetSet(email, password);
                //Toast.makeText(LoginActivity.this, json.toJson(logindata), Toast.LENGTH_SHORT).show();
                RequestTask task = new RequestTask(BASE_URL, "POST", json.toJson(logindata));
                task.execute();
            }
        });
    }

    public void init() {
        loginButton = findViewById(R.id.bejelentkezes);
        registrationButton = findViewById(R.id.regisztracio);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.jelszo);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private class RequestTask extends AsyncTask<Void, Void, Response> {
        String requesrtUrl;
        String requestType;
        String requestParams;

        public RequestTask(String requesrtUrl, String requestType, String requestParams) {
            this.requesrtUrl = requesrtUrl;
            this.requestType = requestType;
            this.requestParams = requestParams;
        }

        public RequestTask(String requesrtUrl, String requestType) {
            this.requesrtUrl = requesrtUrl;
            this.requestType = requestType;
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                switch (requestType) {
                    case "POST":
                        response = RequestHandler.post(requesrtUrl, requestParams, null);
                        break;
                }
            } catch (IOException e) {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            Gson converter = new Gson();

            if (response.getResponseCode() >= 400) {
                Toast.makeText(LoginActivity.this, response.getContent(), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(LoginActivity.this, "Siekeres Bejelentkezés", Toast.LENGTH_SHORT).show();
                Intent mainpage = new Intent(LoginActivity.this, UserMainActivity.class);
                startActivity(mainpage);
                finish();
            }
            switch (requestType) {
                case "GET":
                    break;
                case "POST":
                    Token token = converter.fromJson(response.getContent(), Token.class);
                    SharedPreferences sharedPreferences = getSharedPreferences("Important", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", token.getToken());
                    editor.commit();

                    break;
                case "PUT":
                    break;
                case "DELETE":
                    break;
            }
        }
    }
}