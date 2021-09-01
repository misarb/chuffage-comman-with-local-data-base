package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConfigurationActivity extends AppCompatActivity {
    Button ManualleBtn;
    Button AutomaticBtn;
    Dialog myManualleConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ManualleBtn = (Button)findViewById(R.id.BtnManualleConfig);
        AutomaticBtn = (Button)findViewById(R.id.BtnMAutomaticConfig);
        myManualleConfig=new Dialog(this);
        setContentView(R.layout.activity_configuration);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat(" hh:mm");
        String Datetime=simpleDateFormat.format(calendar.getTime());
        String heure=simpleDateFormat1.format(calendar.getTime());
        String newLine = System.getProperty("line.separator");
        TextView textViewDate=findViewById(R.id.text_view_date);
        textViewDate.setText(Datetime+newLine+heure);
    }

    public void ShowPopup(View v) {
        TextView txtclose;
        TextView showerTime;
        TextView showerHour;
        TextView Option;
        myManualleConfig.setContentView(R.layout.activity_manualle);
        txtclose =(TextView) myManualleConfig.findViewById(R.id.txtclose);
        txtclose.setText("X");
        showerTime =(TextView) myManualleConfig.findViewById(R.id.showerTime);
        showerHour =(TextView) myManualleConfig.findViewById(R.id.showerHour);
        Option =(TextView) myManualleConfig.findViewById(R.id.option);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myManualleConfig.dismiss();
            }
        });
//        shower time
        showerTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),showerTime.class);
                startActivity(intent);

            }
        });

        //            hour time

        showerHour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),showerHour.class);
                startActivity(intent);

            }
        });
//        option
        Option.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Option.class);
                startActivity(intent);

            }
        });
        myManualleConfig.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myManualleConfig.show();
    }
    public void openAutmatic(View v){
        Intent intent=new Intent(getApplicationContext(),Automatic.class);
        startActivity(intent);
    }
}