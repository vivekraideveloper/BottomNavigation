package com.vijayjaidewan01vivekrai.bottomnavigation_github;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private MoneyFragment moneyFragment;
    private PrivacyFragment privacyFragment;
    private DateFragment dateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frame_layout);

        moneyFragment = new MoneyFragment();
        privacyFragment = new PrivacyFragment();
        dateFragment = new DateFragment();

        FragmentManager fm = getSupportFragmentManager();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.privacy:
                        setFragment(privacyFragment);
                        item.setChecked(true);
                        item.setEnabled(true);
//                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        return true;
                    case R.id.money:
                        setFragment(moneyFragment);
                        item.setChecked(true);
                        item.setEnabled(true);
//                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        break;
                    case R.id.date:
                        setFragment(dateFragment);
                        item.setChecked(true);
                        item.setEnabled(true);
//                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        break;
                }
                return false;
            }
        });



    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack("");
        ft.commit();
    }
}
