package com.example.listandadapter.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.listandadapter.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fountian on 2017/1/1.
 */
public class SecondActivity extends AppCompatActivity {
    private ListView list_second;
    private List<String> datalist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list_second= (ListView) findViewById(R.id.list_second);
        datalist=new ArrayList<String>();


        String[] array={"s","ssss","ssss","ssss","ssss"};
        init_datalist();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1, datalist);
        list_second.setAdapter(adapter);
    }

    private void init_datalist() {
        for (int i=0;i<=30;i++ ){
            datalist.add("APPP"+i);
        }
    }
}
