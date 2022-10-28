package com.cheenu123.chaitanyasPriceList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        EditText itemname = findViewById(R.id.itemname);
        EditText itemprice = findViewById(R.id.itemprice);
        EditText itemquantity = findViewById(R.id.itemquantity);

        Date currentTime = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat") DateFormat timeFormat = new SimpleDateFormat("hh:mm");
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = timeFormat.format(currentTime)+"\nDate of Submission: "+dateFormat.format(currentTime);
        Button submit = findViewById(R.id.button);


        submit.setOnClickListener(view -> {
            Intent intent = new Intent(AddItemActivity.this, PriceListActivity.class);
            if(itemname.getText().toString().equals("") || itemprice.getText().toString().equals("") || itemquantity.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Please Add Valid Values", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    int totalprice = Integer.parseInt(itemprice.getText().toString())*Integer.parseInt(itemquantity.getText().toString());
                    String tprice = Integer.toString(totalprice);
                    intent.putExtra("itemname", "\nItem Name: "+itemname.getText().toString() + "\nItem Price: ₹" + itemprice.getText().toString() + "\nItem Quantity: " + itemquantity.getText().toString() + "\nTotal Price: ₹"+ tprice+ "\nTime of Submission: " + strDate+"\n" );
                    startActivity(intent);
                }catch (NumberFormatException ex){
                    Toast.makeText(getApplicationContext(), "Please Add Valid Values", Toast.LENGTH_SHORT).show();
                }


            }});






    }
}