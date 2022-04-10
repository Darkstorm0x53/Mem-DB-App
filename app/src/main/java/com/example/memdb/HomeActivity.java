package com.example.memdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button ddr3Btn, ddr4Btn, ddr5Btn; //declare buttons
    Toolbar toolbar; //declare toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ddr3Btn = findViewById(R.id.ddr3);   // assign buttons by id
        ddr4Btn = findViewById(R.id.ddr4);
        ddr5Btn = findViewById(R.id.ddr5);

        toolbar=findViewById(R.id.app_Bar); //
        setSupportActionBar(toolbar);

        ddr3Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1;
                intent1 = new Intent(HomeActivity.this,
                        FormFactorSelect.class);
                startActivity(intent1);
            }
        });

        ddr4Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent2;
                intent2 = new Intent(HomeActivity.this,
                        FormFactorSelect.class);
                startActivity(intent2);
            }
        });

        ddr5Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent3;
                intent3 = new Intent(HomeActivity.this,
                        FormFactorSelect.class);
                startActivity(intent3);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Intent intent4;
        intent4 = new Intent(HomeActivity.this,
                AccountActivity.class);
        startActivity(intent4);
        return super.onOptionsItemSelected(item);
    }
}