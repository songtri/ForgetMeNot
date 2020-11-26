package com.example.forgetmenot;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import com.example.forgetmenot_softwaredev.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new PatientFragment(), "Patient");
        adapter.addFragment(new DoctorFragment(), "Doctor");
        adapter.addFragment(new CareTakerFragment(), "Care Taker");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(0xff234233);

        // Set actionBar
        toolbar = (Toolbar) findViewById(R.id.topToolbar);
        setSupportActionBar(toolbar);
        // Change ActionBar's title
        getSupportActionBar().setTitle("ForgetMeNot");
        // Display home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Received the data from ActivityLogin
        Bundle bundle = getIntent().getExtras();
        AfterLogin(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    // When click an action button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.home:
                return true;
            case R.id.action_search:
                Toast.makeText(this, "Search Icon Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_setting:
                Toast.makeText(this, "Setting Icon Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public void AfterLogin(Bundle bundle) {
        if(bundle != null) {
            String email = bundle.getString("email");
            String password = bundle.getString("password");
            String role = bundle.getString("role");

            if(email != null && password != null) {
                //getSupportActionBar().setTitle("Test, Success Login");
                String testResult = String.format("%s : %s : %s", email, password, role);
                Toast.makeText(this, testResult, Toast.LENGTH_SHORT).show();
            }
        }
    }
}