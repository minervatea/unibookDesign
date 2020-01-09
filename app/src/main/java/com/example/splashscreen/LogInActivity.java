package com.example.splashscreen;

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
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onSwipeLeft() {
        startActivity(new Intent(this, MainActivity.class));

    }

    public void logIn(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
