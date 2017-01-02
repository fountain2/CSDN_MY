package com.example.keytouchtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fountian on 2016/12/28.
 * mainfest 中的设置theme为 dialog，用startActivity打开后效果为一个对话框
 */
public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}
