package com.example.intentaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by fountian on 2016/12/27.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_call;
    private TextView tv_load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bt_call = (Button) findViewById(R.id.bt_call);
        tv_load = (TextView) findViewById(R.id.tv_load);


//        bt_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //调用拨号页面
//                Intent mIntent = new Intent(Intent.ACTION_DIAL);
//                mIntent.setData(Uri.parse("tel:10086"));
//                startActivity(mIntent);
//            }
//        });

        bt_call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //无返回，获取 来源Intent的存储信息
//        Bundle bundle = getIntent().getExtras();
//        String name = bundle.getString("name");


        //有返回，
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        tv_load.setText(name);

        Bundle bundle2 = new Bundle();
        bundle2.putString("name_01","This is from ShowMsg!");
        intent.putExtras(bundle2);
        setResult(RESULT_OK, intent);

        finish();


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
