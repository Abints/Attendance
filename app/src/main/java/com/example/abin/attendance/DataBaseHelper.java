package com.example.abin.attendance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abin on 6/7/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context)
    {
        super(context,"Attendance",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table parent(name text,pass text,child text)");
        db.execSQL("create table attend(name text,attendance text)");

    }
//    String viewData(String name,String pass)
//    {
//        SQLiteDatabase db=getWritableDatabase();
//        Cursor c=db.rawQuery("select p.name,pass,child,a.attendance from parent p,attend a where p.name='"+name+"' and child=a.name",null);
//        //Cursor c=db.rawQuery("select * from parent where name='"+name+"'",null);
//
//        c.moveToFirst();
//        if(c.getCount()==0)
//            return "No Such username";
//        else if(pass.equals(c.getString(1)))
//            return c.getString(2)+" has attendance "+c.getString(3) ;
//        else
//            return "Incorrect password";
//
//    }
    Cursor all()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from parent",null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }
}
