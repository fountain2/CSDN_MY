package com.example.method123.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.method123.R;
import com.example.method123.user.Person;
import com.example.method123.util.BaseActivity;

/**
 * Created by fountian on 2016/12/31.
 */
public class SecondActivity extends BaseActivity {
    private Button bt_second;
    private TextView tv_second;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_second = (TextView) findViewById(R.id.tv_second);
        bt_second = (Button) findViewById(R.id.bt_second);

//        Person person = (Person) getIntent().getSerializableExtra("person_data");
        Person person = getIntent().getParcelableExtra("person_data");

        String name = person.getName();
        String password = person.getPassword();
        tv_second.setText("name:" + name + ",password:" + password);
    }
}
