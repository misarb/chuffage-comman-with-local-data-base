package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomePage extends AppCompatActivity {
Button EconomyBtn,confortbtn,confortplusbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat(" hh:mm");
        String Datetime=simpleDateFormat.format(calendar.getTime());
        String heure=simpleDateFormat1.format(calendar.getTime());
        String newLine = System.getProperty("line.separator");
        TextView textViewDate=findViewById(R.id.text_view_date);
        textViewDate.setText(Datetime+newLine+heure);
        EconomyBtn = (Button) findViewById(R.id.EconomyBtn);
        confortbtn = (Button) findViewById(R.id.btnconfort);
        confortplusbtn = (Button) findViewById(R.id.btnconfortplus);
        confortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });
        confortplusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });
        EconomyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });

    }

}