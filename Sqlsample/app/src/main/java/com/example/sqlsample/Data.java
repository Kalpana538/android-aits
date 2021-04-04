package com.example.sqlsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Data extends SQLiteOpenHelper {
    public  static final String DB_NAME="database";
    public static final String TABLE_NAME="student";
    public static final String COL1="name";
    public static final String COL2="branch";
    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+COL1+",TEXT,"+COL2+" TEXT);";
    public Data(@Nullable Context context) {
        super(context, "database", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public  void insertData(ContentValues cv){
SQLiteDatabase sq=this.getWritableDatabase();
sq.insert(TABLE_NAME,null,cv);
    }
    public Cursor readdata(){
        SQLiteDatabase sr=this.getReadableDatabase();
        return  sr.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }
}
