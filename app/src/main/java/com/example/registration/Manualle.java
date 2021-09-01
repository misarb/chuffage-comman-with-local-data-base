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
import android.widget.Toast;

public class Manualle extends AppCompatActivity {
    Dialog myManualleConfigs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myManualleConfigs=new Dialog(this);
        setContentView(R.layout.activity_manualle);
    }
    public void ShowPopupOption(View v) {
        TextView txtclose1;
        myManualleConfigs.setContentView(R.layout.activity_option);
        txtclose1 =(TextView) myManualleConfigs.findViewById(R.id.txtclose1);
        txtclose1.setText("X");
        txtclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myManualleConfigs.dismiss();
            }
        });
        myManualleConfigs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myManualleConfigs.show();
    }
}