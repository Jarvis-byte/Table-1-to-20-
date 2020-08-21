package com.example.tableapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;

public void generateTables(int i)
{
    ArrayList<String>arrayMultiply=new ArrayList<String>();
    int x;


        for(x=1;x<=10;x++)
        {

            arrayMultiply.add(Integer.toString(x*i));

        }

        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayMultiply);
        list.setAdapter(arrayAdapter);


}


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar seek=(SeekBar)findViewById(R.id.tableSeek);

        list=findViewById(R.id.listView);
        seek.setMax(20);
        seek.setProgress(1);

       seek.setMin(1);

        generateTables(1);
   seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


           generateTables(i);
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });

    }
}