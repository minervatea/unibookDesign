package com.example.splashscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.sql.Time;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TimetableFragment(); //new TimetableFragment();

            case 1:
                return new CourseReview();  // This is going to be replaced with second fragment
            case 2:
                return new TimetableFragment();// This is going to be replaced with third fragment
            case 3:
                return new TimetableFragment();// This is going to be replaced with fourth fragment
            default:
                return null; // This should never happen. Always account for each position above.
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

   /* @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ""+position+1;
    } */
}
