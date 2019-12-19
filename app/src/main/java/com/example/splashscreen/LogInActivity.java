package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends SwipeAdapter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

    }

    @Override
    protected void onSwipeRight() {
        startActivity(new Intent(this, TimeTable.class));
    }

    @Override
    protected void onSwipeLeft() {

    }

    public void logIn(View v){
        Intent intent = new Intent(this, TimeTable.class);
        startActivity(intent);
    }
}
