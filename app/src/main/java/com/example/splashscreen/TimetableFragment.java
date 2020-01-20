package com.example.splashscreen;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimetableFragment extends Fragment /*implements View.OnClickListener */{


    private TextView textView;
    public static String PACKAGE_NAME;
    public TimetableFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_timetable, container, false);
        PACKAGE_NAME = getContext().getPackageName();
        return v;
    }

/*
    @Override
    public void onClick(View view) {
        switch(view.getId()){
        case R.id.createTable:
            Intent n = new Intent();
            n.setClassName(PACKAGE_NAME, CourseReview.class.toString());
            startActivity(n);

        break;
    }
}*/
}
