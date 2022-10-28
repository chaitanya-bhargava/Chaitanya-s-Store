package com.cheenu123.chaitanyasPriceList;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PriceListActivity extends AppCompatActivity {
    public ListView itemsListView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;





    @Override protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list);


        itemsListView = findViewById(R.id.itemsListView);
        Intent intent2 = getIntent();

        if (getArrayList("key")!=null)
            arrayList=getArrayList("key");
        if(intent2.getStringExtra("itemname")!=null){


            String name=intent2.getStringExtra("itemname");
            arrayList.add(name);
        }

        itemsListView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(), "Removed Item",Toast.LENGTH_SHORT).show();
            removeItem(i);
            return false;
        });



        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        itemsListView.setAdapter(arrayAdapter);
        saveArrayList(arrayList,"key");



    }
    public void removeItem(int remove){
        arrayList.remove(remove);
        arrayAdapter.notifyDataSetChanged();
        saveArrayList(arrayList,"key");

    }


    public void additem(View view){
        Intent intent = new Intent(this, AddItemActivity.class);

        startActivity(intent);
    }
    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();

    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

}