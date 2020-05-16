package com.bracedu.sst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.bracedu.sst.fragment.HomeMainFragment;
import com.bracedu.sst.fragment.NotificationMainFragment;
import com.bracedu.sst.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        final HomeMainFragment homeMainFragment = new HomeMainFragment();

        fragmentTransaction.add(R.id.fragmentContainer, homeMainFragment);
        fragmentTransaction.commit();
         bottomNavigationView = findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {Log.i(TAG, "Selected Item is: "+ menuItem.getTitle());
            Fragment fragment = null;
            switch (menuItem.getItemId()){
                case R.id.bottomNavHome:
                    fragment = new HomeMainFragment();
                    break;
                case R.id.bottomNavNotification:
                    fragment = new NotificationMainFragment();
                    break;
                case R.id.bottomNavProfile:
                    fragment = new ProfileFragment();
                    break;
            }
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.fragmentContainer,fragment);
            fragmentTransaction.commit();
            return true;
        }
    };
}
