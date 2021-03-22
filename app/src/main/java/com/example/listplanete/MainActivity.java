package com.example.listplanete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    PlaneteAdapter adapter;

    public Context context;

    Button verifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.initialize();
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);



        this.context = getApplicationContext();

        adapter = new PlaneteAdapter(this);
        listview.setAdapter(adapter);

        verifier = (Button) findViewById(R.id.verifier);
        verifier.setOnClickListener(verifierListener);
    }

    private View.OnClickListener verifierListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            View item;
            int bonneRep = 0;
            for(int i = 0; i < adapter.getCount(); i++){
                item = (View) adapter.getItem(i);
                TextView nomPlanete = (TextView) item.findViewById(R.id.textView);
                final CheckBox checkBox = (CheckBox) item.findViewById(R.id.checkbox);
                final Spinner spinner = (Spinner) item.findViewById(R.id.spinner);
                if(checkBox.isChecked() && spinner.getSelectedItemPosition() == i){
                    bonneRep++;
                }
            }

            Toast.makeText(MainActivity.this, "Vous avez "+bonneRep+" bonnes réponse", Toast.LENGTH_SHORT).show();

        }
    };


}