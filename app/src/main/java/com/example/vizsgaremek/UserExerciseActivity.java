package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class UserExerciseActivity extends AppCompatActivity {

    private TextView excerciseName, description;
    private MaterialButton nextButton;
    public ArrayList<Gyakorlat> gyakorlatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_exercise);
        Bundle bundle = getIntent().getExtras();
        gyakorlatList = bundle.getParcelableArrayList("gyakorlatList");
        init();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(gyakorlatList.size());
                if (!gyakorlatList.isEmpty()){
                    System.out.println(gyakorlatList.size());
                    excerciseName.setText(gyakorlatList.get(0).getName());
                    description.setText(gyakorlatList.get(0).getDescription());
                    gyakorlatList.remove(0);
                    System.out.println(gyakorlatList.size());
                }
                else {
                    Toast.makeText(UserExerciseActivity.this, "A gyakorlat véget ért.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserExerciseActivity.this, UserMainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void init() {
        nextButton = findViewById(R.id.nextButton);
        excerciseName = findViewById(R.id.excerciseName);
        description = findViewById(R.id.description);
        excerciseName.setText(gyakorlatList.get(0).getName());
        description.setText(gyakorlatList.get(0).getDescription());
        gyakorlatList.remove(0);
    }
}