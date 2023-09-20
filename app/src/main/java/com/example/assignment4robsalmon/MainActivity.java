/**
 * Robert Salmon, Dylan Sperry
 * Assignment 4
 */
package com.example.assignment4robsalmon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener,
        MoodFragment.MoodFragmentListener, ProfileFragment.ProfileFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new MainFragment(), "mainFrag")
                .commit();

    }

    @Override
    public void goToMood() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new MoodFragment(), "moodFragment")
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void goToProfile(Profile profile) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ProfileFragment.newInstance(profile))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendMood(int mood) {
        MainFragment fragment = (MainFragment) getSupportFragmentManager()
                .findFragmentByTag("mainFrag");

        if(fragment != null){
            fragment.setMood(mood);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelMood() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelProfile() {
        getSupportFragmentManager().popBackStack();
    }
}