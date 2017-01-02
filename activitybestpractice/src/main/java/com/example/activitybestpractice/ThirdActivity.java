package com.example.activitybestpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fountian on 2016/12/30.
 */
public class ThirdActivity extends BaseActivity {
    private Button bt_4;
    private TextView tv_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv_4= (TextView) findViewById(R.id.tv_4);
        bt_4= (Button) findViewById(R.id.bt_4);
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAllActivity();
            }
        });

        String param1=getIntent().getStringExtra("param1");
        String param2=getIntent().getStringExtra("param2");
        tv_4.setText("convert data is-param1:"+param1+",param2:"+param2);

    }

//    所有要向此Activity传送数据的活动都可以通过调用此方法
    public static void actionStart(Context context,String data1,String data2){
        Intent mIntent =new Intent(context,ThirdActivity.class);
        mIntent.putExtra("param1",data1);
        mIntent.putExtra("param2",data2);
        context.startActivity(mIntent);
    }
}
