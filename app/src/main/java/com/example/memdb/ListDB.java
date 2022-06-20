package com.example.memdb;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListDB extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<String> OEM, Series, clockSpeed, die_type;
    DbHandler db;
    RecycleAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_db);

        db = new DbHandler(this);

        OEM = new ArrayList<>();
        Series = new ArrayList<>();
        clockSpeed = new ArrayList<>();
        die_type = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_View);
        adaptor = new RecycleAdaptor(this, OEM, Series, clockSpeed, die_type);
        
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData()
    {
        Cursor cursor = db.getDb();
        if (cursor.getCount()==0)
        {
            Toast.makeText(ListDB.this, "No Data in system", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                OEM.add(cursor.getString(0));
                Series.add(cursor.getString(1));
                clockSpeed.add(cursor.getString(2));
                die_type.add(cursor.getString(3));
            }
        }
    }

}