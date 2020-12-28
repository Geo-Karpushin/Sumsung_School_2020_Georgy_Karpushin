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

public class Registration extends AppCompatActivity implements View.OnClickListener {
    Button reg;
    EditText login, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.reg = findViewById(R.id.regin);
        this.login = findViewById(R.id.regLogin);
        this.pass = findViewById(R.id.regPassword);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String l = login.getText().toString();
        String p = login.getText().toString();
        Intent i = new Intent();
        i.putExtra("login", l);
        i.putExtra("password", p);
        setResult(RESULT_OK, i);
        finish();
    }
}