package com.example.keytouchtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fountian on 2016/12/28.
 * 意外关闭，恢复数据
 * 物理按键监听器
 * 触摸屏监听器
 */
public class onKeyTest extends AppCompatActivity implements View.OnKeyListener {

    private TextView tv_3;
    private EditText ed_3;
    private Button bt_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);


        tv_3 = (TextView) findViewById(R.id.tv_3);
        ed_3 = (EditText) findViewById(R.id.ed_3);
        ed_3.setOnKeyListener(this);

        bt_3 = (Button) findViewById(R.id.bt_3);
        Log.w("asdasd","start");


        /**
        * 当程序意外的被关闭才会执行方法，后退键 及 finish（）都不会调用
        */
        Boolean aaa=(savedInstanceState != null);
        Log.w("asdasd", String.valueOf(aaa));

        if (savedInstanceState != null) {
            Log.w("asdasd","recover success");
            String recover_Data = savedInstanceState.getString("save_data");
            ed_3.setText(recover_Data);
            Log.w("asdasd","data:"+recover_Data);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String save_Data = ed_3.getText().toString();
        outState.putString("save_data", save_Data);
        Log.w("asdasd","save success");
    }

    /**
     * 重写onKeyDown方法可以拦截系统默认的处理
     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Toast.makeText(this, "物理键盘后退键", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//            Toast.makeText(this, "声音+", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
//            Toast.makeText(this, "声音-", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_MUTE) {
//            Toast.makeText(this, "静音", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (keyCode == KeyEvent.KEYCODE_HOME) {
//            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    /**
     * 重写onTouchEvent方法可以处理Touch事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
//            Toast.makeText(this, "点击并移动", Toast.LENGTH_SHORT).show();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Toast.makeText(this, "松开", Toast.LENGTH_SHORT).show();
        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

//        if(event.getAction()==KeyEvent.ACTION_DOWN)
//        {
//            Toast.makeText(this,"在绑定的组件里点击了物理键盘",Toast.LENGTH_SHORT).show();
//
//                return true;
//            }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT ||
                keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            Toast.makeText(this, "物理键盘左或右", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_MENU) {
            Toast.makeText(this, "物理键盘菜单", Toast.LENGTH_SHORT).show();
        }

        // TODO Auto-generated method stub
        return false;
    }
}



