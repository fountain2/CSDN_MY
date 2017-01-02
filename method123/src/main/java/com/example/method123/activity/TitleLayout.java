package com.example.method123.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.method123.R;
import com.example.method123.util.ActivityCollector;

/**
 * Created by fountian on 2017/1/1.
 *     自定义布局重写构造方法
 *     初始化点击效果
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener{
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        Button bt_back= (Button) findViewById(R.id.bt_back);
        Button bt_more= (Button) findViewById(R.id.bt_more);
        bt_back.setOnClickListener(this);
        bt_more.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_back:
                ActivityCollector.finishAllActivity();
                break;
            case R.id.bt_more:
                Toast toast=new Toast(getContext());
                ImageView imageView=new ImageView(getContext());
                imageView.setImageResource(R.drawable.ic_get_app_brown_400_48dp);
                toast.setView(imageView);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            default:
                break;
        }
    }
}
