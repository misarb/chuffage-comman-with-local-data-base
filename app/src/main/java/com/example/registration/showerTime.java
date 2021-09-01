package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class showerTime extends AppCompatActivity {
    Button getResult;
    public  EditText Temp,waterQuntity;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_time);
        getResult=(Button)findViewById(R.id.getResultT);
        waterQuntity=(EditText) findViewById(R.id.waterQuntity);
        Temp=(EditText) findViewById(R.id.Temp);
        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder=new AlertDialog.Builder(showerTime.this);
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
                                Calendar calendar=Calendar.getInstance();
                                SimpleDateFormat Hour= new SimpleDateFormat("hh");
                                int H=Integer.valueOf(Hour.format(calendar.getTime()));
                                SimpleDateFormat Minute= new SimpleDateFormat("MM");
                                int M=Integer.valueOf(Minute.format(calendar.getTime())) ;
                                int TotleMinute=H*60+M;
                                int resultMinute=TotleMinute+(int) Math.round(this.cout);
                                int hh=resultMinute/60;
                                int mm=resultMinute%60;
                                this.Temperature=Double.parseDouble(String.valueOf(Temp.getText()));
                                this.energie=4.2*(  this.Temperature-20.0);
                                this.cout= this.energie/3600.0;
                                this.date=String.valueOf(hh)+":"+String.valueOf(mm);
                                bundle.putString("tmp",String.valueOf(Temp.getText()));
                                bundle.putString("qte", String.valueOf(waterQuntity.getText()));
                                bundle.putString("date", date);
                                Intent intent=new Intent(getApplicationContext(),Result.class);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.cancel();
                            }
                        })
                        .setMessage("L'énergie est :"+(4.2*15*(Double.parseDouble(String.valueOf(Temp.getText()))-10.0)/3600)+" Kwh"+newLine+ "Durée nécessaire est :"+(((4.2*15*(Double.parseDouble(String.valueOf(Temp.getText()))-10.0)/3600)/0.5)*60)+" minutes"  +newLine+"Le coût est :"+(4.2*(Double.parseDouble(String.valueOf(Temp.getText()))-20.0)/3600.0)+" DH").setCancelable(false)
                ;
                 dialog=builder.create();
                dialog.show();
            }
        });
    }}

