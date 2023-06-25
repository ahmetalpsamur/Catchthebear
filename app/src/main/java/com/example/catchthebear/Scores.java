package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Scores extends AppCompatActivity {
    TextView textViewUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        textViewUsers = findViewById(R.id.textViewUsers);
        ArrayList<User> userArrayList = loadUser();

        if (userArrayList != null && !userArrayList.isEmpty()) {
            StringBuilder names = new StringBuilder();
            for (User user : userArrayList) {
                names.append(user.getName()).append("\n");
            }
            textViewUsers.setText(names.toString());
        } else {
            textViewUsers.setText("No users found.");
        }
    }

    private ArrayList<User> loadUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.catchthebear", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("usersData", null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
