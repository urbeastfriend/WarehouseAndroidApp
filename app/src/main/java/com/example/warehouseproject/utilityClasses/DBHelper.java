package com.example.warehouseproject.utilityClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                + TABLE_WAREHOUSE + "("
                + KEY_ID + " integer primary key autoincrement, "
                + KEY_QR + " text,"
                + KEY_ITEMTYPE + " text,"
                + KEY_ITEMNAME + " text,"
                + KEY_COUNT + " text,"
                + KEY_DESCRIPTION + " text" + ")" );
        db.execSQL("create table "
                + TABLE_SUPPLY + "("
                + KEY_ID2 + " integer primary key autoincrement, "
                + KEY_SUPPLYTYPE + " text,"
                + KEY_ITEMVENDOR + " text,"
                + KEY_COUNT2 + " text,"
                + KEY_DATE + " integer,"
                + FOREIGNKEY_ID + " integer REFERENCES "+KEY_ID+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_WAREHOUSE);
        db.execSQL("drop table if exists " + TABLE_SUPPLY);
        onCreate(db);
    }


    public static final int DATABASE_VERSION = 12;

    public static final String DATABASE_NAME = "warehouse";
    public static final String TABLE_WAREHOUSE = "itemtable";
    public static final String KEY_ID = "itemid";
    public static final String KEY_QR = "itemqr";
    public static final String KEY_ITEMTYPE = "itemtype";
    public static final String KEY_ITEMNAME = "itemname";
    public static final String KEY_COUNT = "count";
    public static final String KEY_DESCRIPTION = "description";

    public static final String TABLE_SUPPLY = "supplyPlusMinus";
    public static final String KEY_ID2 = "supplyid";
    public static final String KEY_SUPPLYTYPE = "supplyType";
    public static final String KEY_ITEMVENDOR = "itemvendor";
    public static final String KEY_COUNT2 = "supplycount";
    public static final String KEY_DATE = "date";
    public static final String FOREIGNKEY_ID = "itemid";



}