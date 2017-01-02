package com.example.method123.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by fountian on 2016/12/30.
 *        mainfest中 添加 name，使用自定义的application
 * <application
 *               android:name="com.example.method123.util.MyApplication"
 *               ...>
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
