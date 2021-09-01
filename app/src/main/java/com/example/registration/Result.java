package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Result extends AppCompatActivity {
    String quntity;
    Double Temperature;
    Double energie;
    Double cout;
    Integer duree ;
    String DateDouch;
    TextView qteV,tempV,enrV,coutV,DateV,aa,dnV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat Hour= new SimpleDateFormat("yyyy/MM/dd");
        String timing=Hour.format(calendar.getTime());
        setContentView(R.layout.activity_result);
        qteV=(TextView)findViewById(R.id.quntity);
        tempV=(TextView)findViewById(R.id.Temperature);
        enrV=(TextView)findViewById(R.id.energie);
        coutV=(TextView)findViewById(R.id.cout);
        dnV = (TextView)findViewById(R.id.duree);
        DateV=(TextView)findViewById(R.id.DateDouch);
        aa=(TextView)findViewById(R.id.text_view_date);
        Bundle bundle = getIntent().getExtras();
        String qte =bundle.getString("qte");
        String dd=bundle.getString("day");
        Double tmp =Double.parseDouble(bundle.getString("tmp")) ;
        String Date =bundle.getString("date") ;
        this.quntity=qte;
        this.Temperature=tmp;
        this.energie=(4.2*15*(tmp-10.0))/3600; //*Integer.parseInt(qte)
        this.duree= (int)(this.energie/0.5)*60; //Duree neccessair
        this.cout= this.energie*0.79036;
        this.DateDouch=Date;
        this.qteV.setText(qte+" L");
        this.tempV.setText(String.valueOf(tmp+" ºC"));
    if(dd==null){
        this.aa.setText("");
    }else {
        this.aa.setText("Concernant :"+dd);

    }
        this.enrV.setText(String.valueOf(this.energie)+" Kwh");
        this.coutV.setText(String.valueOf(this.cout)+" DH");
        this.dnV.setText(String.valueOf(this.duree/60)+":" + String.valueOf(this.duree%60)+" Hour");
        this.DateV.setText(timing+" "+this.DateDouch+" "+"PM/AM");
    }
}