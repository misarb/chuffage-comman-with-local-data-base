package com.example.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(email Text primary key,username Text,password Text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table  if exists users ");
    }
    public Boolean insertData(String email,String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result=myDB.insert("users",null,contentValues);
        if (result==-1){
            return  false;
        }
        else{
            return  true;
        }
    }
    public  Boolean cheekEmail(String email){
       SQLiteDatabase myDB=this.getWritableDatabase();
       Cursor cursor=myDB.rawQuery("select * from users where email=?",new String[]{email});
        if (cursor.getCount()>0){
            return  true;
        }
        else{
            return  false;
        }
    }
    public  Boolean cheekEmailPassword(String email,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where email=? and password=? ",new String[]{email,password});
        if (cursor.getCount()>0){
            return  true;
        }
        else{
            return  false;
        }
    }

}
