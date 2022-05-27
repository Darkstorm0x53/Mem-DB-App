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

public class FormFactorSelect extends AppCompatActivity
{
    Button desktopBtn, laptopBtn, eccBtn; //declare buttons
    Toolbar toolbar; //declare toolbar

    private String brand = "Micron", subBrand = "Crucial" , speed = "3400Mhz", die = "E die" ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_factor_select);

        desktopBtn = findViewById(R.id.dimmBtn);   // assign buttons by id
        laptopBtn = findViewById(R.id.soDimmBtn);
        eccBtn = findViewById(R.id.serverBtn);

        toolbar=findViewById(R.id.app_Bar2); //
        setSupportActionBar(toolbar);

        // create dummy db
       /* String OEMTemp, subBrandTemp, speedTemp, dieTemp;

        OEMTemp = brand + "\n";
        subBrandTemp = subBrand.toString() + "\n";
        speedTemp = speed.toString() + "\n";
        dieTemp = die.toString() + "\n";

        DbHandler dbHandler = new DbHandler(FormFactorSelect.this);
        dbHandler.insertUservalues(OEMTemp, subBrandTemp, speedTemp, dieTemp);
*/

        desktopBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1;
                intent1 = new Intent(FormFactorSelect.this,
                        ListDB.class);
                startActivity(intent1);
            }
        });

        laptopBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent2;
                intent2 = new Intent(FormFactorSelect.this,
                        ListDB.class);
                startActivity(intent2);
            }
        });

        eccBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent3;
                intent3 = new Intent(FormFactorSelect.this,
                        ListDB.class);
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
        intent4 = new Intent(FormFactorSelect.this,
                AccountActivity.class);
        //startActivity(intent4);
        return super.onOptionsItemSelected(item);
    }
}