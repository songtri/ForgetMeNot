package com.example.forgetmenot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.forgetmenot_softwaredev.R;

public class CareTakerFragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_care_taker, container, false);
        Button register = view.findViewById(R.id.btn_caretaker_register_patient);
        register.setOnClickListener(this);
        Button update = view.findViewById(R.id.btn_caretaker_update_patient_info);
        update.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_caretaker_register_patient:
                Toast.makeText(getContext(), "RegisterPatient Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_caretaker_update_patient_info:
                Toast.makeText(getContext(), "UpdatePatientInfo Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
