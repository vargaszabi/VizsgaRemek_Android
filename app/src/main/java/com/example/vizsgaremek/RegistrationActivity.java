package com.example.vizsgaremek;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

public class RegistrationActivity extends AppCompatActivity {

    private EditText usernameTxt, emailTxt, passwordTxt, passwordagainTxt;
    private Button registrationButton, backButton;
    private String BASE_URL="http://10.0.2.2:3000/auth/register";

    public void init(){
        usernameTxt = findViewById(R.id.felhszanaloNev);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.jelszo);
        passwordagainTxt = findViewById(R.id.jelszoUjra);
        registrationButton = findViewById(R.id.regisztralas);
        backButton = findViewById(R.id.back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTxt.getText().toString().trim();
                String email = emailTxt.getText().toString().trim();
                String password = passwordTxt.getText().toString().trim();
                String passwordAgain = passwordagainTxt.getText().toString().trim();
                if (username.isEmpty()){
                    usernameTxt.setError("Nem lehet üres");
                    return;
                } else {
                    usernameTxt.setError(null);
                }
                if (email.isEmpty()){
                    emailTxt.setError("Nem lehet üres");
                    return;
                } else {
                    emailTxt.setError(null);
                }
                if (password.isEmpty()){
                    passwordTxt.setError("Nem lehet üres");
                    return;
                } else {
                    passwordTxt.setError(null);
                }
                if (passwordAgain.isEmpty()){
                    passwordagainTxt.setError("Nem lehet üres");
                    return;
                } else {
                    passwordagainTxt.setError(null);
                }
                if (!password.equals(passwordAgain)){
                    passwordagainTxt.setError("A jelszó nem egyezik!");
                    return;
                } else {
                    passwordagainTxt.setError(null);
                }
                Gson json = new Gson();
                Users newUser = new Users(username, email, password, passwordAgain);
                RequestTask task = new RequestTask(BASE_URL, "POST", json.toJson(newUser));
                task.execute();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginpage = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(loginpage);
            }
        });
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
                    case "GET":
                        response = RequestHandler.get(requesrtUrl);
                        break;
                    case "POST":
                        response = RequestHandler.post(requesrtUrl, requestParams);
                        break;
                    case "PUT":
                        response = RequestHandler.put(requesrtUrl,requestParams);
                        break;
                    case "DELETE":
                        response = RequestHandler.delete(requesrtUrl + "/" + requestParams);
                        break;
                }
            } catch (IOException e){
                Toast.makeText(RegistrationActivity.this,
                        e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Response response){
            super.onPostExecute(response);
            if (response.getResponseCode() >= 400) {
                Toast.makeText(RegistrationActivity.this,
                        response.getContent(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RegistrationActivity.this,
                       "Sikeres Regisztráció", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            switch (requestType) {
                case "GET":

                    break;
                case "POST":

                    break;
                case "PUT":

                    break;
                case "DELETE":

                    break;
            }
        }
    }
}