package com.example.firstprojectjob.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.firstprojectjob.R;
import com.example.firstprojectjob.fragments.FragmentPosts;
import com.example.firstprojectjob.fragments.free.FragmentFree;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fragment =  fm.findFragmentById(R.id.fragment_container);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list:
                            fragment = FragmentPosts.newInstance(true);
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                    case R.id.action_favorite:
                            fragment = FragmentPosts.newInstance(false);
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                    case R.id.action_free:
                            fragment = new FragmentFree();
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                }
                return false;
            }
        });
        if(savedInstanceState == null){
            bottomNavigationView.setSelectedItemId(R.id.action_free);
        }
    }

}
