package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMainActivity extends AppCompatActivity {

    private Button kezdoButton, gyakorlottButton, rutinosButton;

    public void init() {
        kezdoButton = findViewById(R.id.kezdo);
        gyakorlottButton = findViewById(R.id.gyakorlott);
        rutinosButton = findViewById(R.id.rutinos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        init();

        kezdoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exercisepgae = new Intent(UserMainActivity.this, UserExerciseActivity.class);
                startActivity(exercisepgae);
            }
        });

        gyakorlottButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exercisepgae = new Intent(UserMainActivity.this, UserExerciseActivity.class);
                startActivity(exercisepgae);
            }
        });

        rutinosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exercisepgae = new Intent(UserMainActivity.this, UserExerciseActivity.class);
                startActivity(exercisepgae);
            }
        });
    }
}