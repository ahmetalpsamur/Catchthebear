package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> userArrayList;
    EditText editYourName;
    TextView showName;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }







    public void changeStart(View view)
    {
        Intent intent = new Intent(MainActivity.this,Play.class);
        startActivity(intent);
    }
    public void changeScores(View view)
    {
        Intent intent = new Intent(MainActivity.this,Play.class);
        startActivity(intent);
    }

    public void exit(View view)
    {
        finish();
    }
}