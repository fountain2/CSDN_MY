package com.example.activitybestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by fountian on 2016/12/30.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    private Button bt_2;
    private Button bt_3;

    private Button bt_2_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_2_1= (Button) findViewById(R.id.bt_2_1);

        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_2_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_2:
                Intent mIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(mIntent);
                break;
            case R.id.bt_2_1:
//                传送数据到ThirdActivity并打开此活动
                ThirdActivity.actionStart(SecondActivity.this,"fountain","hello");
            case R.id.bt_3:
                ActivityCollector.finishAllActivity();
                break;
            default:
                break;
        }
    }
}
