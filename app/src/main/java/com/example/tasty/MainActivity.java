package com.example.tasty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SearchFragment searchFragment;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchFragment = new SearchFragment();
        homeFragment = new HomeFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setFragment(searchFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.page_1:
                    setFragment(searchFragment);
                    return true;
                case R.id.page_2:
                    setFragment(homeFragment);
                    return true;
            }
            return false;
        }
    };

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment, fragment)
                .commit();
    }
}