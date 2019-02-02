package com.example.andjoklib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class JokyActivity extends AppCompatActivity {

    public static final String INTENT_JOKE ="joky" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joky);
        TextView textViewJoke = findViewById(R.id.jokText);
        String joke = getIntent().getStringExtra(INTENT_JOKE);
        Log.i("get Joke",joke);
        textViewJoke.setText(joke);
    }
}
