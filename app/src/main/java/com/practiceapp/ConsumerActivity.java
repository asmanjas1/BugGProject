package com.practiceapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.common_fragments.ContactUsFragment;
import com.consumer_fragments.ConsumerOneFragment;
import com.consumer_fragments.ConsumerThreeFragment;
import com.consumer_fragments.ConsumerTwoFragment;

public class ConsumerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation_consumer);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = ConsumerOneFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = ConsumerTwoFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = ConsumerThreeFragment.newInstance();
                                break;
                            case R.id.action_item4:
                                selectedFragment = ContactUsFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout_consumer, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_consumer, ConsumerOneFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
