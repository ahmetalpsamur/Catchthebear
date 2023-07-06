package com.example.catchthebear;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity {
    Button saveButton;
    int score;
    String name;
    TextView showText;
    EditText editYourName;
    TableRow tableRow;
    ArrayList<User> userArrayList;
    User user;
    TextView textViewScore;
    TextView textViewTime;
    LinearLayout linearLayout;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;

    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;
    ImageView imageView20;

    ImageView[]imageArray;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);
        showText = findViewById(R.id.showText1);
        editYourName = findViewById(R.id.editYourName);
        saveButton = findViewById(R.id.saveButton1);
        textViewTime = findViewById(R.id.textViewTime);
        textViewScore = findViewById(R.id.textViewScore);

        tableRow = findViewById(R.id.tableRow);
        linearLayout = findViewById(R.id.linearLayoutEnter);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView19 = findViewById(R.id.imageView19);
        imageView20 = findViewById(R.id.imageView20);

        imageArray = new ImageView[] {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,imageView20};


        loadUser();



    }
    public void showUser(View view)
    {
        String name = editYourName.getText().toString().trim();
        this.name = name;
        if (!name.isEmpty()) {
            User user = new User(name, 0);
            this.user=user;
            userArrayList.add(user);
            showText.setText(user.getName());
            saveUser(); // Save user data to SharedPreferences
            playGame();
        }
    }

    public void saveUser()
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.catchthebear",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(userArrayList);
        sharedPreferences.edit().putString("usersData",json).apply();
        Intent intent = new Intent(Play.this,MainActivity.class);

        intent.putExtra("userArray",userArrayList);


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
    public void playGame()
    {
        linearLayout.setVisibility(View.GONE);
        textViewScore.setVisibility(View.VISIBLE);
        textViewTime.setVisibility(View.VISIBLE);
        tableRow.setVisibility(View.VISIBLE);

        playStage1();


    }

    public void playStage1()
    {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView imageView : imageArray)
                {
                    imageView.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(19);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);

        new CountDownTimer(10000,1000)
        {

            @Override
            public void onTick(long l) {
                textViewTime.setText("Time:"+l/1000);
            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                for (ImageView imageView : imageArray)
                {
                    imageView.setVisibility(View.INVISIBLE);
                }


            }
        }.start();

    }




    public void addScore(View view)
    {
        score++;
        textViewScore.setText("SCORE:"+score);
    }

}