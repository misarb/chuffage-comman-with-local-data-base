package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class showerHour extends AppCompatActivity {
Button getResult;
TimePicker timePicker1;

EditText TempH,waterQuntityH;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_hour);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat(" hh:mm");
        String Datetime=simpleDateFormat.format(calendar.getTime());
        String heure=simpleDateFormat1.format(calendar.getTime());
        String newLine = System.getProperty("line.separator");
        TextView textViewDate=findViewById(R.id.text_view_date);
        textViewDate.setText(Datetime+newLine+heure);
        getResult=(Button)findViewById(R.id.getResult);
        timePicker1=(TimePicker)findViewById(R.id.timePicker1);
        waterQuntityH=(EditText) findViewById(R.id.waterQuntityH);
        TempH=(EditText) findViewById(R.id.TempH);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder=new AlertDialog.Builder(showerHour.this);
                builder.setTitle("Confirmation");
                builder.setIcon(R.drawable.ic_b_foreground);
                String newLine = System.getProperty("line.separator");
                String date;
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    private double energie;
                    private double Temperature;
                    private double cout;
                    private String date;
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Bundle bundle = new Bundle();
                        bundle.putString("tmp",String.valueOf(TempH.getText()));
                        bundle.putString("qte", String.valueOf(waterQuntityH.getText()));
                        bundle.putString("date", String.valueOf(timePicker1.getCurrentHour())+":"+String.valueOf(timePicker1.getCurrentMinute()));
                        Intent intent=new Intent(getApplicationContext(),Result.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
        }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.cancel();
                }
            })
                    .setMessage("L'énergie est :"+(4.2*15*(Double.parseDouble(String.valueOf(TempH.getText()))-10.0)/3600)+" Kwh"+newLine+"Le coût est :"+(4.2*15*(Double.parseDouble(String.valueOf(TempH.getText()))-10.0)/3600.0)+" DH" +newLine+"Durée nécessaire est:" +(((4.2*15*(Double.parseDouble(String.valueOf(TempH.getText()))-10.0)/3600)/0.5)*60)+" minutes" +newLine+"Le date est :"+String.valueOf(timePicker1.getCurrentHour())+":"+String.valueOf(timePicker1.getCurrentMinute())).setCancelable(false)
                    ;
            dialog=builder.create();
                dialog.show();
        }
    });
    }
}