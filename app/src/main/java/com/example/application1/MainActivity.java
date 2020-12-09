package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView WarningLogin, WarningPassword, Sucsses;
    Button vhod;
    EditText login, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vhod = findViewById(R.id.vhod);
        this.WarningLogin = findViewById(R.id.WarningLogin);
        this.WarningPassword = findViewById(R.id.WarningPassword);
        this.Sucsses = findViewById(R.id.Sucsseful);
        this.login = findViewById(R.id.Login);
        this.pass = findViewById(R.id.Password);
        vhod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String l = login.getText().toString();
        String p = pass.getText().toString();
        boolean loginTrue = false;
        boolean passwordTrue = false;

        if(l == "Admin")
        {
            WarningLogin.setVisibility(View.INVISIBLE);
            loginTrue = true;
        }
        else
        {
            WarningLogin.setVisibility(View.VISIBLE);
            Sucsses.setVisibility(View.INVISIBLE);
            loginTrue = false;
        }
        if(p == "Test")
        {
            passwordTrue = true;
            WarningPassword.setVisibility(View.INVISIBLE);
        }
        else
        {
            passwordTrue = false;
            WarningPassword.setVisibility(View.VISIBLE);
            Sucsses.setVisibility(View.INVISIBLE);
        }

        if(loginTrue && passwordTrue)
        {
            Sucsses.setVisibility(View.VISIBLE);
        }
        else
        {
            Sucsses.setVisibility(View.INVISIBLE);
        }
    }
}