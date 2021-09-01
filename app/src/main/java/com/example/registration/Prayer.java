package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;

public class Prayer extends AppCompatActivity implements OnItemSelectedListener{
    Button calcule;
    Spinner spinner;
    String Salah;
    String Date;
    EditText waterQuntityP,TempP;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String newLine = System.getProperty("line.separator");
        setContentView(R.layout.activity_prayer);
        calcule=(Button)findViewById(R.id.button2);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Fajr");
        arrayList.add("Dhuhr");
        arrayList.add("Asr");
        arrayList.add("Maghrib");
        arrayList.add("Isha");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
        waterQuntityP=(EditText) findViewById(R.id.waterP);
        TempP=(EditText) findViewById(R.id.TempP);
        calcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(Prayer.this);
                builder.setTitle("Confirmation");
                builder.setIcon(R.drawable.ic_b_foreground);
                String newLine = System.getProperty("line.separator");

                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Bundle bundle = new Bundle();
                        bundle.putString("tmp", String.valueOf(TempP.getText()));
                        bundle.putString("qte", String.valueOf(waterQuntityP.getText()));
                        bundle.putString("date", Date);
                        bundle.putString("day", Salah);

                        Intent intent = new Intent(getApplicationContext(), Result.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.cancel();
                    }
                })
                        .setMessage("La prière de :"+Salah+newLine+"L'énergie est :" + 4.2 * (Double.parseDouble(String.valueOf(TempP.getText())) - 20.0)+" Kwh" + newLine + "Le coût est :" + (4.2 * (Double.parseDouble(String.valueOf(TempP.getText())) - 20.0) / 3600.0)+" DH").setCancelable(false)
                ;
                dialog = builder.create();
                dialog.show();
                ;
            }
        });}
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Salah = parent.getItemAtPosition(position).toString();
        if (Salah=="Fajr") Date="04:27";
        if (Salah=="Dhuhr") Date="13:29";
        if (Salah=="Asr") Date="17:18   ";
        if (Salah=="Maghrib") Date="20:40";
        if (Salah=="Isha") Date="22:17";
        // Showing selected spinner item
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}