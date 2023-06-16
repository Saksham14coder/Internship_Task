package com.sakt.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] items = {"Fahrenheit to Celsius","Celsius to Fahrenheit"};
    ArrayAdapter<String> adapterItem;
    AutoCompleteTextView autoCompleteTextView;
    EditText value,output1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        value=findViewById(R.id.Value);
        output1 =findViewById(R.id.output1);
        autoCompleteTextView = findViewById(R.id.autoCompleteview);
        adapterItem = new ArrayAdapter<String>(this,R.layout.list_college,items);


        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

                if(id==0){

                    String number = value.getText().toString();
                    if (number.isEmpty()){
                        Toast.makeText(MainActivity.this, "Enter Value", Toast.LENGTH_SHORT).show();
                    }
                    float F2 = Float.parseFloat(number);
                    float FA = ((F2 - 32)*5)/9;
                    String Answer = Float.toString(FA);
                    output1.setText(Answer +"  C");

                    Toast.makeText(MainActivity.this, "Fahrenheit to Celsius", Toast.LENGTH_SHORT).show();
                }else if(id==1){

                    String number = value.getText().toString();
                    if (number.isEmpty()){
                        Toast.makeText(MainActivity.this, "Enter Value", Toast.LENGTH_SHORT).show();
                    }
                    float C2 = Float.parseFloat(number);
                    float FA = (C2*9/5)+32;
                    String Answer = Float.toString(FA);
                    output1.setText(Answer+" F");

                    Toast.makeText(MainActivity.this, "Celsius to Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}