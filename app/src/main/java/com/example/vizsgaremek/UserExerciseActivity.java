package com.example.vizsgaremek;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class UserExerciseActivity extends AppCompatActivity {

    ListView gyakorlatList;
    String descriptionList[] = {"Bicepsz karhajlítás állva kézi súlyzóval",
    "Kalapács bicepsz karhajlítás",
    "Bicepszhajlítás rúddal"};

    private ListView listViewGyakorlat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_exercise);
        gyakorlatList = findViewById(R.id.gyakorlatView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_user_exercise, descriptionList);
        gyakorlatList.setAdapter(arrayAdapter);
    }
}