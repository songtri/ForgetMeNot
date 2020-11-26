package com.example.forgetmenot;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.forgetmenot.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        adapter = new TabAdapter(getSupportFragmentManager());

        adapter.addFragment(new Tab1Fragment(), "Tab 1");
        //adapter.addFragment(new Tab2Fragment(), "Tab 2");
        //adapter.addFragment(new Tab3Fragment(), "Tab 3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        }
        else {
            // otherwise, select the previous step
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}