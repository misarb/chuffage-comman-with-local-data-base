package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText inputUsername,inputEmail,inputPassword,inputConformPassword;
    Button btnRegister;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        inputUsername=(EditText)findViewById(R.id.inputUsername);
        inputEmail=(EditText)findViewById(R.id.inputEmail);
        inputPassword=(EditText)findViewById(R.id.inputPassword);
        inputConformPassword=(EditText)findViewById(R.id.inputConformPassword);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        myDB=new DBHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=inputUsername.getText().toString();
                String email=inputEmail.getText().toString();
                String password=inputPassword.getText().toString();
                String ConfPassword=inputConformPassword.getText().toString();
                if(user.equals("")||email.equals("")||password.equals("")||ConfPassword.equals("")){
                    Toast.makeText(RegisterActivity.this,"Remplir tous les champs",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(ConfPassword)){
                        Boolean userCheekResult= myDB.cheekEmail(email);
                        if(userCheekResult==false){
                            Boolean regResult=myDB.insertData(user,email,password);
                            inputUsername.setText("");
                            inputEmail.setText("");
                            inputPassword.setText("");
                            inputConformPassword.setText("");

                            if(regResult==true){
                                Toast.makeText(RegisterActivity.this,"Enregistrement avec succes",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Echec d'enregistrement",Toast.LENGTH_SHORT).show();

                            }

                        }
                        else{
                            inputUsername.setText("");
                            inputEmail.setText("");
                            inputPassword.setText("");
                            inputConformPassword.setText("");
                            Toast.makeText(RegisterActivity.this,"Email deja existe ,connectez vous à votre compte ",Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Les mots de passe ne sont pas identiques",Toast.LENGTH_SHORT).show();
                        inputConformPassword.setText("");

                    }
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        }

}
