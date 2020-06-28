package com.coolab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

public class BottomNavigationView extends AppCompatActivity implements com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        loadFragment(new FragmentHome());

        com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener((com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener) this);


    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new FragmentHome();
                break;
            case R.id.navigation_events:
                fragment = new EventFragment();
                break;
            case R.id.navigation_feed:
                fragment = new FeedFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;


        }

        return loadFragment(fragment);
    }
}