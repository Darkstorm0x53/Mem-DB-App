package com.example.memdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateDBTest extends AppCompatActivity
{
    private EditText brand, sub_brand, speed, die_type;
    private Button buttonAddRam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_db_test_activity);

        brand = findViewById(R.id.inputBrandName);
        sub_brand = findViewById(R.id.inputSubBrandName);
        speed = findViewById(R.id.inputRamSpeed);
        die_type = findViewById(R.id.inputDieType);

        buttonAddRam = findViewById(R.id.ButtonAddDetails);

        buttonAddRam.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String brandTemp, subBrandTemp, speedTemp, dieTemp;

                brandTemp = brand.getText().toString() + "\n";
                subBrandTemp = sub_brand.getText().toString() + "\n";
                speedTemp = speed.getText().toString() + "\n";
                dieTemp = die_type.getText().toString() + "\n";

                DbHandler dbHandler = new DbHandler(CreateDBTest.this);
                dbHandler.insertUserValues(brandTemp, subBrandTemp, speedTemp, dieTemp);
            }
        });
    }

}
