package com.example.keytouchtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fountian on 2016/12/28.
 * 接收 MainActivity的数据，并返回数据
 */
public class SecondActivity extends Activity implements View.OnClickListener{

    private Button bt_2;
    private TextView tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        bt_2= (Button) findViewById(R.id.bt_2);
        tv_2= (TextView) findViewById(R.id.tv_2);

        bt_2.setOnClickListener(this);

        Bundle mBundle =getIntent().getExtras();
        tv_2.setText(mBundle.getString("name_1"));

    }

    @Override
    public void onClick(View v) {
        Intent mIntent=getIntent();
        Bundle mBundle=new Bundle();
        mBundle.putString("name_2","return to you have you accept");
        mIntent.putExtras(mBundle);
        setResult(RESULT_OK,mIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
