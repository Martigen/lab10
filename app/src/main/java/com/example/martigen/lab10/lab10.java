package com.example.martigen.lab10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class lab10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab10);
    }

    public void zad1(View v){
        Intent intent = new Intent(this, zad1.class);
        startActivity(intent);

    }

    public void zad3(View v){
        Intent intent = new Intent(this, zad3.class);
        startActivity(intent);

    }

}
