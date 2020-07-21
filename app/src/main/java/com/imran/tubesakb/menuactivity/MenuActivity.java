package com.imran.tubesakb.menuactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.imran.tubesakb.R;
import com.imran.tubesakb.fragments.HomeFragment;
import com.imran.tubesakb.fragments.LookbookFragment;
import com.imran.tubesakb.fragments.ProfileFragment;
import com.imran.tubesakb.fragments.TipsTrickFragment;


public class MenuActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mBottomNavigation = findViewById(R.id.bottom_navigation);
        Menu mMenu = mBottomNavigation.getMenu();


        bottomItemClick();
        pindahFragment(new HomeFragment());
    }
    private void bottomItemClick(){
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment newFragment = null;
                switch (item.getItemId()){
                    case R.id.home_menu:{
                        newFragment = new HomeFragment();
                        break;
                    }
                    case R.id.lookbok_menu:{
                        newFragment = new LookbookFragment();
                        break;
                    }
                    case R.id.tusntrick_menu:{
                        newFragment = new TipsTrickFragment();
                        break;
                    }
                    case R.id.profile_menu:{
                        newFragment = new ProfileFragment();
                        break;
                    }
                }
                pindahFragment(newFragment);
                return true;
            }
        });
    }

    private void pindahFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}