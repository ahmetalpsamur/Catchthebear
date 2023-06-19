package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class Play extends AppCompatActivity {
    Button buttonAdd;
    TextView textScore;
    int score;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);
        buttonAdd = findViewById(R.id.buttonAdd);
        textScore = findViewById(R.id.textScore);

    }
    public void addScore(View view)
    {


    }

}