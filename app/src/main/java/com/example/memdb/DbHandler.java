package com.example.memdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper
{
    //DB parameters
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DDR4_desktop.db";
    private static final String TABLE_DDR4 = "DDR4_dtView";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OEM = "brand";
    private static final String COLUMN_SubBRAND = "subBrand";
    private static final String COLUMN_SPEED = "speed";
    private static final String COLUMN_DIE = "die";



    //queries
    private String dropTable = "DROP TABLE IF EXISTS ";
    private String getTable = "SELECT brand, subBrand, speed, die FROM " + TABLE_DDR4;

    public DbHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insertUserValues(String brand, String subBrand, String speed, String die )
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


    public Cursor getDb()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getTable, null);
        return cursor;
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
