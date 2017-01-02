package com.example.keytouchtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
*   启动SecondActivity，并传送数据
 *   接收SecondActivity 返回的数据
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_1;
    private EditText ed_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_1= (Button) findViewById(R.id.bt_1);
        ed_1= (EditText) findViewById(R.id.ed_1);

        bt_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String abc= ed_1.getText().toString()+"";

        Intent mIntent=new Intent(this,SecondActivity.class);
        Bundle mBundle=new Bundle();
        mBundle.putString("name_1",abc);
        mIntent.putExtras(mBundle);
        startActivityForResult(mIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1){
            if (resultCode==RESULT_OK){
                Bundle mBundle=data.getExtras();
                String return_data=mBundle.getString("name_2");
                ed_1.setText(return_data);
            }
        }
    }
}
