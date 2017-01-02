package com.example.listandadapter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listandadapter.R;
import com.example.listandadapter.adapter.FruitAdapter;
import com.example.listandadapter.example.Fruit;

import java.util.ArrayList;
import java.util.List;
/*
*     自定义listview布局
* */
public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    private ListView list_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list_main= (ListView) findViewById(R.id.list_main);
        intial_List();
        FruitAdapter adapter=new FruitAdapter(getApplicationContext(),R.layout.fruit_layout,fruitList);
        list_main.setAdapter(adapter);

        //listview的点击响应事件
        list_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);

                Toast.makeText(getApplicationContext(),"position-->"+fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void intial_List() {
        Fruit apple=new Fruit("Apple",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple);
        Fruit apple_1=new Fruit("Apple_1",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple_1);
        Fruit apple_2=new Fruit("Apple_2",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple_2);
        Fruit apple_3=new Fruit("Apple_3",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple_3);
        Fruit apple_4=new Fruit("Apple_4",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple_4);
        Fruit apple_5=new Fruit("Apple_5",R.drawable.ic_class_purple_500_48dp);
        fruitList.add(apple_5);
//        Fruit apple_6=new Fruit("Apple_6",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_6);
//        Fruit apple_7=new Fruit("Apple_7",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_7);
//        Fruit apple_8=new Fruit("Apple_8",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_8);
//        Fruit apple_9=new Fruit("Apple_9",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_9);
//        Fruit apple_10=new Fruit("Apple_10",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_10);
//        Fruit apple_11=new Fruit("Apple_11",R.drawable.ic_class_purple_500_48dp);
//        fruitList.add(apple_11);

    }
}
