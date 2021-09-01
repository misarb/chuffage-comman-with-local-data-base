package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }
    public void  opt1(View v){
        Bundle bundle = new Bundle();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat Hour= new SimpleDateFormat("hh");
        int H=Integer.valueOf(Hour.format(calendar.getTime()));
        SimpleDateFormat Minute= new SimpleDateFormat("MM");
        int M=Integer.valueOf(Minute.format(calendar.getTime())) ;
        int TotleMinute=H*60+M+60;
        int hh=TotleMinute/60;
        int mm=TotleMinute%60;
        String hhmm=String.valueOf(hh)+":"+String.valueOf(mm);
        bundle.putString("qte", "10.0");
        bundle.putString("tmp","43.0");
        bundle.putString("date",hhmm);

        Intent intent=new Intent(getApplicationContext(),Result.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    public void  opt2(View v){
        Bundle bundle = new Bundle();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat Hour= new SimpleDateFormat("hh");
        int H=Integer.valueOf(Hour.format(calendar.getTime()));
        SimpleDateFormat Minute= new SimpleDateFormat("MM");
        int M=Integer.valueOf(Minute.format(calendar.getTime())) ;
        int TotleMinute=H*60+M+30;
        int hh=TotleMinute/60;
        int mm=TotleMinute%60;
        String hhmm=String.valueOf(hh)+":"+String.valueOf(mm);
        bundle.putString("qte", "15.0");
        bundle.putString("tmp","43.0");
        bundle.putString("date",hhmm);

        Intent intent=new Intent(getApplicationContext(),Result.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void  opt3(View v){
        Bundle bundle = new Bundle();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat Hour= new SimpleDateFormat("hh");
        int H=Integer.valueOf(Hour.format(calendar.getTime()));
        SimpleDateFormat Minute= new SimpleDateFormat("MM");
        int M=Integer.valueOf(Minute.format(calendar.getTime())) ;
        int TotleMinute=H*60+M+40;
        int hh=TotleMinute/60;
        int mm=TotleMinute%60;
        String hhmm=String.valueOf(hh)+":"+String.valueOf(mm);
        bundle.putString("qte", "20.0");
        bundle.putString("tmp","43.0");
        bundle.putString("date",hhmm);

        Intent intent=new Intent(getApplicationContext(),Result.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}