package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    DBHelper myDB;
    Button btnl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn=findViewById(R.id.textViewSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        email=(EditText)findViewById(R.id.inputEmail);
        password=(EditText)findViewById(R.id.inputPassword);
        btnl=(Button)findViewById(R.id.btnlogin);
        myDB=new DBHelper(this);
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                if(Email.equals("")||Password.equals("")){
                    Toast.makeText(LoginActivity.this,"Remplir tous les champs",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result=myDB.cheekEmailPassword(Email,Password);
                    if(result==true){
                        Intent intent=new Intent(getApplicationContext(),HomePage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Vos coordonnées sont incorrectes",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

}
