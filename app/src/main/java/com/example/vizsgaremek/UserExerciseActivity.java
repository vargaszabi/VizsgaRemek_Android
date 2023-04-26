package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UserExerciseActivity extends AppCompatActivity {

    private String viedo_URL= "";
    private String BASE_URL = "";
    private View desc;
    private Button nextButton;

    public void init(){
        nextButton = findViewById(R.id.nextgyak);
        desc = findViewById(R.id.leiras);
        List excerciseList= new ArrayList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_exercise);
        init();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc;
                Intent reloadpage = new Intent(UserExerciseActivity.this, UserExerciseActivity.class);
                startActivity(reloadpage);
            }
        });
    }
}