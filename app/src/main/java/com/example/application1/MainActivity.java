package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView WarningLogin, WarningPassword, Sucsses;
    Button vhod;
    EditText login, pass;
    String Login = "none";
    String Password = "admin";
    SharedPreferences.Editor ed;
    SharedPreferences info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = getSharedPreferences("pref", Context.MODE_PRIVATE);
        ed = info.edit();
        ed.putString("login", Login);
        ed.putString("password", Password);
        ed.apply();
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
        String p = login.getText().toString();
        if ((l.equals(info.getString("login", "none"))) && (p.equals(info.getString("login", "none"))))
            Sucsses.setVisibility(View.VISIBLE);
        else {
            Intent i = new Intent(this, Registration.class);
            startActivityForResult(i, 1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                Login = data.getStringExtra("login");
                Password = data.getStringExtra("password");
                ed.clear();
                ed.putString("login", Login);
                ed.putString("password", Password);
                ed.apply();
                login.setText(Login);
                Sucsses.setVisibility(View.INVISIBLE);
                pass.setText("");
                break;
        }
    }
}