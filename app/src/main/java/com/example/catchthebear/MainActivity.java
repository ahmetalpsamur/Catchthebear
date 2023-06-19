package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button buttonPlay;
    ArrayList<User> userArrayList;
    EditText editYourName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editYourName= findViewById(R.id.editYourName);
        ArrayList<User> userArrayList = new ArrayList<User>();
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
    public void addUser(View view)
    {

    }
    public void exit(View view)
    {
        finish();
    }
}