package com.example.forgetmenot;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.forgetmenot_softwaredev.R;

public class ActivityLogin  extends AppCompatActivity {
    Button btnLogIn;
    RadioGroup radioGroupRole;
    RadioButton rbtnPatient, rbtnDoctor, rbtnCareTaker;
    String rBtnRole;
    EditText textEmail, textPassword;
    LinearLayout linearLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Change ActionBar's title
        //getSupportActionBar().setTitle("Login");

        // Instantiate
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        radioGroupRole = (RadioGroup) findViewById(R.id.radioGroup);
        rbtnPatient = (RadioButton) findViewById(R.id.RBtnPatient);
        rbtnDoctor = (RadioButton) findViewById(R.id.RBtnDoctor);
        rbtnCareTaker = (RadioButton) findViewById(R.id.RBtnCareTaker);
        textEmail = (EditText) findViewById(R.id.TextEmail);
        textPassword = (EditText) findViewById(R.id.TextPassword);

        // Set actionBar
        toolbar = (Toolbar) findViewById(R.id.LoginToolbar);
        setSupportActionBar(toolbar);

        //NavController navigation = Navigation.findNavController(this)
        // Change ActionBar's title
        getSupportActionBar().setTitle("Log In");
        // Display home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Check : data is correct or not
        textEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    String inputEmail = s.toString();

                    // Compare to data from DB
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        radioGroupRole.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.RBtnPatient)
                    rBtnRole = "Patient";
                else if(checkedId == R.id.RBtnDoctor)
                    rBtnRole = "Doctor";
                else if(checkedId == R.id.RBtnCareTaker)
                    rBtnRole = "CareTaker";
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("role", rBtnRole);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
