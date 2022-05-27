package com.example.memdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper
{
    //DB parameters
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DDR4-desktop.db";
    private static final String TABLE_DDR4 = "DDR4-dtView";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OEM = "brand";
    private static final String COLUMN_SubBRAND = "subBrand";
    private static final String COLUMN_SPEED = "speed";
    private static final String COLUMN_DIE = "die";



    //queries
    private String dropTable = "DROP TABLE IF EXISTS ";
    private String getTable = "SELECT name, location, designation FROM " + TABLE_DDR4;

    public DbHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insertUservalues(String brand, String subBrand, String speed, String die )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_OEM, brand);
        values.put(COLUMN_SubBRAND, subBrand);
        values.put(COLUMN_SPEED, speed);
        values.put(COLUMN_DIE, die);

        long newRowId = db.insert(TABLE_DDR4, null, values);
        db.close();
    }


    public ArrayList<HashMap<String, String>> getDb()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String, String>> MemList = new ArrayList<>();

        Cursor cursor = db.rawQuery(getTable, null);

        while (cursor.moveToNext())
        {
            HashMap<String, String> memInfo = new HashMap<>();
            memInfo.put("brand", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OEM)));
            memInfo.put("subBrand", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SubBRAND)));
            memInfo.put("speed", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SPEED)));
            memInfo.put("die", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIE)));

            MemList.add(memInfo);
        }
        return MemList;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_DDR4 + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_OEM + " TEXT,"
                + COLUMN_SubBRAND + " TEXT,"
                + COLUMN_SPEED + " TEXT,"
                + COLUMN_DIE + " TEXT"
                + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //drop table
        db.execSQL(dropTable + TABLE_DDR4);
        // recreate table
        onCreate(db);
    }
}
