package com.example.listplanete;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    CardView login_btn;
    EditText userName;
    EditText password;

    int tentative = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        login_btn = (CardView) findViewById(R.id.login);

        login_btn.setOnClickListener(login_btnListener);
    }

    private View.OnClickListener login_btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            tentative++;
            if(!String.valueOf(userName.getText()).equals("test") && !String.valueOf(password.getText()).equals("test")) {
                Toast.makeText(Login.this, "le mot de passe ou le pseudo est mauvais "+String.valueOf(userName.getText())+" "+String.valueOf(password.getText()), Toast.LENGTH_SHORT).show();
            }
            else{
                data.auth = true;
                startActivity(new Intent(Login.this, MainActivity.class));
            }

            if(tentative >= 3){
                data.auth = true;
                startActivity(new Intent(Login.this, MainActivity.class));
            }

        }
    };
}