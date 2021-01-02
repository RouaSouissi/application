package com.mdw31g5.loginandregistersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "LoginActivity.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,pass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //inserting in database
    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password", password);
        long ins = db.insert("user",null,contentValues);
        return  (ins==-1);
    }

    //checking if email exists
    public boolean chkemail(String email) {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",
                new String[]{email});
        return cursor.getCount() <= 0;
    }
    //checki email and pass
    public Boolean emailpassword (String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",
                new String[]{email,password});
        return cursor.getCount()>0;


    }
}
