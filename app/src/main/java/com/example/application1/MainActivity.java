package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    Button calk;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.calk = findViewById(R.id.calk);
        this.text = findViewById(R.id.otvet);
        this.ed1 = findViewById(R.id.ch1);
        this.ed2 = findViewById(R.id.ch2);
        this.ed3 = findViewById(R.id.ch3);
        calk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String t1 = ed1.getText().toString();
        String t2 = ed2.getText().toString();
        String t3 = ed3.getText().toString();
        int a = Integer.parseInt(t1);
        int b = Integer.parseInt(t2);
        int c = Integer.parseInt(t3);
        if(a==0)
        {
            text.setText("error");
        }
        double D = b*b - 4*a*c;
        if(D<0)
        {
            text.setText("error");
        }
        double x1 = ((-b+Math.sqrt(D))/(2*a));
        double x2 = ((-b+Math.sqrt(D))/(2*a));
        if(D==0)
        {
            text.setText(String.valueOf((x1)));
        }
        else if (D>0)
        {
            text.setText(String.format("%f.2 %f.2",x1,x2));
        }
        text.setText(String.valueOf(a));
    }
}