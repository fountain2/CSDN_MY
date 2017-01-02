package com.example.intentaction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_start;
    private TextView tv_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_start = (Button) findViewById(R.id.bt_start);
        tv_return = (TextView) findViewById(R.id.tv_return);

        bt_start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //调用能够响应http的应用
//        Intent mIntent=new Intent(Intent.ACTION_VIEW);
//        mIntent.setData(Uri.parse("http://baidu.com"));
//        startActivity(mIntent);

//      存储数据到Bundle
        Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("name", "fountain");
        mIntent.putExtras(mBundle);
//     1. 无返回数据，启动活动
//      startActivity(mIntent);

//     2.有返回数据，启动活动
        startActivityForResult(mIntent, 2);

    }

//    必须要请求码对应才会继续执行
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String temp = bundle.getString("name_01");
                tv_return.setText(temp);
            }
        }
    }
}

