package com.cheenu123.chaitanyasPriceList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){
        Intent intent = new Intent(this, PriceListActivity.class);
        EditText editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.editTextTextPassword);
        if(editTextEmailAddress.getText().toString().equals("test@admin.com") && editTextPassword.getText().toString().equals("12345678")) {
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

        }
    }
}