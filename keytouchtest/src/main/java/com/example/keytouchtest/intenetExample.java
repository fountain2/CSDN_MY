package com.example.keytouchtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by fountian on 2016/12/28.
 * 网上的代码，每四位数后接 -
 */
public class intenetExample extends Activity {
    private EditText etAccout=null;
    private TextView tvInfo=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenet);
        tvInfo=(TextView)super.findViewById(R.id.info);

        etAccout=(EditText)super.findViewById(R.id.accout);
        etAccout.setOnKeyListener(new EmailOnKeyListener());
    }

    private class EmailOnKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //输入银行账号，用大字回显出来字符,每4个字符用横线隔开
            switch (event.getAction()) {
                case KeyEvent.ACTION_UP:             //键盘松开
                    String sAccout=etAccout.getText().toString();
                    tvInfo.setText(Subs(sAccout));
                case KeyEvent.ACTION_DOWN:          //键盘按下
                    break;
            }
            return false;
        }

        private String Subs(String total){
            String news = "";
            for(int i=0;i<=total.length()/4;i++)
                //分段后最后不加中间横线-
                if(i*4+4<total.length())
                    news=news+total.substring(i*4,Math.min(i*4+4,total.length()))+"-";
                else
                    news=news+total.substring(i*4,Math.min(i*4+4,total.length()));
            return news;
        }
    }

}