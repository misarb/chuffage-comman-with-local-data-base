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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class hebdomadair extends AppCompatActivity implements OnItemSelectedListener{
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
        setContentView(R.layout.activity_hebdomadair);
        calcule=(Button)findViewById(R.id.btnHEB);
        spinner=(Spinner)findViewById(R.id.spinnerHEB);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Lundi");
        arrayList.add("Mardi");
        arrayList.add("Mercredi");
        arrayList.add("Jeudi");
        arrayList.add("Vendredi");
        arrayList.add("Samedi");
        arrayList.add("Dimanche");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(this);
        waterQuntityP=(EditText) findViewById(R.id.waterHEB);
        TempP=(EditText) findViewById(R.id.TempHEB);
        calcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder=new AlertDialog.Builder(hebdomadair.this);
                builder.setTitle("Confirmation");
                builder.setIcon(R.drawable.ic_b_foreground);
                String newLine = System.getProperty("line.separator");
                String date;
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Calendar calendar=Calendar.getInstance();
                        SimpleDateFormat Hour= new SimpleDateFormat("hh:MM");
                        String   Time= Hour.format(calendar.getTime());
                        Bundle bundle = new Bundle();
                        bundle.putString("tmp",String.valueOf(TempP.getText()));
                        bundle.putString("qte", String.valueOf(waterQuntityP.getText()));
                        bundle.putString("date", Time);
                        bundle.putString("day", Salah);
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
                        .setMessage("Le jour choisi est le "+Salah+newLine+"L'énergie est :"+4.2*(Double.parseDouble(String.valueOf(TempP.getText()))-20.0)+" Kwh"+newLine+"Le coût est :"+(4.2*(Double.parseDouble(String.valueOf(TempP.getText()))-20.0)/3600.0)+" DH").setCancelable(false);
                dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Salah = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}