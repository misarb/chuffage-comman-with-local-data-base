package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Automatic extends AppCompatActivity {
Button heb;
Button Pray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy ");
        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat(" hh:mm");
        String Datetime=simpleDateFormat.format(calendar.getTime());
        String heure=simpleDateFormat1.format(calendar.getTime());
        String newLine = System.getProperty("line.separator");
        TextView textViewDate=findViewById(R.id.text_view_date);
        textViewDate.setText(Datetime+newLine+heure);

        heb=(Button)findViewById(R.id.Hebdomadaire);
        Pray=(Button)findViewById(R.id.prayer);

        heb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),hebdomadair.class);
                startActivity(intent);

            }
        });
        Pray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Prayer.class);
                startActivity(intent);

            }
        });

    }

}