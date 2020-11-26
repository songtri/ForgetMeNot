package com.example.forgetmenot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.forgetmenot_softwaredev.R;

public class FragmentPatientList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_patient_list, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listPatient);
        Button btnChat = (Button) rootView.findViewById(R.id.btnChat);
        Button btnDetailInfo = (Button) rootView.findViewById(R.id.btnDetailInfo);

        // Set List & Adapter
        AdapterPatientList adapter = new AdapterPatientList();
        listView.setAdapter(adapter);

        adapter.addItem(new ItemPatient("Test 1", "TestA","M", "25", "Nov 25, 2020"));
        adapter.addItem(new ItemPatient("Test 2", "TestB","F", "30", "Dec 20, 2020"));
        adapter.addItem(new ItemPatient("Test 3", "TestC","M", "50", "Nov 30, 2020"));
        adapter.addItem(new ItemPatient("Test 4", "TestD","F", "40", "Dec 10, 2020"));
        adapter.addItem(new ItemPatient("Test 5", "TestE","M", "15", "Dec 12, 2020"));

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDetailInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}