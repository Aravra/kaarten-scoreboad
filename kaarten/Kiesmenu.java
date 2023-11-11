package com.example.kaarten;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Kiesmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiesmenu);
        setContentView(R.layout.kiesmenu);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });

    }
    public void Home(View view) {
        finish();
    }
    public void vierspelers(View view) {
        Intent i = new Intent(this, vierspelers.class);
        startActivity(i);
    }
    public void zesspelers(View view) {
        Intent i = new Intent(this, zesspelers.class);
        startActivity(i);
    }
    public void opgeslagen(View view) {
        Intent i = new Intent(this, opgeslagen.class);
        startActivity(i);
    }
}
