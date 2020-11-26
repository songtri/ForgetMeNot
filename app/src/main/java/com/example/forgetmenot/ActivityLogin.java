package com.example.forgetmenot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.forgetmenot_softwaredev.R;

public class ActivityLogin  extends AppCompatActivity {
    Button btnLogIn;
    EditText textEmail, textPassword;
    LinearLayout linearLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Change ActionBar's title
        //getSupportActionBar().setTitle("Login");

        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        textEmail = (EditText) findViewById(R.id.TextEmail);
        textPassword = (EditText) findViewById(R.id.TextPassword);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout_login);

        // Set actionBar
        toolbar = (Toolbar) findViewById(R.id.LoginToolbar);
        setSupportActionBar(toolbar);

        //NavController navigation = Navigation.findNavController(this)
        // Change ActionBar's title
        getSupportActionBar().setTitle("Log In");
        // Display home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
