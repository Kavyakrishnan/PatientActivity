package com.example.patientappactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static String dbname = "Patient.db";
    static String tablename = "patient";
    static String col1 = "ID";
    static String col2 = "pcode";
    static String col3 = "name";
    static String col4 = "address";
    static String col5 = "mobno";
    static String col6 = "docname";

    public DbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + tablename + "(" + col1 + "  integer primary key autoincrement," +
                "" + col2 + " text, " + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists " + tablename;
        db.execSQL(query);
        onCreate(db);

    }

    public boolean insertPatient(String pcode, String name, String address, String mobno, String docname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(col2, pcode);
        content.put(col3, name);
        content.put(col4, address);
        content.put(col5, mobno);
        content.put(col6, docname);
        long status = db.insert(tablename, null, content);
        if (status == -1) {
            return false;

        } else {
            return true;
        }


    }


public Cursor searchpatient(String mobno)
{
    SQLiteDatabase db = this.getWritableDatabase();
    String query = "select * from "+tablename+" where "+col2+"=" + "'" + mobno + "'";
    Cursor c=db.rawQuery(query, null);
    return c;
}








}
