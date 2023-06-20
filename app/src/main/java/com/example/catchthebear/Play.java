package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

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

public class Play extends AppCompatActivity {
    Button buttonAdd;
    TextView textScore;
    int score;
    TextView showText;
    EditText editYourName;
    ArrayList<User> userArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);
        buttonAdd = findViewById(R.id.buttonAdd);
        textScore = findViewById(R.id.textScore);

        showText = findViewById(R.id.showText1);
        editYourName = findViewById(R.id.editYourName);

        loadUser();

    }
    public void addScore(View view)
    {


    }
    public void showUser(View view)
    {
        String name = editYourName.getText().toString().trim();
        if (!name.isEmpty()) {
            User user = new User(name, 0);
            userArrayList.add(user);
            saveUser(); // Save user data to SharedPreferences
        }

        StringBuilder names = new StringBuilder();
        for (User user : userArrayList) {
            names.append(user.getName()).append("\n");
        }
        showText.setText(names.toString());

    }
    public void saveUser()
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.catchthebear",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(userArrayList);
        sharedPreferences.edit().putString("usersData",json).apply();


    }
    public void loadUser()
    {

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.catchthebear",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("usersData",null);

        Type type = new TypeToken<ArrayList<User>>(){}.getType();
        userArrayList = gson.fromJson(json,type);
        if (userArrayList == null)
        {
            userArrayList= new ArrayList<>();
        }
    }


}