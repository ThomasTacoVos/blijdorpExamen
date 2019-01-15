package com.example.thomasvos.blijdorp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void startRouteActivity(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("ROUTE", 1);
        startActivity(intent);
    }

    public void startRoute2Activity(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("ROUTE", 2);
        startActivity(intent);
    }

    public void startMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
