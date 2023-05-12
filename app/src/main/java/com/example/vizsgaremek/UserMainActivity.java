package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class UserMainActivity extends AppCompatActivity {

    private int nap_id = 0;

    public static ArrayList<Gyakorlat> gyakorlatList = new ArrayList<Gyakorlat>();
    private String BASE_URL = "http://10.0.2.2:3000/gyakorlatok/gyakorlatid/bynapid/";
    private Button kezdoButton, gyakorlottButton, rutinosButton;
    private int day;

    public void init() {
        kezdoButton = findViewById(R.id.kezdo);
        gyakorlottButton = findViewById(R.id.gyakorlott);
        rutinosButton = findViewById(R.id.rutinos);
        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        init();

        kezdoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (day) {
                    case Calendar.MONDAY:
                        nap_id = 1;
                        break;
                    case Calendar.TUESDAY:
                        nap_id = 2;
                        break;
                    case Calendar.WEDNESDAY:
                        nap_id = 3;
                        break;
                    case Calendar.THURSDAY:
                        nap_id = 4;
                        break;
                    case Calendar.FRIDAY:
                        nap_id = 5;
                        break;
                    case Calendar.SATURDAY:
                        nap_id = 6;
                        break;
                    case Calendar.SUNDAY:
                        nap_id = 7;
                        break;
                }
                Gson json = new Gson();
                RequestTask task = new RequestTask(BASE_URL+nap_id, "GET", json.toJson(nap_id));
                task.execute();
            }
        });

        gyakorlottButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (day) {
                    case Calendar.MONDAY:
                        nap_id = 8;
                        break;
                    case Calendar.TUESDAY:
                        nap_id = 9;
                        break;
                    case Calendar.WEDNESDAY:
                        nap_id = 10;
                        break;
                    case Calendar.THURSDAY:
                        nap_id = 11;
                        break;
                    case Calendar.FRIDAY:
                        nap_id = 12;
                        break;
                    case Calendar.SATURDAY:
                        nap_id = 13;
                        break;
                    case Calendar.SUNDAY:
                        nap_id = 14;
                        break;
                }
                Gson json = new Gson();
                RequestTask task = new RequestTask(BASE_URL, "GET", json.toJson(nap_id));
                task.execute();
            }
        });


        rutinosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (day) {
                    case Calendar.MONDAY:
                        nap_id = 15;
                        break;
                    case Calendar.TUESDAY:
                        nap_id = 16;
                        break;
                    case Calendar.WEDNESDAY:
                        nap_id = 17;
                        break;
                    case Calendar.THURSDAY:
                        nap_id = 18;
                        break;
                    case Calendar.FRIDAY:
                        nap_id = 19;
                        break;
                    case Calendar.SATURDAY:
                        nap_id = 20;
                        break;
                    case Calendar.SUNDAY:
                        nap_id = 21;
                        break;
                }
                Gson json = new Gson();
                RequestTask task = new RequestTask(BASE_URL, "GET", json.toJson(nap_id));
                task.execute();
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
                    switch (requestType){
                        case "GET":
                            response = RequestHandler.get(requesrtUrl, null);
                            break;
                    }
                }catch (IOException e) {
                    Toast.makeText(UserMainActivity.this,
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
                Gson converter = new Gson();
                if (!(response.getResponseCode() == 200)){
                    Toast.makeText(UserMainActivity.this, "Erre a napra nincs edzés", Toast.LENGTH_SHORT).show();
                    return;
                }
                switch (requestType) {
                    case "GET":
                        Log.d("TAG", "onPostExecute: " +response.getContent());
                        Gyakorlat[] gyakorlat = converter.fromJson(response.getContent(), Gyakorlat[].class);
                        gyakorlatList.clear();
                        gyakorlatList.addAll(Arrays.asList(gyakorlat));
                        for (Gyakorlat gyak : gyakorlatList
                             ) {
                            Log.d("gyakorlat" , "onPostExecute: " +gyak.getName());

                        }
                        Intent exercisepgae = new Intent(UserMainActivity.this, UserExerciseActivity.class);
                        Bundle bundle = new Bundle();
                        System.out.println(gyakorlatList.size());
                        bundle.putParcelableArrayList("gyakorlatList", gyakorlatList);
                        exercisepgae.putExtras(bundle);
                        startActivity(exercisepgae);
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