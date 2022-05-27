package com.example.memdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Adapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListDB extends AppCompatActivity
{
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_db);

        DbHandler db = new DbHandler(this);

        ArrayList<HashMap<String, String>> dbList = db.getDb();

        recyclerView = findViewById(R.id.recycler_View);

        Adapter adapter = new SimpleAdapter(ListDB.this, dbList, R.layout.list_item,
                new String[]{"brand","subBrand", "speed", "die"},
                new int[]{R.id.brand, R.id.subBrand, R.id.speed, R.id.die});
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);


    }
}