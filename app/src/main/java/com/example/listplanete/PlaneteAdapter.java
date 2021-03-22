package com.example.listplanete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaneteAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private ArrayList<View> vue = new ArrayList<View>();

    public PlaneteAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return data.planets.size();
    }

    @Override
    public Object getItem(int position) {
        return vue.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mainActivity.context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(data.planets.get(position).nom);


        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, data.taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                }
            }
        });

        vue.add(itemView);

        return itemView;
    }
}
