package com.example.forgetmenot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.forgetmenot_softwaredev.R;

import java.util.ArrayList;

public class AdapterPatientList extends BaseAdapter {
    Context context;
    ArrayList<ItemPatient> items = new ArrayList<ItemPatient>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        int pos = position;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_patient, parent, false);
        }

        TextView textName = (TextView)convertView.findViewById(R.id.textName);
        TextView textAgeSex = (TextView)convertView.findViewById(R.id.textAgeSex);
        TextView textAppointDate = (TextView)convertView.findViewById(R.id.textAppointDate);

        ItemPatient item = items.get(pos);
        textName.setText(String.format("%s", item.getId()));
        textAgeSex.setText(String.format("%s (%s)", item.getAge(), item.getGender()));
        textAppointDate.setText(String.format("%s", item.getDate()));

        return convertView;
    }

    public void addItem(ItemPatient item) {
        items.add(item);
    }
}
