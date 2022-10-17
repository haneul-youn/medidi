package com.example.medicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuMediCalendarFragment fragmentCalendar = new MainMenuMediCalendarFragment();
    private MainMenuMediBookmark fragmentBookmark = new MainMenuMediBookmark();
    private MainMenuMediAddFragment fragmentAdd = new MainMenuMediAddFragment();
    private MainMenuMediChartFragment fragmentChart = new MainMenuMediChartFragment();
    private MainMenuSettingFragment fragmentSetting = new MainMenuSettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Fragment 관련련
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout,fragmentCalendar).commitNowAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView_userMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()){
                case R.id.page_home:
                    transaction.replace(R.id.menu_frame_layout,fragmentCalendar).commitNowAllowingStateLoss();
                    break;
                case R.id.page_bookmark:
                    transaction.replace(R.id.menu_frame_layout,fragmentBookmark).commitNowAllowingStateLoss();
                    break;
                case R.id.page_medilist:
                    transaction.replace(R.id.menu_frame_layout,fragmentAdd).commitNowAllowingStateLoss();
                    break;
                case R.id.page_chart:
                    transaction.replace(R.id.menu_frame_layout,fragmentChart).commitAllowingStateLoss();
                    break;
                case R.id.page_setting:
                    transaction.replace(R.id.menu_frame_layout,fragmentSetting).commitNowAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

}